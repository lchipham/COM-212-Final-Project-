//Program Three - Chi Pham - Due Nov.2 2021
//This program implements a queue class using an array.

public class QueueA {
	private int n;
	private int front;
	private Node[] arrayQ;

	public QueueA() {
		n = 0;
		front = 0;
		arrayQ = new Node[100];
	}

	public Boolean isEmpty() {
		return n == 0;
	}

	public Node front() {
		return arrayQ[front];
	}

	public Node dequeue() {
		int temp = front;
		front = (front + 1) % 100;
		n = n - 1;
		return arrayQ[temp];	
	}

	public void enqueue(Node x) {
		int end = (front + n) % 100;
		arrayQ[end] = x;
		n = n + 1;
	}

	public void printQueue() {
		int end = (front + n) % 100;
        System.out.println(front);
        System.out.println(end);
        if (front <= end)
           for(int i = front; i < end; i++) 
               System.out.println(arrayQ[i].getKey());
        else {
           for(int i = front; i < 100; i++) 
               System.out.println(arrayQ[i].getKey());          
           for(int i = 0; i < end; i++) 
               System.out.println(arrayQ[i].getKey());
        }  
	}

}