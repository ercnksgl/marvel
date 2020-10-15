package com.path.marvelmobile.remote.repository;

import com.path.marvelmobile.remote.response.getCharacters.GetCharactersResponseBody;


import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ServiceInterface {


    @GET("v1/characters/{limit}")
    Observable<GetCharactersResponseBody> getCharacters(@Path("limit") int limit);
}
