package com.ruoyi.houseservice.service.impl;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.houseservice.domain.CManagement;
import com.ruoyi.houseservice.domain.HomeUpload;
import com.ruoyi.houseservice.mapper.HomeUploadMapper;
import com.ruoyi.houseservice.service.IHomeUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * 房源上传Service业务层处理
 *
 * @author jiahua
 * @date 2022-04-30
 */
@Service
public class HomeUploadServiceImpl implements IHomeUploadService
{
    @Autowired
    private HomeUploadMapper homeUploadMapper;

    /**
     *
     * 模糊房源匹配 （总价，首付，面积，户型）
     *
     * allPrice 总价
     * onePay 首付
     * area 面积
     * homeType 户型
     * @return 房源匹配
     */
    @Override
    public List<HomeUpload> selectHomeInfoMohu(CManagement cManagement) {
        return homeUploadMapper.selectHomeInfoMohu(cManagement);
    }


    /**
     * 查询经纪人列表
     * @return
     */
    @Override
    public List<Map<String, Object>> selectBrokerList() {
        return homeUploadMapper.selectBrokerList();
    }

    /**
     * 房源匹配
     * @param cManagement
     * @return
     */
    @Override
    public List<HomeUpload> selectHomeMatch(CManagement cManagement) {
        return homeUploadMapper.selectHomeMatch(cManagement);
    }


    /**
     * 查询房源上传
     *
     * @param id 房源上传ID
     * @return 房源上传
     */
    @Override
    public HomeUpload selectHomeUploadById(Integer id)
    {
        return homeUploadMapper.selectHomeUploadById(id);
    }


    /**
     * 查询户型列表
     * @return
     */
    @Override
    public List<Map<String, Object>> selecthomeTypeList() {
        return homeUploadMapper.selecthomeTypeList();
    }

    /**
     * 查询房源上传列表
     *
     * @param homeUpload 房源上传
     * @return 房源上传
     */

    @Override
    public List<HomeUpload> selectHomeUploadList(HomeUpload homeUpload)
    {
        System.out.println("这是service");
        return homeUploadMapper.selectHomeUploadList(homeUpload);
    }

    /**
     * 查询房源上传列表(权限管理)
     *
     * @param homeUpload 房源上传
     * @return 房源上传
     */
    @DataScope(deptAlias = "homeUpload", userAlias = "homeUpload")
    @Override
    public List<HomeUpload> selectHomeUploadListInfo(HomeUpload homeUpload) {
        return homeUploadMapper.selectHomeUploadListInfo(homeUpload);
    }

    /**
     * 查询房源上传列表 总价排序
     *
     * @param homeUpload 房源上传
     * @return 房源上传集合
     */
    @Override
    public List<HomeUpload> selectHomeUploadListOrderByAllPrice(HomeUpload homeUpload) {
        return homeUploadMapper.selectHomeUploadListOederByAllPrice(homeUpload);
    }

    /**
     * 新增房源上传
     *
     * @param homeUpload 房源上传
     * @return 结果
     */

    @Override
    public int insertHomeUpload(HomeUpload homeUpload)
    {
        return homeUploadMapper.insertHomeUpload(homeUpload);
    }

    /**
     * 修改房源上传
     *
     * @param homeUpload 房源上传
     * @return 结果
     */
    @Override
    public int updateHomeUpload(HomeUpload homeUpload)
    {
        return homeUploadMapper.updateHomeUpload(homeUpload);
    }

    /**
     * 批量删除房源上传
     *
     * @param ids 需要删除的房源上传ID
     * @return 结果
     */
    @Override
    public int deleteHomeUploadByIds(Integer[] ids)
    {
        return homeUploadMapper.deleteHomeUploadByIds(ids);
    }

    /**
     * 删除房源上传信息
     *
     * @param id 房源上传ID
     * @return 结果
     */
    @Override
    public int deleteHomeUploadById(Integer id)
    {
        return homeUploadMapper.deleteHomeUploadById(id);
    }
}
