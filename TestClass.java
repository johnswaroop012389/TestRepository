import java.io.FileWriter;
import java.io.PrintWriter;

public class TestClass {
    public static void main(String[] args) throws Exception {
        String runTarget = args.length > 0 ? args[0].toLowerCase() : "both";

        PrintWriter writer = new PrintWriter("result.txt");
        writer.println("== Java Test Execution Results ==");
        writer.println("Run Target: " + runTarget);
        writer.println("DEBUG: runTarget (toLowerCase) = " + runTarget);
        writer.close();

        switch (runTarget) {
            case "class1":
                new TestClass1().run();
                break;
            case "class2":
                new TestClass2().run();
                break;
            case "both":
                new TestClass1().run();
                new TestClass2().run();
                break;
            default:
                PrintWriter errorWriter = new PrintWriter(new FileWriter("result.txt", true));
                errorWriter.println("❌ Invalid input: " + runTarget);
                errorWriter.println("Please use one of: class1, class2, both");
                errorWriter.close();
                break;
        }
    }
}
