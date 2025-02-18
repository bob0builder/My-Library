public class QueueDSA {
    private int[] queue Array;
    private int front; // index  of front element
    private int rear; // index of last element
    private int capacity; // max capacity of queue
    private int size; //current size of queue
    
    //constructor to inistilize queue
    public Main(int capacity){
        this.capacity = capacity;
        queueArray = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    //Method to add element in queue(Enqueue)
    public void enqueue(int item){
        if(isFull()){
            System.out.println("Queue is full, cannot enqueu");
        }
    }
}
