import java.util.Scanner;

public class LinkListRotation {

    private static Node head;

   
    public static class Node {
        public int data;
        public Node next;

        Node(int element) {
            this.data = element;
        }
    }

    /**
     * This method is used to add the node to last of list
     * 
     * @param node
     */
    public void addToTheLast(int data) {
        Node node = new Node(data);
        node.next = null;
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;

        }

    }

    /**
     * This method is used to print the link list
     */
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * This method is used to find the size of link list
     * 
     * @param args
     */
    int size = 0;

    public int size(Node node) {
        while (node != null) {
            node = node.next;
            size += 1;
        }
        return size;
    }
    
    /**
     * This method is used to rotate the list
     * @param head
     * @param left
     * @param right
     * @param rotation
     */

    public void rotate(Node head, int left, int right, int rotation) {

        int sizeOfSubArray = right - left + 1;

        

        // if rotaton is greater than size
        if (rotation > sizeOfSubArray) {
            rotation = rotation % sizeOfSubArray;
        }
        // if no rotaion and rotation is equl to sizeOfSubArray
        if (rotation == 0 || rotation == sizeOfSubArray) {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }

        }

        
        Node link = null;
        if (left == 1) {
            link = head;
        }

        Node curr = head;
        int count = 0;
        Node end = null;
        Node pre = null;

        while (curr != null) {
            count++;
            if (count == left - 1) {
                pre = curr;
                link = curr.next;
            }
            if (count == right - rotation) {
                if (left == 1) {
                    end = curr;
                    head = curr.next;
                }
                else{
                    end = curr;
                    pre.next = curr.next;
                }
            }
            if(count == right){
                Node temp = curr.next;
                curr.next = link;
                end.next = temp;
                Node header = head;
                while(head !=null){
                    System.out.print(head.data+"-->");
                    head = head.next;
                }
                return;
            }
            curr = curr.next;
        }

    }

    public static void main(String[] args) {
        int size, index = 0,left,right,rotation;

        LinkListRotation list = new LinkListRotation();

        System.out.println("Enter the number of node you want to enter");
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();

        // Creating a linked list
        while (index < size) {
            System.out.println("Enter the value of node");
            int newNode = sc.nextInt();
            list.addToTheLast(newNode);
            index++;
        }
        list.printList();
        System.out.println("Enter left position");
        left= sc.nextInt();
        System.out.println("Enter right position");
        right=sc.nextInt();
        System.out.println("Enter rotation");
        rotation= sc.nextInt();
        list.rotate(head, left, right, rotation);

    }
}
