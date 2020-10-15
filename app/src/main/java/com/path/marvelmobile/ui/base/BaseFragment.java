package com.path.marvelmobile.ui.base;


import com.path.marvelmobile.application.App;
import com.path.marvelmobile.di.component.DaggerHomeComponent;
import com.path.marvelmobile.di.component.HomeComponent;
import com.path.marvelmobile.di.module.HomeModule;

import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {

    public BaseFragment(){

    }

    public BaseActivity getBaseActivity(){
        return ((BaseActivity)getActivity());
    }


    public HomeComponent prepareHomeComponent(){
        return DaggerHomeComponent.builder().
                homeModule(new HomeModule(getActivity()))
                .appComponent(((App)getActivity().getApplication()).getAppComponent()).build();
    }
}
