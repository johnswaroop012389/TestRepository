import java.io.FileWriter;
import java.io.PrintWriter;

public class TestClass2 {
    public void run() throws Exception {
        PrintWriter writer = new PrintWriter(new FileWriter("result.txt", true));
        writer.println(">> Running TestClass2...");
        writer.println("Result: TestClass2 Passed ✅");
        writer.close();
    }
}
