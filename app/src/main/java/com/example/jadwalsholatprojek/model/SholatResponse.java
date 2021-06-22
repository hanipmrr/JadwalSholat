package com.example.jadwalsholatprojek.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SholatResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("data")
    private ArrayList<SholatDataItem> data;

    @SerializedName("status")
    private String status;

    public void setCode(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public void setData(ArrayList<SholatDataItem> data){
        this.data = data;
    }

    public ArrayList<SholatDataItem> getData(){
        return data;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }

    @Override
    public String toString(){
        return
                "SholatResponse{" +
                        "code = '" + code + '\'' +
                        ",data = '" + data + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}
