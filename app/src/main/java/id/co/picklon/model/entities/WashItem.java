package id.co.picklon.model.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by MSH on 2017/1/20.
 */

public class WashItem {

    private String id;
    @SerializedName("item_name")
    private String itemName;
    private String icon;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
