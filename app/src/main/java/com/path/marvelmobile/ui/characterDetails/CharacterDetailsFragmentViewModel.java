package com.path.marvelmobile.ui.characterDetails;

import android.util.Log;

import com.google.gson.Gson;
import com.path.marvelmobile.remote.interactions.ComicsUseCase;
import com.path.marvelmobile.remote.interactions.DetailUseCase;
import com.path.marvelmobile.remote.response.getCharacterComics.GetCharacterComicsResponseBody;
import com.path.marvelmobile.remote.response.getCharacterDetails.GetCharacterDetailsResponseBody;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

public class CharacterDetailsFragmentViewModel extends ViewModel {

    public MutableLiveData<GetCharacterDetailsResponseBody> responseCharacterDetails = new MutableLiveData<>();
    public MutableLiveData<GetCharacterComicsResponseBody> responseCharacterComics = new MutableLiveData<>();
    public MutableLiveData<String> apiError = new MutableLiveData<>();
    private String title;
    DetailUseCase characterDetailUseCase;
    ComicsUseCase comicsUseCase;

    @Inject
    public CharacterDetailsFragmentViewModel(DetailUseCase characterDetailUseCase,
                                             ComicsUseCase comicsUseCase) {
        this.characterDetailUseCase = characterDetailUseCase;
        this.comicsUseCase = comicsUseCase;
    }


    public void callCharacterDetails(int characterId){
        characterDetailUseCase.execute(DetailUseCase.Params.forGetCharacterDetails(characterId),
                new DisposableObserver<GetCharacterDetailsResponseBody>(){

            @Override
            public void onNext(@NonNull GetCharacterDetailsResponseBody responseModel) {
                Log.d("Test",new Gson().toJson(responseModel));
                responseCharacterDetails.setValue(responseModel);
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

    public void callCharacterComics(int characterId,String orderBy,String dateRange,int limit){
        comicsUseCase.execute(ComicsUseCase.Params.forGetCharacterComics(characterId,orderBy,dateRange,limit),
                new DisposableObserver<GetCharacterComicsResponseBody>(){

                    @Override
                    public void onNext(@NonNull GetCharacterComicsResponseBody responseModel) {
                        Log.d("Test",new Gson().toJson(responseModel));
                        responseCharacterComics.setValue(responseModel);
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
        characterDetailUseCase.dispose();
        comicsUseCase.dispose();
    }
}
