/*
Name:           David O'Meara
Student Number: L00162952
Module:         Software Development
Lecturer:       Clare Doherty
Assignment:     Assignment 2
File:           2 of 2
*/

// Test class to test the functionality of the Car class

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class CarTester {

    public static void main(String [] args) {
        //Car(String regNo, String make, String model, int engineSize, int emissions, int year, double value)
        Car car1 = new Car("151-D-12421", "Ferrari", "F355",1320, 200, 2015,90000);
        Car car2 = new Car("181-CE-5231", "Ford", "Fiesta", 180, 85, 2018, 11720);
        Car car3 = new Car("11-C-713824", "Volkswagen", "Golf", 250, 90, 2011, 6980);
        Car car4 = new Car("00-MH-71128", "Opel", "Astra", 200, 0, 2000, 2320);
        Car car5 = new Car("98-TS-53215", "Toyota", "Yaris", 178, 0, 1998, 1420);
        Car car6 = new Car("72-CN-18988", "Volkswagen", "Beetle", 198, 0, 1972, 600);
        Car car7  = new Car("06-MO-15343", "BMW", "3 Series", 250, 0, 2006, 23000);
        Car car8  = new Car("17-CE-966624", "Porsche", "911", 842, 210, 2017, 76000);
        Car car9  = new Car("03-LH-338821", "Mini", "Cooper", 142, 0, 2003, 12000);
        Car car10  = new Car("93-LK-177247", "Ford", "Focus", 342, 0, 1993, 1000);
        Car car11 = new Car("211-WH-60234", "Tesla", "Model S", 200, 60, 2021, 74200);
  

        // I wanted the user to be able to add cars from the menu
        // Researched using an ArrayList here:
        // https://www.w3schools.com/java/java_arraylist.asp
        // https://stackoverflow.com/questions/15213974/add-multiple-items-to-already-initialized-arraylist-in-java
        
        // Create an ArrayList of all the cars initialised above
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.addAll(Arrays.asList(car1, car2, car3, car4, car5,
                                  car6, car7, car8, car9, car10, car11));

        Scanner keyboardIn = new Scanner(System.in);
        int option=0;

        // Prompt the user to select an option from a list of options
        do {
            System.out.println(
                  "\n---- Main Menu ----"
                + "\n\nPlease enter a number from 0-5 to select from one of the following options:\n"
                + "\n[1] Enter reg number to view all car details"
                + "\n[2] Enter reg number to view make, model and price"
                + "\n[3] Calculate road tax"
                + "\n[4] Check NCT renewal date"
                + "\n[5] Calculate loan repayments"
                + "\n[6] Add new car to system"
                + "\n[7] View list of all cars"
                + "\n[0] Exit"
                + "\n\n---- End Menu ----"
            );
            option = keyboardIn.nextInt();
            String carRegEntered;
            Car selectedCar = cars.get(0); // Selected Car is the first by default
            boolean carFound = false;
            String returnToMenu;
            int carNumberEntered;
         
         switch(option)
         {
            
            // Option 1: Enter reg number to view all car details
            case 1:
                System.out.println("\nYou selected: [1] Enter reg number to view all car details\n");
                System.out.println("\nPlease enter the registration number for the requested car:");
                carRegEntered = keyboardIn.next();
                System.out.println("\nYou entered: " + carRegEntered + "\n");
                
                // Find the selected Car in the list of cars
                
                // Iterate through the cars array until the registration number matches the one entered by the user
                for (int i = 0; i < cars.size(); i++) {
                    if (carRegEntered.equals(cars.get(i).getRegNo())){
                        selectedCar = cars.get(i);
                        carFound = true;
                        break;
                    } 
                }

                // Only show the details if the car is in the system
                if (carFound) {
                    System.out.println("This is a valid registration number and the car exists in the system.");
                    System.out.println(selectedCar.getAllDetails());
                } else {
                    System.out.println("No car such car registration exists in the system. Please try again.\n");
                }

                System.out.println("Press any key and enter to return to the main menu");
                returnToMenu = keyboardIn.next();
    
            
                break;

            // Option 2: Enter reg number to view make, model and price
            case 2:
                System.out.println("\nYou selected: [2] Enter reg number to view make, model and price\n");
                System.out.println("\nPlease enter the registration number for the requested car:");
                carRegEntered = keyboardIn.next();
                System.out.println("\nYou entered: " + carRegEntered + "\n");
                
                // Find the selected Car in the list of cars
               
                // Iterate through the cars arraylist until the registration number matches the one entered by the user
                for (int i = 0; i < cars.size(); i++) {
                    if (carRegEntered.equals(cars.get(i).getRegNo())){
                        selectedCar = cars.get(i);
                        carFound = true;
                        break;
                    } 
                }

                // Only show the details if the car is in the system
                if (carFound) {
                    System.out.println("This is a valid registration number and the car exists in the system.");
                    String carMake = selectedCar.getMake();
                    double carValue = selectedCar.getValue();
                    String carModel = selectedCar.getModel();
                    System.out.println(
                       "\n---- Car Make, Model and Price ----\n\n" + carMake + " " + carModel + " "
                       + String.format("%,.2f", carValue) +"\n\n---- End ----\n");
                } else {
                    System.out.println("No car such car registration exists in the system. Please try again.\n");
                }

                System.out.println("Press any key and enter to return to the main menu");
                returnToMenu = keyboardIn.next();
                break;
            
            case 3:
            // Calculate Road Tax

                // First the user is prompted to select a car from a list of cars
                System.out.println("\nYou selected: [3] Calculate Road Tax\n");
                System.out.println("\nPlease select a car number from one of the below options and press enter\n");
                for (int i = 0; i < cars.size(); i++) {
                    // item format: [i] Make Model XX-XX-XXXX
                    System.out.println("[" + (i+1) + "] " + cars.get(i).getMake() + " " + cars.get(i).getModel() + " (" + cars.get(i).getRegNo() + ")");
                };
                carNumberEntered = keyboardIn.nextInt();
                selectedCar = cars.get(carNumberEntered - 1);
                double roadTax = selectedCar.calculateRoadTax();
                System.out.println(
                    "\nYou selected [" + carNumberEntered +"] "+ selectedCar.getMake() + " " + selectedCar.getModel() + " (" + selectedCar.getRegNo() + ")" 
                    +  "\n\n---- Road Tax Details ----\n"
                    + "\nCar Selected:    " + selectedCar.getMake() + " " + selectedCar.getModel()
                    + "\nRoad Tax Amount: " + String.format("%,.2f", roadTax)
                    + "\n\nPlease note:"
                    + "\n-Cars newer than 2008 pay tax based on their C02 emissions"
                    + "\n-Older cars pay tax based on engine size"
                    + "\n\n---- End ----\n" 
                );

                System.out.println("Press any key and enter to return to the main menu");
                returnToMenu = keyboardIn.next();
                break;
            
            // Option 4: Check NCT Renewal Date
            case 4:
                System.out.println("\nYou selected: [4] Check NCT renewal date\n");
                // Please select a car
                // First the user is prompted to select a car from a list of cars
                
                System.out.println("\nPlease select a car number from one of the below options and press enter\n");
                for (int i = 0; i < cars.size(); i++) {
                    // item format: [i] Make Model XX-XX-XXXX
                    System.out.println("[" + (i+1) + "] " + cars.get(i).getMake() + " " + cars.get(i).getModel() + " (" + cars.get(i).getRegNo() + ")");
                };
                carNumberEntered = keyboardIn.nextInt();
                selectedCar = cars.get(carNumberEntered - 1);
                System.out.println(selectedCar.checkNCTDate());

                System.out.println("Press any key and enter to return to the main menu");
                returnToMenu = keyboardIn.next();
                break;
            
            // Option 5 - Calculate Loan Repayments
            case 5:
            
                System.out.println("\nYou selected: [5] Calculate Repayments\n");

                System.out.println("\nPlease select a car number from one of the below options and press enter\n");
                for (int i = 0; i < cars.size(); i++) {
                    // item format: [i] Make Model XX-XX-XXXX
                    System.out.println("[" + (i+1) + "] " + cars.get(i).getMake() + " " + cars.get(i).getModel() + " (" + cars.get(i).getRegNo() + ")");
                };
                carNumberEntered = keyboardIn.nextInt();
                selectedCar = cars.get(carNumberEntered - 1);
                System.out.println("\nYou selected [" + carNumberEntered +"] "+ selectedCar.getMake() + " " + selectedCar.getModel());
                
                        // Prompt the user the enter the term of the loan in months (capped at 60 regardless of what the user enters)
                System.out.println(
                            "\nPlease enter the term of the loan in months:"
                            + "\n(Maximum loan term is 60 months)"
                            );

                int months = keyboardIn.nextInt();

                System.out.println("\nYou entered " + months + " months\n");

                selectedCar.calculateRepayments(months);
            
                System.out.println("\nPress any key and enter to return to the main menu");
                returnToMenu = keyboardIn.next();
                break;

            // Option 6: Add a car to the system
            case 6:
                System.out.println("\nYou selected: [6] Add new car to system\n");
                System.out.println("Please enter the regNo:");
                String regNo = keyboardIn.next();
                System.out.println("Please enter the make:");
                String make = keyboardIn.next();
                System.out.println("Please enter the model:");
                String model = keyboardIn.next();
                System.out.println("Please enter the engine size (cc):");
                int engineSize  =keyboardIn.nextInt();
                
                System.out.println("Please enter the year (max 2021): ");
                int year = keyboardIn.nextInt();
                if (year > 2021 ){
                    System.out.println("The maximum year allowed is 2021, the year has been set to 2021");
                }

                System.out.println("Please enter the emissions (g/km CO2):");
                System.out.println("(Please enter 0 for Cars before 2008)");
                int emissions = keyboardIn.nextInt();
                if (year < 2008) {
                    System.out.println("As the year is before 2008 the emissions will be recorded as 0");
                }
                System.out.println("Please enter the value:");
                double value = keyboardIn.nextDouble();

                Car newCar = new Car(regNo, make, model, engineSize, emissions, year, value);
                cars.add(newCar);
                System.out.println("Thanks, the car has been added to the system");
    	        break;
            // Option 7: View List of Cars
            case 7:
                System.out.println("\nYou selected: [7] View list of all cars\n");
                System.out.println("\n---- List of Cars ----\n");
                for (int i = 0; i < cars.size(); i++) {
                    // item format: [i] Make Model XX-XX-XXXX
                    System.out.println("[" + (i+1) + "] " + cars.get(i).getMake() + " " + cars.get(i).getModel() + " (" + cars.get(i).getRegNo() + ")");
                };
                System.out.println("\n\n---- End ----\n");

                System.out.println("\nPress any key and enter to return to the main menu");
                returnToMenu = keyboardIn.next();
                break;

            case 0:
            System.out.println("Exiting System");
            break;
            
            default:
            System.out.println("Invalid option - Please choose options 0 - 7 only");
         }


        } while (option != 0);
    }
}