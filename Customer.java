public class Customer {
    private String name;
    private int creditNum;
    private String email;
    private wishList individualList;

    public Customer(String name, int creditNum, String email, wishList individualList) {
        this.name = name;
        this.creditNum = creditNum;
        this.email = email;
        this.individualList = individualList;
    }

    public int getCustomerName() {
        return name;
    }

    public int getCustomerEmail() {
        return email;
    }

    public int getCreditNum() {
		return creditNum;
	}

    public wishList getWishList() {
        return individualList;
    }

}

