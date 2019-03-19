package model;

import lombok.Data;

@Data
public class Villain extends AbstractHero  {

    public Villain (String name, HeroStatistics stats, TeamType type){
        super(name,stats,type);
    }

    public Villain(String [] parts){
        super(parts);

    }


    public int getPower(){
        return (stats.getAttack() + stats.getHealth())
                * stats.getDefense();
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
