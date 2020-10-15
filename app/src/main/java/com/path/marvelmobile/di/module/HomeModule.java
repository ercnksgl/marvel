package com.path.marvelmobile.di.module;

import android.app.Activity;

import com.path.marvelmobile.di.MScope;

import dagger.Module;
import dagger.Provides;

@MScope
@Module
public class HomeModule {

    Activity context;

    public HomeModule(Activity context){
        this.context=context;
    }


    @Provides
    public Activity getContext(){return context;}
}
