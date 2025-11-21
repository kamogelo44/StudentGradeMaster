/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentgradecalculator;

/**
 *
 * @author Obakeng Phale
 */
public class GradeCalculator {
    
    public static String calculateGrade(double averagePercentage) {
        int gradeCategory = (int) averagePercentage / 10;
        return switch (gradeCategory) {
            case 10, 9 -> "A";
            case 8 -> "B";
            case 7 -> "C";
            case 6 -> "D";
            default -> "F";
        };
    }
    
    public static double calculateTotalMarks(double[] subjectMarks) {
        double total = 0;
        for (double mark : subjectMarks) {
            total += mark;
        }
        return total;
    }
    
    public static double calculateAveragePercentage(double totalMarks, int totalSubjects) {
        return totalMarks / totalSubjects;
    }
    
    public static ClassSummary calculateClassSummary(Student[] students, int studentCount) {
        double classTotalAverage = 0;
        int gradeA = 0, gradeB = 0, gradeC = 0, gradeD = 0, gradeF = 0;
        
        for (int i = 0; i < studentCount; i++) {
            classTotalAverage += students[i].getAveragePercentage();
            
            switch (students[i].getGrade()) {
                case "A" -> gradeA++;
                case "B" -> gradeB++;
                case "C" -> gradeC++;
                case "D" -> gradeD++;
                case "F" -> gradeF++;
            }
        }
        
        classTotalAverage /= studentCount;
        
        return new ClassSummary(studentCount, classTotalAverage, gradeA, gradeB, gradeC, gradeD, gradeF);
    }
}

// Helper class for class summary data
class ClassSummary {
    private int totalStudents;
    private double classAverage;
    private int gradeA, gradeB, gradeC, gradeD, gradeF;
    
    public ClassSummary(int totalStudents, double classAverage, int gradeA, int gradeB, int gradeC, int gradeD, int gradeF) {
        this.totalStudents = totalStudents;
        this.classAverage = classAverage;
        this.gradeA = gradeA;
        this.gradeB = gradeB;
        this.gradeC = gradeC;
        this.gradeD = gradeD;
        this.gradeF = gradeF;
    }
    
    // Getters
    public int getTotalStudents() { return totalStudents; }
    public double getClassAverage() { return classAverage; }
    public int getGradeA() { return gradeA; }
    public int getGradeB() { return gradeB; }
    public int getGradeC() { return gradeC; }
    public int getGradeD() { return gradeD; }
    public int getGradeF() { return gradeF; }
}