/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentgradecalculator;

/**
 *
 * @author Obakeng Phale
 */
public class StudentManager {
    private Student[] students;
    private int studentCount;
    private final int MAX_STUDENTS = 10;
    
    public StudentManager() {
        this.students = new Student[MAX_STUDENTS];
        this.studentCount = 0;
    }
    
    public boolean addStudent(String firstName, String lastName, double[] subjectMarks) {
        if (studentCount >= MAX_STUDENTS) {
            return false;
        }
        
        students[studentCount] = new Student(firstName, lastName, subjectMarks);
        studentCount++;
        return true;
    }
    
    public Student getStudent(int index) {
        if (index >= 0 && index < studentCount) {
            return students[index];
        }
        return null;
    }
    
    public Student[] getAllStudents() {
        return students;
    }
    
    public int getStudentCount() {
        return studentCount;
    }
    
    public boolean isFull() {
        return studentCount >= MAX_STUDENTS;
    }
    
    public int getMaxStudents() {
        return MAX_STUDENTS;
    }
}

