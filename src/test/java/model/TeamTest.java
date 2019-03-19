package model;

import exception.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.AbstractHeroBuilder;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    AbstractHero hero = new AbstractHeroBuilder()
        . withBlueType()
            .buildSuperHero();


    @BeforeEach
    void setUp() {
    }
    @Test
    void shouldAddHeroifIsTheSameTypeAsTeam() throws ValidationException {
        //given
        Team team = new Team(TeamType.BLUE);
        //when
        team.addHeroToTeam(hero);
        //then
        assertTrue(team.getHeroes().contains(hero));

    }

    @Test
    void shouldNotAddHeroIfDoesNotMatchTeamType() throws ValidationException {
        Team team = new Team(TeamType.RED);


        assertThrows(ValidationException.class,
                () ->team.addHeroToTeam(hero));
        assertFalse(team.getHeroes().contains(hero));

    }


    @Test
    void shouldChooseSideEvilSideWhenVillainIsAdded() throws ValidationException {
        Team team = new Team(TeamType.RED);
        AbstractHero villain = new AbstractHeroBuilder()
        .buildVillain ();

        team.addHeroToTeam(villain);

        assertEquals(Side.EVIL, team.getSide());{
        }
    }
    @Test
    void shouldChooseGoodSideWhenSuperHeroIsAdded() throws ValidationException {
        Team team = new Team(TeamType.RED);
        AbstractHero superHero = new AbstractHeroBuilder()
                .buildSuperHero();

        team.addHeroToTeam(superHero);
        assertEquals(Side.GOOD, team.getSide());
    }

    @Test
    void shouldChooseSideBasedOnPower() throws ValidationException {
        Team team = new Team(TeamType.RED);
        AbstractHero villain = new AbstractHeroBuilder()
                .withWeakStats()
                .buildVillain();

        AbstractHero villain2 = new AbstractHeroBuilder()
                .withWeakStats()
                .buildVillain();

        AbstractHero superHero = new AbstractHeroBuilder()
        .withStrongStats()
        .buildSuperHero();{

        }

        team.addHeroToTeam(villain);
        team.addHeroToTeam(villain2);
        team.addHeroToTeam(superHero);

        assertEquals(Side.GOOD, team.getSide());
    }


}