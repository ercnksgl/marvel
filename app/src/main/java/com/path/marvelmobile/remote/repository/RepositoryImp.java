package com.path.marvelmobile.remote.repository;
import com.path.marvelmobile.remote.response.getCharacterComics.GetCharacterComicsResponseBody;
import com.path.marvelmobile.remote.response.getCharacterDetails.GetCharacterDetailsResponseBody;
import com.path.marvelmobile.remote.response.getCharacters.GetCharactersResponseBody;
import javax.inject.Inject;

import io.reactivex.Observable;


public class RepositoryImp implements Repository {

     ServiceInterface apiService;

     @Inject
    public RepositoryImp(ServiceInterface apiService) {
        this.apiService = apiService;
    }


    @Override
    public Observable<GetCharactersResponseBody> getCharacters(String apiKey , String hash, String ts,int offset,int limit) {
        return apiService.getCharacters(apiKey, hash,ts,offset,limit);
    }

    @Override
    public Observable<GetCharacterDetailsResponseBody> getCharacterDetails(int characterId,String apiKey, String hash, String ts) {
        return apiService.getCharacterDetails(characterId,apiKey,hash,ts);
    }

    @Override
    public Observable<GetCharacterComicsResponseBody> getCharacterComics(int characterId, String apiKey, String hash, String ts, String orderBy, String dateRange, int limit) {
        return apiService.getCharacterComics(characterId,apiKey,hash,ts,orderBy,dateRange,limit);
    }
}
