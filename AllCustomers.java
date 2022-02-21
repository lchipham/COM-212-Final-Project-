/* FINAL PROJECT - CHI, EUGENIE, MADISON - DEC 20, 2021
   This class of all customers is implemented using Hash - Separate Chaining data structure.
   Key: credit card number; Value: customer's name.
*/

public class AllCustomers implements java.io.Serializable{
    private int size = 5; 
    private Customer[] customerList;

    public AllCustomers() {
        customerList = new Customer[size];
        for (int i = 0; i < size; i++) {
            customerList[i] = null;
        }      
    }  
    
    // This method allows for searching customers by their credit card number
    public Customer searchByCredit(int creditNum) {
        int hash = (creditNum % size );
        if (customerList[hash] == null) {
            return null;
        }
        else {
            Customer entry = customerList[hash];
            while (entry != null && entry.getCreditNum() != creditNum) {
                entry = entry.getNextCustomer();
            } 
            if (entry == null) {
                return null;
            } else {
                return entry;
            }
        }
    }
    
    // This method allows for inserting new customers 
    public void insert(Customer a) { 
        int hash = (a.getCreditNum() % size);
        if (customerList[hash] == null) {
            customerList[hash] = new Customer(a.getCustomerName(), a.getCreditNum(), a.getCustomerEmail());
        } else {
            Customer entry = customerList[hash];
            while (entry.getNextCustomer() != null && entry.getCreditNum() != a.getCreditNum()) {
                entry = entry.getNextCustomer();
            }
            if (entry.getCreditNum() == a.getCreditNum()) {
                entry.setCustomerName(a.getCustomerName());
            } else {
                entry.setNextCustomer(new Customer(a.getCustomerName(), a.getCreditNum(), a.getCustomerEmail()));
            }
        }
    }
 
    // This method allows for deleting customers
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

    // This method allows for printing the full list of customers (admin option)
    public void printCustomerList() {
        for (int i = 0; i < size; i++) {
            Customer temp = customerList[i];
            if (temp == null) {
                System.out.print("null");
            }
            while (temp != null) {
                System.out.print(temp.getCustomerName() + " " + temp.getCustomerEmail() + " " + temp.getCreditNum() + " ");
                temp = temp.getNextCustomer();
            }
        System.out.println();
        }
    }
}