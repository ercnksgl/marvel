package com.path.marvelmobile.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.path.marvelmobile.R;
import com.path.marvelmobile.databinding.FragmentCharacterDetailsBinding;
import com.path.marvelmobile.databinding.FragmentHomeBinding;
import com.path.marvelmobile.di.component.HomeComponent;
import com.path.marvelmobile.ui.base.BaseFragment;
import com.path.marvelmobile.viewModel.GlobalViewModelFactory;

import java.util.ArrayList;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;

public class CharacterDetailsFragment extends BaseFragment {

    private FragmentCharacterDetailsBinding binding;
    HomeComponent homeComponent;

    @Inject
    GlobalViewModelFactory<CharacterDetailsFragmentViewModel> viewModelFactory;
    CharacterDetailsFragmentViewModel viewModel;

    public static Fragment newInstance(){
        Bundle args = new Bundle();
        Fragment fragment = new CharacterDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_character_details,container,false);
        homeComponent = prepareHomeComponent();
        homeComponent.inject(this);

        viewModel = ViewModelProviders.of(this,viewModelFactory).get(CharacterDetailsFragmentViewModel.class);
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel.setTitle(getString(R.string.title_home));
        Glide.with(requireContext()).load("https://images-na.ssl-images-amazon.com/images/I/710-2HTjwZL._AC_SL1000_.jpg").into(binding.imgCharacter);

        setObservables();
    }

    private void setObservables(){

    }
}
