
import java.util.ArrayList;
import java.util.List;

public class Program2Enrollments {
    public static void main(String[] args)  {

        List<Course> courseList = new ArrayList<>();

        Course englishCourse = new Course("English");
        Course mathsCourse = new Course("Math");

        courseList.add( englishCourse );
        courseList.add( mathsCourse );

        Student student1 = new Student("Tom C", "tom@study.com", "12");
        Student student2 = new Student("Bob R", "bob@study.com", "13");
        Student student3 = new Student("Stan L", "stan@study.com", "14");

        //Course engCourse = courseList.stream().filter(x -> x.getCourseName().equals("English")).findFirst().orElse(null);
        //Course mathCourse = courseList.stream().filter(x -> x.getCourseName().equals("Math")).findFirst().orElse(null);

        try {
            englishCourse.addStudent(student1, 2);
        } catch (StudentAlreadyEnrolledInCourseException e) {
            System.out.println("Unable to enroll " + student1.getDetails() + " already enrolled in " + englishCourse.getCourseName());
        } catch ( GradeOutOfRangeException e){
            System.out.println(student1.getDetails() + " grades are invalid, must be > 0 or <= 100");
        }

        try {
            englishCourse.addStudent(student2, 1);

        } catch (StudentAlreadyEnrolledInCourseException e) {
            System.out.println("Unable to enroll " + student2.getDetails() + " already enrolled in " + englishCourse.getCourseName());
        } catch ( GradeOutOfRangeException e){
            System.out.println(student2.getDetails() + " grades are invalid, must be > 0 or <= 100");
        }

        try {
            englishCourse.addStudent(student3, 6);

        } catch (StudentAlreadyEnrolledInCourseException e) {
            System.out.println("Unable to enroll " + student3.getDetails() + " already enrolled in " + englishCourse.getCourseName());
        } catch ( GradeOutOfRangeException e){
            System.out.println(student3.getDetails() + " grades are invalid, must be > 0 or <= 100");
        }

        try {
            mathsCourse.addStudent(student2, 1);
        } catch (StudentAlreadyEnrolledInCourseException e) {
            System.out.println("Unable to enroll " + student2.getDetails() + " already enrolled in " + mathsCourse.getCourseName());
        } catch ( GradeOutOfRangeException e){
            System.out.println(student2.getDetails() + " grades are invalid, must be > 0 or <= 100");
        }

        try {
            mathsCourse.addStudent(student3, 102);
        } catch (StudentAlreadyEnrolledInCourseException e) {
            System.out.println("Unable to enroll " + student3.getDetails() + " already enrolled in " + mathsCourse.getCourseName());
        } catch ( GradeOutOfRangeException e){
            System.out.println(student3.getDetails() + " grades are invalid, must be > 0 or <= 100");
        }

        try {
            mathsCourse.addStudent(student3, 6);
        } catch (StudentAlreadyEnrolledInCourseException e) {
            System.out.println("Unable to enroll " + student3.getDetails() + " already enrolled in " + mathsCourse.getCourseName());
        } catch ( GradeOutOfRangeException e){
            System.out.println(student3.getDetails() + " grades are invalid, must be > 0 or <= 100");
        }
        
        
        

        for(Course course : courseList){

            List<Enrollment> allEnrollments = new ArrayList<>();
            allEnrollments.addAll(course.getEnrollments());

            for(Enrollment enr : allEnrollments){
                System.out.println(enr.getStudent().getDetails() + " - Grade: " + enr.getGrade());
            }

        }


        try {
            mathsCourse.removeStudent(student1);
        } catch (StudentDoesntExistInCourseException e) {
            System.out.println(student1.getDetails() + " is not enrolled in " + mathsCourse.getCourseName());
        }

    }
}
