package aguspriyatin.wordpress.com.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.util.Properties;

public class ConditionTest {

    @Test
    @EnabledOnOs({OS.WINDOWS})
    public void testRunOnlyOnWindows(){

    }

    @Test
    @DisabledOnOs({OS.WINDOWS})
    public void testDisabledOnWindows(){

    }

    @Test
    @EnabledOnJre({JRE.JAVA_11})
    public void testEnabledOnJRE11(){

    }

    @Test
    @DisabledOnJre({JRE.JAVA_11})
    public void testDisabledOnJRE11(){

    }

    @Test
    @EnabledForJreRange(min=JRE.JAVA_11, max = JRE.JAVA_15)
    public void testEnabledOnJRE11To15(){

    }

    @Test
    public void testSystemProperties(){
        Properties properties = System.getProperties();
        properties.forEach((key,value)-> System.out.println(key + ":" + value));
    }

    @Test
    @EnabledIfSystemProperties({
            @EnabledIfSystemProperty(named = "java.vendor",matches = "Oracle Corporation")
    })
    public void testEnableOnJavaVendorOracle(){

    }

    @Test
    @DisabledIfSystemProperties({
            @DisabledIfSystemProperty(named = "java.vendor",matches = "Oracle Corporation")
    })
    public void testDisableOnJavaVendorOracle(){

    }

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")})
            public void testEnableOnProfileDev(){

            }
}
