package com.path.marvelmobile.di.module;

import android.content.Context;
import com.path.marvelmobile.application.App;
import com.path.marvelmobile.remote.repository.Repository;
import com.path.marvelmobile.remote.repository.RepositoryImp;
import com.path.marvelmobile.remote.repository.ServiceInterface;
import com.path.marvelmobile.utilities.ServiceUrls;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    private final App application;

    public AppModule(App application){
        this.application = application;
    }


    @Provides
    @Singleton
     public Retrofit provideRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(ServiceUrls.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public Repository provideRepository(ServiceInterface serviceInterface){
        return new RepositoryImp(serviceInterface);
    }

    @Provides
    @Singleton
    public ServiceInterface provideApiServiceInterface(Retrofit retrofit){
        return retrofit.create(ServiceInterface.class);
    }


    @Provides
    @Singleton
    public Context provideContext(){return this.application;}

}
