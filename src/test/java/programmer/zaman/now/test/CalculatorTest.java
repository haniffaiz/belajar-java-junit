package programmer.zaman.now.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.test.generator.SimpleDisplayNameGenerator;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
//@DisplayName("Test untuk Calculator class")
public class CalculatorTest {

    private Calculator calculator = new Calculator();

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
}
