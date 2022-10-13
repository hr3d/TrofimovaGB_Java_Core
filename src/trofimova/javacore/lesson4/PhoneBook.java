package trofimova.javacore.lesson4;

import jdk.internal.util.xml.impl.Pair;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private HashMap<String,String> phoneBook = new HashMap<>();

    public void add (String phoneNumber, String surname){
        phoneBook.put(phoneNumber, surname);
    }

    public String get (String surname){
        String NumberList = "";
        for (Map.Entry<String, String> o : phoneBook.entrySet()) {
            if (o.getValue().equals(surname)){
                NumberList += "\n" + o.getKey();
            }
        }
        return NumberList;
    }

}
