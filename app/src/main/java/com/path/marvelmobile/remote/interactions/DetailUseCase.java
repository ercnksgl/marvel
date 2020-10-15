package com.path.marvelmobile.remote.interactions;
import com.path.marvelmobile.remote.repository.Repository;
import com.path.marvelmobile.remote.response.getCharacterDetails.GetCharacterDetailsResponseBody;
import com.path.marvelmobile.remote.response.getCharacters.GetCharactersResponseBody;
import com.path.marvelmobile.utilities.ApiConstant;

import javax.inject.Inject;

import io.reactivex.Observable;


public class DetailUseCase extends UseCase<GetCharacterDetailsResponseBody, DetailUseCase.Params> {

    Repository repository;

    @Inject
    public DetailUseCase(Repository repository) {
        this.repository = repository;
    }

    @Override
    Observable<GetCharacterDetailsResponseBody> buildUseCaseObservable(Params params) {
        return repository.getCharacterDetails(params.characterId,ApiConstant.publicKey, ApiConstant.getHashKey(), ApiConstant.ts);
    }

    public static class Params{

        private final int characterId;
        private Params(int characterId){
            this.characterId = characterId;
        }

        public static Params forGetCharacterDetails(int characterId){
            return new Params(characterId);
        }
    }
}
