package com.lab.tesyant.androidcleancode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lab.tesyant.androidcleancode.deps.Deps;
import com.lab.tesyant.androidcleancode.networking.NetworkModule;

import java.io.File;

/**
 * Created by tesyant on 11/14/17.
 */

public class BaseApp extends AppCompatActivity {

    Deps deps;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        File cacheFile = new File(getCacheDir(), "response");
        deps = DaggerDeps.builder().networkModule(new NetworkModule(cacheFile)).build();
    }

    public Deps getDeps() {
        return deps;
    }
}
