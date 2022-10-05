package com.ruoyi.houseservice.service;

import java.util.List;
import com.ruoyi.houseservice.domain.CLog;

/**
 * 操作日志Service接口
 * 
 * @author GaoyiZhang
 * @date 2022-05-07
 */
public interface ICLogService 
{
    /**
     * 查询操作日志
     * 
     * @param id 操作日志ID
     * @return 操作日志
     */
    public CLog selectCLogById(Long id);

    /**
     * 查询操作日志列表
     * 
     * @param cLog 操作日志
     * @return 操作日志集合
     */
    public List<CLog> selectCLogList(CLog cLog);

    /**
     * 新增操作日志
     * 
     * @param cLog 操作日志
     * @return 结果
     */
    public int insertCLog(CLog cLog);

    /**
     * 修改操作日志
     * 
     * @param cLog 操作日志
     * @return 结果
     */
    public int updateCLog(CLog cLog);

    /**
     * 批量删除操作日志
     * 
     * @param ids 需要删除的操作日志ID
     * @return 结果
     */
    public int deleteCLogByIds(Long[] ids);

    /**
     * 删除操作日志信息
     * 
     * @param id 操作日志ID
     * @return 结果
     */
    public int deleteCLogById(Long id);
    /**
     * 清空操作日志
     */
    public void cleanCLog();
}
