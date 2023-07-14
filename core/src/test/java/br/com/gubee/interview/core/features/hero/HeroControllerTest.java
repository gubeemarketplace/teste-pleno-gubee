package br.com.gubee.interview.core.features.hero;


import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

@ExtendWith(SpringExtension.class)
public class HeroControllerTest {


    @InjectMocks
    private HeroController heroController;


    @BeforeEach
    public void setup(){
        standaloneSetup(this.heroController);
    }

    @Test
    public void test() {
                given()
                    .accept(ContentType.JSON)
                .when()
                    .get("/heros/{id}", 1L)//o objeto não e uma String
                .then()
                    .statusCode(HttpStatus.BAD_REQUEST.value());

    }
}
