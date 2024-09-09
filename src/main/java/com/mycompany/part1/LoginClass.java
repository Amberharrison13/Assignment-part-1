/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.part1;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;    
/**
 *
 * @author RC_Student_lab
 */
public class LoginClass {
    // User data storage
    private final Map<String, User> users = new HashMap<>();

    // Nested class to represent a User
    private static class User {
        String password;
        String firstName;
        String lastName;

        User(String password, String firstName, String lastName) {
            this.password = password;
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

    // Method to check if the username meets the format requirements
    public String checkUserName(String username) {
        if (username != null && username.contains("_") && username.length() <= 5) {
            return "Username successfully captured";
        } else {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
    }

    // Method to check if the password meets complexity requirements
    public String checkPasswordComplexity(String password) {
        if (password != null &&
            password.length() >= 8 &&
            Pattern.compile("[A-Z]").matcher(password).find() &&
            Pattern.compile("[0-9]").matcher(password).find() &&
            Pattern.compile("[^a-zA-Z0-9]").matcher(password).find()) {
            return "Password successfully captured";
        } else {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
        }
    }

    // Method to register a new user
    public String registerUser(String username, String password, String firstName, String lastName) {
        String usernameMessage = checkUserName(username);
        if (!usernameMessage.equals("Username successfully captured")) {
            return usernameMessage;
        }

        String passwordMessage = checkPasswordComplexity(password);
        if (!passwordMessage.equals("Password successfully captured")) {
            return passwordMessage;
        }

        // Store the user if both username and password are valid
        users.put(username, new User(password, firstName, lastName));
        return "User registered successfully.";
    }

    // Method to verify login credentials
    public String loginUser(String username, String password) {
        User user = users.get(username);
        if (user != null && user.password.equals(password)) {
            return String.format("Welcome %s, %s. It is great to see you again.", user.firstName, user.lastName);
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}