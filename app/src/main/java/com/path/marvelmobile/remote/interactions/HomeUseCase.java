package com.path.marvelmobile.remote.interactions;

import com.path.marvelmobile.remote.repository.Repository;
import com.path.marvelmobile.remote.repository.RepositoryImp;
import com.path.marvelmobile.remote.response.getCharacters.GetCharactersResponseBody;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;


public class HomeUseCase extends UseCase<GetCharactersResponseBody,HomeUseCase.Params> {

    Repository repository;

    @Inject
    public HomeUseCase(Repository repository) {
        this.repository = repository;
    }

    @Override
    Observable<GetCharactersResponseBody> buildUseCaseObservable(Params params) {
        return repository.getCharacters(params.limit);
    }

    public static class Params{

        private final int limit;
        private Params(int limit){
            this.limit = limit;
        }

        public static Params forGetCharacters(int limit){
            return new Params(limit);
        }
    }
}
