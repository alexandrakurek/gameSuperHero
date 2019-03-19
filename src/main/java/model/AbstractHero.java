package model;


import lombok.Data;

@Data

public abstract class AbstractHero implements Comparable {
    protected String name;
    protected HeroStatistics stats;
    protected TeamType type;
    protected boolean alive;

    public AbstractHero(String[] parts) {
        this(
                parts[0],
                new HeroStatistics(
                        Integer.valueOf(parts[1]),
                        Integer.valueOf(parts[2]),
                        Integer.valueOf(parts[3])),
                TeamType.valueOf(parts[4])
        );


    }


    public AbstractHero(String name, HeroStatistics stats, TeamType type) {
        this.name = name;
        this.stats = stats;
        this.type = type;
        this.alive = true;

        switch (type) {
            case BLUE: {
                this.stats.increaseAttack(50);
                //this.stats.setAttack(this.stats.getAttack() + 50);

                break;
            }
            case GREEN: {
                this.stats.increaseDefense(50);
                // this.stats.setDefense(this.stats.getDefense()+ 50);
                break;
            }
            case RED: {
                this.stats.increaseHealth(50);
                // this.stats.setHealth(this.stats.getHealth() + 50 );
                break;
            }
        }

    }

    public abstract int getPower();

    public int compareTo(AbstractHero hero) {
        if (this.getPower() == hero.getPower()) {
            return hero.getName().compareTo(this.getName());
        }
        return hero.getPower() - this.getPower();
    }

    public void kill() {
        System.out.println("Killing hero: " + name);
        this.alive = false;
    }

    public String toCsvRecord() { // metoda ktora zapisuje nam naszych bohaterow w stringach i do pliku csc
        return String.join(",",
                getClass().getSimpleName(),
                name,
                Integer.toString(stats.getAttack()),
                Integer.toString(stats.getDefense()),
                Integer.toString(stats.getHealth()),
                type.toString());

    }
}

