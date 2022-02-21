/* FINAL PROJECT - CHI, EUGENIE, MADISON - DEC 20, 2021
   This is another class of all movies that is implemented using Hash data structure.
   The sole purpose of this class is to search each movie by its ID code, in constant run time.
*/

public class SearchMovie implements java.io.Serializable{
    private Movie[] movies = new Movie[255];
    private int n = 0;

    public SearchMovie() {
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    // This method allows for inserting a new movie into the search list
    public void insert(Movie x) {
        int i = x.getID() % 255;
        n++;
        if (movies[i] == null) {
            movies[i] = x;
        }
        else {
            Movie temp = movies[i];
            movies[i] = x;
            movies[i].setNext(temp);
        }
    }

    // This method allows for searching a new movie by their ID code
    public Movie lookup(int id) {
        int i = (id % 255 );
        if (movies[i] == null) {
            System.out.println ("-> Movie not found");
            return null;
        }
        else {
            Movie temp = movies[i];
            while (temp != null && temp.getID() != id) {
                temp = temp.getNext();
            } 
            if (temp == null) {
                System.out.println ("\n-> Movie not found");
                return null;
            } else {
                System.out.println ("\n-> Movie found");
                System.out.println ("Title: " + temp.getTitle());
                System.out.println ("ID: " + temp.getID());
                System.out.println ("Release date: " + temp.getReleaseDate());
                System.out.println ("Rating: " + temp.getRating());
                return temp;
            }
        }
    }

    // This method allows for deleting a movie from the search list
    public void delete (int id) {
        if (isEmpty()) {
            return;
        }
        else {
            int i = id % 255;
            n--;
            if (movies[i].getID() == id) {
                if (movies[i].getNext() != null) {
                    movies[i] = movies[i].getNext();
                }
                else {
                    movies[i] = null;
                }
            }
            else {
                Movie temp = movies[i];
                Movie temp2 = null;
                if (temp == null) {
                    System.out.println ("Movie is not in our system");
                }
                while (temp.getID() != id) {
                    temp2 = temp;
                    temp = temp.getNext();
                }
                temp2.setNext(temp.getNext());
            }
        }
    }

    // This method allows for printing the search list
    public void printHash() {
        for (int i = 0; i < 255; i++) {
            Movie temp = movies[i];
            while (temp != null) {
                System.out.print(temp.getTitle() + " " + temp.getReleaseDate() + " " + temp.getID() + " " + temp.getRating());
                temp = temp.getNext();
            }
        System.out.println();
        }
    }
}  
