package trofimova.javacore.lesson3;

import java.util.Arrays;

public class HomeWorkJavaCore3 {

    public static void main (String[] args){

        //Задание 1

        String[] myArray = {"Катя", "Степа", "Ева", "Федя"};
        System.out.println(Arrays.toString(myArray));
        changeArrayElements(myArray, 1, 2);
        System.out.println(Arrays.toString(myArray));

        Integer[] myIntArray = {12, 34, 56, 78};
        System.out.println(Arrays.toString(myIntArray));
        changeArrayElements(myIntArray, 1, 2);
        System.out.println(Arrays.toString(myIntArray));
        System.out.println();

        //Задание 2
        int size = 20;

        Apple [] apples1 = new Apple[size];
        apples1[0] = new Apple();
        apples1[1] = new Apple();
        apples1[2] = new Apple();
        Box <Apple> applesBox1 = new Box<>(apples1);

        Apple [] apples2 = new Apple[size];
        apples2[0] = new Apple();
        apples2[1] = new Apple();
        apples2[2] = new Apple();
        apples2[3] = new Apple();
        Box <Apple> applesBox2 = new Box<>(apples2);

        Orange [] oranges1 = new Orange[size];
        oranges1[0] = new Orange();
        oranges1[1] = new Orange();
        oranges1[2] = new Orange();
        oranges1[3] = new Orange();
        Box <Orange> orangesBox1 = new Box<>(oranges1);

        Orange [] oranges2 = new Orange[size];
        oranges2[0] = new Orange();
        oranges2[1] = new Orange();
        Box <Orange> orangesBox2 = new Box<>(oranges2);

        System.out.println("Вес первой коробки с яблоками " + applesBox1.getWeight());
        System.out.println("Вес второй коробки с яблоками " + applesBox2.getWeight());
        System.out.println("Вес первой коробки с апельсинами " + orangesBox1.getWeight());
        System.out.println("Вес второй коробки с апельсинами " + orangesBox2.getWeight());
        System.out.println();

        System.out.println("Вес коробок совпадает? Ответ: " + applesBox1.compare(orangesBox2));
        System.out.println();

        applesBox1.joinFruits(applesBox2);
        System.out.println();
        orangesBox2.joinFruits(orangesBox1);
        System.out.println();

        Apple OneApple = new Apple();
        applesBox1.addFruit(OneApple);
    }

    public static <T> void changeArrayElements(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
