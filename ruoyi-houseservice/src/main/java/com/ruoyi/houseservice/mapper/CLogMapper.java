package com.ruoyi.houseservice.mapper;

import java.util.List;
import com.ruoyi.houseservice.domain.CLog;

/**
 * 操作日志Mapper接口
 * 
 * @author GaoyiZhang
 * @date 2022-05-07
 */
public interface CLogMapper 
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
     * 删除操作日志
     * 
     * @param id 操作日志ID
     * @return 结果
     */
    public int deleteCLogById(Long id);

    /**
     * 批量删除操作日志
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCLogByIds(Long[] ids);

    /**
     * 清空操作日志
     */
    public void cleanCLog();
}
