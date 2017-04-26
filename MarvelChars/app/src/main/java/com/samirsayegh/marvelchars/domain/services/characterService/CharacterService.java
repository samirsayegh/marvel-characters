package com.samirsayegh.marvelchars.domain.services.characterService;

import com.orhanobut.logger.Logger;
import com.samirsayegh.marvelchars.domain.services.base.BaseService;
import com.samirsayegh.marvelchars.domain.services.dto.HeroDTO;
import com.samirsayegh.marvelchars.domain.services.dto.base.BaseDTO;
import com.samirsayegh.marvelchars.domain.services.parser.HeroParser;
import com.samirsayegh.marvelchars.model.LoggerUtils;

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

    public void getCharacters() {
        api.getCharacters().enqueue(new Callback<BaseDTO<List<HeroDTO>>>() {
            @Override
            public void onResponse(Call<BaseDTO<List<HeroDTO>>> call, Response<BaseDTO<List<HeroDTO>>> response) {
                Logger.d(LoggerUtils.JOIN + " RESPONSE");
                if (response.isSuccessful()) {
                    Logger.d(LoggerUtils.SUCCESS);
                    if (characterServiceResult != null) {
                        characterServiceResult.heroLoaded(HeroParser.toHeroList(response.body().getDataValue()));
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
        });
    }

    public void setCharacterServiceResult(CharacterServiceResult characterServiceResult) {
        this.characterServiceResult = characterServiceResult;
    }
}
