public class AllCustomers {
    private int size = 10;
    private Customer[] customerList;

    public AllCustomers() {
        customerList = new Customer[size];
        for (int i = 0; i < size; i++) {
            customerList[i] = null;
        }      
    }  
 
    public String searchByCredit(int creditNum) {
        int hash = (creditNum % size );
        if (customerList[hash] == null) {
            return "Not Found";
        }
        else {
            Customer entry = customerList[hash];
            while (entry != null && entry.getCreditNum() != creditNum) {
                entry = entry.getNextCustomer();
            } 
            if (entry == null) {
                return "Not Found";
            } else {
                return entry.getCustomerName();
            }
        }
    }
 
    public void insert(Customer a) {  // key = creditNum, value = Name
        int hash = (a.getCreditNum() % size);
        if (customerList[hash] == null) {
            customerList[hash] = new Customer(a.getCustomerName(), a.getCreditNum(), a.getCustomerEmail(), a.getWishList());
        } else {
            Customer entry = customerList[hash];
            while (entry.getNextCustomer() != null && entry.getCreditNum() != a.getCreditNum()) {
                entry = entry.getNextCustomer();
            }
            if (entry.getCreditNum() == a.getCreditNum()) {
                entry.setCustomerName(a.getCustomerName());
            } else {
                entry.setNextCustomer(new Customer(a.getCustomerName(), a.getCreditNum(), a.getCustomerEmail(), a.getWishList()));
            }
        }
    }
 
    public void remove(Customer a) { 
        int hash = (a.getCreditNum() % size);
        if (customerList[hash] != null) {
            Customer prevEntry = null;
            Customer entry = customerList[hash];
            while (entry.getNextCustomer() != null && entry.getCreditNum() != a.getCreditNum()) {
                prevEntry = entry;
                entry = entry.getNextCustomer();
            }
            if (entry.getCreditNum() == a.getCreditNum()) {
                if (prevEntry == null) {
                    customerList[hash] = entry.getNextCustomer();
                } else {
                    prevEntry.setNextCustomer(entry.getNextCustomer());
                }
            }
        }
    }

    private void traverseList(Customer x) {
        Customer current = x;
        while (current != null) {
            System.out.print("{" + current.getCustomerName() + ", " + current.getCreditNum() + "}" + " ");
            current = current.getNextCustomer();
        }
    }

    public void printCustomerList() {
        System.out.println("* List of customers displayed in {name, credit number} format *");
        for (int i = 0; i < size; i++) {
            Customer entry = customerList[i];
            System.out.print("+ ");
            if (entry != null) {
                traverseList(entry);
            }
            System.out.println();
        }   
    }
}