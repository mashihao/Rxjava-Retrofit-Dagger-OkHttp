package id.co.picklon.model.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response<T> {
    private String cmd;
    private int tag;
    private int v;
    @SerializedName("ret")
    private List<Data<T>> dataList;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public List<Data<T>> getDataList() {
        return dataList;
    }

    public void setDataList(List<Data<T>> dataList) {
        this.dataList = dataList;
    }

    public class Data<R> {
        @SerializedName("i")
        private int code;
        @SerializedName("d")
        private R data;
        private String msg;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public R getData() {
            return data;
        }

        public void setData(R data) {
            this.data = data;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
