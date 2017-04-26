package com.samirsayegh.marvelchars.domain.services;

import com.samirsayegh.marvelchars.domain.services.dto.HeroDTO;
import com.samirsayegh.marvelchars.domain.services.dto.TitleDTO;
import com.samirsayegh.marvelchars.domain.services.dto.base.BaseDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by yormirsamir.sayegh on 26/04/2017.
 */

public interface Api {

    @GET("/v1/public/characters")
    Call<BaseDTO<List<HeroDTO>>> getCharacters();

    @GET("/v1/public/characters/{characterId}/comics")
    Call<BaseDTO<List<TitleDTO>>> getComics(@Path("characterId") int characterId);

    @GET("/v1/public/characters/{characterId}/events")
    Call<BaseDTO<List<TitleDTO>>> getEvents(@Path("characterId") int characterId);

}
