package com.mycode.queue;

/**
 * FIFO data structure - Queue array implementation - circular array
 */
class Queue {
	int array[];
	int front;
	int rear;
	int size;
	int capacity;

	public Queue(int c) {
		array = new int[c];
		capacity = c;
		front = 0;
		rear = c - 1;// note, start by 0 and then later change
		size = 0;
	}

	// Queue is full when size becomes equal to the capacity
	boolean isFull() {
		return (size == capacity);
	}

	// Queue is empty when size is 0
	boolean isEmpty() {
		return (size == 0);
	}

	// Push - add item in rear
	// array[rear++] = item; =>Not doing this because we can enqueue and then dequeue and then can again enqueue and rear
	// will keep increasing and can pass actual capacity.
	// rear => 0%4=0, 1%4 = 1, 2%4 =2, 3%4=3, 4%4=0, 5%4=1..
	void enqueue(int item) {
		if (isFull()) {
			System.out.println("Queue is Full");
			return;
		}
		rear = (rear + 1) % capacity; // note- first time it is 4%4, then 1%4.
		array[rear] = item;
		size++;
		System.out.println(item + " enqueued to queue at index " + rear);
	}

	// Method to remove an item from queue. It changes front and size
	// Pop - retrieve element from front
	int dequeue() {
		if (isEmpty()) {
			return 0;
		}
		int item = array[front];
		System.out.println("element returned from index:" + front);
		front = (front + 1) % capacity; //1%4 = 1, 2%4 =2,
		size--;
		return item;
	}

	// Method to get front element of queue
	int front() {
		if (isEmpty())
			return 0;

		return array[front];
	}

	// Method to get rear element of queue
	int rear() {
		if (isEmpty())
			return 0;

		return array[rear];
	}

	public void display() {
		System.out.print("\nQueue elements(this matters):");
		for (int i = 0; i < size; i++) { //loop should start from front to till size and not capacity. Circular array
			System.out.print(array[(front + i) % capacity] + " "); // first element should be start from front and then when it reaches capacity then start from o
		}
		System.out.print("\nActual Queue elements:");
		for (int n : array) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}
}

public class MyQueue {
	public static void main(String[] args) {
		for (int i = 0; i < 6; i++) {
			System.out.println("mod:" + i + "%4: " + (i % 4));
		}

		Queue queue = new Queue(4);

		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);

		System.out.println("dequeued-->" + queue.dequeue());
		System.out.println("dequeued-->" + queue.dequeue());

		System.out.println("Front item is " + queue.front());
		System.out.println("Rear item is " + queue.rear());

		queue.display();

		queue.enqueue(50);
		queue.enqueue(60);
		queue.enqueue(70); // size of queue is 3 so no more addition
		queue.display();
	}
}

//OUTPUT-
//mod:0%4: 0
//mod:1%4: 1
//mod:2%4: 2
//mod:3%4: 3
//mod:4%4: 0
//mod:5%4: 1
//10 enqueued to queue at index 0
//20 enqueued to queue at index 1
//30 enqueued to queue at index 2
//40 enqueued to queue at index 3
//element returned from index:0
//dequeued-->10
//element returned from index:1
//dequeued-->20
//Front item is 30
//Rear item is 40
//
//Queue elements(this matters):30 40 
//Actual Queue elements:10 20 30 40 
//50 enqueued to queue at index 0
//60 enqueued to queue at index 1
//Queue is Full
//
//Queue elements(this matters):30 40 50 60 
//Actual Queue elements:50 60 30 40 

