package com.lab.tesyant.androidcleancode.home;

import com.lab.tesyant.androidcleancode.models.CityListResponse;

/**
 * Created by tesyant on 11/14/17.
 */

public interface HomeView {

    void showWait();
    void removeWait();

    void onFailure(String appErrorMessage);
    void getCityListSuccess(CityListResponse cityListResponse);

}
