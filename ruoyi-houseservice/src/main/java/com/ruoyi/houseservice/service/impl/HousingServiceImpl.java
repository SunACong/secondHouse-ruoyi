package com.ruoyi.houseservice.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.houseservice.mapper.HousingMapper;
import com.ruoyi.houseservice.domain.Housing;
import com.ruoyi.houseservice.service.IHousingService;

/**
 * 小区Service业务层处理
 * 
 * @author jiahua
 * @date 2022-05-25
 */
@Service
public class HousingServiceImpl implements IHousingService 
{
    @Autowired
    private HousingMapper housingMapper;

    /**
     * 查询小区
     * 
     * @param id 小区ID
     * @return 小区
     */
    @Override
    public Housing selectHousingById(Long id)
    {
        return housingMapper.selectHousingById(id);
    }

    /**
     * 查询小区列表
     * 
     * @param housing 小区
     * @return 小区
     */
    @Override
    public List<Housing> selectHousingList(Housing housing)
    {
        return housingMapper.selectHousingList(housing);
    }

    /**
     * 查询商圈列表
     *
     * @param housing 小区
     * @return 小区
     */
    @Override
    public List<Housing> selectDistricList(Housing housing)
    {
        return housingMapper.selectDistricList(housing);
    }

    /**
     * 查询小区列表
     *
     * @param housing 小区
     * @return 小区
     */
    @Override
    public List<Housing> selectHomeList(Housing housing)
    {
        return housingMapper.selectHomeList(housing);
    }


    /**
     * 新增小区
     * 
     * @param housing 小区
     * @return 结果
     */
    @Override
    public int insertHousing(Housing housing)
    {
        return housingMapper.insertHousing(housing);
    }

    /**
     * 修改小区
     * 
     * @param housing 小区
     * @return 结果
     */
    @Override
    public int updateHousing(Housing housing)
    {
        return housingMapper.updateHousing(housing);
    }

    /**
     * 批量删除小区
     * 
     * @param ids 需要删除的小区ID
     * @return 结果
     */
    @Override
    public int deleteHousingByIds(Long[] ids)
    {
        return housingMapper.deleteHousingByIds(ids);
    }

    /**
     * 删除小区信息
     * 
     * @param id 小区ID
     * @return 结果
     */
    @Override
    public int deleteHousingById(Long id)
    {
        return housingMapper.deleteHousingById(id);
    }
}
