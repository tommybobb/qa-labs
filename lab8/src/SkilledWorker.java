
import java.util.ArrayList;

public class SkilledWorker extends Employee {
    
    ArrayList<String> skills;


    public SkilledWorker(String name, String jobTitle) {
        super(name, jobTitle);
        this.skills = new ArrayList<>();
    }

    public void addSkill(String skill) {
        skills.add(skill);
    }
}
