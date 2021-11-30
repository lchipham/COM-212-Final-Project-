public class Customer {
    private String name;
    private int creditNum;
    private String email;
    private WishList individualList;
    private Customer nextCustomer;

    public Customer(String name, int creditNum, String email, WishList individualList) {
        this.name = name;
        this.creditNum = creditNum;
        this.email = email;
        this.individualList = individualList;
    }

    public Customer getNextCustomer() {
        return nextCustomer;
    }

    public void setNextCustomer(Customer nextCustomer) {
        this.nextCustomer = nextCustomer;
    }

    public String getCustomerName() {
        return name;
    }

    public void setCustomerName(String name) {
        this.name = name;
    }

    public String getCustomerEmail() {
        return email;
    }

    public int getCreditNum() {
		return creditNum;
	}

    public WishList getWishList() {
        return individualList;
    }

}

