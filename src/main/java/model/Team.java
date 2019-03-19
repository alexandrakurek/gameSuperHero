package model;

import exception.ValidationException;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Data

public class Team {
    private TeamType type;
    private List<AbstractHero> heroes;
    private AbstractHero teamLeader;
    private boolean isTeamBuffed;
    private Side side;


    public Team() {
        this(null);
    }

    public Team(TeamType type) {
        this(type, new ArrayList<AbstractHero>());

    }

    public Team(TeamType type, List<AbstractHero> heroes) {
        this.type = type;
        this.heroes = heroes;
        this.isTeamBuffed = false;
        this.side = Side.UNKNOWN;

    }


    public void addHeroToTeam(AbstractHero hero) throws ValidationException {
//        if(hero.getType().equals(this.type)) {
//            heroes.add(hero);
//            return true;

        if (!this.type.equals(hero.getType())) { // skrocony zapis tego co jest u gory
            throw new ValidationException("Wrong team type");
        }
        if (teamLeader == null || this.teamLeader.getPower() < hero.getPower()) {
            this.teamLeader = hero;
        }

        heroes.add(hero);
        chooseSide();

    }



    public AbstractHero getTeamLeader1() {
        AbstractHero mostPowerfulHero = null;
        for (AbstractHero hero : this.heroes) {
            if (mostPowerfulHero == null ||
                    hero.getPower() > mostPowerfulHero.getPower()) {
                mostPowerfulHero = hero;
            }
        }
        return mostPowerfulHero;
    }

    public AbstractHero getTeamLeader2() {
        heroes.sort(new AbstractHeroComparator());
        return heroes.get(0);
    }

    public AbstractHero getTeamLeader3() {
        Optional<AbstractHero> hero = heroes.stream() // optional wymusza skorzystanie metody isPresent
                .sorted() // sortuje wedlug metody comapreTo
                .findFirst(); // wyciaga 1 element ze strumienia - metoda konieczna - zwraca optional

        if (hero.isPresent()) {
            return hero.get();
        } else {
            return null;
        }
    }

    public int getTeamPower() {
        int suma = 0;
        for (AbstractHero hero : heroes) {
            suma += hero.getPower();
        }
        return suma;
    }

    public int getTemPowerStream() { //   //     .collect() // kolekcjonuje to listy/mapy itd
        //robimy strumien z listy
        return heroes.stream()
                .mapToInt(hero -> hero.getPower()) // mapujemy (naszego bohatera mamy i z niego wyciagamy jakies statyski np. ktore maja sile = 50 - dane), mamy strumien intow
                .sum();
    }

    public void buffTeamPower() {
        if (!isTeamBuffed) {
            for (AbstractHero hero : heroes) {
                if (hero instanceof SuperHero) { // czy obiekt po lewej stronie jest instancja klasy po prawej stronie
                    hero.stats.increaseDefense(10);
                }
                if (hero instanceof Villain) {
                    hero.stats.increaseHealth(10);
                }

            }
            isTeamBuffed = true;

        }
    }

    public AbstractHero getRandomHero() {
        //TODO: filter out dead heroes
        List<AbstractHero> alieveheroes = this.heroes.stream()
                .filter(hero -> hero.isAlive())
                .collect(toList());

        if(alieveheroes.isEmpty()){
            return null;
        }

        //TODO check if list of alive heroes is not empty
        // losowanie od 10 - 100
//        int a = 10, b=100;
//        int randomNumber = a + random.nextInt(b - a);

        Random random = new Random();
        int heroIndex = random
                .nextInt(alieveheroes.size());
        return alieveheroes.get(heroIndex);
    }

    public boolean hasAlieveHeroes(){
        return this.heroes.stream()
                .anyMatch(hero -> hero.isAlive() ); // dziala tak samo jak filter ale zwraca nam od razu true false

//                .filter(hero -> hero.isAlive())
//                .findAny().isPresent()
    }

    private void chooseSide() {

        int superheroCounts = 0;
        int villainCounts = 0;

        for (AbstractHero hero : heroes) {
            if (hero instanceof SuperHero) {
                superheroCounts++;
            }
            if (hero instanceof Villain) {
                villainCounts++;
            }
        }
        if (superheroCounts > villainCounts) {
            this.side = Side.GOOD;
        } else if (superheroCounts < villainCounts) {
            this.side = Side.EVIL;
        } else {
            this.side = Side.UNKNOWN;
        }
    }

    private void chooseSideStream() {
        long superHeroPower = heroes.stream()
                .filter(hero -> hero instanceof SuperHero)
                .mapToInt(hero -> hero.getPower()) // zmieniamy strumien naszych bohaterow na strumien sil, maptoInt - strumien numeryczny
                .sum();

        int villainPower = heroes.stream()
                .filter(hero -> hero instanceof Villain)
                .mapToInt(hero -> hero.getPower())
                .sum();

        setSide((int) superHeroPower, villainPower);
    }

    private void setSide(int superHeroPower, int villainPower) {
        if (superHeroPower > villainPower) {
            this.side = Side.GOOD;
        } else if (superHeroPower < villainPower) {
            this.side = Side.EVIL;
        } else {
            this.side = Side.UNKNOWN;
        }
    }


}
