/* FINAL PROJECT - CHI, EUGENIE, MADISON - DEC 20, 2021
   This class builds each single movie based on the structure of a node.
   Each movie has its own title, release date, ID code, Rotten Tomatoes rating (0-100) and status (available/unavailable).
*/

public class Movie implements java.io.Serializable{
    private String title;
    private int releaseDate;
    private int idCode;
    private int rating;
    private Movie next;
    private Movie left;
    private Movie right; 
    private Boolean isAvailable = true; 

    public Movie(String title, int releaseDate, int idCode, int rating) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.idCode = idCode;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public int getID() {
        return idCode;
    } 

    public int getRating() {    
        return rating;
    }
    // This method returns the status of a movie
    public Boolean checkStatus() {
        return isAvailable;
    }

    // This method sets a movie's status to unavailable
    public void setToUnavailable() {
        isAvailable = false;
    }

    // This method returns the next movie in list
    public Movie getNext() {
        return next;
    }

    public void setLeft(Movie x) {
        this.left = x;
    }

    public Movie getLeft() {
        return left;
    }
    
    public void setRight(Movie x) {
        this.right = x;
    }

    public Movie getRight() {
        return right;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setID(int idCode) {
        this.idCode = idCode;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setNext(Movie next) {
        this.next = next;
    }
}