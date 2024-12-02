import java.io.*;
import java.util.Scanner;
/**
 * Class contains methods for checking the operator and evaluation of 
 * a single postfix expression 
 * 
 * @author Marie Nguyen 
 * @version April 7th, 2022
 */

public class Evaluator {
    // Instance properties
    private String expression;
    private StackLL<Integer> stackEvaluator;

    /**
     * Constructor
     * @param givenExpression postfix equation in each line of the file 
     * create a stack for keeping track on the numbers in the expression 
     */
    public Evaluator(String givenExpression){
        this.expression = givenExpression;
        this.stackEvaluator = new StackLL<Integer>(); 
    }
    
    /**
     * isOperator method to check whether the token is an operator or not
     * @param operator
     * @return true if it's an operator; otherwise return false
     */
    public boolean isOperator(String operator){
        if (operator.equals("+")){
            return true;
        }
        else if (operator.equals("-")){
            return true;
        }
        else if (operator.equals("*")){
            return true;
        }
        else if (operator.equals("/")){
            return true;
        }
        return false;
    }
    /**
     * PostfixEvaluate : evaluate the postfix equation in each line 
     * @return the result of the postfix equation 
     */
    public Integer PostfixEvaluate() {
        String token; 
        // Create a Scanner object for reading each line of the file 
        Scanner parser = new Scanner(expression);
        // while there's still token in the expression (line)
        while (parser.hasNext()){
            token = parser.next();  // get the token 

            // Get the first character of the token to see if it is an operator 
            char element = token.charAt(0);
            // Convert token's type from character to string for comparision 
            String operator = String.valueOf(element);
            
            // while the token is not operator, add number-token into the stack
            if (!isOperator(operator)){
                // Convert token from String to Integer 
                Integer val = Integer.parseInt(token);
                // push it to the stack 
                stackEvaluator.push(val);
            }
            // check invalid expression: 
            else if (isOperator(operator) && stackEvaluator.isEmpty()){
                System.out.println("Invalid equation");
                break;
            }
            /* otherwise; if the token is a operator, 
            evaluate the calculation between the 2 values on top of the stack and the operator (current token) */
            else {
                Integer value1 = stackEvaluator.pop();   // Get and remove the first value from top of the stack 
                Integer value2 = stackEvaluator.pop();   // Get and remove the second value from top of the stack 

                // Evaluate Postfix equation  
                // As the postfix equation comes from left to right the second values from top of the stack comes first
                if (operator.equals("+")){
                    stackEvaluator.push(value2 + value1);
                }
                else if (operator.equals("-")){
                    stackEvaluator.push(value2 - value1);
                }
                else if (operator.equals("*")){
                    stackEvaluator.push(value2 * value1);
                }
                else {
                    stackEvaluator.push(value2 / value1);
                }
            }
        }
        // Invalid expression: when the stack is empty as the expression starts off with the operator 
        if (stackEvaluator.isEmpty()){
            return null;
        }
        return stackEvaluator.pop();   // otherwise, return the result of the expression 
    }
}
