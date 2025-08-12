import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {
        
        String[] courses = readCSV("src/course.txt");
        String[] trainers = readCSV("src/trainer.txt");

        

        BufferedWriter writer = new BufferedWriter(new FileWriter("src/trainersAndCourses.txt"));

        for(String course : courses){
            writer.write(course);
            writer.newLine();
        }

        for(String trainer : trainers){
            writer.write(trainer);
            writer.newLine();
        }

        writer.close();
        
    }

    private static String[] readCSV(String inFile) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(inFile));
        String line = br.readLine(); 
        br.close();

        if (line != null) {
            return line.split(",");
        } else {
            return new String[0]; 
        }

    }


}
