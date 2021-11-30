public class AllMovies {
    private MovieArchive[] movies = new MovieArchive[255];
    private int n;

    public AllMovies() {
        n = 0;
    }
    
    public Boolean isEmpty() {
        return n == 0;
    }

    public String findLeastRT() {
        return movies[0].getTitle();
    }

    public String searchByID(int id) {
        for (int i = 0; i < n - 1; i ++) {
            if (movies[i].getID() == id) {
                return movies[i].getTitle();
            } 
        }
        return "Movie Not Found";
    }

    public void swap (int x, int y) {
        MovieArchive temp = movies[x];
        movies[x] = movies[y];
        movies[y] = temp;
    }

    public void insert(MovieArchive x) {
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

    public void printAllMovies() {
        for (int i = 0; i <= n-1; i++) {
            System.out.println(movies[i].getTitle());
        }
    }
}