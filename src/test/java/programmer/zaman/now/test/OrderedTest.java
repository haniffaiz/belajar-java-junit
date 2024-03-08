package programmer.zaman.now.test;

import org.junit.jupiter.api.*;

//test dijalankan per method
//@TestInstance(TestInstance.Lifecycle.PER_METHOD)

//test dijalankan per class (sharing variable)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)


//Mengurutkan test
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTest {

    private int counter = 0;

    @BeforeAll
    void beforeAll(){

    }

    @AfterAll
    void afterAll(){

    }

    @Test
    @Order(1)
    void test3() {
        counter++;
        System.out.println(counter);
    }

    @Test
    @Order(2)
    void test2() {
        counter++;
        System.out.println(counter);
    }

    @Test
    @Order(3)
    void test1() {
        counter++;
        System.out.println(counter);
    }
}
