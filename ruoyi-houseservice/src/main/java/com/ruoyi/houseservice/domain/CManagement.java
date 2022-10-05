package com.ruoyi.houseservice.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 客源上传对象 c_management
 * 
 * @author Gaoyi
 * @date 2022-06-22
 */
public class CManagement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 公司id */
    @Excel(name = "公司id")
    private Long firmId;

    /** 部门id */
    @Excel(name = "部门id")
    private Long deptId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 角色id */
    @Excel(name = "角色id")
    private Long roleId;

    /** 客源编号 */
    @Excel(name = "客源编号")
    private Long customId;

    /** 上传者 */
    @Excel(name = "上传者")
    private String uploader;

    /** 上传者电话 */
    @Excel(name = "上传者电话")
    private String uploaderPhone;

    /** 公私盘 */
    @Excel(name = "公私盘")
    private String gongSiPan;

    /** 客户等级 */
    @Excel(name = "客户等级")
    private String customerLever;

    /** 购房目的 */
    @Excel(name = "购房目的")
    private String purpose;

    /** 客户姓名1 */
    @Excel(name = "客户姓名1")
    private String name;

    /** 联系方式1 */
    @Excel(name = "联系方式1")
    private String phoneNum;

    /** 客户姓名2 */
    @Excel(name = "客户姓名2")
    private String nameOne;

    /** 联系方式2 */
    @Excel(name = "联系方式2")
    private String phoneNumber;

    /** 客户性别 */
    @Excel(name = "客户性别")
    private String sex;

    /** 区域 */
    @Excel(name = "区域")
    private String region;

    /** 小区 */
    @Excel(name = "小区")
    private String homeName;

    /** 总价 */
    @Excel(name = "总价")
    private String allPrice;

    /** 面积 */
    @Excel(name = "面积")
    private String area;

    /** 首付 */
    @Excel(name = "首付")
    private String onePay;

    /** 户型 */
    @Excel(name = "户型")
    private String homeType;

    /** 朝向 */
    @Excel(name = "朝向")
    private String towards;

    /** 装修现状 */
    @Excel(name = "装修现状")
    private String furnish;

    /** 装修风格 */
    @Excel(name = "装修风格")
    private String furnishStyle;

    /** 装修年限 */
    @Excel(name = "装修年限")
    private String furnishYear;


    /** 电梯/步梯 */
    @Excel(name = "电梯/步梯")
    private String elevator;

    /** 支付方式 */
    @Excel(name = "支付方式")
    private String payType;

    public String getFurnishYear() {
        return furnishYear;
    }

    public void setFurnishYear(String furnishYear) {
        this.furnishYear = furnishYear;
    }

    /** 忌讳楼层 */
    @Excel(name = "忌讳楼层")
    private String floor;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 到期时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "到期时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date expireDate;

    /** 附属设施 */
    @Excel(name = "附属设施")
    private String facility;

    /** 其他需求 */
    @Excel(name = "其他需求")
    private String otherNeed;

    /** 客源状态 */
    @Excel(name = "客源状态")
    private String status;

    /** 备用2 */
    @Excel(name = "备用2")
    private String flog2;

    /** 备用3 */
    @Excel(name = "备用3")
    private String flog3;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setFirmId(Long firmId) 
    {
        this.firmId = firmId;
    }

    public Long getFirmId() 
    {
        return firmId;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setRoleId(Long roleId) 
    {
        this.roleId = roleId;
    }

    public Long getRoleId() 
    {
        return roleId;
    }
    public void setCustomId(Long customId) 
    {
        this.customId = customId;
    }

    public Long getCustomId() 
    {
        return customId;
    }
    public void setUploader(String uploader) 
    {
        this.uploader = uploader;
    }

    public String getUploader() 
    {
        return uploader;
    }
    public void setUploaderPhone(String uploaderPhone) 
    {
        this.uploaderPhone = uploaderPhone;
    }

    public String getUploaderPhone() 
    {
        return uploaderPhone;
    }
    public void setGongSiPan(String gongSiPan) 
    {
        this.gongSiPan = gongSiPan;
    }

    public String getGongSiPan() 
    {
        return gongSiPan;
    }
    public void setCustomerLever(String customerLever) 
    {
        this.customerLever = customerLever;
    }

    public String getCustomerLever() 
    {
        return customerLever;
    }
    public void setPurpose(String purpose) 
    {
        this.purpose = purpose;
    }

    public String getPurpose() 
    {
        return purpose;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPhoneNum(String phoneNum) 
    {
        this.phoneNum = phoneNum;
    }

    public String getPhoneNum() 
    {
        return phoneNum;
    }
    public void setNameOne(String nameOne) 
    {
        this.nameOne = nameOne;
    }

    public String getNameOne() 
    {
        return nameOne;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setRegion(String region)
    {
        this.region = region;
    }

    public String getRegion()
    {
        return region;
    }
    public void setHomeName(String homeName) 
    {
        this.homeName = homeName;
    }

    public String getHomeName() 
    {
        return homeName;
    }
    public void setAllPrice(String allPrice) 
    {
        this.allPrice = allPrice;
    }

    public String getAllPrice() 
    {
        return allPrice;
    }
    public void setArea(String area)
    {
        this.area = area;
    }

    public String getArea()
    {
        return area;
    }
    public void setOnePay(String onePay) 
    {
        this.onePay = onePay;
    }

    public String getOnePay() 
    {
        return onePay;
    }
    public void setHomeType(String homeType)
    {
        this.homeType = homeType;
    }

    public String getHomeType()
    {
        return homeType;
    }
    public void setTowards(String towards) 
    {
        this.towards = towards;
    }

    public String getTowards() 
    {
        return towards;
    }
    public void setFurnish(String furnish) 
    {
        this.furnish = furnish;
    }

    public String getFurnish() 
    {
        return furnish;
    }
    public void setFurnishStyle(String furnishStyle) 
    {
        this.furnishStyle = furnishStyle;
    }

    public String getFurnishStyle() 
    {
        return furnishStyle;
    }

    public void setElevator(String elevator) 
    {
        this.elevator = elevator;
    }

    public String getElevator() 
    {
        return elevator;
    }
    public void setPayType(String payType) 
    {
        this.payType = payType;
    }

    public String getPayType() 
    {
        return payType;
    }
    public void setFloor(String floor)
    {
        this.floor = floor;
    }

    public String getFloor()
    {
        return floor;
    }
    public void setNote(String note) 
    {
        this.note = note;
    }

    public String getNote() 
    {
        return note;
    }
    public void setExpireDate(Date expireDate) 
    {
        this.expireDate = expireDate;
    }

    public Date getExpireDate() 
    {
        return expireDate;
    }
    public void setFacility(String facility) 
    {
        this.facility = facility;
    }

    public String getFacility() 
    {
        return facility;
    }
    public void setOtherNeed(String otherNeed) 
    {
        this.otherNeed = otherNeed;
    }

    public String getOtherNeed() 
    {
        return otherNeed;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setFlog2(String flog2) 
    {
        this.flog2 = flog2;
    }

    public String getFlog2() 
    {
        return flog2;
    }
    public void setFlog3(String flog3) 
    {
        this.flog3 = flog3;
    }

    public String getFlog3() 
    {
        return flog3;
    }

    @Override
    public String toString() {
        return "CManagement{" +
                "id=" + id +
                ", firmId=" + firmId +
                ", deptId=" + deptId +
                ", userId=" + userId +
                ", roleId=" + roleId +
                ", customId=" + customId +
                ", uploader='" + uploader + '\'' +
                ", uploaderPhone='" + uploaderPhone + '\'' +
                ", gongSiPan='" + gongSiPan + '\'' +
                ", customerLever='" + customerLever + '\'' +
                ", purpose='" + purpose + '\'' +
                ", name='" + name + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", nameOne='" + nameOne + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", sex='" + sex + '\'' +
                ", region='" + region + '\'' +
                ", homeName='" + homeName + '\'' +
                ", allPrice='" + allPrice + '\'' +
                ", area='" + area + '\'' +
                ", onePay='" + onePay + '\'' +
                ", homeType='" + homeType + '\'' +
                ", towards='" + towards + '\'' +
                ", furnish='" + furnish + '\'' +
                ", furnishStyle='" + furnishStyle + '\'' +
                ", furnishYear='" + furnishYear + '\'' +
                ", elevator='" + elevator + '\'' +
                ", payType='" + payType + '\'' +
                ", floor='" + floor + '\'' +
                ", note='" + note + '\'' +
                ", expireDate=" + expireDate +
                ", facility='" + facility + '\'' +
                ", otherNeed='" + otherNeed + '\'' +
                ", status='" + status + '\'' +
                ", flog2='" + flog2 + '\'' +
                ", flog3='" + flog3 + '\'' +
                '}';
    }
}
