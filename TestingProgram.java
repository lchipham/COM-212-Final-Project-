import java.security.interfaces.ECKey;
import java.util.Scanner;

public class TestingProgram {
    public static void main(String[] args) {

        System.out.println();
        AllMovies listOfMovies = new AllMovies(); 
        AllCustomers listOfCustomers = new AllCustomers();

        WishList a = new WishList();
        WishList c = new WishList();
        WishList d = new WishList();
        WishList e = new WishList();
        WishList b = new WishList();

        Customer cusA = new Customer("Chi", 3539, "linhchipham.269@gmail.com", a);
        Customer cusB = new Customer("Mel", 2235, "melanie@gmail.com", b);
        Customer cusC = new Customer("Chu", 1234, "hanoi@gmail.com", c);
        Customer cusD = new Customer("Chau", 1341, "sylviale@gmail.com", d);
        Customer cusE = new Customer("Nhi", 1190, "nhinguyen@gmail.com", e);
        listOfCustomers.insert(cusA);
        listOfCustomers.insert(cusC);
        listOfCustomers.insert(cusD);
        listOfCustomers.insert(cusE);
        listOfCustomers.insert(cusB);
        //listOfCustomers.remove(cusB);
        listOfCustomers.printCustomerList();

        System.out.println();
        System.out.println("* Customer Lookup By Credit Card Number:");
        System.out.println("+ Customer with credit card number 3539: " + listOfCustomers.searchByCredit(3539));
        System.out.println("+ Customer with credit card number 2235: " + listOfCustomers.searchByCredit(2235));
        System.out.println("+ Customer with credit card number 1234: " + listOfCustomers.searchByCredit(1234));
        System.out.println("+ Customer with credit card number 1341: " + listOfCustomers.searchByCredit(1341));
        System.out.println("+ Customer with credit card number 1190: " + listOfCustomers.searchByCredit(1190));
        System.out.println();

        System.out.println("* Customer Info Lookup:");
        System.out.println("Email of customer A is: " + cusA.getCustomerEmail());
        System.out.println("Email of customer B is: " + cusB.getCustomerEmail());
        System.out.println("Email of customer C is: " + cusC.getCustomerEmail());
        System.out.println("Email of customer D is: " + cusD.getCustomerEmail());
        System.out.println();


        System.out.println("Original list of movies:");
        MovieArchive movie1 = new MovieArchive("Titanic", 19640502, 12100);
        MovieArchive movie2 = new MovieArchive("Catch me if you can", 19800502, 12089);
        MovieArchive movie3 = new MovieArchive("The Vampires", 20140502, 12070);
        MovieArchive movie4 = new MovieArchive("The Notebook", 20020502, 12089);
        MovieArchive movie5 = new MovieArchive("Love, Rosie", 20160502, 12081);
        MovieArchive movie6 = new MovieArchive("Squid Game", 20010502, 12060);
        MovieArchive movie7 = new MovieArchive("Zootopia", 20170502, 12090);
        MovieArchive movie8 = new MovieArchive("Killer", 20000502, 12080);
        MovieArchive movie9 = new MovieArchive("The Matrix", 19640502, 12100);
        MovieArchive movie10 = new MovieArchive("Hurricane", 20010502, 12030);

        listOfMovies.insert(movie1);
        listOfMovies.insert(movie2);
        listOfMovies.insert(movie3);
        listOfMovies.insert(movie4);
        listOfMovies.insert(movie5);
        listOfMovies.insert(movie6);
        listOfMovies.insert(movie7);
        listOfMovies.insert(movie8);
        listOfMovies.insert(movie9);
        listOfMovies.insert(movie10);

        listOfMovies.printAllMovies();
        System.out.println();

        System.out.println("Least Rated Movie: " + listOfMovies.findLeastRT());
        System.out.println("-> Delete " + listOfMovies.findLeastRT()+ ". Revised movie list: ");
        listOfMovies.deleteLeastRT();
        listOfMovies.printAllMovies();
        System.out.println();

        a.addMovie(movie1);
        a.addMovie(movie2);
        a.addMovie(movie6);
        a.addMovie(movie7);
        a.addMovie(movie10);
        
        System.out.println();
        System.out.println("Welcome to the movies!");
        System.out.println("Choose one from the following options:");
        System.out.println("1. Search a movie by ID");
        System.out.println("2. New & Popular"); //sort by release date
        System.out.println("3. Top 10 Movies in US today"); //sort by rating
        System.out.println("4. All Movies"); //users are able to sort movies from newly released to oldest and vice versa
        System.out.println("5. My Wishlist");
        System.out.println("6. Watch Again"); //Have watched 
        
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter option number (eg. 1): ");
        int optionNum = userInput.nextInt();
        System.out.println();

        if (optionNum == 1) {
            System.out.println("* Movie Lookup by ID:");
            System.out.println("Enter the ID of movie you'd like to search for: ");
            Scanner user_picksMovie = new Scanner(System.in);
            int user_movieID = user_picksMovie.nextInt();
            System.out.println("Movie with ID " + user_movieID + ": " + listOfMovies.searchByID(user_movieID));
            user_picksMovie.close();
        } else if (optionNum == 2) {
            System.out.println("Newly Released movies:");
        } else if (optionNum == 3) {
            System.out.println("Top 10 Movies in US today:");
        } else if (optionNum == 4) {
            System.out.println("* All Movies (lowest -> highest rated):");
            listOfMovies.printAllMovies();
        } else if (optionNum == 5) {
            System.out.println("My Wishlist:");
            a.displayWishList();
            
        } else {
            System.out.println("Watch Again?:");
        }    
        
        userInput.close();
  
    }
}