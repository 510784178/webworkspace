package com.example.demo.pojo;

public class Shoppcar {

	private Integer shoppcarId;

	private Integer shoppcarStuid;

    private String shoppcarName;

    private Integer shoppcarPrice;

    private Integer shoppcarNum;

    private String shoppcarImage;

    public Integer getShoppcarId() {
        return shoppcarId;
    }

    public String getShoppcarImage() {
        return shoppcarImage;
    }

    public String getShoppcarName() {
        return shoppcarName;
    }

    public Integer getShoppcarNum() {
        return shoppcarNum;
    }

    public Integer getShoppcarPrice() {
        return shoppcarPrice;
    }

    public Integer getShoppcarStuid() {
        return shoppcarStuid;
    }

    public void setShoppcarId(Integer shoppcarId) {
        this.shoppcarId = shoppcarId;
    }

    public void setShoppcarImage(String shoppcarImage) {
        this.shoppcarImage = shoppcarImage == null ? null : shoppcarImage.trim();
    }

    public void setShoppcarName(String shoppcarName) {
        this.shoppcarName = shoppcarName == null ? null : shoppcarName.trim();
    }

    public void setShoppcarNum(Integer shoppcarNum) {
        this.shoppcarNum = shoppcarNum;
    }

    public void setShoppcarPrice(Integer shoppcarPrice) {
        this.shoppcarPrice = shoppcarPrice;
    }

    public void setShoppcarStuid(Integer shoppcarStuid) {
        this.shoppcarStuid = shoppcarStuid;
    }

    public String toString() {
		return "Shoppcar [shoppcarId=" + shoppcarId + ", shoppcarStuid=" + shoppcarStuid + ", shoppcarName="
				+ shoppcarName + ", shoppcarPrice=" + shoppcarPrice + ", shoppcarNum=" + shoppcarNum
				+ ", shoppcarImage=" + shoppcarImage + "]";
	}
}