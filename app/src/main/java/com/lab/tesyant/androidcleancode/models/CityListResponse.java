package com.lab.tesyant.androidcleancode.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

/**
 * Created by tesyant on 11/12/17.
 */

@Generated("org.jsonschema2pojo")
public class CityListResponse {

    @SerializedName("data")
    @Expose
    private List<CityListData> data = new ArrayList<CityListData>();

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("status")
    @Expose
    private int status;

    public List<CityListData> getData() {
        return data;
    }

    public void setData (List<CityListData> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage (String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }



}
