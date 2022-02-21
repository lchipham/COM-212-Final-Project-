/* FINAL PROJECT - CHI, EUGENIE, MADISON - DEC 20, 2021
   This class of Have Watched Movies is implemented using Queue Array data structure.
   Adding and deleting of movies can be done in constant run time.
*/

public class WatchedMovies implements java.io.Serializable{
	private int n;
	private int front;
    private Movie nextMovie;
	private Movie[] arrayQ;

	public WatchedMovies() {
		n = 0;
		front = 0;
		arrayQ = new Movie[20];
	}

	public Boolean isEmpty() {
		return n == 0;
	}

    public Movie getNextMovie() {
        return nextMovie;
    }

	public Movie firstMovie() {
		return arrayQ[front];
	}

	// This method allows for deleting a movie from customer's watched list
	public void deleteMovie() {
		front = (front + 1) % 100;
		n = n - 1;
	}

	// This method allows for adding a movie into customer's watched list
	public void addMovie(Movie x) {
		int end = (front + n) % 100;
		arrayQ[end] = x;
		n = n + 1;
	}

	// This method allows for printing a customer's watched list
	public void displayWatchedMovies() {
		int end = (front + n) % 100;
        if (front <= end) {
			for(int i = front; i < end; i++) {
				System.out.println(arrayQ[i].getTitle());
			}
		} else {
        	for(int i = front; i < 100; i++) 
            	System.out.println(arrayQ[i].getTitle());          
        	for(int i = 0; i < end; i++) 
               	System.out.println(arrayQ[i].getTitle());
        }  
	}
}