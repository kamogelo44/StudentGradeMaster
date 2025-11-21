/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentgradecalculator;

/**
 *
 * @author Obakeng Phale
 */
public class DisplayManager {
    
    public void displayWelcomeMessage() {
        System.out.println("🎓 WELCOME TO STUDENT GRADE CALCULATOR 🎓");
        System.out.println("=".repeat(50));
    }
    
    public void displayStudentInfo(Student student, int studentNumber) {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("STUDENT " + studentNumber + " DETAILS");
        System.out.println("=".repeat(80));
        
        System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
        System.out.println("Subjects Marks:");
        
        for (int j = 0; j < student.getTotalSubjects(); j++) {
            System.out.println("  Subject " + (j + 1) + ": " + student.getSubjectMarks()[j] + "/100");
        }
        
        System.out.println("Total Marks: " + student.getTotalMarks() + "/500");
        System.out.println("Average Percentage: " + String.format("%.2f", student.getAveragePercentage()) + "%");
        System.out.println("Grade: " + student.getGrade());
        System.out.println("-".repeat(40));
    }
    
    public void displayAllStudents(StudentManager studentManager) {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("ALL STUDENTS SUMMARY");
        System.out.println("=".repeat(80));
        
        for (int i = 0; i < studentManager.getStudentCount(); i++) {
            displayStudentInfo(studentManager.getStudent(i), i + 1);
        }
    }
    
    public void displayClassSummary(StudentManager studentManager) {
        ClassSummary summary = GradeCalculator.calculateClassSummary(
            studentManager.getAllStudents(), studentManager.getStudentCount());
        
        System.out.println("\n" + "=".repeat(80));
        System.out.println("CLASS OVERALL SUMMARY");
        System.out.println("=".repeat(80));
        System.out.println("Total Students: " + summary.getTotalStudents());
        
        if (summary.getTotalStudents() > 0) {
            System.out.println("Class Average: " + String.format("%.2f", summary.getClassAverage()) + "%");
            
            System.out.println("\nGrade Distribution:");
            System.out.println("A: " + summary.getGradeA() + " students");
            System.out.println("B: " + summary.getGradeB() + " students");
            System.out.println("C: " + summary.getGradeC() + " students");
            System.out.println("D: " + summary.getGradeD() + " students");
            System.out.println("F: " + summary.getGradeF() + " students");
        }
    }
    
    public void displayFullCapacityMessage() {
        System.out.println("\n⚠️  Maximum student capacity reached (10 students)");
    }
    
    public void displayFarewellMessage() {
        System.out.println("\nThank you for using Student Grade Calculator!");
    }
}
