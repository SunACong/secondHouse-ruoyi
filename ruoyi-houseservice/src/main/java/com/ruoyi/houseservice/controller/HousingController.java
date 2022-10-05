package com.ruoyi.houseservice.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.houseservice.domain.Housing;
import com.ruoyi.houseservice.service.IHousingService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 小区Controller
 * 
 * @author jiahua
 * @date 2022-05-25
 */
@RestController
@RequestMapping("/houseservice/housing")
public class HousingController extends BaseController
{
    @Autowired
    private IHousingService housingService;

    /**
     * 查询小区所有信息列表
     */
    @PreAuthorize("@ss.hasPermi('houseservice:housing:list')")
    @GetMapping("/list")
    public TableDataInfo list(Housing housing)
    {
        startPage();
        List<Housing> list = housingService.selectHousingList(housing);
        return getDataTable(list);
    }

    /**
     * 查询商圈列表
     */
    @GetMapping("/selectDistricList")
    public TableDataInfo selectDistricList(Housing housing)
    {
        startPage();
        List<Housing> list = housingService.selectDistricList(housing);
        return getDataTable(list);
    }

    /**
     * 查询小区列表
     */
    @GetMapping("/selectHomeList")
    public TableDataInfo selectHomeList(Housing housing)
    {
        startPage();
        List<Housing> list = housingService.selectHomeList(housing);
        return getDataTable(list);
    }

    /**
     * 导出小区列表
     */
    @PreAuthorize("@ss.hasPermi('houseservice:housing:export')")
    @Log(title = "小区", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Housing housing)
    {
        List<Housing> list = housingService.selectHousingList(housing);
        ExcelUtil<Housing> util = new ExcelUtil<Housing>(Housing.class);
        return util.exportExcel(list, "housing");
    }

    /**
     * 获取小区详细信息
     */
    @PreAuthorize("@ss.hasPermi('houseservice:housing:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(housingService.selectHousingById(id));
    }

    /**
     * 新增小区
     */
    @PreAuthorize("@ss.hasPermi('houseservice:housing:add')")
    @Log(title = "小区", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Housing housing)
    {
        return toAjax(housingService.insertHousing(housing));
    }

    /**
     * 修改小区
     */
    @PreAuthorize("@ss.hasPermi('houseservice:housing:edit')")
    @Log(title = "小区", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Housing housing)
    {
        return toAjax(housingService.updateHousing(housing));
    }

    /**
     * 删除小区
     */
    @PreAuthorize("@ss.hasPermi('houseservice:housing:remove')")
    @Log(title = "小区", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(housingService.deleteHousingByIds(ids));
    }
}
