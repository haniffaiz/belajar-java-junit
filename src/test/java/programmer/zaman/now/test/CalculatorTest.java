package programmer.zaman.now.test;

import org.junit.jupiter.api.*;
import org.opentest4j.TestAbortedException;
import programmer.zaman.now.test.generator.SimpleDisplayNameGenerator;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
//@DisplayName("Test untuk Calculator class")
public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @BeforeAll //harus statik
    public static void beforeAll(){
        System.out.println("Before all");
    }

    @AfterAll //harus statik
    public static void afterAll(){
        System.out.println("After all");
    }

    @BeforeEach
    public void setUp(){
        System.out.println("Before each");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("After each");
    }

    @Test
    @DisplayName("Test skenario sukses method add()")
    public void testAddSuccess(){
        var result = calculator.add(10, 10);

        assertEquals(20, result);

//        if(result != 20){
//            throw new RuntimeException("Test gagal");
//        }
    }

    @Test
    public void testDivideSuccess(){
        var result = calculator.divide(100, 10);
        assertEquals(10, result);
    }

    @Test
    public void testDivideFailed(){
        assertThrows(IllegalArgumentException.class, ()->{
            calculator.divide(10, 0);
        });
    }

    @Test
    @Disabled
    public void testComingsoon(){

    }

    @Test
    public void testAborted(){
        var profile = System.getenv("PROFILE");
        if(!"DEV".equals(profile)){
            throw  new TestAbortedException("Test dibatalkan karena bukan DEV");
        }
        //unit test untuk DEV
    }
}
