package br.com.gubee.interview.core.services;

import br.com.gubee.interview.dto.HeroDTO;

import java.util.UUID;

public interface HeroService {

    HeroDTO findById(UUID id);

    HeroDTO save(HeroDTO heroDTO);

    HeroDTO update(UUID id, HeroDTO heroDTO);

    void delete(UUID id);

}
