package id.co.picklon.model.entities;

import com.google.gson.annotations.SerializedName;

public class Token {
    @SerializedName("tk")
    private String token;
    private int id;
    private String nickname;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
