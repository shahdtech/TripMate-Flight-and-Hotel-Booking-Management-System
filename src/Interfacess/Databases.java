package Interfacess;

import java.sql.*;

/**
 *
 * @author Queen Shosho
 */
public class Databases {

    private static Connection con;

    public static void main(String[] args) throws SQLException {

        try {
            //CREAT DATABASE 
            String ConnectionURL = "jdbc:mysql://localhost:3306";
            con = DriverManager.getConnection(ConnectionURL, "root", "Sh@123456");
            Statement st = con.createStatement();

            String nameDB = "TripMate";
            st.executeUpdate("CREATE DATABASE IF NOT EXISTS " + nameDB);
            System.out.println("Database created successfully!");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nameDB, "root", "Sh@123456");

            //METHOOD OF EACH QUERY
            setupFlightTable();
            setupHotelTable();

            //CLOSE
            con.close();
        } catch (SQLException s) {
            System.out.println("SQL statement is not executed!");
            s.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void setupFlightTable() throws SQLException {
        Statement st = con.createStatement();
        // CREATE A TABLE "Flight"
        String creatTableFlight = "CREATE TABLE IF NOT EXISTS Flight( "
                + "FlightID INT NOT NULL , "
                + "Source VARCHAR(255), "
                + "Destination VARCHAR(255), "
                + "`From` VARCHAR(255), "
                + "`To` VARCHAR(255), "
                + "Price DOUBLE NOT NULL, "
                + "PRIMARY KEY (FlightID))";
        st.executeUpdate(creatTableFlight);

        // ADD RECORDS OF FLIGHT
        String insertDataFlight = "INSERT INTO Flight("
                + "FlightID , Source, Destination , `From`, `To` ,Price) VALUES "
                + "(8202, 'Jeddah', 'Riyadh','13:00','14:45',800.00), "
                + "(8203, 'Riyadh', 'Dubai','20:15','23:30',1300.50), "
                + "(8204, 'Doha', 'Madrid','07:00','12:45',2200.75), "
                + "(8205, 'Doha', 'Paris','13:00','19:00',2700.00), "
                + "(8206, 'Jeddah', 'Doha','00:00','03:10',1300.00), "
                + "(8207, 'Jeddah', 'Doha','14:00','17:10',1400.00), "
                + "(8208, 'Riyadh', 'Doha','08:30','09:50',1100.00), "
                + "(8209, 'Doha', 'Riyadh','15:15','16:35',1150.00), "
                + "(8210, 'Riyadh', 'Jeddah','19:00','20:15',900.00), "
                + "(8211, 'Dubai', 'Riyadh','22:00','01:00',1500.00), "
                + "(8212, 'Dubai', 'Doha','10:00','11:30',1250.00), "
                + "(8213, 'Paris', 'Madrid','10:00','12:30',1500.00), "
                + "(8214, 'Madrid', 'Paris','14:00','16:30',1450.00),"
                + "(8215, 'Jeddah', 'Riyadh','16:00','17:45',800.00), "
                + "(8216, 'Doha', 'Rome','08:00','01:45',2200.75), "
                + "(8217, 'Rome', 'Paris','07:00','08:45',900.00), "
                + "(8218, 'Rome', 'Paris','09:00','10:45',900.00), "
                + "(8219, 'Doha', 'Paris','01:00','07:45',2700.00)";
        st.executeUpdate(insertDataFlight);
    }

    private static void setupHotelTable() throws SQLException {
        Statement st = con.createStatement();

// CREATE A TABLE "HOTEL"
        String creatTableHOTEL = "CREATE TABLE IF NOT EXISTS Hotel( "
                + "HotelID INT NOT NULL , "
                + "HotelName VARCHAR(255), "
                + "Location VARCHAR(255), "
                + "City VARCHAR(255), "
                + "Rating INT CHECK (Rating BETWEEN 1 AND 5), "
                + "Price DOUBLE NOT NULL, "
                + "PRIMARY KEY (HotelID))";
        st.executeUpdate(creatTableHOTEL);


        // ADD RECORDS OF HOTEL
        String insertDataHOTEL = "INSERT INTO Hotel(HotelID, HotelName, Location,City ,Rating, Price) VALUES "
                + "(1001, 'SHANGRI LA Jeddah', 'Alshaati','Jeddah',5, 1800.50), "
                + "(1002, 'Ewaa Express Riyadh', 'Al OLAYA','Riyadh',3, 670.00), "
                + "(1003, 'Hotel Boulevard Dubai', 'City Center','Dubai',4, 1500.75), "
                + "(1004, 'Four Seasons Madrid', 'City Center','Madrid',5, 3400.25), "
                + "(1005, 'Paris Marriott Champs', 'Champs Elysees','Paris',5, 3500.00), "
                + "(1006, 'Premier Inn Doha', 'Education City','Doha',3, 400.00),"
                + "(1007, 'Donatello hotel', 'Alrayyan','Jeddah',3, 450.50), "
                + "(1008, 'Myrtle hotel', 'Alsahafuh','Riyadh' ,4, 600.00), "
                + "(1009, 'Burj Alarab jumeirah hotel', 'Jumeirah','Dubai',5, 1400.00), "
                + "(1010, 'Palazzo montemartini Rome', 'City Center','Rome',5, 1280.25) ";
        st.executeUpdate(insertDataHOTEL);
    }

}
