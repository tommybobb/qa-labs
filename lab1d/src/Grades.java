public class Grades {
    public static void main(String[] args) {
        String[] students = { "Alice", "Bob", "Charlie", "Diana", "Ethan" };
        int[] marks = { 85, 67, 45, 90, 55 };

        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i] + ": " + getGrade(marks[i]));
        }
    }

    static String getGrade (int mark){
        if (mark < 1 || mark > 100) {
            return "Error: marks must be between 1..100";
        }

        if (mark >= 70){
            return "You have earned a Distinction.";
        } else if (mark > 60){
            return "You have earned a Merit.";
        } else if (mark > 50){
            return "You have earned a Pass.";
        } else {
            return "You have failed your exam.";
        }
    }
}
