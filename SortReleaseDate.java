/* FINAL PROJECT - CHI, EUGENIE, MADISON - DEC 20, 2021
   This is another class of all movies that is implemented using Binary Search Tree data structure.
   The sole purpose of this class is to sort movies by its release date.
*/

public class SortReleaseDate implements java.io.Serializable{
    private Movie t;

    public SortReleaseDate() {
        t = null;
    }

    public boolean isEmptyTree() {
        return t == null;
    }

    // This method allows for sorting the movie list by newest -> oldest release date
    public void traversee() {
        traversee2(t);
    }

    public void traversee2(Movie y) { 
        if (y != null) {
            traversee2(y.getRight());
            System.out.println(y.getTitle() + " " + y.getReleaseDate() + " " + y.getID() + " " + y.getRating());
            traversee2(y.getLeft());
        }
    }

    // This method allows for sorting the movie list by oldest -> newest release date
    public void traverse() {
        traverse2(t);
    }

    public void traverse2(Movie y) {
        if (y != null) {
            traverse2(y.getLeft());
            System.out.println(y.getTitle() + " " + y.getReleaseDate() + " " + y.getID() + " " + y.getRating());
            traverse2(y.getRight());
        }
    }

    public Movie search(int releaseDate) {
        if (t == null) {
            return null;
        }
        else {
            return search2(t, releaseDate);
        }
    }

    public Movie search2(Movie x, int releaseDate) {
        if (x == null) {
            return null;
        }
        else if (x.getReleaseDate() == releaseDate) {
            return x;
        }
        else if (x.getReleaseDate() > releaseDate) {
            return search2(x.getLeft(), releaseDate);
        }
        else if (x.getReleaseDate() < releaseDate) {
            return search2(x.getRight(), releaseDate);
        }
        else {
            return x;
        }
    }

    // This method allows for inserting a new movie into the sort list
    public void insert(Movie p) {
        if (t == null) {
            t = p;
        }
        else {
            insert2(t, p);
        }
    }

    public void insert2(Movie t, Movie p) {
        if (p.getReleaseDate() < t.getReleaseDate()) {
            if (t.getLeft() == null) {
                t.setLeft(p);
            }
            else {
                insert2(t.getLeft(), p);
            }
        }
        else {
            if (t.getRight() == null) {
                t.setRight(p);
            }
            else {
                insert2(t.getRight(), p);
            }
        }
    }    

    public Movie getMin(Movie z) {
        if (z.getLeft() == null) {
            return z;
        }
        else {
            return getMin(z.getLeft());
        }
    }

    public void delete (Movie p) {
        t = delete2(t, p);
    }

    public Movie delete2(Movie t, Movie p) {
        // if tree is empty
        if (t == null) {
            return t;
        }
        // traverse left side to get to the movie being deleted
        else if (p.getReleaseDate() < t.getReleaseDate()) {
            t.setLeft(delete2(t.getLeft(), p));
        }
        // traverse right side to get to the movie being deleted
        else if (p.getReleaseDate() > t.getReleaseDate()) {
            t.setRight(delete2(t.getRight(), p));
        }
        else {
            // if movie deleted has two children, the sucessor would take its place
            if (t.getLeft() != null && t.getRight() != null) {
                // get the smallest movie in the right side (sucessor)
                Movie min = getMin(t.getRight());
                t.setReleaseDate(min.getReleaseDate());
                t.setRight(delete2(t.getRight(), min));
            }

            // if movie deleted has one child, the child would take its place
            else if (t.getRight() == null) {
                t = t.getLeft();
            }
            else if (t.getLeft() == null) {
                t = t.getRight();
            }

            // if movie is a leaf
            else {
                return null;
            }
        }
        return t;
    }

    public void printSorted() {
        System.out.println();
        printSorted2(t);
        System.out.println();
        }
    
    private void printSorted2(Movie t) {
        if (t != null) {
            System.out.print(t.getReleaseDate() + " ");
                if (t.getLeft() != null)
                System.out.print("Left: " + t.getLeft().getReleaseDate() + " ");
                else
                    System.out.print("Left: null ");
                if (t.getRight() != null)
                System.out.println("Right: " + t.getRight().getReleaseDate() + " ");
                else
                    System.out.println("Right: null ");
            printSorted2(t.getLeft());
            printSorted2(t.getRight());
        }
    }
}