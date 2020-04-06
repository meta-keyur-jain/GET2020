package Employee;

import java.util.Comparator;

public class SortByName implements Comparator<Employee>{

    @Override
    public int compare(Employee name1, Employee name2) {
        
        return name1.name.compareTo(name2.name);
    }
}