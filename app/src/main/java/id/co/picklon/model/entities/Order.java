package id.co.picklon.model.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Order implements Parcelable {
    private int washType;
    private int washWeight;
    private boolean isCarpet;
    private int meters;
    private Address address;
    private String requirements;
    private DateTime pickTime;
    private DateTime dTime;
    private int tips;
    private long estimatePrice;
    private String service;

    @SerializedName("order_id")
    private String orderId;
    @SerializedName("wash_status")
    private String washStatus;
    @SerializedName("pickup_time")
    private String pickupTime;
    @SerializedName("deliver_time")
    private String deliverTime;
    @SerializedName("pickup_guy_name")
    private String pickupGuyName;
    @SerializedName("pickup_guy_mobile")
    private String pickupGuyMobile;
    @SerializedName("address_detail")
    private String addressDetail;
    private int star;
    @SerializedName("shop_name")
    private String shopName;
    @SerializedName("shop_id")
    private int shopId;
    @SerializedName("shop_phone")
    private String shopPhone;
    @SerializedName("dis")
    private long distance;
    @SerializedName("seconds")
    private int comeTime;
    @SerializedName("shop_image")
    private String shopImage;

    public int getWashType() {
        return washType;
    }

    public void setWashType(int washType) {
        this.washType = washType;
    }

    public int getWashWeight() {
        return washWeight;
    }

    public void setWashWeight(int washWeight) {
        this.washWeight = washWeight;
    }

    public boolean isCarpet() {
        return isCarpet;
    }

    public void setCarpet(boolean carpet) {
        isCarpet = carpet;
    }

    public int getMeters() {
        return meters;
    }

    public void setMeters(int meters) {
        this.meters = meters;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(String deliverTime) {
        this.deliverTime = deliverTime;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getWashStatus() {
        return washStatus;
    }

    public void setWashStatus(String washStatus) {
        this.washStatus = washStatus;
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getPickupGuyName() {
        return pickupGuyName;
    }

    public void setPickupGuyName(String pickupGuyName) {
        this.pickupGuyName = pickupGuyName;
    }

    public String getPickupGuyMobile() {
        return pickupGuyMobile;
    }

    public void setPickupGuyMobile(String pickupGuyMobile) {
        this.pickupGuyMobile = pickupGuyMobile;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public DateTime getPickTime() {
        return pickTime;
    }

    public void setPickTime(DateTime pickTime) {
        this.pickTime = pickTime;
    }

    public DateTime getdTime() {
        return dTime;
    }

    public void setdTime(DateTime dTime) {
        this.dTime = dTime;
    }

    public int getTips() {
        return tips;
    }

    public void setTips(int tips) {
        this.tips = tips;
    }

    public long getEstimatePrice() {
        return estimatePrice;
    }

    public void setEstimatePrice(long estimatePrice) {
        this.estimatePrice = estimatePrice;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getShopPhone() {
        return shopPhone;
    }

    public void setShopPhone(String shopPhone) {
        this.shopPhone = shopPhone;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public int getComeTime() {
        return comeTime;
    }

    public void setComeTime(int comeTime) {
        this.comeTime = comeTime;
    }

    public String getShopImage() {
        return shopImage;
    }

    public void setShopImage(String shopImage) {
        this.shopImage = shopImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.washType);
        dest.writeInt(this.washWeight);
        dest.writeByte(this.isCarpet ? (byte) 1 : (byte) 0);
        dest.writeInt(this.meters);
        dest.writeParcelable(this.address, flags);
        dest.writeString(this.requirements);
        dest.writeParcelable(this.pickTime, flags);
        dest.writeParcelable(this.dTime, flags);
        dest.writeString(this.orderId);
        dest.writeString(this.washStatus);
        dest.writeString(this.pickupTime);
        dest.writeString(this.deliverTime);
        dest.writeString(this.pickupGuyName);
        dest.writeString(this.pickupGuyMobile);
        dest.writeString(this.addressDetail);
        dest.writeInt(this.star);
        dest.writeString(this.shopName);
        dest.writeInt(this.shopId);
        dest.writeInt(this.tips);
        dest.writeLong(this.estimatePrice);
        dest.writeString(this.service);
        dest.writeString(this.shopPhone);
        dest.writeLong(this.distance);
        dest.writeInt(this.comeTime);
        dest.writeString(this.shopImage);
    }

    public Order() {
    }

    protected Order(Parcel in) {
        this.washType = in.readInt();
        this.washWeight = in.readInt();
        this.isCarpet = in.readByte() != 0;
        this.meters = in.readInt();
        this.address = in.readParcelable(Address.class.getClassLoader());
        this.requirements = in.readString();
        this.pickTime = in.readParcelable(DateTime.class.getClassLoader());
        this.dTime = in.readParcelable(DateTime.class.getClassLoader());
        this.orderId = in.readString();
        this.washStatus = in.readString();
        this.pickupTime = in.readString();
        this.deliverTime = in.readString();
        this.pickupGuyName = in.readString();
        this.pickupGuyMobile = in.readString();
        this.addressDetail = in.readString();
        this.star = in.readInt();
        this.shopName = in.readString();
        this.shopId = in.readInt();
        this.tips = in.readInt();
        this.estimatePrice = in.readLong();
        this.service = in.readString();
        this.shopPhone = in.readString();
        this.distance = in.readLong();
        this.comeTime = in.readInt();
        this.shopImage = in.readString();
    }

    public static final Creator<Order> CREATOR = new Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel source) {
            return new Order(source);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };
}
