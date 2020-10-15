package com.path.marvelmobile.remote.repository;

import com.path.marvelmobile.remote.response.getCharacterComics.GetCharacterComicsResponseBody;
import com.path.marvelmobile.remote.response.getCharacterDetails.GetCharacterDetailsResponseBody;
import com.path.marvelmobile.remote.response.getCharacters.GetCharactersResponseBody;

import io.reactivex.Observable;


public interface Repository {

    Observable<GetCharactersResponseBody> getCharacters(String apiKey,
                                                        String hash,
                                                        String ts,
                                                        int offset,
                                                        int limit);

    Observable<GetCharacterDetailsResponseBody> getCharacterDetails( int characterId,
                                                                     String apiKey,
                                                                     String hash,
                                                                     String ts);

    Observable<GetCharacterComicsResponseBody> getCharacterComics(int characterId,
                                                                  String apiKey,
                                                                  String hash,
                                                                  String ts,
                                                                  String orderBy,
                                                                  String dateRange,
                                                                  int limit);

}
