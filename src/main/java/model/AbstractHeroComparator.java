package model;

import java.util.Comparator;

public class AbstractHeroComparator implements Comparator<AbstractHero> {


    public int compare(AbstractHero o1, AbstractHero o2){
//        if(o1.getPower() > o2.getPower()){
//            return 1;
//        } else if(o1.getPower() < o2.getPower()){
//            return -1;
//        } else {
//            return 0;
//        }
        return o1.getPower() - o2.getPower();
    }
}
