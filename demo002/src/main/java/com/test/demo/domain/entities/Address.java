package com.test.demo.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "address")
public class Address {

    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 省
     */
    @Column(name = "province", nullable = false)
    private String province;

    /**
     * 市
     */
    @Column(name = "city", nullable = false)
    private String city;

    /**
     * 区
     */
    @Column(name = "area", nullable = false)
    private String area;

    /**
     * address
     */
    @Column(name = "address", nullable = false)
    private String address;

    /**
     * 创建时间
     */
    @Column(name = "create_time", nullable = false)
    private Date createTime;

    /**
     * 创建时间
     */
    @Column(name = "update_time", nullable = false)
    private Date updateTime;

    /**
     * contact
     */
    @Column(name = "contact", nullable = false)
    private String contact;

    /**
     * appellation
     */
    @Column(name = "appellation", nullable = false)
    private String appellation;

    /**
     * deleted
     */
    @Column(name = "deleted", nullable = false)
    private Boolean deleted;

    /**
     * deleted
     */
    @Column(name = "mobile", nullable = false)
    private String mobile;

    /**
     * status
     */
    @Column(name = "status", nullable = false )
    private Integer status;

    /**
     * user_id
     */
    @Column(name = "user_id", nullable = false )
    private Integer userId;

    /**
     * province_id
     */
    @Column(name = "province_id", nullable = false )
    private Integer provinceId;

     /**
     * city_id
     */
    @Column(name = "city_id", nullable = false )
    private Integer cityId;

    /**
     * area_id
     */
    @Column(name = "area_id", nullable = false )
    private Integer areaId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAppellation() {
        return appellation;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", address='" + address + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", contact='" + contact + '\'' +
                ", appellation='" + appellation + '\'' +
                ", deleted=" + deleted +
                ", mobile='" + mobile + '\'' +
                ", status=" + status +
                ", userId=" + userId +
                ", provinceId=" + provinceId +
                ", cityId=" + cityId +
                ", areaId=" + areaId +
                '}';
    }
}
