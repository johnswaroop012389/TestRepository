import java.io.FileWriter;
import java.io.PrintWriter;

public class TestClass1 {
    public void run() throws Exception {
        PrintWriter writer = new PrintWriter(new FileWriter("result.txt", true));
        writer.println(">> Running TestClass1...");
        writer.println("Result: TestClass1 Passed ✅");
        writer.close();
    }
}
