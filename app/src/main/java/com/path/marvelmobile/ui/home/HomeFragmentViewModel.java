package com.path.marvelmobile.ui.home;

import android.util.Log;

import com.google.gson.Gson;
import com.path.marvelmobile.remote.interactions.HomeUseCase;
import com.path.marvelmobile.remote.response.getCharacters.GetCharactersResponseBody;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

public class HomeFragmentViewModel extends ViewModel {

    public int limit = 30;
    public int offsetCount = 30;
    public MutableLiveData<GetCharactersResponseBody> responseCharacters = new MutableLiveData<>();
    public MutableLiveData<String> apiError = new MutableLiveData<>();
    private String title;
    HomeUseCase useCase;

    @Inject
    public HomeFragmentViewModel(HomeUseCase useCase) {
        this.useCase = useCase;
    }

    public void callCharacters(int offset) {
        useCase.execute(HomeUseCase.Params.forGetCharacters(offset, limit),
                new DisposableObserver<GetCharactersResponseBody>() {

                    @Override
                    public void onNext(@NonNull GetCharactersResponseBody getCharactersResponseBody) {
                        Log.d("Test", new Gson().toJson(getCharactersResponseBody));
                        responseCharacters.setValue(getCharactersResponseBody);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                        apiError.setValue("Bir sorun oluştu");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        useCase.dispose();
    }
}
