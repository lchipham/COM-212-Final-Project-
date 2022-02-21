/* FINAL PROJECT - CHI, EUGENIE, MADISON - DEC 20, 2021
   This class of all movies is implemented using Heap data structure.
   The least-rated movie is always placed at the very top of list.
*/

public class AllMovies implements java.io.Serializable{
    private Movie[] movies = new Movie[255]; // max 255 movies
    private int n;

    public AllMovies() {
        n = 0;
    }
    
    public Boolean isEmpty() {
        return n == 0;
    }

    // This method returns least-rated movie in the list
    public Movie findLeastRT() {
        return movies[0];
    }

    // This method allows for searching movies by their ID code
    public String searchByID(int id) {
        for (int i = 0; i < n - 1; i ++) {
            if (movies[i].getID() == id) {
                return movies[i].getTitle();
            } 
        }
        return "Movie Not Found";
    }

    public void swap (int x, int y) {
        Movie temp = movies[x];
        movies[x] = movies[y];
        movies[y] = temp;
    }

    // This method allows for inserting new movies
    public void insert(Movie x) {
        if (isEmpty()) {
            movies[n] = x;
        }

        else {
            movies[n] = x;
            int temp = n;
            int parent = (n-1)/2;
            while (movies[temp].getRating() < movies[parent].getRating()) {
                swap (temp, parent);
                temp = parent;
                parent = (temp-1)/2;
            }
        }
        n++;
    }

    // This method allows for deleting the least rated movie
    public void deleteLeastRT() {
        n--;
        swap (0, n);
        int parent = 0;
        int child = delete2(parent);

        while (child != -1) {
            swap (parent, child);
            parent = child;
            child = delete2(parent);
        }
    }

    public int delete2(int p) {
        int left = (p*2)+1;
        int right = (p*2)+2;

        if (left >= n && right >= n) {
            return -1;
        }
        else if (movies[left].getRating() < movies[right].getRating() || right >= n) {
            return left;
        }
        else {
            return right;
        }
    }

    // This method allows for printing the full list of movies
    public void printAllMovies() {
        for (int i = 0; i <= n-1; i++) {
            System.out.println(movies[i].getTitle() + " " + movies[i].getReleaseDate() + " " + movies[i].getID() + " " + movies[i].getRating());
        }
    }
}