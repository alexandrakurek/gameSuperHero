package factory;

import model.*;
import utils.PropertiesUtils;

public class HeroCreator {

    public AbstractHero createSuperHero(String name, HeroStatistics stats, TeamType type){
        return new SuperHero(name,stats,type);

    }

    public AbstractHero createSuperHero(String name, TeamType type){
        int health = PropertiesUtils.INSTANCE.getPropertiesIntValue("app.superHero.health");
        int attack = PropertiesUtils.INSTANCE.getPropertiesIntValue("app.superHero.attack");
        int defense =PropertiesUtils.INSTANCE.getPropertiesIntValue("app.superHero.defence");

        return new SuperHero(name,new HeroStatistics(health,attack,defense),type);

    }
    public AbstractHero createVallain(String name, HeroStatistics stats, TeamType type){
        int health = PropertiesUtils.INSTANCE.getPropertiesIntValue("app.villain.health");
        int attack = PropertiesUtils.INSTANCE.getPropertiesIntValue("app.villain.attack");
        int defense =PropertiesUtils.INSTANCE.getPropertiesIntValue("app.villain.defence");

        return new Villain(name,new HeroStatistics(health,attack,defense), type);
    }

    public AbstractHero fromString (String hero){
        // podajemy separator, drugi limit na ile czesci nam podzieli
//        "SuperHero, name, 12,12,12".split(",",2);
//        "SuperHero", "name: 12,12,12" - limit 2
//        "SuperHero:", "name", "12,12,12" - limit 3

        String[] parts = hero.split(",", 2);

        if(parts[0].equals("SuperHero")){
            return new SuperHero(parts[1].split(","));
        } else if(parts[0].equals("Villain")){
            return new Villain(parts[1].split(","));
        }
         return null;

    }

}
