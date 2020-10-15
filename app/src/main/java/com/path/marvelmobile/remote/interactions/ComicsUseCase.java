package com.path.marvelmobile.remote.interactions;
import com.path.marvelmobile.remote.repository.Repository;
import com.path.marvelmobile.remote.response.getCharacterComics.GetCharacterComicsResponseBody;
import com.path.marvelmobile.utilities.ApiConstant;

import javax.inject.Inject;

import io.reactivex.Observable;


public class ComicsUseCase extends UseCase<GetCharacterComicsResponseBody, ComicsUseCase.Params> {

    Repository repository;

    @Inject
    public ComicsUseCase(Repository repository) {
        this.repository = repository;
    }

    @Override
    Observable<GetCharacterComicsResponseBody> buildUseCaseObservable(Params params) {
        return repository.getCharacterComics(params.characterId,
                ApiConstant.publicKey,
                ApiConstant.getHashKey(),
                ApiConstant.ts,
                params.orderBy,
                params.dateRange,
                params.limit);
    }

    public static class Params{

        private final int characterId;
        private final String orderBy;
        private final String dateRange;
        private final int limit;
        private Params(int characterId,String orderBy, String dateRange, int limit){
            this.characterId = characterId;
            this.orderBy =orderBy;
            this.dateRange=dateRange;
            this.limit=limit;
        }

        public static Params forGetCharacterComics(int characterId,String orderBy, String dateRange, int limit){
            return new Params(characterId,orderBy,dateRange,limit);
        }
    }
}
