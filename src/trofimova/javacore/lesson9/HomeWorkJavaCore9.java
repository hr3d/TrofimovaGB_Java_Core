package trofimova.javacore.lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HomeWorkJavaCore9 {

    public static void main(String[] args) {

        Course course1 = new Course("Тестирование ПО");
        Course course2 = new Course("Программирование на Java");
        Course course3 = new Course("Программирование на Python");
        Course course4 = new Course("Машинное обучение");
        Course course5 = new Course("Аналитика");
        Course course6 = new Course("Дизайн");
        Course course7 = new Course("Маркетинг");

        Student student1 = new Student("Иван", new ArrayList<>(Arrays.asList(course1,course3,course5)));
        Student student2 = new Student("Федор", new ArrayList<>(Arrays.asList(course2)));
        Student student3 = new Student("Матвей", new ArrayList<>(Arrays.asList(course5,course6,course7)));
        Student student4 = new Student("Степан", new ArrayList<>(Arrays.asList(course1,course2,course4,course5)));
        Student student5 = new Student("Павел", new ArrayList<>(Arrays.asList(course1,course4)));

        List<Student> students = new ArrayList<>(Arrays.asList(student1,student2,student3,student4,student5));

        //Задание 1
        List <Course> listUniqueCourses = students.stream().flatMap(student -> student.getCourses().stream()).distinct().collect(Collectors.toList());
        String message1 = "Список уникальных курсов, на которые подписаны студенты:\n";
        for(int i = 0; i < listUniqueCourses.size();i++){
            message1 += listUniqueCourses.get(i).getCourseName() + "\n";
        }
        System.out.println(message1);

        //Задание 2
        List <Student> listСuriousStudents = students.stream().sorted((st1,st2) -> st2.getCourses().size() - st1.getCourses().size()).limit(3).collect(Collectors.toList());
        String message2 = "Список самых любознательных студентов:\n";
        for(int i = 0; i < listСuriousStudents.size();i++){
            message2 += listСuriousStudents.get(i).getName() + "\n";
        }
        System.out.println(message2);

        //Задание 3
        List <Student> listStudentsVisitedCourse1 = students.stream().filter(student -> student.getCourses().contains(course1)).collect(Collectors.toList());
        String message3 = "Список студентов, посещающих курс '" + course1.getCourseName() +"':\n";
        for(int i = 0; i < listStudentsVisitedCourse1.size();i++){
            message3 += listStudentsVisitedCourse1.get(i).getName() + "\n";
        }
        System.out.println(message3);

    }

}