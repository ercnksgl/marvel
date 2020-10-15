package com.path.marvelmobile.remote.repository;

import com.path.marvelmobile.remote.response.getCharacters.GetCharactersResponseBody;
import com.path.marvelmobile.utilities.ServiceUrls;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServiceInterface {


    @GET(ServiceUrls.GetCharacters)
    Observable<GetCharactersResponseBody> getCharacters(@Query("apikey") String apiKey,
                                                        @Query("hash") String hash,
                                                        @Query("ts") String ts);
}
