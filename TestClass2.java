public class TestClass2 {

    public static void main(String[] args) {
        System.out.println("Executing automated test case2...");
        
        String expected = "pass";
        String actual = "pass";

        if (expected.equals(actual)) {
            System.out.println("Test2 Passed!");
        } else {
            System.out.println("Test2 Failed!");
        }
    }
}
