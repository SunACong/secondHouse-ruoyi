package com.ruoyi.houseservice.controller;

import java.util.Date;
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
import com.ruoyi.houseservice.domain.CLog;
import com.ruoyi.houseservice.service.ICLogService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 操作日志Controller
 * 
 * @author GaoyiZhang
 * @date 2022-05-07
 */
@RestController
@RequestMapping("/houseservice/log")
public class CLogController extends BaseController
{
    @Autowired
    private ICLogService cLogService;

    /**
     * 查询操作日志列表
     */
    @GetMapping("/list")
    public TableDataInfo list(CLog cLog)
    {
        startPage();
        List<CLog> list = cLogService.selectCLogList(cLog);
        return getDataTable(list);
    }
    /**
     * 新增操作日志
     */

    @Log(title = "操作日志", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CLog cLog)
    {
        Date date = new Date(System.currentTimeMillis());
        cLog.setCheckTime(date);
        return toAjax(cLogService.insertCLog(cLog));
    }

    /**
     * 导出操作日志列表
     */

    @Log(title = "操作日志", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CLog cLog)
    {
        List<CLog> list = cLogService.selectCLogList(cLog);
        ExcelUtil<CLog> util = new ExcelUtil<CLog>(CLog.class);
        return util.exportExcel(list, "log");
    }



    /**
     * 删除操作日志
     */

    @Log(title = "操作日志", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cLogService.deleteCLogByIds(ids));
    }

    /**
     * 清空操作日志
     */
    @Log(title = "操作日志", businessType = BusinessType.CLEAN)

    @DeleteMapping("/clean")
    public AjaxResult clean()
    {
        cLogService.cleanCLog();
        return AjaxResult.success();
    }
}
