package com.samirsayegh.marvelchars.model.services.parser;

import com.samirsayegh.marvelchars.domain.entities.Hero;
import com.samirsayegh.marvelchars.domain.entities.OffsetList;
import com.samirsayegh.marvelchars.domain.entities.Thumbnail;
import com.samirsayegh.marvelchars.model.services.dto.HeroDTO;
import com.samirsayegh.marvelchars.model.services.dto.base.BaseDTO;
import com.samirsayegh.marvelchars.model.services.dto.base.DataDTO;
import com.samirsayegh.marvelchars.model.services.dto.base.ThumbnailDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yormirsamir.sayegh on 26/04/2017.
 */

public class HeroParser {

    public static Hero toHero(HeroDTO heroDTO) {
        Hero hero = new Hero();
        if (heroDTO != null) {
            hero.setId(heroDTO.getId());
            hero.setName(heroDTO.getName() != null ? heroDTO.getName() : "");
            hero.setDescription(heroDTO.getDescription() != null ? heroDTO.getDescription() : "");
            Thumbnail thumbnail = new Thumbnail();
            if (heroDTO.getThumbnail() != null) {
                ThumbnailDTO thumbnailDTO = heroDTO.getThumbnail();
                thumbnail.setPath(thumbnailDTO.getPath() != null ? thumbnailDTO.getPath() : "");
                thumbnail.setExtension(thumbnailDTO.getExtension() != null ? thumbnailDTO.getExtension() : "");
            }
            hero.setThumbnail(thumbnail);
        }
        return hero;
    }

    public static OffsetList<Hero> toHeroList(BaseDTO<List<HeroDTO>> heroDTOList) {
        OffsetList<Hero> offsetList = new OffsetList<>();
        List<Hero> heroList = new ArrayList<>();
        offsetList.setList(heroList);
        DataDTO<List<HeroDTO>> dataDTO = heroDTOList.getData();
        if (dataDTO != null) {
            offsetList.setOffset(dataDTO.getOffset());
            offsetList.setTotal(dataDTO.getTotal());
            for (HeroDTO heroDTO : dataDTO.getResults()) {
                if (heroDTO != null)
                    heroList.add(toHero(heroDTO));
            }
        }
        return offsetList;
    }
}
