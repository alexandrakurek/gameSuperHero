package utils;

import factory.HeroCreator;
import model.AbstractHero;
import model.Team;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TeamUtils {

    public static boolean compare(Team team1, Team team2) {
        if (team1.getTeamPower() > team2.getTeamPower()) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean compareBuffedteams(Team team1, Team team2) {
        team1.buffTeamPower();
        team2.buffTeamPower();

        return compare(team1, team2);
    }

    public static void saveTeamToFile(String fileName, Team team) {


        try (FileWriter fileWriter = new FileWriter(fileName);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
            team.getHeroes()
                    .forEach(hero -> printWriter.write(hero.toCsvRecord() + "\n"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Team createTeamFromFile(String fileName){ // zapisywanie do pliku
        HeroCreator heroCreator = new HeroCreator();
        List<AbstractHero> heroes = new ArrayList<>();

        try (FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String line = bufferedReader.readLine();
            while (line != null){
                //TODO create hero instance from line
                AbstractHero hero = heroCreator.fromString(line);
                heroes.add(hero);
                line = bufferedReader.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } return new Team(heroes.get(0).getType(), heroes); // typ z 1 bohatera
    }
}
