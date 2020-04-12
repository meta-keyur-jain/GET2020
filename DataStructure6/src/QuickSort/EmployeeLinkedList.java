package QuickSort;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeLinkedList {

    private Node head;
    private Node last;
    private int size = 0;

    public EmployeeLinkedList() {
        this.last = null;
    }

    /**
     * This method is used to insert employee in list
     * 
     * @param
     */
    public void insertEmployee(Employee employee) {
        Node newNode = new Node(employee);
        // if list is empty
        if (last == null) {
            head = newNode;
            last = newNode;
        }
        // enter employee at last index
        else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    /**
     * This method is used to get employee on index
     * 
     * @param index
     * 
     * @return
     */
    private Employee get(int index) {
        // check index is valid or not
        if (index < size) {
            Node curr = getHead();
            for (int count_i = 0; count_i < index; count_i++)
                curr = curr.next;
            return curr.employee;
        } else
            throw new AssertionError("index out of bound");
    }

    /**
     * This method is used to sort employees by quick sort algorithm
     */
    void quickSort() {
        sort(0, size - 1);
    }

    /**
     * This method is called by quickSort
     * 
     * @param low
     * 
     * @param high
     * 
     */
    private void sort(int low, int high) {
        if (low < high) {
            int mid = partition(low, high);
            // recursive call
            sort(low, mid - 1);
            sort(mid + 1, high);
        }
    }

    /**
     * This method is used to partition method for quick Sort
     * 
     * @param low
     * 
     * @param high
     * 
     * @return
     */
    private int partition(int low, int high) {

        Employee pivot = get(high);
        int index = (low - 1);

        for (int index2 = low; index2 < high; index2++) {
            // check any employee has salary greater than pivot
            if (get(index2).getSalary() >= pivot.getSalary()) {
                // if salary is same than compare age
                if (get(index2).getSalary() == pivot.getSalary()
                        && get(index2).getAge() > pivot.getAge())
                    continue;
                index++;
                // swap data of employees
                String name = get(index).getName();
                int age = get(index).getAge();
                int salary = get(index).getSalary();
                get(index).setData(get(index2).getName(), get(index2).getAge(),
                        get(index2).getSalary());
                get(index2).setData(name, age, salary);
            }
        }

        // set pivot employee on his correct position
        String name = get(index + 1).getName();
        int age = get(index + 1).getAge();
        int salary = get(index + 1).getSalary();
        get(index + 1).setData(get(high).getName(), get(high).getAge(),
                get(high).getSalary());
        get(high).setData(name, age, salary);
        return index + 1;
    }

    /**
     * This method is used to return employee name list
     */
    public String[] getEmployeeList() {
        String[] employees = new String[size];
        Node curr = getHead().next;
        int count = 0;
        while (curr != null && count < size) {
            employees[count] = curr.employee.getName();
            curr = curr.next;
            count++;
        }
        return employees;
    }

    /**
     * This method is used to get head
     * 
     * @return
     */
    public Node getHead() {
        return head;
    }

    public static void main(String[] args) {

        Scanner inputObj = new Scanner(System.in);
        EmployeeLinkedList listObj = new EmployeeLinkedList();

        String moreInput = "";
        int choice = 0;

        System.out
                .println("Enter Your Choice\n1.Add an Employee\n2.Sort\n3.Display Employee List\n4.Exit");
        choice = inputObj.nextInt();

        while (true) {
            switch (choice) {
            case 1: {
                inputObj.nextLine();
                System.out.println("Enter Employee Name :");
                String name = inputObj.nextLine();
                System.out.println("Enter Employee Age");
                int age = inputObj.nextInt();
                System.out.println("Enter Employee Salary :");
                int salary = inputObj.nextInt();
                Employee emp = new Employee(name, age, salary);
                listObj.insertEmployee(emp);
                System.out.println("Employee " + name + " added in the list\n");

            }
                break;
            case 2:
                listObj.quickSort();
                System.out.println("List Sorted successfully \n");
                break;
            case 3:
                Node temp = listObj.getHead();
                System.out
                        .println("Employee Name\tEmployee Age\tEmployee Salary");
                while (temp != null) {
                    System.out.println(temp.employee.getName() + "\t\t"
                            + temp.employee.getAge() + "\t\t"
                            + temp.employee.getSalary());
                    temp = temp.next;
                }

                break;
            case 4:
                System.exit(0);

            }
            System.out
                    .println("Enter Your Choice\n1.Add an Employee\n2.Sort\n3.Display Employee List\n4.Exit");
            choice = inputObj.nextInt();
        }
    }
}
