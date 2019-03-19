package utils;

import model.Team;
import model.TeamType;
import org.junit.jupiter.api.Test;
import testUtils.AbstractHeroBuilder;
import testUtils.TeamBuilder;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class TeamUtilsTest {
    @Test
    void shouldComparedBuffedTeams() {
        Team team1 = new Team(TeamType.BLUE);
        Team team2 = new Team(TeamType.BLUE);

        Team team3 = new TeamBuilder()
                .withStrongHero()
                .build();

        Team team4 = new TeamBuilder()
                .withWeakHero()
                .build();

        assertTrue(TeamUtils
                .compareBuffedteams(team3,team4));
        assertTrue(team3.isTeamBuffed());
        assertTrue(team4.isTeamBuffed());




//        team1.addHeroToTeam(new AbstractHeroBuilder()
//                .withWeakStats()
//                .withBlueType()
//                .buildSuperHero());
//
//        team2.addHeroToTeam(new AbstractHeroBuilder()
//                .withStrongStats()
//                .buildSuperHero());

//        boolean result = TeamUtils
//                .compareBuffedteams(team1, team2);

//        assertTrue(result);
//        assertTrue(team1.isTeamBuffed());
//        assertTrue(team2.isTeamBuffed());




    }

}
