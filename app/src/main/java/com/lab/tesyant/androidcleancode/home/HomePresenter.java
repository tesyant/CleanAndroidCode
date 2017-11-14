package com.lab.tesyant.androidcleancode.home;

import com.lab.tesyant.androidcleancode.models.CityListResponse;
import com.lab.tesyant.androidcleancode.networking.NetworkError;
import com.lab.tesyant.androidcleancode.networking.Service;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by tesyant on 11/14/17.
 */

public class HomePresenter {

    private final Service service;
    private final HomeView view;
    private CompositeSubscription compositeSubscription;

    public HomePresenter (Service service, HomeView view) {
        this.service = service;
        this.view = view;
        this.compositeSubscription = new CompositeSubscription();
    }

    public void getCityList() {
        view.showWait();

        Subscription subscriptions = service.getListCity(new Service.GetCityListCallback() {
            @Override
            public void onSuccess(CityListResponse cityListResponse) {
                view.removeWait();
                view.getCityListSuccess(cityListResponse);
            }

            @Override
            public void onError(NetworkError networkError) {
                view.removeWait();
                view.onFailure(networkError.getAppErrorMessage());
            }
        });

        compositeSubscription.add(subscriptions);
    }

    public void onStop() {
        compositeSubscription.unsubscribe();
    }
}
