package com.ruoyi.houseservice.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 小区对象 housing
 * 
 * @author jiahua
 * @date 2022-05-25
 */
public class Housing extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 小区名称 */
    @Excel(name = "小区名称")
    private String name;

    /** 产权性质 */
    @Excel(name = "产权性质")
    private String property;

    /** 银行评估值 */
    @Excel(name = "银行评估值")
    private BigDecimal bankValue;

    /** 市场价 */
    @Excel(name = "市场价")
    private BigDecimal marketPrice;

    /** 税务单价 */
    @Excel(name = "税务单价")
    private BigDecimal taxPrice;

    /** 商圈 */
    @Excel(name = "商圈")
    private String distric;

    /** 贷款比例值 */
    @Excel(name = "贷款比例值")
    private BigDecimal loanValue;

    /** 交房日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "交房日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date exchangeDate;

    /** 产证状态 */
    @Excel(name = "产证状态")
    private String productStatus;

    /** 备用1 */
    @Excel(name = "备用1")
    private String ready;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setProperty(String property) 
    {
        this.property = property;
    }

    public String getProperty() 
    {
        return property;
    }
    public void setBankValue(BigDecimal bankValue) 
    {
        this.bankValue = bankValue;
    }

    public BigDecimal getBankValue() 
    {
        return bankValue;
    }
    public void setMarketPrice(BigDecimal marketPrice) 
    {
        this.marketPrice = marketPrice;
    }

    public BigDecimal getMarketPrice() 
    {
        return marketPrice;
    }
    public void setTaxPrice(BigDecimal taxPrice) 
    {
        this.taxPrice = taxPrice;
    }

    public BigDecimal getTaxPrice() 
    {
        return taxPrice;
    }
    public void setDistric(String distric) 
    {
        this.distric = distric;
    }

    public String getDistric() 
    {
        return distric;
    }
    public void setLoanValue(BigDecimal loanValue) 
    {
        this.loanValue = loanValue;
    }

    public BigDecimal getLoanValue() 
    {
        return loanValue;
    }
    public void setExchangeDate(Date exchangeDate) 
    {
        this.exchangeDate = exchangeDate;
    }

    public Date getExchangeDate() 
    {
        return exchangeDate;
    }
    public void setProductStatus(String productStatus) 
    {
        this.productStatus = productStatus;
    }

    public String getProductStatus() 
    {
        return productStatus;
    }
    public void setReady(String ready) 
    {
        this.ready = ready;
    }

    public String getReady() 
    {
        return ready;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("property", getProperty())
            .append("bankValue", getBankValue())
            .append("marketPrice", getMarketPrice())
            .append("taxPrice", getTaxPrice())
            .append("distric", getDistric())
            .append("loanValue", getLoanValue())
            .append("exchangeDate", getExchangeDate())
            .append("productStatus", getProductStatus())
            .append("ready", getReady())
            .toString();
    }
}
