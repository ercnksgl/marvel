package com.path.marvelmobile.ui.home;

import com.path.marvelmobile.remote.interactions.HomeUseCase;
import com.path.marvelmobile.remote.response.getCharacters.GetCharactersResponseBody;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.observers.DisposableObserver;

public class CharacterDetailsFragmentViewModel extends ViewModel {

    HomeUseCase useCase;
    private String title;

    @Inject
    public CharacterDetailsFragmentViewModel(HomeUseCase useCase) {
        this.useCase = useCase;
    }


    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }

    public void callCharacters(int limit){
        useCase.execute(HomeUseCase.Params.forGetCharacters(limit), new DisposableObserver<GetCharactersResponseBody>(){

            @Override
            public void onNext(@NonNull GetCharactersResponseBody getCharactersResponseBody) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
