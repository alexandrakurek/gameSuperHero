package model;

import org.junit.jupiter.api.Test;
import testUtils.AbstractHeroBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AbstractHeroComparatorTest {
    @Test
    void shouldSortHeroesByPower(){
        List<AbstractHero> heroes = new ArrayList<AbstractHero>();

        AbstractHero weakHero = new AbstractHeroBuilder()
        .withWeakStats()
        .buildSuperHero();
        heroes.add(weakHero);

        AbstractHero strongHero = new AbstractHeroBuilder()
        .withStrongStats()
        .buildSuperHero();
        heroes.add(strongHero);

        heroes.sort(new AbstractHeroComparator());

        assertEquals(strongHero, heroes.get(0));

    }

}