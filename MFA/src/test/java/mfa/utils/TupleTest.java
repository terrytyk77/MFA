
package mfa.utils;

import org.junit.jupiter.api.*;

/**
 *
 * @author Terry Keyrouz
 */
public class TupleTest {

    /**
     * Test tuple creation
     */
    @Test
    void testTuples(){
        Tuple<Boolean, String> tuple1 = new Tuple<>(false, "Error");
        Tuple<Integer, String> tuple2 = new Tuple<>(404, "Not Found");
        Tuple<Float, Character> tuple3 = new Tuple<>(7.7f, 'L');
        Tuple<Float, Character> tuple4 = new Tuple<>(null, null);

        Assertions.assertNotNull(tuple1.getFirst());
        Assertions.assertNotNull(tuple1.getSecond());

        Assertions.assertEquals(tuple1.getFirst(), false);
        Assertions.assertEquals(tuple1.getSecond(), "Error");

        Assertions.assertEquals(tuple2.getFirst(), 404);
        Assertions.assertEquals(tuple2.getSecond(), "Not Found");

        Assertions.assertEquals(tuple3.getFirst(), 7.7f);
        Assertions.assertEquals(tuple3.getSecond(), 'L');

        Assertions.assertNull(tuple4.getFirst());
        Assertions.assertNull(tuple4.getSecond());
    }
}