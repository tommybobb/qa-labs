
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class App {


    public static void main(String[] args) throws Exception {

        try {
            log("hello world");
        } catch (Exception e) {
            System.out.println("An error occured");
        }

    }

    private static void log(String msg) throws IOException{
		File file = new File("log.txt");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter br = new BufferedWriter(fr);
        br.write(msg + "\r\n");
        br.close();
        fr.close();
    }

}
