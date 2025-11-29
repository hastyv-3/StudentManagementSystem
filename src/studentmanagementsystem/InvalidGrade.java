/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;

/**
 *
 * @author Stephen
 */
public class InvalidGrade extends Exception {
    
    public InvalidGrade() {
        super("Error: grade should be between 0-100");
    }
    
}
