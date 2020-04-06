 package Employee;

import java.util.Comparator;



public class SortByEmpId implements Comparator<Employee> {

        
        public int compare(Employee empId1, Employee empId2) {
        
          
            return empId1.id - empId2.id;
        }
    } 

