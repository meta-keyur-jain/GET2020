import java.util.Scanner;

public class queue {

    int front = 0;
    int rear = 0;
    int size = 0;
    int element = 0;
    int[] queueArray;

    /**
     * This is used to initilize array
     * 
     * @param sizeofArray
     */
    queue(int sizeofArray) {

        this.queueArray = new int[sizeofArray];
        this.element = sizeofArray;
    }

    /**
     * This is used to add the element to queue
     * 
     * @param data
     */
    public String enque(int data) {
        String result;
        if (!isFull()) {
            queueArray[rear] = data;
            rear = (rear + 1) % (element);
            size++;
            result = "--------added sucessfully---------";
        } else {
            result = "-------Queue is full--------";

        }
        return result;
    }

    /**
     * This is used to delete from queue
     */
    public String deque() {
        String result;
        int data = queueArray[front];
        if (!isEmpty()) {
            front = (front + 1) % (queueArray.length);
            size--;
            result = "-------Deleted Sucessfully--------";
        } else {
            result = "--------Queue is empty------------";
        }
        return result;
    }

    /**
     * This is used to check whether queue is empty
     * 
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * This is used to check whether queue is full
     * 
     * @return
     */
    public boolean isFull() {
        return size == element;

    }

    /**
     * This is used to print size of queue
     */
    public int sizeofQueue() {
        return size;
    }

    /**
     * This is used to show queue
     */
    public int[] show() {
        System.out.println("list after operation");
        int[] arr = new int[element];
        for (int index = 0; index < size; index++) {

            arr[index] = queueArray[(front + index) % (queueArray.length)];
        }
        // System.out.println("Actual list");
        // for (int number : queueArray) {
        // System.out.println(number + "");
        //
        // }
        return arr;
    }

    // public static void main(String[] args) {
    // int element, operation;
    //
    // Scanner sc = new Scanner(System.in);
    // System.out.println("Enter the no of element you want to enter");
    // element = sc.nextInt();
    // queue q = new queue(element);
    // System.out.println("Enter operation" + "\n" + " 1 add to queue" + "\n"
    // + "2 delete from queue" + "\n" + "3 show" + "\n"
    // + "4 size of queue" + "5" + "exit");
    // operation = sc.nextInt();
    // while (true) {
    // String result;
    // int size;
    // switch (operation) {
    // case 1:
    // System.out.println("Enter data");
    // int data = sc.nextInt();
    // result = q.enque(data);
    // System.out.println(result);
    // break;
    // case 2:
    // result = q.deque();
    // System.out.println(result);
    // break;
    // case 3:
    // q.show();
    // break;
    // case 4:
    // size = q.sizeofQueue();
    // System.out.println(size);
    // break;
    // case 5:
    // System.exit(0);
    // }
    //
    // System.out.println("Enter operation" + "\n" + " 1 add to queue"
    // + "\n" + "2 delete from queue" + "\n" + "3 show" + "\n"
    // + "4 size of queue" + "\n" + "5 exit");
    // operation = sc.nextInt();
    // }
    // }

}
