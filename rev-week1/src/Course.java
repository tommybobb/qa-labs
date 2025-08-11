
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Course {
    private String courseName;
    private HashMap<Student, Integer> studentGrades; //OLD
    private List<Enrollment> enrollments; //IMPROVED

    public Course(String courseName) {
        this.courseName = courseName;
        this.studentGrades = new HashMap<>();
        this.enrollments = new ArrayList<>();
    }

    public String getCourseName(){
        return this.courseName;
    }

    public void addStudent(Student s, int grade) throws StudentAlreadyEnrolledInCourseException, GradeOutOfRangeException{

        //OLD
        if(studentGrades.get(s) != null ){
            throw new StudentAlreadyEnrolledInCourseException();
        }

        if(grade <= 0 || grade > 100){
            throw new GradeOutOfRangeException();
        }

        studentGrades.put(s, grade);

        // IMPROVED
        if(findEnrollment(s) != null ){
            throw new StudentAlreadyEnrolledInCourseException();
        }

        if(grade <= 0 || grade > 100){
            throw new GradeOutOfRangeException();
        }

        enrollments.add( new Enrollment(s,this, grade));

    }

    private Enrollment findEnrollment(Student s) {
        return enrollments.stream()
                .filter(enrollment -> enrollment.getStudent().equals(s))
                .findFirst()
                .orElse(null);
    }

    public void removeStudent(Student s) throws StudentDoesntExistInCourseException{

        if(studentGrades.get(s) == null ){
            throw new StudentDoesntExistInCourseException();
        }

        studentGrades.remove(s);

        Enrollment enrollment = findEnrollment(s);
        if(enrollment == null ){
            throw new StudentDoesntExistInCourseException();
        }

        enrollments.remove(enrollment);

    }

    public List<Enrollment> getEnrollments() {
        return new ArrayList<>(enrollments);
    }

    public void printStudentList(){

        for(Student student : studentGrades.keySet()){

            student.getDetails();
            System.out.println("Student:" + student.getDetails() + " -- Grade: " + studentGrades.get(student));

        }

    }


}
