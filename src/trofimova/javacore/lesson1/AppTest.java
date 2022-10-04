package trofimova.javacore.lesson1;

public class AppTest {
    public static void main(String[] args) {

        Obstacle[] obstacles = new Obstacle[3];
        obstacles[0] = new Obstacle("Первая штанга", 195);
        obstacles[1] = new Obstacle("Вторая штанга", 205);
        obstacles[2] = new Obstacle("Третья штанга", 215);

        Course course = new Course("Первый подход", obstacles);

        Player[] players = new Player[4];
        players[0] = new Player("Степан", 230);
        players[1] = new Player("Арсений", 220);
        players[2] = new Player("Николай", 210);
        players[3] = new Player("Матвей", 200);

        Team team = new Team("Силачи", players);

        course.doIt(team);
        course.showAllResult();
        course.showSuccessfulResult();

    }
}