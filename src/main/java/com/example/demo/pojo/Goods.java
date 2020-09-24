package com.example.demo.pojo;

public class Goods {

	private Integer goodsId;

	private String goodsNo;

    private String goodsName;

    private String goodsDetails;

    private Integer goodsPrice;

    private String goodsImage;

    private Integer goodsStatus;

    public String getGoodsDetails() {
        return goodsDetails;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    public Integer getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsDetails(String goodsDetails) {
        this.goodsDetails = goodsDetails == null ? null : goodsDetails.trim();
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage == null ? null : goodsImage.trim();
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo == null ? null : goodsNo.trim();
    }

    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public void setGoodsStatus(Integer goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsNo=" + goodsNo + ", goodsName=" + goodsName + ", goodsDetails="
				+ goodsDetails + ", goodsPrice=" + goodsPrice + ", goodsImage=" + goodsImage + ", goodsStatus="
				+ goodsStatus + "]";
	}
}