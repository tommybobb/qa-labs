
import java.util.ArrayList;

public class Manager extends Employee {

    private ArrayList<Employee> employees;

    public Manager(String name, String jobTitle) {
        super(name, jobTitle);
        employees = new ArrayList<Employee>();
    }

    public void addEmployee(Employee emp){
        employees.add(emp);
    }
    
    @Override
    public String getInfo(){
        String info = super.getInfo();
        
        for (Employee emp : employees) {
            info += emp.getInfo();
        }
        
        return info;
    }
}

