public class StudentAlreadyEnrolledInCourseException extends Exception {
    
    public StudentAlreadyEnrolledInCourseException(){
        super("This student is already enrolled in this course");
    }

}

