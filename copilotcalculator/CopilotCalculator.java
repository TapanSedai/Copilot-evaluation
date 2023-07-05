package copilotcalculator;

import java.util.Stack;

public class CopilotCalculator{
    // calculator capable of receiving any no of args and providing correct output
    // eg :  input "2+3*4/2" output "8"
    // eg :  input "2+3*4/2+1" output "9"
    // eg :  input "2+3*4/2+1*2" output "11"
    // eg :  input "2+3*4/2+1*2+1" output "12"

    public double sum(double a, double b){
        return a+b;
    }

    public double sub(double a, double b){
        return a-b;
    }

    public double mul(double a, double b){
        return a*b;
    }

    public double div(double a, double b){
        if(b==0){
            throw new IllegalArgumentException("Divisor cannot be zero");
        }
        return a/b;
    }

    // apply bodmas rule

    public Double calculate(String arithmeticExpression){
        Stack<Double> operands = new Stack<Double>();
        Stack<Character> operators = new Stack<Character>();
        int i = 0;
        while(i < arithmeticExpression.length()){
            char c = arithmeticExpression.charAt(i);
            if(c == ' '){
                i++;
                continue;
            }
            if(Character.isDigit(c)){
                double num = 0;
                while(i < arithmeticExpression.length() && Character.isDigit(arithmeticExpression.charAt(i))){
                    num = num*10 + (arithmeticExpression.charAt(i) - '0');
                    i++;
                }
                operands.push(num);
            }
            else if(c == '('){
                operators.push(c);
                i++;
            }
            else if(c == ')'){
                while(operators.peek() != '('){
                    operands.push(applyOperation(operators.pop(), operands.pop(), operands.pop()));
                }
                operators.pop();
                i++;
            }
            else if(c == '+' || c == '-' || c == '*' || c == '/'){
                while(!operators.empty() && hasPrecedence(c, operators.peek())){
                    operands.push(applyOperation(operators.pop(), operands.pop(), operands.pop()));
                }
                operators.push(c);
                i++;
            }
            else{
                throw new IllegalArgumentException("Invalid character");
            }
        }
        while(!operators.empty()){
            operands.push(applyOperation(operators.pop(), operands.pop(), operands.pop()));
        }
        return operands.pop();
    }

    public double applyOperation(char operator, double b, double a){
        switch(operator){
            case '+':
                return sum(a, b);
            case '-':
                return sub(a, b);
            case '*':
                return mul(a, b);
            case '/':
                return div(a, b);
        }
        return 0;
    }

    public boolean hasPrecedence(char operator1, char operator2){
        if(operator2 == '(' || operator2 == ')'){
            return false;
        }
        if((operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-')){
            return false;
        }
        else{
            return true;
        }
    }

}
