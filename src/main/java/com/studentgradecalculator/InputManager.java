/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentgradecalculator;

/**
 *
 * @author Obakeng Phale
 */
import java.util.Scanner;

public class InputManager {
    private Scanner scanner;
    
    public InputManager(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public String getStudentFirstName() {
        System.out.print("Enter student first name: ");
        return scanner.nextLine().trim();
    }
    
    public String getStudentLastName() {
        System.out.print("Enter student last name: ");
        return scanner.nextLine().trim();
    }
    
    public double[] getSubjectMarks(int totalSubjects) {
        double[] subjectMarks = new double[totalSubjects];
        System.out.println("\nEnter marks for " + totalSubjects + " subjects (out of 100):");
        
        for (int i = 0; i < totalSubjects; i++) {
            while (true) {
                System.out.print("Subject " + (i + 1) + " mark: ");
                if (scanner.hasNextDouble()) {
                    double mark = scanner.nextDouble();
                    if (mark >= 0 && mark <= 100) {
                        subjectMarks[i] = mark;
                        scanner.nextLine(); // consume newline
                        break;
                    } else {
                        System.out.println("Please enter a mark between 0 and 100.");
                    }
                } else {
                    System.out.println("Please enter a valid number.");
                    scanner.next(); // clear invalid input
                }
            }
        }
        return subjectMarks;
    }
    
    public boolean askToContinue() {
        System.out.print("\nAdd another student? (yes/no): ");
        String choice = scanner.nextLine().trim().toLowerCase();
        return !choice.equals("no");
    }
}

