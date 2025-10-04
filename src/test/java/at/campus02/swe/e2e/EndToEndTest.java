package at.campus02.swe.e2e;

import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;
import at.campus02.swe.logic.CalculatorImpl;
import at.campus02.swe.parser.Parser;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class EndToEndTest {

    @Test
    public void e2eTestAdd() throws CalculatorException, XMLStreamException, FileNotFoundException {

        Calculator calculator = new CalculatorImpl();
        Parser parser = new Parser(calculator);
        File file = new File("src/test/resources/test01.xml");
        double result = parser.parse(file);

        assertEquals(3, result, 0);
    }
    @Test
    public void e2eTestSubtraction() throws CalculatorException, XMLStreamException, FileNotFoundException {
        Calculator calculator = new CalculatorImpl();
        Parser parser = new Parser(calculator);
        File file = new File("src/test/resources/test05.xml");
        double result = parser.parse(file);

        assertEquals(-1,result,0);
    }
    @Test
    public void e2eTestModulo() throws CalculatorException, XMLStreamException, FileNotFoundException {
        Calculator calculator = new CalculatorImpl();
        Parser parser = new Parser(calculator);
        File file = new File("src/test/resources/test04.xml");
        double result = parser.parse(file);

        assertEquals(2,result,0);
    }
    @Test
    public void e2eTestDivide() throws CalculatorException, XMLStreamException, FileNotFoundException {
        Calculator calculator = new CalculatorImpl();
        Parser parser = new Parser(calculator);
        File file = new File("src/test/resources/test06.xml");
        double result = parser.parse(file);

        assertEquals(5,result,0);
    }
}
