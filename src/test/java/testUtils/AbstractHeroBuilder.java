package testUtils;

import model.*;

public class AbstractHeroBuilder {

    private String name;
    private HeroStatistics stats;
    private TeamType type;

    // ustawiamy konstruktor
    public AbstractHeroBuilder(){
        name = "default hero";
        stats = new HeroStatistics(1,1,1);
        type = TeamType.RED;
    }
    // metody do ustawiania poszczegolnych wartosci

    public AbstractHeroBuilder withName (String name){
        this.name = name;
        return this;
    }
    public AbstractHeroBuilder withStats(HeroStatistics stats){
        this.stats = stats;
        return this;
    }
    public AbstractHeroBuilder withType(TeamType type){
        this.type = type;
        return this;
    }
    public SuperHero buildSuperHero(){
        return new SuperHero(name,stats,type);
    }

    public AbstractHeroBuilder withBlueType(){
        return withType(TeamType.BLUE);
    }
    public AbstractHeroBuilder withGreenType(){
        return withType(TeamType.GREEN);
    }

    public AbstractHeroBuilder withWeakStats() {
        return withStats(new HeroStatistics(1,1,1));
    }
    public AbstractHeroBuilder withStrongStats(){
        return withStats(new HeroStatistics(100,100,100));
    }


    public AbstractHero buildVillain() {
        return new Villain(name,stats,type);
    }
}
