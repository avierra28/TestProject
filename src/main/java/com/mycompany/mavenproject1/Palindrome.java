/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.Scanner;

/**
 *
 * @author anthony
 */
public class Palindrome {
    
    public static Scanner myScanner = new Scanner(System.in);
    
    public static void main(String[] args) {
       
        
        System.out.println("Please enter a string: ");
        String mystring = myScanner.nextLine();
        
        System.out.println(checkPalindrome(mystring));
        
        
    }
    
    // Define a method to accept this.
    public static boolean checkPalindrome(String str) {
        
        String tempString = "";
        
        for (int i = str.length() - 1; i >= 0; i--) {
            tempString += str.charAt(i);
        }
        
        if (tempString.equals(str)) {
            return true;
        }
        else {
            return false;
        }
        
    }
    
}
