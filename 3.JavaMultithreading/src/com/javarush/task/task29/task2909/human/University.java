package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for(Student student: students){
            if(averageGrade==student.getAverageGrade()) return student;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student best = null;
        double max = 0;
        for(Student student: students){
            if(max<student.getAverageGrade()){
                max = student.getAverageGrade();
                best = student;
            }
        }
        return best;
    }

    public Student getStudentWithMinAverageGrade(){
        Student worst = null;
        double min = students.get(0).getAverageGrade();
        for(Student student: students){
            if(min>student.getAverageGrade()){
                min = student.getAverageGrade();
                worst = student;
            }
        }
        return worst;
    }

    public void expel(Student student){
        students.remove(student);
    }
}