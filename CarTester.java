import java.util.Scanner;

public class CarTester {

    // function to select car by registration

    // function to see all cars

    public static void main(String [] args) {
        // public Car(String regNo, String make, String model, int engineSize, int emissions, int year, double value)
        Car car1 = new Car("151-D-12421", "Ferrari", "F355",1320, 200, 2015,90000);
        Car car2 = new Car("181-CE-5231", "Ford", "Fiesta", 180, 85, 2018, 11720);
        Car car3 = new Car("11-C-713824", "Volkswagen", "Golf", 250, 90, 2011, 6980);
        Car car4 = new Car("00-MH-71128", "Opel", "Astra", 200, 240, 2000, 2320);
        Car car5 = new Car("98-TS-53215", "Toyota", "Yaris", 178, 120, 1998, 1420);
        Car car6 = new Car("72-CN-18988", "Volkswagen", "Beetle", 198, 125, 1972, 600);
        Car car7  = new Car("211-WW-914141", "Tesla", "Model 3", 442, 80, 2021, 70000 );

        Car[] cars = {car1, car2, car3, car4, car5, car6, car7};

        Scanner keyboardIn = new Scanner(System.in);

        int option=0;
        do {
            System.out.println(

                  "\n---- Main Menu ----"
                + "\n\nPlease enter a number from 0-5 to select from one of the following options:\n"
                + "\n[1] Enter reg number to view all car details"
                + "\n[2] Enter reg number to view make, model and price"
                + "\n[3] Calculate road tax"
                + "\n[4] Check NCT renewal date"
                + "\n[5] Calculate loan repayments"
                + "\n[0] Exit"
                + "\n\n---- End Menu ----"
            );
                    option = keyboardIn.nextInt();
         
         switch(option)
         {
            // Option 1: Enter reg number to view all car details
            case 1:
            System.out.println("Please enter the registration number for the requested car:");
            String carReg = keyboardIn.next();
            System.out.println("\nYou entered: " + carReg + "\n");
            
            // Find the selected Car in the list of cars
            Car selectedCar = new Car();
            boolean carFound = false;
            // Iterate through the cars array until the registration number matches the one entered by the user
            for (int i = 0; i < cars.length; i++) {
                if (carReg.equals(cars[i].getRegNo())){
                    selectedCar = cars[i];
                    carFound = true;
                    break;
                } 
            }

            if (carFound) {
                System.out.println("This is a valid registration number and the car exists in the system.");
                System.out.println(selectedCar.getAllDetails());
            } else {
                System.out.println("No car such car registration exists in the system. Please try again.\n");
            }

            System.out.println("Press any key and enter to return to the main menu");
            String returnToMenu = keyboardIn.next();keyboardIn.nextLine();
            System.out.flush();
  
          
            break;
            
            case 2:
            System.out.println(car1.getMake());
            break;
            
            case 3:
            // Please select a car
            System.out.println(car1.calculateRoadTax());
            break;
            
            case 4:
            // Please select a car
            System.out.println(car1.checkNCTDate());
            break;
            
            case 5:
            // Please select a car
            System.out.println(car1.calculateRepayments());
            break;
            
            case 0:
            System.out.println("Exiting System");
            break;
            
            default:
            System.out.println("Invalid option - Please choose options 1 - 5 only");
         }


        } while (option != 0);
    }
}