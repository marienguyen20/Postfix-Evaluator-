import java.io.*;
import java.util.Scanner;
/**
 * Class contains main method for handling file reading and 
 * display the original string and the result 
 * Invoking Evaluator.java
 * 
 * @author Marie Nguyen 
 * @version April 7th, 2022
 */
public class PostfixEvaluator{
    public PostfixEvaluator(){ // Intentionally empty
    }
    
    /**
     * Main method: reading and handling the passed-in file 
     * @param args file name 
     * @throws FileNotFoundException
     * Print out the result of each postfix equation expression 
     */
    public static void main(String[] args) throws FileNotFoundException{
        // Get the file name from the command line in the configuration
        File infile = new File(args[0]);
        // Create a Scanner method for reading the file 
        Scanner dataIn = new Scanner(infile);
        String expression;   // Initialize a variable for information on each line
        
        // Check if the file is empty or not 
        if (!dataIn.hasNext()){
            // If the file is empty
            System.out.println("No expression in the file");
        }
        /* otherwise, do the postfix evaluation in each line and 
        print out the result along with the original expression */
        
        // while there's information on the file 
        while(dataIn.hasNext()){
            // Read a line from the file 
            expression = dataIn.nextLine();
            // Create an evaluator object 
            Evaluator result = new Evaluator(expression);
            // Print out orginal expression and the results of the postfix equation
            System.out.println(expression + " results in " + result.PostfixEvaluate());
        }
    }
}
