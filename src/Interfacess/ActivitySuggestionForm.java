/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfacess;

import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ActivitySuggestionForm implements Runnable{
     private String city;
     String filePath = "Flight ticket.txt";
     
     
   
    @Override
    public void run() {
        String activities = getCityActivities(extractCityFromFile(filePath));

        // Create and display a simple form with the activity suggestions
        JOptionPane.showMessageDialog(null, "Your Hotel Reservation Was Made Successfully\n Here some activity for you to have FUN !\n"+activities, "Activity Suggestions for " + extractCityFromFile(filePath), JOptionPane.INFORMATION_MESSAGE);
      
        
      
    }
    
    //extracting city from eticket file
     public static String extractCityFromFile(String filePath) {
        String city = "";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("TO :")) {
                    city = line.split("TO :")[1].trim().split("\\|\\|")[0].trim();
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return city;
    }
    //
    private String getCityActivities(String city) {
        switch (city) {
            case "Jeddah":
                return "1. Visit Al-Balad\n2. Red Sea Mall\n3. Corniche";
            case "Riyadh":
                return "1. Al-Masmak Fortress\n2. Kingdom Tower\n3. Edge of the World";
            case "Rome":
                return "1. Colosseum\n2. Vatican Museums\n3. Trevi Fountain";
            case "Paris":
                return "1. Eiffel Tower\n2. Louvre Museum\n3. Notre Dame";
            case "Dubai":
                return "1. Burj Khalifa\n2. Dubai Mall\n3. Palm Jumeirah";
            case "Doha":
                return "1. Souq Waqif\n2. Museum of Islamic Art\n3. Katara Village";
            case "Madrid":
                return "1. Prado Museum\n2. Royal Palace\n3. Retiro Park";
            default:
                return "Explore the city and discover its hidden gems!";
        }
    }
    
}