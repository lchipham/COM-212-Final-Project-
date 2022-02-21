/* FINAL PROJECT - CHI, EUGENIE, MADISON - DEC 20, 2021
   This Main class should be run only after CreateSerialization has been run.
   Main.java includes a Main Log-in Menu (Customer/Admin/Quit), 1 menu for admin and 1 menu for customer. 
*/

import java.util.Scanner;
import java.io.*;
public class Main implements java.io.Serializable{
    public static AllMovies listOfMovies ; 
    public static AllCustomers listOfCustomers ;
    public static SearchMovie hashMovies ;
    public static SortReleaseDate bstMovies;

	public static void main(String[] args) {
        System.out.println("\n================================");
        /* Deserialization of objects prior to the execution of entire program */
        // Deserialize allMovies
        try
        {   
            // Reading the object from a file
            FileInputStream file = new FileInputStream("allMovies.ser");
            ObjectInputStream in = new ObjectInputStream(file);
            // Method for deserialization of object
            listOfMovies = (AllMovies)in.readObject();
            in.close();
            file.close();
        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }

        // Deserialize searchMovie
        try
        {   
            FileInputStream file = new FileInputStream("searchMovie.ser");
            ObjectInputStream in = new ObjectInputStream(file);
            hashMovies = (SearchMovie)in.readObject();
            in.close();
            file.close();
        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }

        // Deserialize sortReleaseDate
        try
        {   
            FileInputStream file = new FileInputStream("sortReleaseDate.ser");
            ObjectInputStream in = new ObjectInputStream(file);
            bstMovies = (SortReleaseDate)in.readObject();
            in.close();
            file.close();
        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }

        // Deserialize allCustomers
        try
        {   
            FileInputStream file = new FileInputStream("allCustomers.ser");
            ObjectInputStream in = new ObjectInputStream(file);
            listOfCustomers = (AllCustomers)in.readObject();
            in.close();
            file.close();
        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
// ===========================================================================================================
        /* Execution of main menu starts here */
        Main.mMenu();
    }

    /* This is the main Log-In Menu with 3 options: Customer / Admin / Quit */
    public static void mMenu() {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\nWelcome to our program!");
            System.out.println("1. Customer");
            System.out.println("2. Administrator");
            System.out.println("3. Quit");
            try {
                System.out.println("\nEnter option number: ");
                choice = Integer.parseInt(sc.nextLine());
            }
            // catch if input is not an int
            catch(NumberFormatException e) {
            }
            // Customer menu starts here
            if (choice == 1) {
                try {
                    System.out.println("\nEnter your credit card number (last 4 digits): ");
                    int userCredit = Integer.parseInt(sc.nextLine());
                    // if the credit card number already exists in the system (CreateSerialization.java), 
                    // welcome back the existing customer and log them in
                    if (listOfCustomers.searchByCredit(userCredit) != null) {
                        System.out.println("\n\n*** Welcome back, " + listOfCustomers.searchByCredit(userCredit).getCustomerName() + "! ***");
                        Main.cMenu(userCredit);
                    // else, new customers can register with their name and emai (credit num already saved from userCredit input)
                    } else {
                        System.out.println("\n\n*** Welcome New Customer! ***");
                        System.out.println("Please register by typing your info below.");
                        System.out.println("Name: ");
                        String cusName = sc.nextLine();
                        System.out.println("Email: ");
                        String userEmail = sc.nextLine();
                        Customer newCus = new Customer(cusName, userCredit, userEmail);
                        listOfCustomers.insert(newCus);
                        // Serialize allMovies
                        try {   
                            //Saving of object in a file
                            FileOutputStream file = new FileOutputStream("allMovies.ser");
                            ObjectOutputStream out = new ObjectOutputStream(file);
                            // Method for serialization of object
                            out.writeObject(listOfMovies);
                            out.close();
                            file.close();
                        }  
                        catch(IOException ex) {
                            System.out.println("IOException is caught");
                        }

                        // Serializate searchMovie
                        try {   
                            FileOutputStream file = new FileOutputStream("searchMovie.ser");
                            ObjectOutputStream out = new ObjectOutputStream(file); 
                            out.writeObject(hashMovies);                              
                            out.close();
                            file.close();
                        }                          
                        catch(IOException ex) {
                            System.out.println("IOException is caught");
                        }

                        // Serialize sortReleaseDate
                        try {   
                            FileOutputStream file = new FileOutputStream("sortReleaseDate.ser");
                            ObjectOutputStream out = new ObjectOutputStream(file); 
                            out.writeObject(bstMovies);                                
                            out.close();
                            file.close();
                        }                            
                        catch(IOException ex) {
                            System.out.println("IOException is caught");
                        }

                        // Serialize allCustomers
                        try {   
                            FileOutputStream file = new FileOutputStream("allCustomers.ser");
                            ObjectOutputStream out = new ObjectOutputStream(file); 
                            out.writeObject(listOfCustomers);                                
                            out.close();
                            file.close();
                        }                           
                        catch(IOException ex) {
                            System.out.println("IOException is caught");
                        }
                        System.out.println("\nThank you for signing up! Please choose from the options below (1-6): ");
                        Main.cMenu(userCredit);
                    }
                } catch(NumberFormatException e) {
                    System.out.println("\n-> Wrong format. Try again.");
                    Main.mMenu();
                }

            // Admin menu starts here    
            } else if (choice == 2) {
                System.out.println("\nEnter admin email: ");
                String adminEmail= sc.nextLine();
                // one admin account, log in if credentials match
                if (adminEmail.equals("admin@movies.com")) {
                    System.out.println("\nEnter admin password: ");
                    String adminPassword = sc.nextLine();
                        if (adminPassword.equals("212admin")) {
                            System.out.println("\n\n*** Welcome Admin! ***");
                            Main.aMenu();
                        } else {
                            System.out.println("\n-> Invalid credentials. Try again.");
                            Main.mMenu();
                        }
                } else {
                    System.out.println("\n-> Invalid credentials. Try again.");
                    Main.mMenu();
                }

            // if input is none of the 3 options provided, print error
            } else if (choice != 3) {
                System.out.println("\n-> Error, not an option, pick again (1-3)");
                Main.mMenu();
            
            // else, quit and serialize all objects
            } else {
                System.out.println("\n*** Thank you for using our program! ***");
                System.out.println();
                // Serialize allMovies
                try {   
                    FileOutputStream file = new FileOutputStream("allMovies.ser");
                    ObjectOutputStream out = new ObjectOutputStream(file);
                    out.writeObject(listOfMovies);                       
                    out.close();
                    file.close();
                }                  
                catch(IOException ex) {
                    System.out.println("IOException is caught");
                }
                // Serialize searchMovie
                try {   
                    FileOutputStream file = new FileOutputStream("searchMovie.ser");
                    ObjectOutputStream out = new ObjectOutputStream(file);  
                    out.writeObject(hashMovies);                        
                    out.close();
                    file.close();
                }                    
                catch(IOException ex) {
                    System.out.println("IOException is caught");
                }
                // Serialize sortReleaseDate
                try {   
                    FileOutputStream file = new FileOutputStream("sortReleaseDate.ser");
                    ObjectOutputStream out = new ObjectOutputStream(file);   
                    out.writeObject(bstMovies);                       
                    out.close();
                    file.close();
                }                   
                catch(IOException ex) {
                    System.out.println("IOException is caught");
                }
                // Serialize allCustomers
                try {   
                    FileOutputStream file = new FileOutputStream("allCustomers.ser");
                    ObjectOutputStream out = new ObjectOutputStream(file);    
                    out.writeObject(listOfCustomers);                       
                    out.close();
                    file.close();
                }                 
                catch(IOException ex) {
                    System.out.println("IOException is caught");
                }
            }
            break;
        } while (choice != 3);
    }

