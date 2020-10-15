package com.path.marvelmobile.ui.home;

import android.util.Log;

import com.google.gson.Gson;
import com.path.marvelmobile.remote.interactions.HomeUseCase;
import com.path.marvelmobile.remote.response.getCharacters.GetCharactersResponseBody;
import com.path.marvelmobile.remote.response.getCharacters.GetCharactersResult;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

public class HomeFragmentViewModel extends ViewModel {

    public MutableLiveData<GetCharactersResponseBody> responseCharacters = new MutableLiveData<>();
    public MutableLiveData<String> apiError = new MutableLiveData<>();
    private String title;
    HomeUseCase useCase;

    @Inject
    public HomeFragmentViewModel(HomeUseCase useCase) {
        this.useCase = useCase;
    }


    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }

    public void callCharacters(int limit){
        useCase.execute(HomeUseCase.Params.forGetCharacters(limit),
                new DisposableObserver<GetCharactersResponseBody>(){

            @Override
            public void onNext(@NonNull GetCharactersResponseBody getCharactersResponseBody) {
                Log.d("Test",new Gson().toJson(getCharactersResponseBody));
                responseCharacters.setValue(getCharactersResponseBody);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
                apiError.setValue(e.getMessage());
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
