public class TestClass2 {

     public void test2_method() {
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
