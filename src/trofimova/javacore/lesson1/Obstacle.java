package trofimova.javacore.lesson1;

public class Obstacle {
    private String nameRod;
    private int weightRod;

    public Obstacle(String nameRod, int weightRod) {
        this.nameRod = nameRod;
        this.weightRod = weightRod;
    }

    public int getWeightRod() {
        return weightRod;
    }

    public String getNameRod() {
        return nameRod;
    }
}
