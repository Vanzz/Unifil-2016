

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class FibonacciTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class FibonacciTest
{
    /**
     * Default constructor for test class FibonacciTest
     */
    public FibonacciTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    @Test
    public void fibTest() {
        assertEquals(0, Fibonacci.fib(0));
        assertEquals(1, Fibonacci.fib(1));
        assertEquals(1, Fibonacci.fib(2));
        assertEquals(2, Fibonacci.fib(3));
        assertEquals(3, Fibonacci.fib(4));
        assertEquals(5, Fibonacci.fib(5));
        assertEquals(8, Fibonacci.fib(6));
    }
    
    @Test
    public void rec_fibTest() {
        assertEquals(0, Fibonacci.rec_fib(0));
        assertEquals(1, Fibonacci.rec_fib(1));
        assertEquals(1, Fibonacci.rec_fib(2));
        assertEquals(2, Fibonacci.rec_fib(3));
        assertEquals(3, Fibonacci.rec_fib(4));
        assertEquals(5, Fibonacci.rec_fib(5));
        assertEquals(8, Fibonacci.rec_fib(6));
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
