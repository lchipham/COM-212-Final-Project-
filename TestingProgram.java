import java.util.Scanner;

public class TestingProgram {
    public static void main(String[] args) {
        System.out.println("Welcome to the movies!");
        System.out.println("Choose one from the following options.");
        System.out.println("1. New & Popular");
        System.out.println("2. Top 10 Movies in US today");
        System.out.println("3. All Movies"); //users are able to sort movies from newly released to oldest and vice versa
        System.out.println("4. My Wishlist");
        System.out.println("5. Watch Again"); //Have watched 
        
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter option number (eg. 1): ");
        int optionNum = userInput.nextInt();

        if (optionNum == 1) {
            System.out.println("Newly Released movies:");
        } else if (optionNum == 2) {
            System.out.println("Top 10 Movies in US today:");
        } else if (optionNum == 3) {
            System.out.println("All Movies:");
        } else if (optionNum == 4) {
            System.out.println("My Wishlist:");
        } else {
            System.out.println("Watch Again?:");
        }     
    }
}