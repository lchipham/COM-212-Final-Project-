//Program Three - Chi Pham - Due Nov.2 2021
//This program implements a queue class using an array.

public class wishList {
	private int n;
	private int front;
    private movieArchive nextMovie;
	private movieArchive[] arrayQ;

	public wishList() {
		n = 0;
		front = 0;
		arrayQ = new wishList[20];
	}

	public Boolean isEmpty() {
		return n == 0;
	}

    public movieArchive getNextMovie() {
        return nextMovie;
    }

	public Node firstMovie() {
		return arrayQ[front];
	}

	// public Node dequeue() {
	// 	int temp = front;
	// 	front = (front + 1) % 100;
	// 	n = n - 1;
	// 	return arrayQ[temp];	
	// }

	public void addMovie(movieArchive x) {
		int end = (front + n) % 100;
		arrayQ[end] = x;
		n = n + 1;
	}

	public void displayWishList() {
		int end = (front + n) % 100;
        System.out.println(front);
        System.out.println(end);
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