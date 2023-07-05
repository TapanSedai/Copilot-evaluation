package copilotcalculator.tests;

import java.util.ArrayList;

import copilotcalculator.CopilotCalculator;

public class CopilotCalculatorUnitTest {

    // copilot calculator test

    static int errorCount = 0;
    static int testCount = 0;
    static ArrayList<String> exceptions = new ArrayList<String>();

    public void testCalculator(String exp, double expected){
        testCount++;
        CopilotCalculator copilotCalculator = new CopilotCalculator();
        try{
        Assertions.assertEquals(expected, copilotCalculator.calculate(exp));
        }
        catch(AssertionError e){
            exceptions.add(testCount + " " + e.getMessage());
            errorCount++;
        }
    }

    public static void main(String[] args) {
        CopilotCalculatorUnitTest copilotCalculatorUnitTest = new CopilotCalculatorUnitTest();
        copilotCalculatorUnitTest.testCalculator("2+3", 5);
        copilotCalculatorUnitTest.testCalculator("2+3*4/2", 8);
        copilotCalculatorUnitTest.testCalculator("2+3*4/2+1", 9);
        copilotCalculatorUnitTest.testCalculator("2*5*3+6/8", 30.75);
        copilotCalculatorUnitTest.testCalculator("999/111", 9);
        copilotCalculatorUnitTest.testCalculator("7-4-3", 0);
        copilotCalculatorUnitTest.testCalculator("7-4-3*2", -3);
        copilotCalculatorUnitTest.testCalculator("9002*4500", 40509000);
        copilotCalculatorUnitTest.testCalculator("(8+2)*(10-4)/2+6-3*(5-1)", 24);

        System.out.println("Testcases passed: " + (testCount - errorCount) + "/" + testCount);

        for(String exception: exceptions)
            System.out.println(exception);
    }
    
}
