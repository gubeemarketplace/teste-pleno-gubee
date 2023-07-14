package br.com.gubee.interview.core.services.imp;

import br.com.gubee.interview.core.repository.HeroRepository;
import br.com.gubee.interview.core.services.HeroService;
import br.com.gubee.interview.dto.HeroDTO;
import br.com.gubee.interview.model.Hero;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class HeroServiceImpl implements HeroService {



    @Autowired
    private HeroRepository heroRepository;

    @Autowired
    private ModelMapper modelMapper;

    public HeroServiceImpl(HeroRepository heroRepository, ModelMapper modelMapper) {
        this.heroRepository = heroRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public HeroDTO findById(UUID id) {
        Hero hero = heroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Heroi não encontrado"));
        return modelMapper.map(hero, HeroDTO.class);
    }

    @Override
    public HeroDTO save(HeroDTO heroDTO) {
        Hero hero = modelMapper.map(heroDTO, Hero.class);
        Hero heroSave = heroRepository.save(hero);
        return modelMapper.map(heroSave, HeroDTO.class);
    }

    @Override
    public HeroDTO update(UUID id, HeroDTO heroDTO) {
        Hero hero = heroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Heroi não encontrado"));
        modelMapper.map(heroDTO, hero);
        Hero heroUpdate = heroRepository.save(hero);
        return modelMapper.map(heroUpdate, HeroDTO.class);
    }

    @Override
    public void delete(UUID id) {
        Hero hero = heroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Heroi não encontrado"));
        heroRepository.delete(hero);
    }
}
