public class GradeOutOfRangeException extends Exception {
    
    public GradeOutOfRangeException(){
        super("Grades must be > 0 or <= 100");
    }

}

