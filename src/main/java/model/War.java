package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class War {

    private Team team1;
    private Team team2;

    public Team startWar() {

        while (team1.hasAlieveHeroes()
                && team2.hasAlieveHeroes()) {
            duel();
        }
        return determineVictoriousTeam();

    }

    private void duel() {
        AbstractHero hero1 = team1.getRandomHero();
        AbstractHero hero2 = team2.getRandomHero();

        if (hero1.getPower() < hero2.getPower()) {
            hero1.kill();
        } else if (hero1.getPower() > hero2.getPower()) {
            hero2.kill();
        } else {
            hero1.kill();
            hero2.kill();
        }
    }

    private Team determineVictoriousTeam() {
        if (team1.hasAlieveHeroes()) {
            return team1;
        } else if (team2.hasAlieveHeroes()) {
            return team2;
        } else {
            return null;
        }


    }

}
