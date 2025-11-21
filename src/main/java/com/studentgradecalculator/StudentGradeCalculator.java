/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.studentgradecalculator;

import java.util.Scanner;
import static com.studentgradecalculator.DisplayManager.*;
import static com.studentgradecalculator.InputManager.*;

/**
 *
 * @author Obakeng Phale
 */
public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Initialize managers
        StudentManager studentManager = new StudentManager();
        DisplayManager displayManager = new DisplayManager();
        InputManager inputManager = new InputManager(scanner);
        
        // Display welcome message
        displayManager.displayWelcomeMessage();
        
        // Main program loop
        while (true) {
            System.out.println("\n--- Enter Student Information ---");
            
            // Get student information using cleaner calls
            String firstName = inputManager.getStudentFirstName();
            String lastName = inputManager.getStudentLastName();
            double[] subjectMarks = inputManager.getSubjectMarks(5);
            
            // Add student to manager
            boolean added = studentManager.addStudent(firstName, lastName, subjectMarks);
            
            if (!added) {
                displayManager.displayFullCapacityMessage();
                break;
            }
            
            // Display current student info
            Student currentStudent = studentManager.getStudent(studentManager.getStudentCount() - 1);
            displayManager.displayStudentInfo(currentStudent, studentManager.getStudentCount());
            
            // Ask to continue
            if (!inputManager.askToContinue()) {
                break;
            }
        }
        
        // Display final summaries
        displayManager.displayAllStudents(studentManager);
        displayManager.displayClassSummary(studentManager);
        displayManager.displayFarewellMessage();
        
        scanner.close();
    }
}