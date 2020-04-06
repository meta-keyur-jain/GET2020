package Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class EmployeeImpl {

    List<Employee> empHash = new ArrayList<Employee>();
/**
 * This method is used to insert the details
 * @param id
 * @param name
 * @param address
 */
    public void insert(int id, String name, String address) {
        boolean temp = true;
        Employee emp = new Employee(id);
        emp.setName(name);
        emp.setAddress(address);
        for (Employee e : empHash) {
            if (id == e.getId()) {
                temp = false;
            }
        }
        if (temp) {
            empHash.add(emp);
        } 
    }

   /**
    * This method is used to sort employee by id 
    * @return
    */
    public List<Employee> sortById() {
        Collections.sort(empHash, new SortByEmpId());
        List<Employee> empHashSort = new ArrayList<Employee>();

        int size = empHash.size();

        for (int index = 0; index < size; index++) {
            Employee emp = new Employee(empHash.get(index).id);
            emp.setName(empHash.get(index).name);
            emp.setAddress(empHash.get(index).address);
            empHashSort.add(emp);
        }
        return empHashSort;

    }
 /**
  * This method is used to sort by name
  * @return
  */
    public List<Employee> sortByName() {
        Collections.sort(empHash, new SortByName());

        List<Employee> empHashSort = new ArrayList<Employee>();

        int size = empHash.size();

        for (int index = 0; index < size; index++) {
            Employee emp = new Employee(empHash.get(index).id);
            emp.setName(empHash.get(index).name);
            emp.setAddress(empHash.get(index).address);
            empHashSort.add(emp);
        }
        return empHashSort;
    }
}
