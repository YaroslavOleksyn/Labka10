/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package labka10;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Головий клас виконання програми з меню.
 * @author Admin
 */
public class Labka10 {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Student> students = new ArrayList<>();

    while (true) {
        System.out.println("Оберіть дію із списку.");
        System.out.println("1. Зчитати студентів з файлу.");
        System.out.println("2. Записати студентів у інший файл.");
        System.out.println("3. Знайти найуспішнішого студента.");
        System.out.println("4. Вийти з меню:");

        int n = scanner.nextInt();
        scanner.nextLine();

        switch (n) {
            case 1:
                Student.readStudentsFromFile("C:\\Users\\Admin\\Desktop\\Нова папка\\text.txt", students);
                System.out.println("Дані студентів зчитані з файлу.");
                break;
            case 2:
                Student.writeStudentsToFile("C:\\Users\\Admin\\Desktop\\Нова папка\\text2.txt", students);
                System.out.println("Дані студентів записані у другий файл.");
                break;
            case 3:
                Student.writeTopStudentToFile("C:\\Users\\Admin\\Desktop\\Нова папка\\text3.txt", students);
                System.out.println("Найкращий студент записаний у 2 файл.");
                break;
            case 4:
                System.out.println("Завершую роботу з проектом...");
                return;
            default:
                System.out.println("Немає такої дії в меню.");
                return;
        }
    }
}
}

