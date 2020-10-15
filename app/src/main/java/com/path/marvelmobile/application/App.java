package com.path.marvelmobile.application;

import android.app.Application;

import com.path.marvelmobile.di.component.AppComponent;
import com.path.marvelmobile.di.component.DaggerAppComponent;
import com.path.marvelmobile.di.module.AppModule;

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        appComponent.inject(this);
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}
