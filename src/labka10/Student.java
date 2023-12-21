/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labka10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Клас студент для считування та додавання даних.
 * @author Admin
 */
public class Student {

    private String Name;
    private String Surname;
    private int Averagemark;
    private int Course;
    private String Specialisetion;

    static ArrayList<Student> students = new ArrayList<>();

    public Student(String name, String surname, int averagemark, int course, String specialisetion) {
        this.Name = name;
        this.Surname = surname;
        this.Averagemark = averagemark;
        this.Course = course;
        this.Specialisetion = specialisetion;
    }

    public String getn() {
        return Name;
    }

    public void setn(String Name) {
        this.Name = Name;
    }

    public String getsn() {
        return Surname;
    }

    public void setsn(String Surname) {
        this.Surname = Surname;
    }

    public int getam() {
        return Averagemark;
    }

    public void setam(int Averagemark) {
        this.Averagemark = Averagemark;
    }

    public int getcs() {
        return Course;
    }

    public void setcs(int Course) {
        this.Course = Course;
    }

    public String getsp() {
        return Specialisetion;
    }

    public void setsp(String Specialisetion) {
        this.Specialisetion = Specialisetion;
    }
    /**
    * Клас для зчитування з файлу.
    */
    public static void readStudentsFromFile(String filename, ArrayList<Student> students) {
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(" ");
                String name = parts[0].trim();
                String surname = parts[1].trim();
                int averagemark = Integer.parseInt(parts[2].trim());
                int course = Integer.parseInt(parts[3].trim());
                String specialization = parts[4].trim();

                Student student = new Student(name, surname, averagemark, course, specialization);
                students.add(student);
            }
            System.out.println("Дані успішно зчитані з файлу: " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайден: " + filename);
        }
    }
    /**
    * Клас для зчитування з файлу.
    */
    public static void writeStudentsToFile(String filename, ArrayList<Student> students) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Student student : students) {
                writer.write(String.format("%s, %s, %d, %d, %s%n",student.getn(), student.getsn(), student.getam(), student.getcs(), student.getsp()));
            }
            System.out.println("Дані успішно записані у файл: " + filename);
        } catch (IOException e) {
            System.out.println("Помилка запису: " + filename);
        }
    }
    /**
    * Клас для пошуку найкращого студента.
    */
    public static Student TopStudentsearch(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("Список порожній.");
            return null;
        }
        Student top = students.get(0);
        for (int i = 1; i < students.size(); i++) {
            Student cei = students.get(i);
            if (cei.getam() > top.getam()) {
                top = cei;
            }
        }
        return top;
    }
    /**
    * Клас для запису до файлу найкращого студента.
    */
    public static void writeTopStudentToFile(String filename, ArrayList<Student> students) {
        Student topStudent = TopStudentsearch(students);
        if (topStudent != null) {
            try (FileWriter writer = new FileWriter(filename)) {
                writer.write(String.format("%s, %s, %d, %d, %s%n",
                        topStudent.getn(), topStudent.getsn(), topStudent.getam(), topStudent.getcs(), topStudent.getsp()));
            } catch (IOException e) {
            }
        }
    }
}
