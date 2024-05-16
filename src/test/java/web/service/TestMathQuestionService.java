package web.service;
import org.junit.Assert;
import org.junit.Test;
import web.service.MathQuestionService;

public class TestMathQuestionService {

    @Test
    public void testTrueAdd() {
        Assert.assertEquals(3.0, MathQuestionService.q1Addition("1", "2"), 0);
    }

    @Test
    public void testAddNumber1Empty() {
        Assert.assertNull(MathQuestionService.q1Addition("", "2"));
    }   
    
    @Test
    public void testAddNumber2Empty() {
        Assert.assertNull(MathQuestionService.q1Addition("1", ""));
    }

    @Test
    public void testAddBothNumbersEmpty() {
        Assert.assertNull(MathQuestionService.q1Addition("", ""));
    }

    @Test
    public void testAddNonNumericInput() {
        Assert.assertNull(MathQuestionService.q1Addition("a", "2"));
    }

    @Test
    public void testAddNumber1Negative() {
        Assert.assertEquals(-1.0, MathQuestionService.q1Addition("-1", "0"), 0);
    }

    @Test
    public void testAddNumber2Negative() {
        Assert.assertEquals(-1.0, MathQuestionService.q1Addition("0", "-1"), 0);
    }

    @Test
    public void testAddBothNumbersNegative() {
        Assert.assertEquals(-3.0, MathQuestionService.q1Addition("-1", "-2"), 0);
    }

    @Test
    public void testAddWithZero() {
        Assert.assertEquals(2.0, MathQuestionService.q1Addition("2", "0"), 0);
    }

    // Update for non-numeric input
    @Test
    public void testAddWithNonNumericInput() {
        Assert.assertNull(MathQuestionService.q1Addition("a", "b"));
    }

    // Update for non-numeric input
    @Test
    public void testAddWithOneNonNumericInput() {
        Assert.assertNull(MathQuestionService.q1Addition("1", "b"));
    }

    @Test
    public void testTrueSubtract() {
        Assert.assertEquals(1.0, MathQuestionService.q2Subtraction("3", "2"), 0);
    }

    @Test
    public void testSubtractNumber1Empty() {
        Assert.assertNull(MathQuestionService.q2Subtraction("", "2"));
    }

    @Test
    public void testSubtractNumber2Empty() {
        Assert.assertNull(MathQuestionService.q2Subtraction("3", ""));
    }

    @Test
    public void testSubtractBothNumbersEmpty() {
        Assert.assertNull(MathQuestionService.q2Subtraction("", ""));
    }

    @Test
    public void testSubtractNonNumericInput() {
        Assert.assertNull(MathQuestionService.q2Subtraction("a", "2"));
    }

    @Test
    public void testSubtractNumber1Negative() {
        Assert.assertEquals(-3.0, MathQuestionService.q2Subtraction("-1", "2"), 0);
    }

    @Test
    public void testSubtractNumber2Negative() {
        Assert.assertEquals(3.0, MathQuestionService.q2Subtraction("1", "-2"), 0);
    }

    @Test
    public void testSubtractBothNumbersNegative() {
        Assert.assertEquals(1.0, MathQuestionService.q2Subtraction("-1", "-2"), 0);
    }

    @Test
    public void testSubtractWithZero() {
        Assert.assertEquals(2.0, MathQuestionService.q2Subtraction("2", "0"), 0);
    }

    @Test
    public void testTrueMultiply() {
        Assert.assertEquals(6.0, MathQuestionService.q3Multiplication("2", "3"), 0);
    }

    @Test
    public void testMultiplyNumber1Empty() {
        Assert.assertNull(MathQuestionService.q3Multiplication("", "2"));
    }

    @Test
    public void testMultiplyNumber2Empty() {
        Assert.assertNull(MathQuestionService.q3Multiplication("3", ""));
    }

    @Test
    public void testMultiplyBothNumbersEmpty() {
        Assert.assertNull(MathQuestionService.q3Multiplication("", ""));
    }

    @Test
    public void testMultiplyNonNumericInput() {
        Assert.assertNull(MathQuestionService.q3Multiplication("a", "2"));
    }

    @Test
    public void testMultiplyNumber1Negative() {
        Assert.assertEquals(-2.0, MathQuestionService.q3Multiplication("-1", "2"), 0);
    }

    @Test
    public void testMultiplyNumber2Negative() {
        Assert.assertEquals(-2.0, MathQuestionService.q3Multiplication("1", "-2"), 0);
    }

    @Test
    public void testMultiplyBothNumbersNegative() {
        Assert.assertEquals(2.0, MathQuestionService.q3Multiplication("-1", "-2"), 0);
    }

    @Test
    public void testMultiplyWithZero() {
        Assert.assertEquals(0.0, MathQuestionService.q3Multiplication("2", "0"), 0);
    }
}
