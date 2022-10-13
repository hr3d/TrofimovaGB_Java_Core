package trofimova.javacore.lesson4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HomeWorkJavaCore4 {

    public static void main(String[] args) {

        // Задание 1

        String[] myArray = {"Катя", "Степа", "Ева", "Федя", "Катя", "Вера", "Ева", "Владимир", "Ева", "Слава", "Вадим", "Вадим", "Ева", "Катя"};
        System.out.println(Arrays.toString(myArray));
        System.out.println();

        Set<String> set = new HashSet<>();
        for (int i = 0; i < myArray.length; i++){
            set.add(myArray[i]);
        }
        System.out.println(set);
        System.out.println();

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < myArray.length; i++){
            Integer value = 1;
            if (hashMap.containsKey(myArray[i])){
                value = hashMap.get(myArray[i]);
                value += 1;
            }
            hashMap.put(myArray[i],value);
        }
        System.out.println(hashMap);
        System.out.println();

        // Задание 2

        PhoneBook book = new PhoneBook();
        book.add("79263434344", "Иванов");
        book.add("79263334445", "Сергеев");
        book.add("79266676676", "Иванов");
        book.add("79298989898", "Кузнецов");
        book.add("79290009999", "Малинин");
        book.add("79265555676", "Сергеев");
        book.add("79294446677", "Попов");
        book.add("79298888888", "Малинин");
        book.add("79265500055", "Сергеев");

        System.out.println("Список телефонов для фамилии Сергеев: " + book.get("Сергеев"));
        System.out.println();
        System.out.println("Список телефонов для фамилии Иванов: " + book.get("Иванов"));
    }
}

