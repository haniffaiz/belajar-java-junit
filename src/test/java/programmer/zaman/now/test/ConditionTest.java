package programmer.zaman.now.test;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.util.Properties;

public class ConditionTest {

    @Test
    void testSystemProperties() {
        Properties properties = System.getProperties();
        properties.forEach((key,value)->System.out.println(key+":"+value));
    }

    //dijalankan pada OS terlampir
    @Test
    @EnabledOnOs({OS.WINDOWS})
    public void testRunOnlyOnWindows(){

    }

    //dilewati pada OS terlampir
    @Test
    @DisabledOnOs({OS.WINDOWS})
    public void testDisabledOnWindows(){

    }

    //dijalankan pada Java 21
    @Test
    @EnabledOnJre({JRE.JAVA_21})
    void testEnabledOnJava21() {
    }

    //dilewati pada Java 21
    @Test
    @DisabledOnJre({JRE.JAVA_21})
    void testDisabledOnJava21() {
    }

    //dijalankan untuk JRE 8 ke 21
    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_21)
    void testEnabledOnJava8To21() {
    }

    //dilewati untuk JRE 8 ke 21
    @Test
    @DisabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_21)
    void testDisabledOnJava8To21() {
    }

    //dijalankan pada Java Vendor Oracle
    @Test
    @EnabledIfSystemProperties({
            @EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    })
    void testEnabledOnJavaVendorOracle() {
    }

    //dilewati pada Java Vendor Oracle
    @Test
    @DisabledIfSystemProperties({
            @DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")

    })
    void testDisabledOnJavaVendorOracle() {
    }

    //dijalankan pada ENV DEV
    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    void testEnabledOnProfileDev() {
    }

    //dilewati pada ENV DEV
    @Test
    @DisabledIfEnvironmentVariables({
            @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    void testDisabledOnProfileDev() {
    }
}
