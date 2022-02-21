/* FINAL PROJECT - CHI, EUGENIE, MADISON - DEC 20, 2021
   This class has to be run BEFORE and SEPARATELY from Main.java. 
   It is used to serialize the original list of customers and movies before customer/admin make changes.
   To reset any previous changes made by customer/admin, run CreateSerialization.java again after running Main.java.
*/

import java.io.*;
public class CreateSerialization implements java.io.Serializable{
    public static void main(String[] args) {
        System.out.println();
        AllMovies listOfMovies = new AllMovies(); 
        AllCustomers listOfCustomers = new AllCustomers();
        SearchMovie hashMovies = new SearchMovie();
        SortReleaseDate bstMovies = new SortReleaseDate();

        // existing customers are created (for the existing customer identification in log in menu)
        System.out.println("Original list of customers:");
        Customer cusA = new Customer("Chi", 3539, "linhchipham.269@gmail.com");
        Customer cusB = new Customer("Mel", 3538, "melanie@gmail.com");
        Customer cusC = new Customer("Chu", 3537, "hanoi@gmail.com");
        Customer cusD = new Customer("Chau", 3536, "sylviale@gmail.com");
        Customer cusE = new Customer("Nhi", 3535, "nhinguyen@gmail.com");
        listOfCustomers.insert(cusA);
        listOfCustomers.insert(cusC);
        listOfCustomers.insert(cusD);
        listOfCustomers.insert(cusE);
        listOfCustomers.insert(cusB);
        listOfCustomers.printCustomerList();

        // movie release date is in yyyymmdd format
        System.out.println("\nOriginal list of movies:");
        Movie movie1 = new Movie("Titanic", 19640502, 12096, 96);
        Movie movie2 = new Movie("Catch Me If You Can", 19800502, 11089, 89);
        Movie movie3 = new Movie("The Vampires", 20140502, 12070, 70);
        Movie movie4 = new Movie("The Notebook", 20020502, 12030, 30);
        Movie movie5 = new Movie("Love, Rosie", 20160502, 134081, 81);
        Movie movie6 = new Movie("Squid Game", 20010502, 12960, 60);
        Movie movie7 = new Movie("Zootopia", 20170502, 14890, 90);
        Movie movie8 = new Movie("Killer", 20000502, 15580, 80);
        Movie movie9 = new Movie("The Matrix", 19640502, 11686, 86);
        Movie movie10 = new Movie("Hurricane", 20010502, 10930, 30);
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

        // movies are also added in the sortReleaseDate list
        bstMovies.insert(movie1);
        bstMovies.insert(movie2);
        bstMovies.insert(movie3);
        bstMovies.insert(movie4);
        bstMovies.insert(movie5);
        bstMovies.insert(movie6);
        bstMovies.insert(movie7);
        bstMovies.insert(movie8);
        bstMovies.insert(movie9);
        bstMovies.insert(movie10);

        // movies are also added in the searchMovie list
        hashMovies.insert(movie1);
        hashMovies.insert(movie2);
        hashMovies.insert(movie3);
        hashMovies.insert(movie4);
        hashMovies.insert(movie5);
        hashMovies.insert(movie6);
        hashMovies.insert(movie7);
        hashMovies.insert(movie8);
        hashMovies.insert(movie9);
        hashMovies.insert(movie10);

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
}
