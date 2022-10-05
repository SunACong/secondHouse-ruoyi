package com.ruoyi.houseservice.mapper;

import java.util.List;
import com.ruoyi.houseservice.domain.Housing;

/**
 * 小区Mapper接口
 * 
 * @author jiahua
 * @date 2022-05-25
 */
public interface HousingMapper 
{
    /**
     * 查询小区
     * 
     * @param id 小区ID
     * @return 小区
     */
    public Housing selectHousingById(Long id);

    /**
     * 查询小区所有信息列表
     * 
     * @param housing 小区
     * @return 小区集合
     */
    public List<Housing> selectHousingList(Housing housing);

    /**
     * 查询商圈列表
     *
     * @param housing 小区
     * @return 小区集合
     */
    public List<Housing> selectDistricList(Housing housing);

    /**
     * 查询小区列表
     *
     * @param housing 小区
     * @return 小区集合
     */
    public List<Housing> selectHomeList(Housing housing);

    /**
     * 新增小区
     * 
     * @param housing 小区
     * @return 结果
     */
    public int insertHousing(Housing housing);

    /**
     * 修改小区
     * 
     * @param housing 小区
     * @return 结果
     */
    public int updateHousing(Housing housing);

    /**
     * 删除小区
     * 
     * @param id 小区ID
     * @return 结果
     */
    public int deleteHousingById(Long id);

    /**
     * 批量删除小区
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHousingByIds(Long[] ids);
}
