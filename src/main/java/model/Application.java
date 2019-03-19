package model;

        import exception.ValidationException;
        import factory.HeroCreator;
        import utils.TeamUtils;


public class Application {
    private static HeroCreator heroCreator = new HeroCreator();

    public static void main(String[] arg) throws ValidationException {
        heroCreator.createSuperHero("Karo", TeamType.RED);

        Team team = new Team(TeamType.RED);
        team.addHeroToTeam(heroCreator.createSuperHero("Super hero", TeamType.RED));



        System.out.println(team.getTeamLeader1());

        Team avengers = new Team(TeamType.RED);
        avengers.addHeroToTeam(heroCreator.createSuperHero("Thor", TeamType.RED));
        avengers.addHeroToTeam(heroCreator.createSuperHero("Capitan Marvel", TeamType.RED));
        avengers.addHeroToTeam(heroCreator.createSuperHero("Hulk", TeamType.RED));

        Team justieLeague = new Team(TeamType.BLUE);
        justieLeague.addHeroToTeam(heroCreator.createSuperHero("Superman", TeamType.BLUE));
        justieLeague.addHeroToTeam(heroCreator.createSuperHero("Aquaman",TeamType.BLUE));
        justieLeague.addHeroToTeam(heroCreator.createSuperHero("Wonder Woman",TeamType.BLUE));

        War war = new War(avengers,justieLeague);
        System.out.println(war.startWar());

        System.out.println(heroCreator.createSuperHero("Thor",TeamType.RED)
        .toCsvRecord());

        TeamUtils.saveTeamToFile("JusticeLegue.csv",justieLeague);

//        System.out.println(heroCreator.fromString("SuperHero, name, 12,12,12, BLUE"));

        System.out.println(TeamUtils.createTeamFromFile("JusticeLegue.csv"));



    }
}