package com.lab.tesyant.androidcleancode.deps;

import com.lab.tesyant.androidcleancode.home.HomeActivity;
import com.lab.tesyant.androidcleancode.networking.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by tesyant on 11/14/17.
 */

@Singleton
@Component(modules = {NetworkModule.class})
public interface Deps {
    void inject(HomeActivity homeActivity);
}