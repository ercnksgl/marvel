package com.path.marvelmobile.di.component;


import android.content.Context;

import com.path.marvelmobile.application.App;
import com.path.marvelmobile.di.module.AppModule;
import com.path.marvelmobile.remote.repository.Repository;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(App app);

    Repository getRepository();
    Context context();
}
