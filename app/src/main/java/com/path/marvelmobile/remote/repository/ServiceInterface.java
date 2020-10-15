package com.path.marvelmobile.remote.repository;

import com.path.marvelmobile.remote.response.getCharacterComics.GetCharacterComicsResponseBody;
import com.path.marvelmobile.remote.response.getCharacterDetails.GetCharacterDetailsResponseBody;
import com.path.marvelmobile.remote.response.getCharacters.GetCharactersResponseBody;
import com.path.marvelmobile.utilities.ServiceUrls;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServiceInterface {


    @GET(ServiceUrls.GetCharacters)
    Observable<GetCharactersResponseBody> getCharacters(@Query("apikey") String apiKey,
                                                        @Query("hash") String hash,
                                                        @Query("ts") String ts,
                                                        @Query("offset") int offset,
                                                        @Query("limit") int limit);


    @GET(ServiceUrls.GetCharacterById)
    Observable<GetCharacterDetailsResponseBody> getCharacterDetails(@Path("characterId") int characterId,
                                                                    @Query("apikey") String apiKey,
                                                                    @Query("hash") String hash,
                                                                    @Query("ts") String ts);

    @GET(ServiceUrls.GetCharacterComics)
    Observable<GetCharacterComicsResponseBody> getCharacterComics(@Path("characterId") int characterId,
                                                                  @Query("apikey") String apiKey,
                                                                  @Query("hash") String hash,
                                                                  @Query("ts") String ts,
                                                                  @Query("orderBy") String orderBy,
                                                                  @Query("dateRange") String dateRange,
                                                                  @Query("limit") int limit);
}
