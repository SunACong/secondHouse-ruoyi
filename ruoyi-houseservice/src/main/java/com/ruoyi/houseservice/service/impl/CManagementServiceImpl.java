package com.ruoyi.houseservice.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.houseservice.mapper.CManagementMapper;
import com.ruoyi.houseservice.domain.CManagement;
import com.ruoyi.houseservice.service.ICManagementService;

/**
 * 客源管理Service业务层处理
 *
 * @author GaoyiZhang
 * @date 2022-04-29
 */
@Service
public class CManagementServiceImpl implements ICManagementService
{
    @Autowired
    private CManagementMapper cManagementMapper;

    /**
     * 根据总价需求和特殊需求查询客源管理列表
     *
     * @param  allpriceNeed
     * @param  specialNeed
     * @return 客源管理
     */
    @Override
    public List<CManagement> selectCustomer(String allpriceNeed, String specialNeed) {
        return cManagementMapper.selectCustomer(allpriceNeed,specialNeed);
    }


    /**
     * 查询客源管理
     *
     * @param id 客源管理ID
     * @return 客源管理
     */
    @Override
    public CManagement selectCManagementById(Long id)
    {
        return cManagementMapper.selectCManagementById(id);
    }


    /**
     * 查询客源管理列表
     *
     * @param cManagement 客源管理
     * @return 客源管理
     */

    @Override
    public List<CManagement> selectCManagementList(CManagement cManagement)
    {
        return cManagementMapper.selectCManagementList(cManagement);
    }



    /**
     * 查询客源管理列表(权限管理)
     *
     * @param cManagement 客源管理
     * @return 客源管理集合
     */
    @DataScope(deptAlias = "cManagement", userAlias = "cManagement")
    @Override
    public List<CManagement> selectCManagementListInfo(CManagement cManagement) {
        return cManagementMapper.selectCManagementListInfo(cManagement);
    }

    /**
     * 新增客源管理
     *
     * @param cManagement 客源管理
     * @return 结果
     */
    @Override
    public int insertCManagement(CManagement cManagement)
    {
        return cManagementMapper.insertCManagement(cManagement);
    }

    /**
     * 修改客源管理
     *
     * @param cManagement 客源管理
     * @return 结果
     */
    @Override
    public int updateCManagement(CManagement cManagement)
    {
        return cManagementMapper.updateCManagement(cManagement);
    }

    /**
     * 批量删除客源管理
     *
     * @param ids 需要删除的客源管理ID
     * @return 结果
     */
    @Override
    public int deleteCManagementByIds(Long[] ids)
    {
        return cManagementMapper.deleteCManagementByIds(ids);
    }

    /**
     * 删除客源管理信息
     *
     * @param id 客源管理ID
     * @return 结果
     */
    @Override
    public int deleteCManagementById(Long id)
    {
        return cManagementMapper.deleteCManagementById(id);
    }
}
