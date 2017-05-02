package com.samirsayegh.marvelchars.model.services;


import com.samirsayegh.marvelchars.model.services.dto.HeroDTO;
import com.samirsayegh.marvelchars.model.services.dto.TitleDTO;
import com.samirsayegh.marvelchars.model.services.dto.base.BaseDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by yormirsamir.sayegh on 26/04/2017.
 * Samir Dev
 */

public interface Api {

    String OFFSET = "offset";
    String START_WITH = "nameStartsWith";

    @GET("/v1/public/characters")
    Call<BaseDTO<List<HeroDTO>>> getCharacters();

    @GET("/v1/public/characters")
    Call<BaseDTO<List<HeroDTO>>> getCharacters(@Query(OFFSET) int offset);

    @GET("/v1/public/characters")
    Call<BaseDTO<List<HeroDTO>>> getCharactersStartingWith(@Query(START_WITH) String startWith);

    @GET("/v1/public/characters")
    Call<BaseDTO<List<HeroDTO>>> getCharactersStartingWith(@Query(START_WITH) String startWith, @Query(OFFSET) int offset);

    @GET("/v1/public/characters/{characterId}/comics")
    Call<BaseDTO<List<TitleDTO>>> getComics(@Path("characterId") int characterId);

    @GET("/v1/public/characters/{characterId}/comics")
    Call<BaseDTO<List<TitleDTO>>> getComics(@Path("characterId") int characterId, @Query(OFFSET) int offset);

    @GET("/v1/public/characters/{characterId}/events")
    Call<BaseDTO<List<TitleDTO>>> getEvents(@Path("characterId") int characterId);

    @GET("/v1/public/characters/{characterId}/events")
    Call<BaseDTO<List<TitleDTO>>> getEvents(@Path("characterId") int characterId, @Query(OFFSET) int offset);

}
