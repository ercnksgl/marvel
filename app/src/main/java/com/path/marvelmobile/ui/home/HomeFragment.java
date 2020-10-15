package com.path.marvelmobile.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.path.marvelmobile.R;
import com.path.marvelmobile.application.App;
import com.path.marvelmobile.databinding.FragmentHomeBinding;
import com.path.marvelmobile.di.component.HomeComponent;
import com.path.marvelmobile.remote.response.getCharacters.GetCharactersData;
import com.path.marvelmobile.remote.response.getCharacters.GetCharactersResponseBody;
import com.path.marvelmobile.remote.response.getCharacters.GetCharactersResult;
import com.path.marvelmobile.ui.base.BaseFragment;
import com.path.marvelmobile.viewModel.GlobalViewModelFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;

public class HomeFragment extends BaseFragment {

    private FragmentHomeBinding binding;
    HomeComponent homeComponent;



    @Inject
    GlobalViewModelFactory<HomeFragmentViewModel> viewModelFactory;
    HomeFragmentViewModel viewModel;
    private HomeAdapter homeAdapter;


    public static Fragment newInstance(){
        Bundle args = new Bundle();
        Fragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home,container,false);
        homeComponent = prepareHomeComponent();
        homeComponent.inject(this);

        viewModel = ViewModelProviders.of(this,viewModelFactory).get(HomeFragmentViewModel.class);
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel.setTitle(getString(R.string.title_home));
        initRecyclerView();
        setObservables();
        viewModel.callCharacters(30);
    }

    private void initRecyclerView(){
        homeAdapter = new HomeAdapter(new ArrayList<>()) {
            @Override
            public void onSelected(String object) {
                ((HomeActivity)getActivity()).addFragment(CharacterDetailsFragment.newInstance());
            }

            @Override
            public void fetchData() {

            }
        };
        GridLayoutManager layoutManager = new GridLayoutManager(requireContext(),2);
        binding.recyclerHome.setLayoutManager(layoutManager);
        binding.recyclerHome.setAdapter(homeAdapter);
    }

    private void setObservables(){

        viewModel.responseCharacters.observe(this, responseBody -> {
            if(responseBody.getCode() == 200){
                GetCharactersData result = responseBody.getData();
                homeAdapter.AddList(result.getResults());

            }else{
                showToastMessage("Bir sorun oluştu");
            }
        });

        viewModel.apiError.observe(this, msg ->showToastMessage("Bir sorun oluştu"));

    }
}
