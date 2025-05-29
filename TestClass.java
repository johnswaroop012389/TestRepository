public class TestClass {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide input: TestClass1, TestClass2, or Both");
            return;
        }

        String input = args[0];

        switch (input.toLowerCase()) {
            case "test1":
                new TestClass1().test1_method();
                break;

            case "test2":
                new TestClass2().test2_method();
                break;

            case "both":
                new TestClass1().test1_method();
                new TestClass2().test2_method();
                break;

            default:
                System.out.println("Invalid input. Use: TestClass1, TestClass2, or Both");
        }
    }
}
