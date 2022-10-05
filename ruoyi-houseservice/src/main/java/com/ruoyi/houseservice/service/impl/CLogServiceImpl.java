package com.ruoyi.houseservice.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.houseservice.mapper.CLogMapper;
import com.ruoyi.houseservice.domain.CLog;
import com.ruoyi.houseservice.service.ICLogService;

/**
 * 操作日志Service业务层处理
 * 
 * @author GaoyiZhang
 * @date 2022-05-07
 */
@Service
public class CLogServiceImpl implements ICLogService 
{
    @Autowired
    private CLogMapper cLogMapper;

    /**
     * 查询操作日志
     * 
     * @param id 操作日志ID
     * @return 操作日志
     */
    @Override
    public CLog selectCLogById(Long id)
    {
        return cLogMapper.selectCLogById(id);
    }

    /**
     * 查询操作日志列表
     * 
     * @param cLog 操作日志
     * @return 操作日志
     */
    @Override
    public List<CLog> selectCLogList(CLog cLog)
    {
        return cLogMapper.selectCLogList(cLog);
    }

    /**
     * 新增操作日志
     * 
     * @param cLog 操作日志
     * @return 结果
     */
    @Override
    public int insertCLog(CLog cLog)
    {
        return cLogMapper.insertCLog(cLog);
    }

    /**
     * 修改操作日志
     * 
     * @param cLog 操作日志
     * @return 结果
     */
    @Override
    public int updateCLog(CLog cLog)
    {
        return cLogMapper.updateCLog(cLog);
    }

    /**
     * 批量删除操作日志
     * 
     * @param ids 需要删除的操作日志ID
     * @return 结果
     */
    @Override
    public int deleteCLogByIds(Long[] ids)
    {
        return cLogMapper.deleteCLogByIds(ids);
    }

    /**
     * 删除操作日志信息
     * 
     * @param id 操作日志ID
     * @return 结果
     */
    @Override
    public int deleteCLogById(Long id)
    {
        return cLogMapper.deleteCLogById(id);
    }


    /**
     * 清空操作日志
     */
    @Override
    public void cleanCLog() {
        cLogMapper.cleanCLog();
    }
}
