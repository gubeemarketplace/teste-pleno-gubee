package br.com.gubee.interview.core.features.hero;

import br.com.gubee.interview.core.services.HeroService;
import br.com.gubee.interview.model.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
@ActiveProfiles("it")
public class HeroServiceIT {

    @Autowired
    private HeroService heroService;



}
