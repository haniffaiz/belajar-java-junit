package programmer.zaman.now.test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import programmer.zaman.now.test.resolver.RandomParameterResolver;

import java.util.Random;

//dependensi injection junit

public class RandomCalculatorTest extends AbstractCalculatorTest{



    @Test
    void testRandom(Random random) {
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a,b);
        var expected = a + b;

        Assertions.assertEquals(expected,result);
    }

    @DisplayName("Test random calculator")
    //perulangan test tiap methode
    @RepeatedTest(
            value = 10,
            name = "{displayName} ke {currentRepetition} dari {totalRepetitions}"
    )
    void testRandomRepeat(Random random) {
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a,b);
        var expected = a + b;

        Assertions.assertEquals(expected,result);
    }

    @DisplayName("Test random calculator")
    //perulangan test tiap methode
    @RepeatedTest(
            value = 10,
            name = "{displayName}"
    )
    void testRandomRepeat(TestInfo info,Random random, RepetitionInfo repetitionInfo) {
        System.out.println(info.getDisplayName() + " ke "+repetitionInfo.getCurrentRepetition()+" dari" + repetitionInfo.getTotalRepetitions());
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a,b);
        var expected = a + b;

        Assertions.assertEquals(expected,result);
    }
}
