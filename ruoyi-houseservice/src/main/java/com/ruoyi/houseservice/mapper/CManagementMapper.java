package com.ruoyi.houseservice.mapper;

import java.util.List;
import com.ruoyi.houseservice.domain.CManagement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 客源管理Mapper接口
 * 
 * @author GaoyiZhang
 * @date 2022-04-29
 */
@Mapper
public interface CManagementMapper
{
    /**
     * 根据总价需求和特殊需求查询客源管理列表
     *
     * @param  allpriceNeed
     * @param  specialNeed
     * @return 客源管理
     */
    public List<CManagement> selectCustomer(@Param("allpriceNeed") String allpriceNeed, @Param("specialNeed") String specialNeed);


    /**
     * 查询客源管理
     * 
     * @param id 客源管理ID
     * @return 客源管理
     */
    public CManagement selectCManagementById(Long id);


    /**
     * 查询客源管理列表
     * 
     * @param cManagement 客源管理
     * @return 客源管理集合
     */
    public List<CManagement> selectCManagementList(CManagement cManagement);

    /**
     * 查询客源管理列表(权限管理)
     *
     * @param cManagement 客源管理
     * @return 客源管理集合
     */
    public List<CManagement> selectCManagementListInfo(CManagement cManagement);

    /**
     * 新增客源管理
     * 
     * @param cManagement 客源管理
     * @return 结果
     */
    public int insertCManagement(CManagement cManagement);

    /**
     * 修改客源管理
     * 
     * @param cManagement 客源管理
     * @return 结果
     */
    public int updateCManagement(CManagement cManagement);

    /**
     * 删除客源管理
     * 
     * @param id 客源管理ID
     * @return 结果
     */
    public int deleteCManagementById(Long id);

    /**
     * 批量删除客源管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCManagementByIds(Long[] ids);
}
