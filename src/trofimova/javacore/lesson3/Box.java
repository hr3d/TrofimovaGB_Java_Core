package trofimova.javacore.lesson3;

public class Box <T extends Fruit>{

    private T[] fruits;

    private int count;

    public Box(T[] fruits) {
        this.fruits = fruits;
    }

    public float getWeight(){
        if (fruits[0] == null) return 0;

        return fruits[0].getWeight() * getSize();
    }

    public Boolean compare(Box<? extends Fruit> secondBox){
        return (this.getWeight() == secondBox.getWeight());
    }

    private int getSize(){
        int result = 0;
        for(T t: fruits){
            if(t!=null)result++;
        }
        return result;
    }

    public void joinFruits(Box<T> secondBox){
        System.out.println("В первой коробке: " + this.getWeight());
        System.out.println("Во второй коробке: " + secondBox.getWeight());

        int startSecondBoxSize = secondBox.getSize();
        for (int i = 0; i < startSecondBoxSize; i++){
            this.fruits[this.getSize()] = secondBox.fruits[i];
            secondBox.fruits[i] = null;
        }

        System.out.println("В первой коробке после: " + this.getWeight());
        System.out.println("Во второй коробке после: " + secondBox.getWeight());
    }

    public void addFruit(T fruit){
        System.out.println("Изначально в коробке: " + this.getWeight());
        this.fruits[this.getSize()] = fruit;
        System.out.println("После добавления одного фрукта: " + this.getWeight());
    }
}