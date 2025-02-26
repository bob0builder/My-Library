public class Queue_3rd{
    private int[] queueArray; //array to store queue
    private int front; //index of front element
    private int rear; //index of last element
    private int capacity; // Maximum capacity of our queue
    private int size; //Current size of queue
    
    //Constructor to initialize queue
    public Main(int capacity){
        this.capacity = capacity;
        queueArray =new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    //method to add element in a queue(enqueue)
    public void enqueue(int item){
        if(isFull()){
            System.out.println(" Queue is full, cannot enqueue" + item);
        }
        
        rear = (rear + 1)%capacity; //circular increament of queue
        queueArray[rear] = item;
        size++;
        System.out.println(" Enqueued item; " + item);
    }
    
    //method to remove/delete an element from the queue
    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty, Cannot dequeue");
            return -1; // O/P return -1 , indicates empty
        }
        int item = queueArray[front];
        front = (front + 1)%capacity;
        size--;
        System.out.println(" Dequeued item: " + item);
        return item;
        }
    
    //method to see front element without removing it
    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty, cannot peek");
        }
        return queueArray[front];
    }
    
    //method to check if the queue is empty
    public boolean isEmpty(){
        return size == 0;
    }
    //method to check if the queue is full
    public boolean isFull(){
        return size == capacity;
    }
    
    public void display(){
        if(isEmpty()){
            System.out.println("Queue is empty");
        }
        System.out.print("Queue:");
        int count =size;
        int i = front;
        while(count > 0){
            System.out.print(queueArray[i] + "  ");
            i = (i+1)%capacity; // circular increment
            count--;
        }
    }
    
    public static void main(String[] args){
        Main queue = new Main(5);
        
        queue.enqueue(12);
        queue.enqueue(30);
        queue.enqueue(70);
        queue.enqueue(115);
        queue.enqueue(40);
        queue.enqueue(112);
        
        queue.display();
        
        queue.dequeue();
        queue.dequeue();
        
        System.out.println("Front element" + queue.peek());
        
        System.out.println("Is the queue empty?" + queue.isEmpty());
        }
}