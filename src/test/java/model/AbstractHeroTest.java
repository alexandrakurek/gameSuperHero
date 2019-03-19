package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.AbstractHeroBuilder;

import static org.junit.jupiter.api.Assertions.*;

class AbstractHeroTest {

    // tutaj jest jakby już nasz given
    private String name = "name";
    private HeroStatistics stats = new HeroStatistics(1,1,1);


    @BeforeEach
    void setUp() {
        System.out.println(1+1+ "1");
        System.out.println(1 + "1" + 1);


    }
    @Test
    public void shouldIncreaseHealthifRedType(){
        //when
       TestHero hero = new TestHero(name,stats, TeamType.RED);

       //then
        assertEquals(51, stats.getHealth());

    }
    @Test
    public void shouldIncreaseAttackifBlueType(){
        AbstractHero hero = new AbstractHeroBuilder()
                .withType(TeamType.BLUE)
                .buildSuperHero();
        assertEquals(51,hero.getStats().getAttack());
    }

    @Test
    public void shouldIncreaseDefenceIfGreenType(){
        AbstractHero hero = new AbstractHeroBuilder()
                .withType(TeamType.GREEN)
                .buildSuperHero();

        assertEquals(51,hero.getStats().getDefense());
    }



    private class TestHero extends AbstractHero { // oddzielamy sie od naszego abstracthero, zeby nam nie zepsul niczego. to tylko test
        public TestHero (String name, HeroStatistics stats, TeamType type){
            super(name,stats,type);
        }
        public int getPower(){
            return 0;
        }

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }
}