package id.co.picklon.model.entities;

import com.google.gson.annotations.SerializedName;

public class WashService {

    private int id;
    private String name;
    private long rp;
    @SerializedName("service_type")
    private int serviceType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getRp() {
        return rp;
    }

    public void setRp(long rp) {
        this.rp = rp;
    }

    public int getServiceType() {
        return serviceType;
    }

    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }
}
