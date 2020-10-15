package com.path.marvelmobile.ui.characterDetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.path.marvelmobile.R;
import com.path.marvelmobile.databinding.FragmentCharacterDetailsBinding;
import com.path.marvelmobile.di.component.HomeComponent;
import com.path.marvelmobile.remote.response.getCharacterComics.GetCharacterComicsData;
import com.path.marvelmobile.remote.response.getCharacterComics.GetCharacterComicsResult;
import com.path.marvelmobile.remote.response.getCharacterDetails.GetCharacterDetailsData;
import com.path.marvelmobile.remote.response.getCharacterDetails.GetCharacterDetailsResult;
import com.path.marvelmobile.ui.base.BaseFragment;
import com.path.marvelmobile.ui.home.HomeActivity;
import com.path.marvelmobile.viewModel.GlobalViewModelFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CharacterDetailsFragment extends BaseFragment {

    private FragmentCharacterDetailsBinding binding;
    HomeComponent homeComponent;
    private int characterId;
    private CharacterComicsAdapter adapter;
    @Inject
    GlobalViewModelFactory<CharacterDetailsFragmentViewModel> viewModelFactory;
    CharacterDetailsFragmentViewModel viewModel;

    public static Fragment newInstance(int characterId) {
        Bundle args = new Bundle();
        args.putInt("characterId", characterId);
        Fragment fragment = new CharacterDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_character_details, container, false);
        homeComponent = prepareHomeComponent();
        homeComponent.inject(this);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(CharacterDetailsFragmentViewModel.class);
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        characterId = getArguments().getInt("characterId");
        initRecyclerView();
        setObservables();
        callCharacterDetail(characterId);
        callCharacterComics(characterId);
    }

    private void callCharacterDetail(int characterId) {
        viewModel.callCharacterDetails(characterId);
    }

    private void callCharacterComics(int characterId) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date todayDate = calendar.getTime();
        String todayString = format.format(todayDate);

        calendar.set(Calendar.YEAR, 2005);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        Date oldDate = calendar.getTime();
        String oldDateString = format.format(oldDate);
        String dateRange = oldDateString + "," + todayString;
        viewModel.callCharacterComics(characterId, "-modified", dateRange, 10);
    }

    private void initRecyclerView() {
        adapter = new CharacterComicsAdapter(new ArrayList<>());
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false) {
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }

            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setAdapter(adapter);
    }

    private void setObservables() {
        viewModel.apiError.observe(this, msg -> showToastMessage("Bir sorun oluştu"));

        viewModel.responseCharacterDetails.observe(this, responseBody -> {
            if (responseBody.getCode() == 200) {
                GetCharacterDetailsData data = responseBody.getData();
                setCharacterDetailsData(data);
            } else {
                showToastMessage("Bir sorun oluştu");
            }
        });


        viewModel.responseCharacterComics.observe(this, responseBody -> {
            if (responseBody.getCode() == 200) {
                GetCharacterComicsData data = responseBody.getData();
                ArrayList<String> list = new ArrayList<>();
                if (data != null && data.getResults() != null && !data.getResults().isEmpty()) {

                    if (adapter != null) {
                        for (GetCharacterComicsResult model : data.getResults()) {
                            if (model.getTitle() == null)
                                continue;
                            list.add(model.getTitle());
                        }
                        adapter.setList(list);
                    }
                }

            } else {
                showToastMessage("Bir sorun oluştu");
            }
        });

    }

    private void setCharacterDetailsData(GetCharacterDetailsData data) {
        if (data != null && !data.getResults().isEmpty()) {
            GetCharacterDetailsResult result = data.getResults().get(0);
            String name = result.getName() == null ? "" : result.getName();
            String description = result.getDescription() == null ? "" : result.getDescription();
            if (result.getThumbnail() != null && result.getThumbnail().getExtension() != null && result.getThumbnail().getPath() != null) {
                String imgUrl = result.getThumbnail().getPath() + "." + result.getThumbnail().getExtension();
                binding.tvName.setText(name);
                binding.tvDescription.setText(description);
                Glide.with(requireContext()).load(imgUrl).into(binding.imgCharacter);
            }
        }
    }
}
