/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentgradecalculator;

/**
 *
 * @author Obakeng Phale
 */
public class Student {
    private String firstName;
    private String lastName;
    private double[] subjectMarks;
    private double totalMarks;
    private double averagePercentage;
    private String grade;
    
    private final int TOTAL_SUBJECTS = 5;
    
    public Student(String firstName, String lastName, double[] subjectMarks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjectMarks = subjectMarks;
        calculateResults();
    }
    
    private void calculateResults() {
        // Calculate total marks
        this.totalMarks = 0;
        for (double mark : subjectMarks) {
            this.totalMarks += mark;
        }
        
        // Calculate average percentage
        this.averagePercentage = this.totalMarks / TOTAL_SUBJECTS;
        
        // Calculate grade
        this.grade = calculateGrade(this.averagePercentage);
    }
    
    private String calculateGrade(double average) {
        int gradeCategory = (int) average / 10;
        return switch (gradeCategory) {
            case 10, 9 -> "A";
            case 8 -> "B";
            case 7 -> "C";
            case 6 -> "D";
            default -> "F";
        };
    }
    
    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public double[] getSubjectMarks() { return subjectMarks; }
    public double getTotalMarks() { return totalMarks; }
    public double getAveragePercentage() { return averagePercentage; }
    public String getGrade() { return grade; }
    public int getTotalSubjects() { return TOTAL_SUBJECTS; }
}
