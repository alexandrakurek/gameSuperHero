package model;

import lombok.Data;

@Data
public class SuperHero extends AbstractHero {


    public SuperHero (String name, HeroStatistics stats, TeamType type){
        super(name, stats, type);
    }

    @Override
    public int getPower(){
        return (stats.getAttack()+ stats.getDefense())* stats.getHealth();

    }
    public SuperHero(String[] parts){
        super(parts);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }



}
