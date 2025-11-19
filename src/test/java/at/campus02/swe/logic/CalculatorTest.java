package at.campus02.swe.logic;

import org.junit.Test;

import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;
import at.campus02.swe.Calculator.Operation;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testSimpleAddOperation() throws Exception {

        //setup
        Calculator calc = new CalculatorImpl();

        //execute
        calc.push(2.0);
        calc.push(3);
        double result = calc.perform(Operation.add);

        //verify
        assertEquals(5, result, 0);


    }

    @Test
    public void testSimpleModOperationOne() throws Exception {
        Calculator calc = new CalculatorImpl();

        calc.push(3);
        calc.push(2);
        double result = calc.perform(Operation.mod);

        assertEquals(1, result, 0);
    }


    @Test
    public void testSimpleModOperationTwo() throws Exception {
        Calculator calc = new CalculatorImpl();

        calc.push(10);
        calc.push(4);
        double result = calc.perform(Operation.mod);

        assertEquals(2, result, 0);
    }

    @Test
    public void testSimpleModOperationNegativ() throws Exception {
        Calculator calc = new CalculatorImpl();

        calc.push(5); // only one value pushed

        try {
            calc.perform(Operation.mod);
            fail("Exception expected");
        } catch (CalculatorException e) {
            // Only Check if exception was raised
            assertNotNull(e);
        }
    }


    @Test
    public void testSimpleMulOperation() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(2.0);
        calc.push(3);
        double result = calc.perform(Operation.mul);

        assertEquals(6, result, 0);

    }

    @Test
    public void testSimpleDivOperation() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(6.0);
        calc.push(2);
        double result = calc.perform(Operation.div);

        assertEquals(3, result, 0);

    }

    @Test
    public void testSimpleSinOperation() throws Exception{

        Calculator calc = new CalculatorImpl();
        calc.push(5);
        double result = calc.perform(Operation.sin);

        assertEquals(0.087155742, result, 0.00000001);
    }
    @Test
    public void testSimpleCosOperation() throws Exception{

        Calculator calc = new CalculatorImpl();
        calc.push(8);
        double result = calc.perform(Operation.cos);

        assertEquals(0.990268068, result, 0.00000001);
    }



    @Test(expected = CalculatorException.class)
    public void testPopOnEmptyStack() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.pop();

    }

    @Test
    public void testDivisionByZero() throws Exception {

        //Setup
        Calculator calc = new CalculatorImpl();
        try {
            calc.push(2);
            calc.push(0);
            calc.perform(Operation.div);

            fail("Exception expected");


        } catch (CalculatorException e) {
            assertEquals("Division by zero", e.getMessage());
            // e.getCause()
        }

    }
    @Test
    public void testDotProductPositive() throws Exception {
        // Setup
        Calculator calc = new CalculatorImpl();

        calc.push(1);
        calc.push(3);

        calc.push(2);
        calc.push(4);

        // Number of elements
        calc.push(2);

        double result = calc.perform(Operation.dotproduct);

        assertEquals(14, result, 0.0001);
    }

    @Test
    public void testNotEnoughElements() throws Exception {
        // setup
        Calculator calc = new CalculatorImpl();

        calc.push(1);
        calc.push(2);
        calc.push(3);
        // Push wrong length
        calc.push(3);

        try {
            calc.perform(Operation.dotproduct);
            fail("Exception expected");
        } catch (CalculatorException e) {
            assertEquals("Not enough elements on stack for dotproduct", e.getMessage());
        }
    }
}