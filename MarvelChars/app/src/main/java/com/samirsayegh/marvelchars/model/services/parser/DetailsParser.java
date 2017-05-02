package com.samirsayegh.marvelchars.model.services.parser;

import com.samirsayegh.marvelchars.domain.entities.BaseContent;
import com.samirsayegh.marvelchars.domain.entities.OffsetList;
import com.samirsayegh.marvelchars.domain.entities.Thumbnail;
import com.samirsayegh.marvelchars.model.services.dto.TitleDTO;
import com.samirsayegh.marvelchars.model.services.dto.base.BaseDTO;
import com.samirsayegh.marvelchars.model.services.dto.base.DataDTO;
import com.samirsayegh.marvelchars.model.services.dto.base.ThumbnailDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samir DK on 5/1/2017.
 * Samir Dev
 */

public class DetailsParser {

    public static OffsetList<BaseContent> toComicList(BaseDTO<List<TitleDTO>> baseDTO) {
        OffsetList<BaseContent> offsetList = new OffsetList<>();
        List<BaseContent> baseContents = new ArrayList<>();
        offsetList.setList(baseContents);
        DataDTO<List<TitleDTO>> dataDTO = baseDTO.getData();
        if (dataDTO != null) {
            offsetList.setOffset(dataDTO.getOffset());
            offsetList.setTotal(dataDTO.getTotal());
            for (TitleDTO titleDTO : dataDTO.getResults()) {
                if (titleDTO != null)
                    baseContents.add(toBaseContent(titleDTO));
            }
        }
        return offsetList;
    }

    private static BaseContent toBaseContent(TitleDTO titleDTO) {
        BaseContent baseContent = new BaseContent();
        if (titleDTO != null) {
            baseContent.setName(titleDTO.getTitle() != null ? titleDTO.getTitle() : "");
            baseContent.setDescription(titleDTO.getDescription() != null ? titleDTO.getDescription() : "");
            Thumbnail thumbnail = new Thumbnail();
            if (titleDTO.getThumbnail() != null) {
                ThumbnailDTO thumbnailDTO = titleDTO.getThumbnail();
                thumbnail.setPath(thumbnailDTO.getPath() != null ? thumbnailDTO.getPath() : "");
                thumbnail.setExtension(thumbnailDTO.getExtension() != null ? thumbnailDTO.getExtension() : "");
            }
            baseContent.setThumbnail(thumbnail);
        }
        return baseContent;

    }
}
