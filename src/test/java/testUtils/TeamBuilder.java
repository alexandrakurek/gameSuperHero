package testUtils;

import model.AbstractHero;
import model.Team;
import model.TeamType;

import java.util.ArrayList;
import java.util.List;

public class TeamBuilder {

    private List<AbstractHero> heroes;
    private TeamType type;

    public TeamBuilder() {
        heroes = new ArrayList<>();
        type = TeamType.RED;
    }

    public TeamBuilder withHero(AbstractHero hero) {
        heroes.add(hero);
        return this;
    }

    public Team build() {
        return new Team(type, heroes);
    }

    public TeamBuilder withStrongHero() {
        return withHero(new AbstractHeroBuilder()
                .withStrongStats()
                .withType(type)
                .buildSuperHero());
    }

    public TeamBuilder withWeakHero() {
        return withHero(new AbstractHeroBuilder()
                .withWeakStats()
                .withType(type)
                .buildSuperHero());
    }
}
