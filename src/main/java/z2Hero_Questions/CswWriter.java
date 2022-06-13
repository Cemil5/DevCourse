package z2Hero_Questions;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CswWriter {
    public static void main(String[] args) {

        try (PrintWriter writer = new PrintWriter("test.csv")) {

            StringBuilder sb = new StringBuilder();
            sb.append("id");
            sb.append(',');
            sb.append("Name");
            sb.append('\n');

            sb.append("1");
            sb.append(',');
            sb.append("Cydeo School");
            sb.append('\n');

            sb.append("1");
            sb.append(',');
            sb.append("Cydeo School");
            sb.append('\n');

            writer.write(sb.toString());

            System.out.println("done!");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
