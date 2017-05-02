package com.samirsayegh.marvelchars.model.services.characterService;

import android.support.annotation.NonNull;

import com.orhanobut.logger.Logger;
import com.samirsayegh.marvelchars.domain.utils.LoggerUtils;
import com.samirsayegh.marvelchars.model.services.base.BaseService;
import com.samirsayegh.marvelchars.model.services.dto.HeroDTO;
import com.samirsayegh.marvelchars.model.services.dto.base.BaseDTO;
import com.samirsayegh.marvelchars.model.services.parser.HeroParser;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by yormirsamir.sayegh on 26/04/2017.
 */

public class CharacterService extends BaseService {

    private CharacterServiceResult characterServiceResult;

    public CharacterService(CharacterServiceResult characterServiceResult) {
        super();
        this.characterServiceResult = characterServiceResult;
    }

    @NonNull
    private Callback<BaseDTO<List<HeroDTO>>> getCallback(final boolean isNew) {
        return new Callback<BaseDTO<List<HeroDTO>>>() {
            @Override
            public void onResponse(Call<BaseDTO<List<HeroDTO>>> call, Response<BaseDTO<List<HeroDTO>>> response) {
                Logger.d(LoggerUtils.JOIN + " RESPONSE");
                if (response.isSuccessful()) {
                    Logger.d(LoggerUtils.SUCCESS);
                    if (characterServiceResult != null) {
                        characterServiceResult.heroList(HeroParser.toHeroList(response.body()), isNew);
                    }
                } else {
                    Logger.d(LoggerUtils.FAILED);
                    if (characterServiceResult != null) {
                        characterServiceResult.error(response.message());
                    }
                }
                Logger.d(LoggerUtils.LEAVE + " RESPONSE");
            }

            @Override
            public void onFailure(Call<BaseDTO<List<HeroDTO>>> call, Throwable t) {
                if (characterServiceResult != null) {
                    characterServiceResult.error(t.getMessage());
                }
            }
        };
    }

    public void getCharacters() {
        api.getCharacters().enqueue(getCallback(true));
    }

    public void getCharactersOffset(int offset) {
        api.getCharacters(offset).enqueue(getCallback(false));
    }

    public void getCharactersStartingWith(String startingWith) {
        api.getCharactersStartingWith(startingWith).enqueue(getCallbackStartingWith(true));
    }

    public void getCharactersStartingWith(String startingWith, int offset) {
        api.getCharactersStartingWith(startingWith, offset).enqueue(getCallbackStartingWith(false));
    }

    @NonNull
    private Callback<BaseDTO<List<HeroDTO>>> getCallbackStartingWith(final boolean isNew) {
        return new Callback<BaseDTO<List<HeroDTO>>>() {
            @Override
            public void onResponse(Call<BaseDTO<List<HeroDTO>>> call, Response<BaseDTO<List<HeroDTO>>> response) {
                Logger.d(LoggerUtils.JOIN + " RESPONSE");
                if (response.isSuccessful()) {
                    Logger.d(LoggerUtils.SUCCESS);
                    if (characterServiceResult != null) {
                        characterServiceResult.heroListStartingWith(HeroParser.toHeroList(response.body()), isNew);
                    }
                } else {
                    Logger.d(LoggerUtils.FAILED);
                    if (characterServiceResult != null) {
                        characterServiceResult.error(response.message());
                    }
                }
                Logger.d(LoggerUtils.LEAVE + " RESPONSE");
            }

            @Override
            public void onFailure(Call<BaseDTO<List<HeroDTO>>> call, Throwable t) {
                if (characterServiceResult != null) {
                    characterServiceResult.error(t.getMessage());
                }
            }
        };
    }

    public void setCharacterServiceResult(CharacterServiceResult characterServiceResult) {
        this.characterServiceResult = characterServiceResult;
    }
}
