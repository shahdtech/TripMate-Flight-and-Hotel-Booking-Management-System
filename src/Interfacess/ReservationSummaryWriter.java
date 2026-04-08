/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfacess;


import java.io.*;
/**
 *
 * @author Admin
 */
public class ReservationSummaryWriter implements Runnable{
    
    private final String ticketFile = "Flight ticket.txt";
    private final String hotelFile = "Reserve hotel.txt";
    private final String outputFile = "reservation_summary.txt";
    private final double flightPrice;
    private final double hotelPrice;

    // Constructor to accept prices
    public ReservationSummaryWriter(double flightPrice, double hotelPrice) {
        this.flightPrice = flightPrice;
        this.hotelPrice = hotelPrice;
    }
    
    
    

    @Override
    public void run() {
        try {
            // Extract data from files
            String flightDetails = extractFlightDetails(ticketFile);
            String hotelDetails = extractHotelDetails(hotelFile);
            double totalPrice = calculateTotalPrice();

            // Write data to output file
            try (FileWriter writer = new FileWriter(outputFile)) {
                writer.write("Reservation Summary:\n");
                writer.write(flightDetails);
                writer.write(hotelDetails);
                writer.write(String.format("Total Price: %.2f SAR\n", totalPrice));
                writer.flush();
                System.out.println("Reservation summary written to file.");
            }
        } catch (IOException e) {
            System.err.println("Error handling files: " + e.getMessage());
        }
    }
    
     private String extractFlightDetails(String filePath) throws IOException {
    StringBuilder details = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains("Flight Number")) {
                details.append(line.trim()).append("\n");
            } else if (line.contains("FROM")) {
                details.append(line.trim()).append("\n");
            } else if (line.contains("Start Time")) {
                details.append(line.trim()).append("\n");
            } else if (line.contains("End Time")) {
                details.append(line.trim()).append("\n");
            }
           
        }
    }

    // Return flight details excluding price and class
    return details.toString();
}
    private String extractHotelDetails(String filePath) throws IOException {
    StringBuilder details = new StringBuilder();

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            // Extract hotel name
            if (line.contains("Hotel :")) {
                String[] parts = line.split("Hotel :");
                if (parts.length > 1) {
                    details.append("Hotel: ").append(parts[1].trim()).append("\n");
                }
            }
            
        }
    }

    // Check if no details were extracted
    if (details.length() == 0) {
        details.append("No hotel details found.\n"); // Fallback if no data is present
    }

    return details.toString();
}

   private double calculateTotalPrice() {
        return flightPrice + hotelPrice; // Calculate total price
    }
}