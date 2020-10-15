package com.path.marvelmobile.remote.repository;

import com.path.marvelmobile.remote.response.getCharacters.GetCharactersResponseBody;

import io.reactivex.rxjava3.core.Observable;


public interface Repository {

     Observable<GetCharactersResponseBody> getCharacters(int limit);

}
