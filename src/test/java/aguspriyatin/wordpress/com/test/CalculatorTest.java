package aguspriyatin.wordpress.com.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import aguspriyatin.wordpress.com.test.generator.SimpleDisplayNameGenerator;
import org.junit.jupiter.api.*;
import org.opentest4j.TestAbortedException;

//@DisplayName("Test Calculator")
@DisplayNameGeneration(value= SimpleDisplayNameGenerator.class)
public class CalculatorTest {

    private Calculator calculator = new Calculator();


    @BeforeAll
    public static void beforeALl(){
        System.out.println("before all");
    }

    @AfterAll
    public static void afterALl(){
        System.out.println("after all");
    }

    @BeforeEach
    public void setUp(){
        System.out.println("before each");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("after each");
    }
    @Test
//    @DisplayName("test function calculator.add(Integer, Integer)")
    public void testAddSuccess(){
        var result = calculator.add(2,2);
        assertEquals(4,result);
    }

    @Test
//    @DisplayName("test function calculator.divide(Integer, Integer)")
    public void testDivideSuccess(){
        var result = calculator.divide(10,5);
        assertEquals(2,result);
    }

    @Test
//    @DisplayName("test function calculator.divide(Integer, Integer) when divide by zero")
    public void testDivideError(){
        assertThrows(IllegalArgumentException.class,()-> calculator.divide(10,0));
    }

    @Test
    @Disabled
    public void skipTest(){

    }

    @Test
    public void testAborted(){
        var profile = System.getenv("PROFILE");
        if(!"DEV".equals(profile)){
            throw new TestAbortedException("test dibatalkan karena profile environtment bukan DEV");
        }
        // unit test DEV
    }

    @Test
    public void testAssumption(){
        assumeTrue("PROD".equals(System.getenv("PROFILE")));
        // test DEV unit test
    }
}
