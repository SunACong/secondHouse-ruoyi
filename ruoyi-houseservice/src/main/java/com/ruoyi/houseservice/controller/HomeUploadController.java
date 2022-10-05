package com.ruoyi.houseservice.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.houseservice.domain.CManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.houseservice.domain.HomeUpload;
import com.ruoyi.houseservice.domain.Housing;
import com.ruoyi.houseservice.service.IHomeUploadService;
import com.ruoyi.houseservice.service.IHousingService;
/**
 * 房源上传Controller
 *
 * @author jiahua
 * @date 2022-04-30
 */
@RestController
@RequestMapping("/houseservice/upload")
public class HomeUploadController extends BaseController {
    @Autowired
    private IHomeUploadService homeUploadService;
    @Autowired
    private IHousingService housingService;


    /**
     * 模糊房源匹配 （总价，首付，面积，户型）
     * allPrice 总价
     * onePay 首付
     * area 面积
     * homeType 户型
     * @return 房源匹配
     */
    @GetMapping("/homeInfoMohu")
    public TableDataInfo homeInfoMohu(CManagement cManagement) {
        List<HomeUpload> list = homeUploadService.selectHomeInfoMohu(cManagement);
        return getDataTable(list);
    }

    /**
     * 查询经纪人列表
     * @return
     */
    @GetMapping(value = "/selectBrokerList")
    public AjaxResult selectBrokerList() {
        return AjaxResult.success(homeUploadService.selectBrokerList());
    }

    /**
     * 查询户型列表
     * @return
     */
    @GetMapping(value = "/selecthomeTypeList")
    public AjaxResult selecthomeTypeList() {
        return AjaxResult.success(homeUploadService.selecthomeTypeList());
    }

    /**
     * 房源匹配
     *
     * @param c_name 房源匹配
     * @param specialNeed
     * @return 房源匹配
     */
//    @GetMapping("/homeInfo")
//    public TableDataInfo homeInfo(@RequestParam("c_name") String c_name, @RequestParam("specialNeed") String specialNeed) {
//        List<HomeUpload> list = homeUploadService.selectHomeMatch(c_name, specialNeed);
//        return getDataTable(list);
//    }

    /**
     * 房源管理匹配
     */
    @GetMapping("/homeManagementList")
    public AjaxResult homeManagementList(HomeUpload homeUpload) {
        return AjaxResult.success(homeUploadService.selectHomeUploadList(homeUpload));
    }


    /**
     * 查询房源上传列表
     */
    @GetMapping("/list")
    public TableDataInfo list(HomeUpload homeUpload) {
        startPage();
        List<HomeUpload> list = homeUploadService.selectHomeUploadList(homeUpload);
        return getDataTable(list);
    }
    /**
     * 查询房源上传列表(权限管理)
     */
    @GetMapping("/listInfo")
    public TableDataInfo listInfo(HomeUpload homeUpload) {
        startPage();
        LoginUser loginUser = SecurityUtils.getLoginUser();
        if(loginUser.getUser().isAdmin()){
            homeUpload.setCompanyId(null);
            homeUpload.setUserId(null);
            homeUpload.setDeptId(null);
            homeUpload.setAreaId(null);
            homeUpload.setRoleId(null);
        }

        List<HomeUpload> list = homeUploadService.selectHomeUploadListInfo(homeUpload);
        return getDataTable(list);
    }

    /**
     * 查询房源上传列表（总价排序）
     */
    @GetMapping("/listOrderByPrice")
    public TableDataInfo listOrderByPrice(HomeUpload homeUpload) {
        startPage();
        List<HomeUpload> list = homeUploadService.selectHomeUploadListOrderByAllPrice(homeUpload);
        return getDataTable(list);
    }

    /**
     * 导出房源上传列表
     */
    @Log(title = "房源上传", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(HomeUpload homeUpload) {
        List<HomeUpload> list = homeUploadService.selectHomeUploadList(homeUpload);
        ExcelUtil<HomeUpload> util = new ExcelUtil<HomeUpload>(HomeUpload.class);
        return util.exportExcel(list, "upload");
    }

    /**
     * 获取房源上传详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id) {
        return AjaxResult.success(homeUploadService.selectHomeUploadById(id));
    }

    /**
     * 新增房源上传
     */
    @Log(title = "房源上传", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HomeUpload homeUpload) {

        List<HomeUpload> list = homeUploadService.selectHomeUploadList(homeUpload);

        if (list.size() == 0) {
            Housing housing = new Housing();
            housing.setName(homeUpload.getHomeName());
            List<Housing> housings = housingService.selectHousingList(housing);
            for (Housing a: housings) {
                homeUpload.setDistric(a.getDistric());
            }
            LoginUser loginUser = SecurityUtils.getLoginUser();
            homeUpload.setUserId(loginUser.getUser().getUserId().intValue());
            homeUpload.setDeptId(loginUser.getUser().getDeptId().intValue());
            homeUpload.setCompanyId(loginUser.getUser().getDept().getParentId().intValue());
            homeUpload.setCreater(loginUser.getUser().getNickName());
            homeUpload.setStoreFront(loginUser.getUser().getDept().getDeptName());
            homeUpload.setCreaterNumber(loginUser.getUser().getPhonenumber());
            homeUpload.setBroker(loginUser.getUser().getNickName());
            String s = "未售";
            homeUpload.setState(s);
            Date date = new Date(System.currentTimeMillis());
            homeUpload.setCreateTime(date);
            //获取当前时间转化对应数字
            SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmm");
            String str=sdf.format(new Date());
            homeUpload.setHouseNum(str);
            return toAjax(homeUploadService.insertHomeUpload(homeUpload));
        } else {
            return AjaxResult.error("数据已存在，请勿重复提交");
        }
    }

    /**
     * 修改房源上传
     */
    @Log(title = "房源上传", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HomeUpload homeUpload) {
        return toAjax(homeUploadService.updateHomeUpload(homeUpload));
    }

    /**
     * 删除房源上传
     */
    @Log(title = "房源上传", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids) {
        return toAjax(homeUploadService.deleteHomeUploadByIds(ids));
    }
}
