public class ProgramEmp {
    public static void main(String[] args) {
        
        Manager manager = new Manager("Tom C", "Senior Manager");

        Employee emp1 = new Employee("Bob R", "Advisor");
        Employee emp2 = new Employee("Stan L", "Senior Advisor");

        manager.addEmployee(emp1);
        manager.addEmployee(emp2);

        SkilledWorker skillEmp = new SkilledWorker("Mike C", "Tech Advisor");

        manager.addEmployee(skillEmp);

        Manager newMgr = new Manager("Pete D", "Tech Managers");
        manager.addEmployee(newMgr);

        System.out.println(manager.getInfo());

    }
}
