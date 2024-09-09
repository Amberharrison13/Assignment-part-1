/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.part1;
import java.util.Scanner;
/**
 *
 * @author RC_Student_lab
 */
public class Part1 {
    

    public static void main(String[] args) {
        String username;
        String password;
        String firstname,lastname;
        
       
        Scanner scanner = new Scanner(System.in);
        
        //instance of a class
        Part1 bvvv = new Part1();
        

        // Input fields
        System.out.print("Enter username: ");
        username = scanner.nextLine();

        System.out.print("Enter password: ");
        password = scanner.nextLine();

        System.out.print("Enter first name: ");
        firstname = scanner.nextLine();

        System.out.print("Enter last name: ");
        lastname = scanner.nextLine();

        // Validate inputs
        String result = bvvv.vaildateAccounts(username, password, firstname, lastname);
        System.out.println(result);

        scanner.close();
    }
    
    public String vaildateAccounts(String username, String password, String firstName, String lastName){
        
        // Check password
        if (password.length() < 8){
            return "Password must be at least 8 characters long.";
       }
        if (!password.matches(".*[A-Z].*")) {
            return "Password must contain at least one uppercase letter.";
       }
        if (!password.matches(".*[a-z].*")) {
            return "Password must contain at least one lowercase letter.";
       }

        if (!password.matches(".*\\d.*")) {
            return "Password must contain at least one number.";
       }

        // Check first name
        if (firstName.length() < 1 || firstName.length() > 30 || !firstName.matches("[a-zA-Z]+")) {
            return "First name must be between 1 and 30 characters long and contain only letters.";
       }

        // Check last name
        if (lastName.length() < 1 || lastName.length() > 30 || !lastName.matches("[a-zA-Z]+")) {
            return "Last name must be between 1 and 30 characters long and contain only letters.";
       }

        return "Account created successfully!";
        
        
       LoginClass loginSystem = new LoginClass();

        // Test user registration
        System.out.println(loginSystem.registerUser("john_d", "Password1!", "John", "Doe")); // Expected: User registered successfully.
        System.out.println(loginSystem.registerUser("john.d", "Password1!", "John", "Doe")); // Expected: Username is not correctly formatted...
        System.out.println(loginSystem.registerUser("john_d", "short", "John", "Doe")); // Expected: Password is not correctly formatted...

        // Test user login
        System.out.println(loginSystem.loginUser("john_d", "Password1!")); // Expected: Welcome John, Doe. It is great to see you again.
        System.out.println(loginSystem.loginUser("john_d", "WrongPassword")); // Expected: Username or password incorrect, please try again.
        System.out.println(loginSystem.loginUser("non_existent_user", "Password1!")); // Expected: Username or password incorrect, please try again.
    }


        
}