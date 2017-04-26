package com.samirsayegh.marvelchars.domain.services.parser;

import com.samirsayegh.marvelchars.domain.services.dto.HeroDTO;
import com.samirsayegh.marvelchars.domain.services.dto.base.ThumbnailDTO;
import com.samirsayegh.marvelchars.model.entities.Hero;
import com.samirsayegh.marvelchars.model.entities.Thumbnail;

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

    public static List<Hero> toHeroList(List<HeroDTO> heroDTOList) {
        List<Hero> heroList = new ArrayList<>();
        for (HeroDTO heroDTO : heroDTOList) {
            if (heroDTO != null)
                heroList.add(toHero(heroDTO));
        }
        return heroList;
    }
}
