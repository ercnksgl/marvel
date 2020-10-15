package com.path.marvelmobile.remote.repository;

import com.path.marvelmobile.remote.response.getCharacters.GetCharactersResponseBody;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;


public class RepositoryImp implements Repository {

     ServiceInterface apiService;

     @Inject
    public RepositoryImp(ServiceInterface apiService) {
        this.apiService = apiService;
    }


    @Override
    public Observable<GetCharactersResponseBody> getCharacters(int limit) {
        return apiService.getCharacters(limit);
    }
}
