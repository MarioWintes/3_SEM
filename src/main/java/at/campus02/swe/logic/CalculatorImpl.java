package at.campus02.swe.logic;


import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;

import java.util.Stack;

public class CalculatorImpl implements Calculator {

    private Stack<Double> stack_ = new Stack<Double>();

    @Override
    public double perform(Operation op) throws CalculatorException {

        if(op == Operation.dotproduct){
            return performDotProduct();
        }else{
            double b = pop();
            double a = pop();

        switch (op) {
            case add:
                return a + b;
            case sub:
                return a - b;
            case div:
                double c = a / b;
                if (Double.isInfinite(c))
                    throw new CalculatorException("Division by zero");
                return c;
            case mul:
                return a * b;
            case mod:
                return a % b;
            case sin:
                push(a);
                return Math.sin(Math.toRadians(b));
            case cos:
                push(a);
                return Math.cos(Math.toRadians(b));
        }
        return 0;}
    }

    private double performDotProduct() throws CalculatorException {
        int n = (int) pop(); // Number of elements

        // Exception handling
        if (n <= 0)
            throw new CalculatorException("Vector size must be positive");

        if (stack_.size() < 2 * n)
            throw new CalculatorException("Not enough elements on stack for dotproduct");

        // Create vector
        double[] bVec = new double[n];
        double[] aVec = new double[n];

        // Read second vector
        for (int i = n - 1; i >= 0; i--) {
            bVec[i] = pop();
        }

        // Read first vector
        for (int i = n - 1; i >= 0; i--) {
            aVec[i] = pop();
        }

        double result = 0;
        // Calc result
        for (int i = 0; i < n; i++) {
            result += aVec[i] * bVec[i];
        }

        return result;
    }


    @Override
    public double pop() throws CalculatorException {
        if (stack_.isEmpty())
            throw new CalculatorException();
        return stack_.pop();
    }

    @Override
    public void push(double v) {
        stack_.push(v);
    }

    @Override
    public void clear() {
        stack_.clear();
    }

}
