package trofimova.javacore.lesson1;

public class Course {
    String allResult = "";
    String successfulResult = "";
    private String courseName;
    private Obstacle[] obstacles;

    public Course(String courseName, Obstacle[] obstacles) {
        this.courseName = courseName;
        this.obstacles = obstacles;
    }

    public void showAllResult(){
        System.out.println(allResult);
    }

    public void showSuccessfulResult(){
        System.out.println(successfulResult);
    }
    public void doIt (Team team){
       allResult = "Команда " + team.getNameTeam() + ":" + '\n';
       for (Player player: team.getPlayers()){
           allResult += "Участник " + player.getNamePlayer() +  ":" + '\n';
           boolean isPassed = true;
           for (int i = 0; i < obstacles.length; i++){
               if (player.getPower() > obstacles[i].getWeightRod()) allResult = allResult + obstacles[i].getNameRod() + ": зачет" + '\n';
               else {
                   allResult = allResult + obstacles[i].getNameRod() + ": не зачет" + '\n';
                   isPassed = false;
               }
           }
           if (isPassed) {
               successfulResult += "Участник " + player.getNamePlayer() +  " прошел испытание: " + courseName +'\n';
           }
       }
    }
}
