package com.ruoyi.houseservice.controller;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.annotation.RepeatSubmit;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.houseservice.domain.CManagement;
import com.ruoyi.houseservice.domain.HomeUpload;
import com.ruoyi.houseservice.service.ICManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 * 客源管理Controller
 *
 * @author GaoyiZhang
 * @date 2022-04-29
 */
@RestController
@RequestMapping("/houseservice/customerManagement")
public class CManagementController extends BaseController {
    @Autowired
    private ICManagementService cManagementService;

    /**
     * 根据总价,首付，面积，户型查询客源管理列表
     */

    @GetMapping("/getcustomerinfo")
    public TableDataInfo getcustomerinfo(HomeUpload homeUpload) {
        CManagement cManagement = new CManagement();

        if (homeUpload.getAllPrice() <= 20) {
            cManagement.setAllPrice("20万以下");
        } else if (homeUpload.getAllPrice() > 20 && homeUpload.getAllPrice() <= 30) {
            cManagement.setAllPrice("21-30万");
        } else if (homeUpload.getAllPrice()> 30 && homeUpload.getAllPrice() <= 40) {
            cManagement.setAllPrice("31-40万");
        } else if (homeUpload.getAllPrice() > 40 && homeUpload.getAllPrice() <= 50) {
            cManagement.setAllPrice("41-50万");
        } else if (homeUpload.getAllPrice() > 50 && homeUpload.getAllPrice() <= 60) {
            cManagement.setAllPrice("51-60万");
        } else if (homeUpload.getAllPrice() > 60 && homeUpload.getAllPrice() <= 70) {
            cManagement.setAllPrice("61-70万");
        } else if (homeUpload.getAllPrice() > 70 && homeUpload.getAllPrice() <= 80) {
            cManagement.setAllPrice("71-80万");
        } else if (homeUpload.getAllPrice() > 80 && homeUpload.getAllPrice() <= 100) {
            cManagement.setAllPrice("81-100万");
        } else if (homeUpload.getAllPrice() > 100 && homeUpload.getAllPrice() <= 130) {
            cManagement.setAllPrice("101-130万");
        } else {
            cManagement.setAllPrice("131万以上");
        }

        if (homeUpload.getOnePay() <= 5) {
            cManagement.setOnePay("5万以下");
        } else if (homeUpload.getOnePay() > 5 && homeUpload.getOnePay() <= 10) {
            cManagement.setOnePay("5-10万");
        } else if (homeUpload.getOnePay() > 10 && homeUpload.getOnePay() <= 15) {
            cManagement.setOnePay("10-15万");
        } else if (homeUpload.getOnePay() > 15 && homeUpload.getOnePay() <= 20) {
            cManagement.setOnePay("15-20万");
        } else if (homeUpload.getOnePay() > 20 && homeUpload.getOnePay() <= 25) {
            cManagement.setOnePay("20-25万");
        } else if (homeUpload.getOnePay() > 25 && homeUpload.getOnePay() <= 30) {
            cManagement.setOnePay("25-30万");
        } else {
            cManagement.setOnePay("30万以上");
        }

        if (homeUpload.getArea() <= 50) {
            cManagement.setArea("50㎡以下");
        } else if (homeUpload.getArea() > 50 && homeUpload.getArea() <= 70) {
            cManagement.setArea("51-70㎡");
        } else if (homeUpload.getArea() > 70 && homeUpload.getArea() <= 90) {
            cManagement.setArea("71-90㎡");
        } else if (homeUpload.getArea() > 90 && homeUpload.getArea() <= 100) {
            cManagement.setArea("91-100㎡");
        } else if (homeUpload.getArea() > 100 && homeUpload.getArea() <= 110) {
            cManagement.setArea("101-110㎡");
        } else if (homeUpload.getArea() > 110 && homeUpload.getArea() <= 120) {
            cManagement.setArea("111-120㎡");
        } else if (homeUpload.getArea() > 120 && homeUpload.getArea() <= 130) {
            cManagement.setArea("121-130㎡");
        } else if (homeUpload.getArea() > 130 && homeUpload.getArea() <= 150) {
            cManagement.setArea("131-150㎡");
        } else if (homeUpload.getArea() > 150 && homeUpload.getArea() <= 180) {
            cManagement.setArea("151-180㎡");
        } else {
            cManagement.setArea("181㎡以上");
        }

        cManagement.setHomeType(homeUpload.getHomeType());
        cManagement.setRegion(homeUpload.getRegion());
        cManagement.setTowards(homeUpload.getTowards());
        cManagement.setFurnish(homeUpload.getFurnish());
        cManagement.setFurnishStyle(homeUpload.getFurnishStyle());
        cManagement.setHomeName(homeUpload.getHomeName());
        cManagement.setPayType(homeUpload.getPayType());
        cManagement.setElevator(homeUpload.getElevator());
        cManagement.setFacility(homeUpload.getFacility());
        startPage();
        List<CManagement> list = cManagementService.selectCManagementList(cManagement);
        return getDataTable(list);
    }


    /**
     * 查询客源管理列表
     */

    @GetMapping("/list")
    public TableDataInfo list(CManagement cManagement)
    {
        startPage();
        List<CManagement> list = cManagementService.selectCManagementList(cManagement);
        return getDataTable(list);
    }

    /**
     * 查询客源管理列表(权限管理)
     */

    @GetMapping("/listInfo")
    public TableDataInfo listInfo(CManagement cManagement)
    {

        startPage();
        LoginUser loginUser = SecurityUtils.getLoginUser();
        if(loginUser.getUser().isAdmin()){
            cManagement.setFirmId(null);
            cManagement.setUserId(null);
            cManagement.setDeptId(null);
            cManagement.setRoleId(null);
        }
        List<CManagement> list = cManagementService.selectCManagementListInfo(cManagement);

        return getDataTable(list);
    }


    /**
     * 导出客源管理列表
     */
    @Log(title = "客源管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CManagement cManagement) {
        List<CManagement> list = cManagementService.selectCManagementList(cManagement);
        ExcelUtil<CManagement> util = new ExcelUtil<CManagement>(CManagement.class);
        return util.exportExcel(list, "customerManagement");
    }

    /**
     * 获取客源管理详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(cManagementService.selectCManagementById(id));
    }

    /**
     * 新增客源管理
     */
    @RepeatSubmit
    @Log(title = "客源管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CManagement cManagement)
    {
        LoginUser loginUser = SecurityUtils.getLoginUser();

        cManagement.setUserId(loginUser.getUser().getUserId());
        cManagement.setDeptId(loginUser.getUser().getDeptId());
        cManagement.setFirmId(loginUser.getUser().getDept().getParentId());
        cManagement.setUploader(loginUser.getUser().getNickName());
        cManagement.setUploaderPhone(loginUser.getUser().getPhonenumber());
        cManagement.setStatus("未成交");
        Date date = new Date(System.currentTimeMillis());
        cManagement.setCreateTime(date);
        //获取当前时间转化对应数字
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmm");
        Long str= Long.valueOf(sdf.format(new Date()));
       cManagement.setCustomId(str);

        List<CManagement> list = cManagementService.selectCManagementList(cManagement);

        if (list.size()==0) {
            return toAjax(cManagementService.insertCManagement(cManagement));
        } else {
            return AjaxResult.error("数据已存在，请勿重复提交");
        }
    }

    /**
     * 修改客源管理
     */
    @Log(title = "客源管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CManagement cManagement) {
        return toAjax(cManagementService.updateCManagement(cManagement));
    }

    /**
     * 删除客源管理
     */
    @Log(title = "客源管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(cManagementService.deleteCManagementByIds(ids));
    }
}
