public class TestClass1 {

    public static void main(String[] args) {
        System.out.println("Executing automated test case1...");
        
        String expected = "pass";
        String actual = "pass";

        if (expected.equals(actual)) {
            System.out.println("Test1 Passed!");
        } else {
            System.out.println("Test1 Failed!");
        }
    }
}
