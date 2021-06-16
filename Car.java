// Name: David O'Meara
// Student Number: L00162952

import java.time.Year;
import java.lang.Math;
import java.util.Scanner;

public class Car {

    private String regNo;
    private String make;
    private String model;
    private int engineSize;
    private int emissions;
    private int year;
    private double value;

    // Constructor 1
    public Car() {
    }

    // Constructor 2
    public Car(String regNo, String make, String model, int engineSize, int emissions, int year, double value){
        this.regNo = regNo;
        this.make = make;
        this.model = model;
        this.engineSize = engineSize;
        this.emissions = emissions;
        this.year = year;
        this.value = value;
    }
    
    // Get Registration No.
    public String getRegNo() {
        return regNo;
    }

    // Set Registration No.
    public void setRegNo(String newRegNo) {
        this.regNo = newRegNo;
    }

    // Get Make
    public String getMake() {
        return make;
    }

    // Set Make
    public void setMake(String newMake) {
        this.make = newMake;
    }

    // Get Model
    public String getModel() {
        return model;
    }

    // Set Model
    public void setModel(String newModel) {
        this.model = newModel;
    }

    // Get Engine Size (cc)
    public int getEngineSize() {
        return engineSize;
    }

    // Set Engine Size (cc)
    public void setEngineSize(int newEngineSize) {
        this.engineSize = newEngineSize;
    }

    // Get Emissions (g/km CO2)
    public int getEmissions() {
        return emissions;
    }

    // Set Emissions (g/km CO2)
    public void setEmissions(int newEmissions) {
        this.emissions = newEmissions;
    }

    // Get Year
    public int getYear() {
        return year;
    }

    // Set Year
    public void setYear(int newYear) {
        this.year = newYear;
    }

    // Get Value (€)
    public double getValue() {
        return value;
    }

    // Set Value (€)
    public void setValue(double newValue) {
        this.value = newValue;
    }
    
    // Calculate Road Tax
    public double calculateRoadTax() {
        double roadTax;
        // https://stackoverflow.com/questions/136419/get-integer-value-of-the-current-year-in-java/6761567     
        int currentYear = Year.now().getValue();
   
        // Cars after 2008 are taxed based on emissions (g/km)
        if (year >= 2008) {
            if (emissions == 0) {
                roadTax = 120;
            } else if (emissions <= 80) {
                roadTax = 170;
            } else if (emissions <= 120) {
                roadTax = 180;
            } else if (emissions <= 140) {
                roadTax = 270;
            } else if (emissions <= 170) {
                roadTax = 400;
            } else if (emissions <= 225) {
                roadTax = 790;
            } else {
                roadTax = 1250;
            }

        // Cars pre-2008 but less than 30 years old are taxed based on engine size 
        } else if (year >= (currentYear - 30)) {
            if (engineSize <= 1000) {
                roadTax = 200;
            } else if (engineSize <= 1400) {
                roadTax = 350;
            } else if (engineSize <= 1700) {
                roadTax = 500;
            } else if (engineSize <= 2000) {
                roadTax = 650;
            } else {
                roadTax = 1000;
            }

        // Cars that are more than 30 years old pay tax of 26
        } else {
            roadTax = 26;
        }
    
        return roadTax;
    }

    // Check NCT Date
    public String checkNCTDate() {
        String NCTDueDate;
        int currentYear = Year.now().getValue();
        int carAge = currentYear - year;
        String NCTFrequency;

        // Cars have their first NCT test when they are 4 years old
        if (carAge < 4) {
            NCTDueDate = Integer.toString(year + 4);
            NCTFrequency = "when the car is 4 years old in " + NCTDueDate + " and every 2 years thereafter";

        // Cars that are 11-29 (inclusive) years old have an annual NCT test
        } else if (carAge > 10 && carAge < 30) {
            NCTDueDate = "this year";
            NCTFrequency = "annually";
        } else {
            // Cars > 30 years old have an NCT test every 2 years - odd or even years depending on when it was bought new
            NCTFrequency = "every 2 years";
            if (carAge % 2 == 0) {
                NCTDueDate = "this year";
            } else {
                NCTDueDate = Integer.toString(currentYear + 1);
            }
        }

        return (
            "\n---- NCT Details ----"
            + "\n\nYear of car: " + year
            + "\nNCT Due Date: " + NCTDueDate
            + "\n\nYour NCT test is to be done " + NCTFrequency
            + "\n\n---- End NCT Details ----"
        );
    }

    // Calcuate Repayments - supposed to return a double
    public double calculateRepayments() {
         /* 
        Assumptions:
        - The rate is 4% per annum and fixed for the term of the loan.
        - I assumed no downpayment/deposit on the value of the car
        
        I took a lot of inspiration from repayments formulas here: https://javatutoring.com/emi-java-program/.
        (I did not copy/paste the code and I made my own changes)
        I verified my formula was correct with the calculator here: https://www.investopedia.com/personal-loan-calculator-5082130.
        */

        // Prompt the user the enter the term of the loan in months (capped at 60 regardless of what the user enters)
        System.out.println(
                            "\nPlease enter the term of the loan in months:"
                            + "\n(Maximum loan term is 60 months)"
                            );
        Scanner keyboardIn = new Scanner(System.in);
        int months = keyboardIn.nextInt();
        System.out.println("\nYou entered " + months + " months\n");

        // The term of the loan is capped at 60 months
        if (months > 60) {
            System.out.println(
                "The maximum term allowed is 60 months"
                + "\nPlease note that your repayments have been calculated on the basis of 60 months\n"
            );
            months = 60;
        }

        // Interest rate for each period:
        double annualRate = 0.04;
        double monthlyRate = annualRate / 12;


        /* 
        Formula to calculate monthly payment:
        Source: https://javatutoring.com/emi-java-program/ and verified here https://www.investopedia.com/personal-loan-calculator-5082130.
        (P X R X (1+R)^N/ ((1+R)^N - 1)
        P = principal
        R = period interest rate
        N = periods
        */
        double monthlyPayment = (value*monthlyRate*Math.pow(1+monthlyRate,months))/(Math.pow(1+monthlyRate,months)-1);

        System.out.println(
                            "---- Monthly Repayment Details ----\n"
                            + "\nCar value: \u20AC" + String.format("%,.2f",value)
                            + "\nLoan Term: " + months + " months"
                            + "\nInterest Rate: " + (annualRate*100) + "% per annum"
                            + "\nMonthly Payment: \u20AC" + String.format("%,.2f", monthlyPayment)+"\n"
                            + "\n(This calculation assumes no downpayment was made and the value of the loan was \u20AC" + String.format("%,.2f",value) + ")"
                            + "\n\n---- End Monthly Repayment Details ----"
                            );

        return monthlyPayment; 
    }

    // return all details
    public String getAllDetails() {
        return (
              "\n---- Car Details ----"
            + "\n\nReg No.:       " + regNo
            + "\nMake:          " + make
            + "\nModel:         " + model
            + "\nEngine Size:   " + engineSize + "cc"
            + "\nEmissions:     " + emissions + "g/km CO2"
            + "\nYear:          " + year
            + "\nValue:         \u20ac" + value
            +"\n\n---- End Car Details ----\n"
        );
    }

    public String toString() {
      return year + " " + make + " " + model ;
   }

    public static void main(String[] args) {
        

    }
}