    /* This is the Customer Menu with 6 options */
    public static void cMenu(int userCredit) {
        int optionNum = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n\nCUSTOMER MENU");
            System.out.println("1. View All Movies"); // print all movies from AllMovie heap
            System.out.println("2. Find Movie"); // lookup movie in SearchMovie hash
            System.out.println("3. Watch Next"); // print wishlist from Queue Array Wishlist, fifo
            System.out.println("4. Have Watched"); // print havewatched, which can be added from wishlist, from Queue Array WatchedMovies
            System.out.println("5. Change Personal Info"); // update customer name or email in ser files
            System.out.println("6. Log Out"); //return to Main Menu

            //error checking of user's option input format
            try {
                System.out.println("\nEnter option number: ");
                optionNum = Integer.parseInt(sc.nextLine());
            }
            catch(NumberFormatException e) {
            }

            if (optionNum == 1) {
                System.out.println("\n*** All Movies ***");
                System.out.println("Would you like to sort all movies by release date? (Yes/No)");
                String userInput2 = sc.nextLine();
                if (userInput2.equals("Yes")) {
                    System.out.println("\nPlease choose a sorting option");
                    System.out.println("a. Newest -> Oldest");
                    System.out.println("b. Oldest -> Newest");
                    String userSort = sc.nextLine();
                    if (userSort.equals("a")) {
                        System.out.println("-> Newest movies: ");
                        bstMovies.traversee();
                    } else if (userSort.equals("b")) {
                        System.out.println("-> Oldest movies: ");
                        bstMovies.traverse();
                    }
                } else if (userInput2.equals("No")) {
                    System.out.println("\n-> Unordered movie list: ");
                    listOfMovies.printAllMovies();
                } else {
                    System.out.println("\n-> Wrong input. Try again.");
                }

            // search movie by ID, if the movie is available, the customer can add it to their wishlist (if they'd like to)
            } else if (optionNum == 2) {
                    try {
                        System.out.println("\n*** Find movie by ID ***");
                        System.out.println("Enter your movie ID: ");
                        int user_movieID = Integer.parseInt(sc.nextLine());
                        Movie result = hashMovies.lookup(user_movieID);
                        if (result != null) {
                            if (result.checkStatus() == true) {
                                System.out.println("Status: Available");
                                System.out.println("\nWould you like to add " + result.getTitle() + " to your wishlist? (Yes/No)");
                                String userInput1 = sc.nextLine();
                                if (userInput1.equals("Yes")) {
                                    listOfCustomers.searchByCredit(userCredit).getWishList().addMovie(result);
                                    System.out.println("\n-> Here's your current wishlist: ");
                                    listOfCustomers.searchByCredit(userCredit).getWishList().displayWishList(); //movie found is added to wishlist
                                } else if (userInput1.equals("No")) {
                                    System.out.println();
                                } else {
                                    System.out.println("\n-> Wrong input. Try again.");
                                }
                            } else if (result.checkStatus() == false) {
                                System.out.println("Status: Unvailable");
                                System.out.println("\n-> Sorry, this movie is not available to watch.");
                            }
                        }
                    } catch(NumberFormatException e) {
                        System.out.println("\n-> Wrong format. Try again.");
                    } 
            
            // first return the next movie in WishList, then ask if the customer have watched the movie, 
            // if yes, it will be removed from wishlist and added to havewatched list
            } else if (optionNum == 3) {
                System.out.println("\n*** Watch Next ***");
                if (listOfCustomers.searchByCredit(userCredit).getWishList().firstMovie() != null) {
                    Movie x = listOfCustomers.searchByCredit(userCredit).getWishList().firstMovie();
                    if (x.checkStatus() == true) {
                        System.out.println("Next movie to watch: " + x.getTitle());
                        System.out.println("-> This movie is available");
                        System.out.println("\nDid you watch " + x.getTitle() + "? (Yes/No)");
                        String userWishlist = sc.nextLine();
                        if (userWishlist.equals("Yes")) {
                            System.out.println("-> " + x.getTitle() + " has been deleted from your wishlist");
                            listOfCustomers.searchByCredit(userCredit).getWatched().addMovie(x);
                            x = x.getNext();
                            listOfCustomers.searchByCredit(userCredit).getWishList().deleteMovie();
                        } else if (userWishlist.equals("No")) {
                            System.out.println("-> " + x.getTitle() + " is kept in your wishlist");
                        } else {
                            System.out.println("\n-> Wrong input. Try again.");
                        }
                    } else if (x.checkStatus() == false) {
                        System.out.println("* Next movie: " +  x.getTitle() + ".");
                        System.out.println("Sorry, movie not available to watch.");
                        System.out.println("-> " + x.getTitle() + " is deleted from wishlist.");
                        listOfCustomers.searchByCredit(userCredit).getWishList().deleteMovie();
                    }
                } else {
                    System.out.println("-> There's currently no movie to watch next. Please add movie(s) to your wishlist first.");
                }
        
            // print movies the customer has watched, which can only be added from wishlist
            } else if (optionNum == 4) {
                System.out.println("\n*** Have Watched ***");
                System.out.println("Movies you have watched: ");
                listOfCustomers.searchByCredit(userCredit).getWatched().displayWatchedMovies();

            // customers can change either or both of their personal info (name/email)
            } else if (optionNum == 5) {
                System.out.println("\n*** Enter your updated info below ***");
                System.out.println("Name: ");
                String newName = sc.nextLine();
                System.out.println("Email: ");
                String newEmail = sc.nextLine();
                listOfCustomers.searchByCredit(userCredit).setCustomerName(newName);
                listOfCustomers.searchByCredit(userCredit).setCustomerEmail(newEmail);

                // Serialization of objects to save customer's updated info abvove
                // Serialize allMovies
                try {   
                    FileOutputStream file = new FileOutputStream("allMovies.ser");
                    ObjectOutputStream out = new ObjectOutputStream(file);   
                    out.writeObject(listOfMovies);                       
                    out.close();
                    file.close();
                }                 
                catch(IOException ex) {
                    System.out.println("IOException is caught");
                }

                // Serialize searchMovie 
                try {   
                    FileOutputStream file = new FileOutputStream("searchMovie.ser");
                    ObjectOutputStream out = new ObjectOutputStream(file);
                    out.writeObject(hashMovies);                       
                    out.close();
                    file.close();
                }                   
                catch(IOException ex) {
                    System.out.println("IOException is caught");
                }

                // Serialize sortReleaseDate
                try {   
                    FileOutputStream file = new FileOutputStream("sortReleaseDate.ser");
                    ObjectOutputStream out = new ObjectOutputStream(file);  
                    out.writeObject(bstMovies);                       
                    out.close();
                    file.close();
                }                   
                catch(IOException ex) {
                    System.out.println("IOException is caught");
                }

                // Serialize allCustomers
                try {   
                    FileOutputStream file = new FileOutputStream("allCustomers.ser");
                    ObjectOutputStream out = new ObjectOutputStream(file);   
                    out.writeObject(listOfCustomers);                       
                    out.close();
                    file.close();
                }                    
                catch(IOException ex) {
                    System.out.println("IOException is caught");
                }
 
            } else if (optionNum != 6) {
                System.out.println("\n-> Error, not an option, pick again(1-3)");
            }

        } while (optionNum != 6);
        System.out.println("\n\n*** You have logged out successfully ***\n\n");
        Main.mMenu();
        
    } 

    /* This is the Admin Menu with 7 options */

    // Deserialization of objects to update customer's changed info
    public static void aMenu() {
        // Deserialize allMovies
        try
        {   
            FileInputStream file = new FileInputStream("allMovies.ser");
            ObjectInputStream in = new ObjectInputStream(file);  
            listOfMovies = (AllMovies)in.readObject();           
            in.close();
            file.close();
        }       
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }       
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }

        // Deserialize searchMovie
        try
        {  
            FileInputStream file = new FileInputStream("searchMovie.ser");
            ObjectInputStream in = new ObjectInputStream(file);   
            hashMovies = (SearchMovie)in.readObject();          
            in.close();
            file.close();
        }       
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }       
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }

        // Deserialize sortReleaseDate
        try
        {   
            FileInputStream file = new FileInputStream("sortReleaseDate.ser");
            ObjectInputStream in = new ObjectInputStream(file);  
            bstMovies = (SortReleaseDate)in.readObject();           
            in.close();
            file.close();
        }       
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }        
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }

        // Deserialize allCustomers
        try
        {   
            FileInputStream file = new FileInputStream("allCustomers.ser");
            ObjectInputStream in = new ObjectInputStream(file);       
            listOfCustomers = (AllCustomers)in.readObject();            
            in.close();
            file.close();
        }       
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }       
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }

        int adChoice = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n\nADMINISTRATOR MENU");
            System.out.println("1. View All Existing Customers"); 
            System.out.println("2. Find Customer"); 
            System.out.println("3. View All Movies"); 
            System.out.println("4. Add New Movie");
            System.out.println("5. Find and Set Least Rated Movie to Unavailable"); 
            System.out.println("6. Find and Delete Movie"); 
            System.out.println("7. Log Out");

            // error checking of user's option input format
            try {
                System.out.println("\nEnter option number: ");
                adChoice = Integer.parseInt(sc.nextLine());
            } catch(NumberFormatException e) {
            }

            // print all customer info from AllCustomers hash
            if (adChoice == 1) {
                System.out.println("\n*** All Customers ***");
                listOfCustomers.printCustomerList();

            // find a customer based on the last 4 digits of their credit card number
            } else if (adChoice == 2) {
                try {
                    System.out.println("\n*** Find a Customer ***");
                    System.out.println("Enter customer credit card number (last 4 digits): ");
                    int cust_ID = Integer.parseInt(sc.nextLine());
                    Customer result = listOfCustomers.searchByCredit(cust_ID);
                    if (result != null) {
                        System.out.println("\n-> Customer found");
                        System.out.println("Name: " + result.getCustomerName());
                        System.out.println("Email: " + result.getCustomerEmail());
                        System.out.println("Credit Card Number (last 4 digits): " + result.getCreditNum());
                    } else {
                        System.out.println("-> Customer not found");
                    }
                } catch(NumberFormatException e) {
                    System.out.println("\nWrong format. Try again.");    
                }

            // print all movies from AllMovies heap
            } else if (adChoice == 3) {
                System.out.println("\n*** All Movies ***");
                listOfMovies.printAllMovies();

            // add a new movie, check if it's already in the database, if not, ask for movie info
            // admin also has the choice to view the updated movie list right after adding a new one
            } else if (adChoice == 4) {
                try {
                    System.out.println("\nEnter ID of new movie: ");
                    int newID = Integer.parseInt(sc.nextLine());
                    if (hashMovies.lookup(newID) != null) {
                        System.out.println("-> Movie ID already exists. Please try again");
                    } else {
                        System.out.println(" \n*** Complete New Movie Info ***");
                        System.out.println("\nTitle: ");
                        String newTitle = sc.nextLine();
                        System.out.println("Release Date (YYYYMMDD): ");
                        int newRD = Integer.parseInt(sc.nextLine());
                        System.out.println("Rating (0-100): ");
                        int newRate = Integer.parseInt(sc.nextLine());
                        Movie newMovie = new Movie(newTitle, newRD, newID, newRate);
                        listOfMovies.insert(newMovie);
                        bstMovies.insert(newMovie);
                        hashMovies.insert(newMovie);
                        System.out.println("-> " + newMovie.getTitle() + " has been added to movie list.");
                        System.out.println("\n-> View updated movie list? (Yes/No)");
                        String viewChoice = sc.nextLine();
                        if (viewChoice.equals("Yes")) {
                            System.out.println();
                            listOfMovies.printAllMovies();
                        } else {
                            Main.aMenu(); 
                        }
                    }
                } catch(NumberFormatException e) {
                    System.out.println("\n-> Wrong format. Try again.");
                }

            // see the least rated movie and admin has the option set it to unavailble 
            // so that it can be deleted later (in admin option 5)    
            } else if (adChoice == 5) {
                System.out.println("\n*** Find and Set Least Rated Movie to Unavailable ***");
                Movie least1 = listOfMovies.findLeastRT();
                int leastID = least1.getID();
                Movie least_hash = hashMovies.lookup(leastID);
                System.out.println("\n-> " + least1.getTitle() + " is the least rated movie.");
                System.out.println("Change " + least1.getTitle() + "'s status to unavailable? (Yes/No)");
                String adminInput2 = sc.nextLine();
                if (adminInput2.equals("Yes")) {
                    System.out.println("\n-> " + least1.getTitle()+ " has been made unavailable.");
                    least1.setToUnavailable();
                    least_hash.setToUnavailable();
                    System.out.println("-> Check " + least1.getTitle() + "'s status again: isAvailable = " + least1.checkStatus() + ".");
                } else if (adminInput2.equals("No")) {
                    System.out.println("-> " + least1.getTitle()+ " is kept available.");
                } else {
                    System.out.println("-> Wrong input. Try again.");
                }

            // search a movie by ID, delete a movie only if it's unavailable    
            } else if (adChoice == 6) {
                try {
                    System.out.println("\n*** Search and Delete Movie ***");
                    System.out.println("Enter the movie ID: ");
                    int admin_movieID = Integer.parseInt(sc.nextLine());
                    Movie result = hashMovies.lookup(admin_movieID);
                    if (result != null) {
                        if (result.checkStatus() == false) {
                            System.out.println("Status: Unavailable");
                            System.out.println("\nWould you like to delete " + result.getTitle() + "? (Yes/No)");
                            String adminInput1 = sc.nextLine();
                            if (adminInput1.equals("Yes")) {
                                hashMovies.delete(admin_movieID);
                                listOfMovies.deleteLeastRT();
                                System.out.println("-> " + result.getTitle() + " has been deleted.");
                                System.out.println("\n-> Here's the updated movie list: ");
                                listOfMovies.printAllMovies();
                            } else if (adminInput1.equals("No")) {
                                System.out.println("\n-> " + result.getTitle() + "is kept in movie list.");
                            }
                        } else if (result.checkStatus() == true) {
                            System.out.println("\nCareful! " + result.getTitle() + " is available.");
                            System.out.println("You don't want to delete an available movie.");
                        }
                    }
                } catch(NumberFormatException e) {
                    System.out.println("\n-> Wrong format. Try again.");
                }
            
            } else if (adChoice != 7) {
                System.out.println("\n-> Error, not an option, pick again(1-3)");
            }
            
        } while (adChoice != 7);
        System.out.println("\n\n*** You have logged out successfully ***\n\n");
        Main.mMenu();
    } 
}