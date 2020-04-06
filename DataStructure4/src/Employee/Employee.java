package Employee;

import java.util.HashMap;

public class Employee {

    int id;
    String name;
    String address;
    
    Employee(int id){
        this.id=id;
    }
    
    public int getId() {
        return id;
    }
 
    public void setId(int id) { 
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

 

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", address=" + address
                + "]";
    }
    
    
}
