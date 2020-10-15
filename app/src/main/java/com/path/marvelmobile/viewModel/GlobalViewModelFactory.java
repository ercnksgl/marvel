package com.path.marvelmobile.viewModel;


import javax.inject.Inject;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


public class GlobalViewModelFactory<T> implements ViewModelProvider.Factory {

    public T viewModel;

    @Inject
    GlobalViewModelFactory(T viewModel){this.viewModel=viewModel;}

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) viewModel;
    }
}
