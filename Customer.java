/* FINAL PROJECT - CHI, EUGENIE, MADISON - DEC 20, 2021
   This class builds an individual customer based on the structure of a node.
   Each customer has their own name, credit card number, email, movie wishlist and "have watched" movie list.
*/

public class Customer implements java.io.Serializable{
    private String name;
    private int creditNum;
    private String email;
    private WishList individualList= new WishList();
    private Customer nextCustomer;
    private WatchedMovies haveWatched = new WatchedMovies();

    public Customer(String name, int creditNum, String email) {
        this.name = name;
        this.creditNum = creditNum;
        this.email = email;
    }

    public String getCustomerName() {
        return name;
    }

    public int getCreditNum() {
		return creditNum;
	}

    public String getCustomerEmail() {
        return email;
    }

    public Customer getNextCustomer() {
        return nextCustomer;
    }

    // This method returns the haveWatched movie list of each customer
    public WatchedMovies getWatched() {
        return haveWatched;
    }

    // This method returns the movie WishList of each customer
    public WishList getWishList() {
        return individualList;
    }

    // This method allows for changing a customer's name (customer menu option 5)
    public void setCustomerName(String name) {
        this.name = name;
    }

    // This method allows for changing a customer's name (customer menu option 5)
    public void setCustomerEmail(String email) {
        this.email = email;
    }

    public void setNextCustomer(Customer nextCustomer) {
        this.nextCustomer = nextCustomer;
    }
}

