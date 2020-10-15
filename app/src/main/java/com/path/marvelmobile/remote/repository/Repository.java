package com.path.marvelmobile.remote.repository;

import com.path.marvelmobile.remote.response.getCharacters.GetCharactersResponseBody;

import io.reactivex.Observable;


public interface Repository {

     Observable<GetCharactersResponseBody> getCharacters(String apiKey, String hash, String ts);

}
