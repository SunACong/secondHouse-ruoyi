package com.ruoyi.houseservice.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 房源上传对象 home_upload
 *
 * @author jiahua
 * @date 2022-04-30
 */
public class HomeUpload extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Integer id;

    /** 用户id */
    private Integer userId;

    /** 部门id */
    private Integer deptId;

    /** 公司id */
    private Integer companyId;

    /** 角色id */
    private Integer roleId;

    /** 区域id */
    private Long areaId;

    /** 房源编号 */
    @Excel(name = "房源编号")
    private String houseNum;

    /** 公私盘 */
    @Excel(name = "公私盘")
    private String gongSiPan;

    /** 房东姓名 */
    @Excel(name = "房东姓名")
    private String name;

    /** 房东电话 */
    @Excel(name = "房东电话")
    private String phoneNum;

    /** 小区名称 */
    @Excel(name = "小区名称")
    private String homeName;

    /** 房龄 */
    @Excel(name = "房龄")
    private Integer roomAge;

    /** 电梯 */
    @Excel(name = "电梯")
    private String elevator;

    /** 产证状态 */
    @Excel(name = "产证状态")
    private String productStatus;

    /** 栋座 */
    @Excel(name = "栋座")
    private String build;

    /** 单元 */
    @Excel(name = "单元")
    private String unit;

    /** 楼层 */
    @Excel(name = "楼层")
    private String floor;

    /** 房号 */
    @Excel(name = "房号")
    private Integer roomId;

    /** 户型 */
    @Excel(name = "户型")
    private String homeType;

    /** 面积（平方米） */
    @Excel(name = "面积", readConverterExp = "平=方米")
    private Double area;

    /** 总价（万元） */
    @Excel(name = "总价", readConverterExp = "万=元")
    private Double allPrice;

    /** 底价（万元） */
    @Excel(name = "底价", readConverterExp = "万=元")
    private Double lowPrice;

    /** 首付（万元） */
    @Excel(name = "首付", readConverterExp = "万=元")
    private Double onePay;

    /** 产权状态 */
    @Excel(name = "产权状态")
    private String propertyStatus;

    /** 装修 */
    @Excel(name = "装修")
    private String furnish;

    /** 朝向 */
    @Excel(name = "朝向")
    private String towards;

    /** 支付方式 */
    @Excel(name = "支付方式")
    private String payType;

    /** 附属设施 */
    @Excel(name = "附属设施")
    private String facility;

    /** 状态 */
    private String state;

    /** 特殊需求 */
    @Excel(name = "特殊需求")
    private String specialNeed;

    /** 图片1 */
    @Excel(name = "图片1")
    private String picOne;

    /** 图片2 */
    @Excel(name = "图片2")
    private String picTwo;

    /** 图片3 */
    @Excel(name = "图片3")
    private String picThree;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /** 经济人 */
    @Excel(name = "经济人")
    private String broker;

    /** 创建人 */
    @Excel(name = "创建人")
    private String creater;

    /** 创建人电话 */
    @Excel(name = "创建人电话")
    private String createrNumber;

    /** 门店 */
    @Excel(name = "门店")
    private String storeFront;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 备用字段1 */
    private String readyOne;

    /** 备用字段2 */
    private String readyTwo;

    /** 商圈 */
    @Excel(name = "商圈")
    private String distric;

    /** 房东姓名2 */
    @Excel(name = "房东姓名2")
    private String nameOne;

    /** 房东电话2 */
    @Excel(name = "房东电话2")
    private String phoneNumber;

    /** 区域 */
    @Excel(name = "区域")
    private String region;

    /** 房源等级 */
    @Excel(name = "房源等级")
    private String homeLevel;

    /** 产证地址 */
    @Excel(name = "产证地址")
    private String location;

    /** 装修风格 */
    @Excel(name = "装修风格")
    private String furnishStyle;

    /** 装修金额 */
    @Excel(name = "装修金额")
    private Double furnishAmount;

    /** 装修时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "装修时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date furnishTime;

    /** 产权性质 */
    @Excel(name = "产权性质")
    private String property;

    /** 产权类型 */
    @Excel(name = "产权类型")
    private String propertyType;

    /** 房屋现状 */
    @Excel(name = "房屋现状")
    private String currentStatus;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public String getGongSiPan() {
        return gongSiPan;
    }

    public void setGongSiPan(String gongSiPan) {
        this.gongSiPan = gongSiPan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public Integer getRoomAge() {
        return roomAge;
    }

    public void setRoomAge(Integer roomAge) {
        this.roomAge = roomAge;
    }

    public String getElevator() {
        return elevator;
    }

    public void setElevator(String elevator) {
        this.elevator = elevator;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getHomeType() {
        return homeType;
    }

    public void setHomeType(String homeType) {
        this.homeType = homeType;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(Double allPrice) {
        this.allPrice = allPrice;
    }

    public Double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(Double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public Double getOnePay() {
        return onePay;
    }

    public void setOnePay(Double onePay) {
        this.onePay = onePay;
    }

    public String getPropertyStatus() {
        return propertyStatus;
    }

    public void setPropertyStatus(String propertyStatus) {
        this.propertyStatus = propertyStatus;
    }

    public String getFurnish() {
        return furnish;
    }

    public void setFurnish(String furnish) {
        this.furnish = furnish;
    }

    public String getTowards() {
        return towards;
    }

    public void setTowards(String towards) {
        this.towards = towards;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSpecialNeed() {
        return specialNeed;
    }

    public void setSpecialNeed(String specialNeed) {
        this.specialNeed = specialNeed;
    }

    public String getPicOne() {
        return picOne;
    }

    public void setPicOne(String picOne) {
        this.picOne = picOne;
    }

    public String getPicTwo() {
        return picTwo;
    }

    public void setPicTwo(String picTwo) {
        this.picTwo = picTwo;
    }

    public String getPicThree() {
        return picThree;
    }

    public void setPicThree(String picThree) {
        this.picThree = picThree;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getCreaterNumber() {
        return createrNumber;
    }

    public void setCreaterNumber(String createrNumber) {
        this.createrNumber = createrNumber;
    }

    public String getStoreFront() {
        return storeFront;
    }

    public void setStoreFront(String storeFront) {
        this.storeFront = storeFront;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getReadyOne() {
        return readyOne;
    }

    public void setReadyOne(String readyOne) {
        this.readyOne = readyOne;
    }

    public String getReadyTwo() {
        return readyTwo;
    }

    public void setReadyTwo(String readyTwo) {
        this.readyTwo = readyTwo;
    }

    public String getDistric() {
        return distric;
    }

    public void setDistric(String distric) {
        this.distric = distric;
    }

    public String getNameOne() {
        return nameOne;
    }

    public void setNameOne(String nameOne) {
        this.nameOne = nameOne;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getHomeLevel() {
        return homeLevel;
    }

    public void setHomeLevel(String homeLevel) {
        this.homeLevel = homeLevel;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFurnishStyle() {
        return furnishStyle;
    }

    public void setFurnishStyle(String furnishStyle) {
        this.furnishStyle = furnishStyle;
    }

    public Double getFurnishAmount() {
        return furnishAmount;
    }

    public void setFurnishAmount(Double furnishAmount) {
        this.furnishAmount = furnishAmount;
    }

    public Date getFurnishTime() {
        return furnishTime;
    }

    public void setFurnishTime(Date furnishTime) {
        this.furnishTime = furnishTime;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    @Override
    public String toString() {
        return "HomeUpload{" +
                "id=" + id +
                ", userId=" + userId +
                ", deptId=" + deptId +
                ", companyId=" + companyId +
                ", roleId=" + roleId +
                ", areaId=" + areaId +
                ", houseNum='" + houseNum + '\'' +
                ", gongSiPan='" + gongSiPan + '\'' +
                ", name='" + name + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", homeName='" + homeName + '\'' +
                ", roomAge=" + roomAge +
                ", elevator='" + elevator + '\'' +
                ", productStatus='" + productStatus + '\'' +
                ", build='" + build + '\'' +
                ", unit='" + unit + '\'' +
                ", floor='" + floor + '\'' +
                ", roomId=" + roomId +
                ", homeType='" + homeType + '\'' +
                ", area=" + area +
                ", allPrice=" + allPrice +
                ", lowPrice=" + lowPrice +
                ", onePay=" + onePay +
                ", propertyStatus='" + propertyStatus + '\'' +
                ", furnish='" + furnish + '\'' +
                ", towards='" + towards + '\'' +
                ", payType='" + payType + '\'' +
                ", facility='" + facility + '\'' +
                ", state='" + state + '\'' +
                ", specialNeed='" + specialNeed + '\'' +
                ", picOne='" + picOne + '\'' +
                ", picTwo='" + picTwo + '\'' +
                ", picThree='" + picThree + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", broker='" + broker + '\'' +
                ", creater='" + creater + '\'' +
                ", createrNumber='" + createrNumber + '\'' +
                ", storeFront='" + storeFront + '\'' +
                ", note='" + note + '\'' +
                ", readyOne='" + readyOne + '\'' +
                ", readyTwo='" + readyTwo + '\'' +
                ", distric='" + distric + '\'' +
                ", nameOne='" + nameOne + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", region='" + region + '\'' +
                ", homeLevel='" + homeLevel + '\'' +
                ", location='" + location + '\'' +
                ", furnishStyle='" + furnishStyle + '\'' +
                ", furnishAmount=" + furnishAmount +
                ", furnishTime=" + furnishTime +
                ", property='" + property + '\'' +
                ", propertyType='" + propertyType + '\'' +
                ", currentStatus='" + currentStatus + '\'' +
                '}';
    }
}

