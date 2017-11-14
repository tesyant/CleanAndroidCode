package com.lab.tesyant.androidcleancode.networking;

import com.lab.tesyant.androidcleancode.models.CityListResponse;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by tesyant on 11/12/17.
 */

public interface NetworkService {

    @GET("v1/city")
    Observable<CityListResponse> getCityList();
}
