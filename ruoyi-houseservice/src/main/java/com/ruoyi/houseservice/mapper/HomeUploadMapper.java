package com.ruoyi.houseservice.mapper;
import java.util.List;

import com.ruoyi.houseservice.domain.CManagement;
import com.ruoyi.houseservice.domain.HomeUpload;
import java.util.Map;
import org.apache.ibatis.annotations.Param;


/**
 * 房源上传Mapper接口
 *
 * @author jiahua
 * @date 2022-04-30
 */
public interface HomeUploadMapper
{

    /**
     * 模糊房源匹配 （总价，首付，面积，户型）
     *
     * allPrice 总价
     * onePay 首付
     * area 面积
     * homeType 户型
     * @return 房源匹配
     */
    public List<HomeUpload> selectHomeInfoMohu(CManagement cManagement);

    /**
     * 查询经纪人列表
     * @return
     */
    public List<Map<String,Object>> selectBrokerList();

    /**
     * 查询商圈列表
     * @return
     */
    public List<Map<String,Object>> selectDistricList();

    /**

     * 查询户型列表
     * @return
     */
    public List<Map<String,Object>> selecthomeTypeList();


    /**
     * 房源匹配
     */

    public List<HomeUpload> selectHomeMatch(CManagement cManagement);

    /**
     * 查询房源上传
     *
     * @param id 房源上传ID
     * @return 房源上传
     */
    public HomeUpload selectHomeUploadById(Integer id);

    /**
     * 查询房源上传列表
     *
     * @param homeUpload 房源上传
     * @return 房源上传集合
     */
    public List<HomeUpload> selectHomeUploadList(HomeUpload homeUpload);

    /**
     * 查询房源上传列表(权限管理)
     *
     * @param homeUpload 房源上传
     * @return 房源上传集合
     */
    public List<HomeUpload> selectHomeUploadListInfo(HomeUpload homeUpload);


    /**
     * 查询房源上传列表 排序按照总价
     *
     * @param homeUpload 房源上传
     * @return 房源上传集合
     */
    public List<HomeUpload> selectHomeUploadListOederByAllPrice(HomeUpload homeUpload);

    /**
     * 新增房源上传
     *
     * @param homeUpload 房源上传
     * @return 结果
     */
    public int insertHomeUpload(HomeUpload homeUpload);

    /**
     * 修改房源上传
     *
     * @param homeUpload 房源上传
     * @return 结果
     */
    public int updateHomeUpload(HomeUpload homeUpload);

    /**
     * 删除房源上传
     *
     * @param id 房源上传ID
     * @return 结果
     */
    public int deleteHomeUploadById(Integer id);

    /**
     * 批量删除房源上传
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHomeUploadByIds(Integer[] ids);
}
