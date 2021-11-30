//Program Three - Chi Pham - Due Nov.2 2021
//This program implements a queue class using an array.

public class WishList {
	private int n;
	private int front;
    private MovieArchive nextMovie;
	private MovieArchive[] arrayQ;

	public WishList() {
		n = 0;
		front = 0;
		arrayQ = new MovieArchive[20];
	}

	public Boolean isEmpty() {
		return n == 0;
	}

    public MovieArchive getNextMovie() {
        return nextMovie;
    }

	public MovieArchive firstMovie() {
		return arrayQ[front];
	}

	// public Node dequeue() {
	// 	int temp = front;
	// 	front = (front + 1) % 100;
	// 	n = n - 1;
	// 	return arrayQ[temp];	
	// }

	public void addMovie(MovieArchive x) {
		int end = (front + n) % 100;
		arrayQ[end] = x;
		n = n + 1;
	}

	public void displayWishList() {
		int end = (front + n) % 100;
        // System.out.println(front);
        // System.out.println(end);
        if (front <= end)
        	for(int i = front; i < end; i++) 
            	System.out.println(arrayQ[i].getTitle());
        else {
        	for(int i = front; i < 100; i++) 
            	System.out.println(arrayQ[i].getTitle());          
        	for(int i = 0; i < end; i++) 
               	System.out.println(arrayQ[i].getTitle());
        }  
	}

}