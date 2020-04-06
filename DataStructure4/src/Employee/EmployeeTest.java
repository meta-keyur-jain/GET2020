package Employee;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import junit.framework.Assert;

import org.junit.Test;

public class EmployeeTest {
    @Test
    public void test1() {

        EmployeeImpl emp = new EmployeeImpl();
        HashMap<Integer, ArrayList<String>> employeeHash = new HashMap<Integer, ArrayList<String>>();
        List<Employee> sortedById;
        List<Employee> sortedName;

        emp.insert(1, "keyur", "dpr");
        emp.insert(5, "ronak", "jaipur");
        emp.insert(2, "jainam", "banswara");
        emp.insert(3, "bhavesh", "alwar");
        emp.insert(4, "kunal", "tonk");

        sortedById = emp.sortById();
        sortedName = emp.sortByName();
        String expectedName = "[Employee [id=3, name=bhavesh, address=alwar], Employee [id=2, name=jainam, address=banswara], Employee [id=1, name=keyur, address=dpr], Employee [id=4, name=kunal, address=tonk], Employee [id=5, name=ronak, address=jaipur]]";
        String expectedId = "[Employee [id=1, name=keyur, address=dpr], Employee [id=2, name=jainam, address=banswara], Employee [id=3, name=bhavesh, address=alwar], Employee [id=4, name=kunal, address=tonk], Employee [id=5, name=ronak, address=jaipur]]";
        assertEquals(expectedId, sortedById.toString());
        assertEquals(expectedName, sortedName.toString());

    }

    @Test
    public void test2() {

        EmployeeImpl emp = new EmployeeImpl();
        HashMap<Integer, ArrayList<String>> employeeHash = new HashMap<Integer, ArrayList<String>>();
        List<Employee> sortedById;
        List<Employee> sortedName;

        emp.insert(1, "keyur", "dpr");
        emp.insert(1, "Keyur", "jaipur");
        emp.insert(2, "jainam", "banswara");
        emp.insert(3, "bhavesh", "alwar");
        emp.insert(4, "kunal", "tonk");
        sortedById = emp.sortById();
        sortedName = emp.sortByName();

        String expectedId = "[Employee [id=1, name=keyur, address=dpr], Employee [id=2, name=jainam, address=banswara], Employee [id=3, name=bhavesh, address=alwar], Employee [id=4, name=kunal, address=tonk]]";
        String expectedName = "[Employee [id=3, name=bhavesh, address=alwar], Employee [id=2, name=jainam, address=banswara], Employee [id=1, name=keyur, address=dpr], Employee [id=4, name=kunal, address=tonk]]";
        assertEquals(expectedId, sortedById.toString());
        assertEquals(expectedName, sortedName.toString());
    }

    @Test
    public void test3() {

        EmployeeImpl emp = new EmployeeImpl();
        HashMap<Integer, ArrayList<String>> employeeHash = new HashMap<Integer, ArrayList<String>>();
        List<Employee> sortedById;
        List<Employee> sortedName;

        emp.insert(1, "keyur", "dpr");
        emp.insert(5, "Keyur", "jaipur");
        emp.insert(2, "jainam", "banswara");
        emp.insert(3, "bhavesh", "alwar");
        emp.insert(4, "kunal", "tonk");
        sortedById = emp.sortById();
        sortedName = emp.sortByName();
 
        String expectedName = "[Employee [id=5, name=Keyur, address=jaipur], Employee [id=3, name=bhavesh, address=alwar], Employee [id=2, name=jainam, address=banswara], Employee [id=1, name=keyur, address=dpr], Employee [id=4, name=kunal, address=tonk]]";
        String expectedId = "[Employee [id=1, name=keyur, address=dpr], Employee [id=2, name=jainam, address=banswara], Employee [id=3, name=bhavesh, address=alwar], Employee [id=4, name=kunal, address=tonk], Employee [id=5, name=Keyur, address=jaipur]]";
        assertEquals(expectedName, sortedName.toString());
        assertEquals(expectedName, sortedName.toString());

    }
}
