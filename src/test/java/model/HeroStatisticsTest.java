package model;

import com.sun.org.apache.xpath.internal.operations.Equals;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeroStatisticsTest {

    private HeroStatistics stats;
    @BeforeAll
    public static void beforeAll(){

    }

    @BeforeEach // wywołuje się przed każdym testem
    public void setUp(){
        stats = new HeroStatistics(10, 10, 10); // dzieki temu mamy nowe statystyki

    }
    @Test
    public void shouldIncreasedHealth(){
        // given - inicjalizujemy dane testowe
        HeroStatistics stats = new HeroStatistics(10,10,10);


        // when - wywołanie metody, którą chcemy przetestować

        stats.increaseHealth(10);

        // them - sprawdzenie czy się udało (wyniku metody)

        assertEquals(20, stats.getHealth()); // mamy wybrac jakas druga opcje

    }
    @Test
    public void shouldIncreasedAttack(){

        stats.increaseAttack(10);

        assertEquals(20, stats.getAttack());
    }

    @Test
    public void shouldIncreasedDefense(){
        stats.increaseDefense(10);
        assertEquals(20, stats.getDefense());

    }


    @AfterEach // czyscimy bazę danych po każdym teście - w tej grze nam się raczej nie przyda
    public void testDown(){

    }

}
