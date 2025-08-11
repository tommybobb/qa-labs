public class StudentDoesntExistInCourseException extends Exception {
    
    public StudentDoesntExistInCourseException(){
        super("This student doesn't exist in this course");
    }

}
