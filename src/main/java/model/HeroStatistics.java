package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class HeroStatistics {
    private int health;
    private int attack;
    private int defense;

    public void increaseHealth(int amount){
        if(amount <0){
            throw new IllegalStateException("amount is below 0");
        }
       this.health = this.health + amount;

    }
    public void increaseAttack(int amount){
        attack = attack + amount;
    }
    public void increaseDefense(int amount){
        defense= defense + amount;
    }
}
