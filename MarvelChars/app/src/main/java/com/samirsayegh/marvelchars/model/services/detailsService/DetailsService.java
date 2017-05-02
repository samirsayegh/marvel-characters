package com.samirsayegh.marvelchars.model.services.detailsService;

import android.support.annotation.NonNull;

import com.orhanobut.logger.Logger;
import com.samirsayegh.marvelchars.domain.utils.LoggerUtils;
import com.samirsayegh.marvelchars.model.services.base.BaseService;
import com.samirsayegh.marvelchars.model.services.dto.TitleDTO;
import com.samirsayegh.marvelchars.model.services.dto.base.BaseDTO;
import com.samirsayegh.marvelchars.model.services.parser.DetailsParser;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Samir DK on 5/1/2017.
 * Samir Dev
 */

public class DetailsService extends BaseService {

    private DetailsServiceResult detailsServiceResult;

    public DetailsService(DetailsServiceResult detailsServiceResult) {
        super();
        this.detailsServiceResult = detailsServiceResult;
    }

    @NonNull
    private Callback<BaseDTO<List<TitleDTO>>> getCallback(final boolean isComic, final boolean isNew) {
        return new Callback<BaseDTO<List<TitleDTO>>>() {
            @Override
            public void onResponse(Call<BaseDTO<List<TitleDTO>>> call, Response<BaseDTO<List<TitleDTO>>> response) {
                Logger.d(LoggerUtils.JOIN + " RESPONSE");
                if (response.isSuccessful()) {
                    Logger.d(LoggerUtils.SUCCESS);
                    if (detailsServiceResult != null) {
                        if (isComic)
                            detailsServiceResult.comicList(DetailsParser.toComicList(response.body()), isNew);
                        else
                            detailsServiceResult.eventList(DetailsParser.toComicList(response.body()), isNew);
                    }
                } else {
                    Logger.d(LoggerUtils.FAILED);
                    if (detailsServiceResult != null) {
                        detailsServiceResult.error(response.message(), isComic);
                    }
                }
                Logger.d(LoggerUtils.LEAVE + " RESPONSE");
            }

            @Override
            public void onFailure(Call<BaseDTO<List<TitleDTO>>> call, Throwable t) {
                if (detailsServiceResult != null) {
                    detailsServiceResult.error(t.getMessage(), isComic);
                }
            }
        };
    }

    public void getComics(int characterId) {
        api.getComics(characterId).enqueue(getCallback(true, true));
    }

    public void getComicsOffset(int characterId, int offset) {
        api.getComics(characterId, offset).enqueue(getCallback(true, false));
    }

    public void getEvents(int characterId) {
        api.getEvents(characterId).enqueue(getCallback(false, true));
    }

    public void getEventsOffset(int characterId, int offset) {
        api.getEvents(characterId, offset).enqueue(getCallback(false, false));
    }
}
