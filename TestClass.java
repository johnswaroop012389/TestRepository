import java.io.FileWriter;
import java.io.PrintWriter;

public class TestClass {
    public static void main(String[] args) throws Exception {
        String runTarget = args.length > 0 ? args[0] : "both";

        // Overwrite result.txt with header
        PrintWriter writer = new PrintWriter("result.txt");
        writer.println("== Java Test Execution Results ==");
        writer.println("Run Target: " + runTarget);
        writer.close();

        if ("class1".equalsIgnoreCase(runTarget)) {
            new TestClass1().run();
        } else if ("class2".equalsIgnoreCase(runTarget)) {
            new TestClass2().run();
        } else {
            new TestClass1().run();
            new TestClass2().run();
        }
    }
}
