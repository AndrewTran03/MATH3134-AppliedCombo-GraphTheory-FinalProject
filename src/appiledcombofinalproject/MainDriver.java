package appiledcombofinalproject;

import java.util.*;

//-------------------------------------------------------------------------
/**
* Driver program that allows for the user to run the Cycle Detection Algoithm.
* 
* @author Andrew Tran (andrewt03)
* @version 2022.05.03
*/
//-------------------------------------------------------------------------
public class MainDriver {

    /**
     * Empty constructor (not used).
     */
    public MainDriver() {
        // Constructor left intentionally empty
    }

    /**
     * The main method for running the Graph program to show to the user.
     *
     * @param args
     *            the input files written in as the system arguments (none in this case)
     */
    public static void main(String[] args) {
        System.out.println("Welcome to Andrew's Graph Cycle Detection Program!");
        System.out.println("NOTE: WE ONLY ALLOW UP TO 52 VERTICES (0-51 / A-Z and a-z) FOR THIS IMPLEMENTATION OF THIS PROGRAM!");
        Scanner input = new Scanner(System.in);
               
        int numberOfVertices = numVerticesUserInputValidation();
        if(numberOfVertices == 0) { //No Graph Case
            System.out.println("\nThere is no graph with 0 vertices! Thanks for using Andrew's "
                                + "Graph Cycle Detection Program! Have a good rest of your day!");
            System.exit(0);
        }
        else if(numberOfVertices == 1) { //1 Vertex Case
            System.out.println("\nA graph with 1 vertex NEVER has a cycle! Thanks for using Andrew's "
                + "Graph Cycle Detection Program! Have a good rest of your day!");
            System.exit(0);
        }
        
        HashMap<String, Integer> hmStrToIntConversion = createConversionTableStringToInt(52);
        HashMap<Integer, String> hmIntToStrConversion = createConversionTableIntToString(52);
        CycleDetectionGraphAlgorithm newGraph = new CycleDetectionGraphAlgorithm(52, hmIntToStrConversion);
        
        String vertexType = vertexTypeUserInputValidation();
        
        boolean continueProgram = true;
        while(continueProgram == true) {
            int firstVertexNum = Integer.MIN_VALUE;
            int secondVertexNum = Integer.MIN_VALUE;
            String firstVertex = "";
            String secondVertex = "";
            
            if(vertexType.equals("s")) { //String Input (Letters and Numbers Allowed)
                System.out.print("\nEnter the First Vertex where you want to Add an Edge (SINGLE-LETTER Input Only): ");
                firstVertex = input.nextLine(); 
                System.out.print("Enter the Second Vertex where you want to Add an Edge (SINGLE-LETTER Input Only): ");
                secondVertex = input.nextLine();
                if(isNumeric(firstVertex) && isNumeric(secondVertex)) {
                    continue;
                }
                else {
                    while(firstVertex.length() != 1 || secondVertex.length() != 1) {
                        System.out.println("\nERROR! Invalid Input. Please enter the edge vertices again!");
                        System.out.print("Enter the First Vertex where you want to Add an Edge (SINGLE-LETTER Input Only): ");
                        firstVertex = input.nextLine(); 
                        System.out.print("Enter the Second Vertex where you want to Add an Edge (SINGLE-LETTER Input Only): ");
                        secondVertex = input.nextLine();
                    }
                }
                firstVertexNum = (int)(hmStrToIntConversion.get(firstVertex));
                secondVertexNum = (int)(hmStrToIntConversion.get(secondVertex));
                newGraph.addGraphEdge(firstVertexNum, secondVertexNum, "Letter");
            }
            else { //Digit Input Only
                System.out.print("\nEnter the First Vertex where you want to Add an Edge (DIGIT Input Only): ");
                firstVertex = input.nextLine(); 
                System.out.print("Enter the Second Vertex where you want to Add an Edge (DIGIT Input Only): ");
                secondVertex = input.nextLine();
                while((!isNumeric(firstVertex) || (Integer.parseInt(firstVertex) < 0 || Integer.parseInt(firstVertex) >= 52)) 
                    && (!isNumeric(secondVertex) || (Integer.parseInt(secondVertex) < 0 || Integer.parseInt(secondVertex) >= 52))) {
                    System.out.println("\nERROR! Invalid Input. Please enter the edge vertices again!");
                    System.out.print("Enter the First Vertex where you want to Add an Edge (DIGIT Input Only): ");
                    firstVertex = input.nextLine(); 
                    System.out.print("Enter the Second Vertex where you want to Add an Edge (DIGIT Input Only): ");
                    secondVertex = input.nextLine();
                }
                firstVertexNum = Integer.parseInt(firstVertex);
                secondVertexNum = Integer.parseInt(secondVertex);
                newGraph.addGraphEdge(firstVertexNum, secondVertexNum, "Numeric");
            }
            
            System.out.print("\nDo you want to continue entering edges into your graph? ");
            String endProgramResult = input.nextLine();
            while(!isYes(endProgramResult) && !isNo(endProgramResult) ) {
                System.out.println("ERROR! Invalid Input. Try again!");
                System.out.print("Do you want to continue entering edges into your graph? ");
                endProgramResult = input.nextLine();
            }
            
            if(isYes(endProgramResult) == false) {
                continueProgram = false;
            }
        }
        System.out.println("\n" + newGraph.toString());
        System.out.println("\n" + newGraph.displayHasCycleResults());
        System.out.println("\nThanks for using Andrew's Graph Cycle Detection Program! Have a good rest of your day!");
        System.exit(0);
    }
    
    
    /**
     * Creates a HashMap that assigns/converts a letter (key) to a numerical 
     * value from 0-51 (value).
     *
     * @param maxLength 
     *              the maximum number of nodes/vertices in the Graph
     * 
     * @return the representation of a String to Integer conversion table as a HashMap. 
     */
    public static HashMap<String, Integer> createConversionTableStringToInt(int maxLength) {
        HashMap<String, Integer> conversionTable = new HashMap<String, Integer>();
        String alphabet = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z a b c d e f g h i j k l m n o p q r s t u v w x y z";
        String[] splittedArray = alphabet.split(" ");
        for(int i = 0; i < maxLength; i++) {
            conversionTable.put(splittedArray[i], i);
        }
        return conversionTable;
    }
    
    
    /**
     * Creates a HashMap that assigns/converts a numerical value from 0-51 
     * (key) to a letter (value).
     *
     * @param maxLength 
     *              the maximum number of nodes/vertices in the Graph
     * 
     * @return the representation of an Integer to String conversion table as a HashMap. 
     */
    public static HashMap<Integer, String> createConversionTableIntToString(int maxLength) {
        HashMap<Integer, String> conversionTable = new HashMap<Integer, String>();
        String alphabet = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z "
                        + "a b c d e f g h i j k l m n o p q r s t u v w x y z";
        String[] splittedArray = alphabet.split(" ");
        for(int i = 0; i < maxLength; i++) {
            conversionTable.put(i, splittedArray[i]);
        }
        return conversionTable;
    }
    
    
    /**
     * Handles input validation for the user entering the
     * number of total vertices in the Graph being inputed.
     *
     * @return the number of total vertices in the Graph.
     */
    public static int numVerticesUserInputValidation() {
        Scanner input = new Scanner(System.in);
        int numVertices = Integer.MIN_VALUE;
        System.out.print("Enter the number of vertices in your graph: ");
        String result = input.nextLine();
        while(!isNumeric(result) || (Integer.parseInt(result) < 0 || Integer.parseInt(result) >= 52)) {
            System.out.println("Error! Please try again!");
            System.out.print("Enter the number of vertices in your graph: ");
            result = input.nextLine();
        }
        numVertices = Integer.parseInt(result);
        return numVertices;
    }
    
    
    /**
     * Handles input validation for determining which vertex type will be
     * used in this Graph program (Letters or Numbers).
     *
     * @return the string representation for vertex type on the Graph.
     */
    public static String vertexTypeUserInputValidation() {
        Scanner input = new Scanner(System.in);
        String vertexType = "";
        System.out.print("Do you want to enter letter-edges or numerical-edges? (Enter 'S' for letter vertices and "
            + "'I' for digit vertices?): ");
        String vertexInput = input.nextLine();
        while(validateUserWantingStringInput(vertexInput) == false && validateUserWantingIntegerInput(vertexInput) == false) {
            System.out.println("ERROR! Invalid Input. Try again");
            System.out.print("Do you want to enter letter-edges or numerical-edges? (Enter 'S' for letter vertices and "
                + "'I' for digit vertices?): ");
            vertexInput = input.nextLine();
        }
        
        if(validateUserWantingStringInput(vertexInput) == true) {
            vertexType = "s";
        }
        else { //validateUserWantingIntegerInput(vertexInput) == true
            vertexType = "i";
        }
        return vertexType;
    }
    
    
    /**
     * Handles input validation for asking the user if they want to enter 
     * letter/string results.
     *
     * @param input 
     *              the user input
     *              
     * @return true; if the user wants string input.
     *         false; otherwise.
     */
    public static boolean validateUserWantingStringInput(String input) {
        return input.toLowerCase().equals("s") || input.toLowerCase().equals("str") 
            || input.toLowerCase().equals("l") || input.toLowerCase().equals("letter")
            || input.toLowerCase().equals("string");
    }
    
    
    /**
     * Handles input validation for asking the user if they want to enter 
     * numerical/integer results.
     *
     * @param input 
     *              the user input
     *              
     * @return true; if the user wants integer input.
     *         false; otherwise.
     */
    public static boolean validateUserWantingIntegerInput(String str) {
        return str.toLowerCase().equals("i") || str.toLowerCase().equals("int") 
            || str.toLowerCase().equals("n") || str.toLowerCase().equals("number")
            || str.toLowerCase().equals("integer");
    }
    
    
    /**
     * Checks if the input is a variation of "yes".
     *
     * @param str
     *           the user input
     *           
     * @return true; if the user input is a variation of "yes".
     *         false; otherwise.
     */
    public static boolean isYes(String str) {
        return str.toLowerCase().equals("y") || str.toLowerCase().equals("yes");
    }
    
    
    /**
     * Checks if the input is a variation of "no".
     *
     * @param str
     *           the user input
     *           
     * @return true; if the user input is a variation of "no".
     *         false; otherwise.
     */
    public static boolean isNo(String str) {
        return str.toLowerCase().equals("n") || str.toLowerCase().equals("no");
    }
    
    
    /**
     * Checks if the input is a numerical value.
     *
     * @param str
     *           the user input
     *           
     * @return true; if the user input is numeric.
     *         false; otherwise.
     */
    public static boolean isNumeric(String str) {
        return str != null && str.matches("[-+]?\\d*\\.?\\d+");
    }
    
    
    /**
     * Checks if the input is a alphabetical value.
     *
     * @param str
     *           the user input
     *           
     * @return true; if the user input is alphabetical.
     *         false; otherwise.
     */
    public static boolean isAlpha(String str) {
        return str != null && str.matches("^[a-zA-Z]*$");
    }
}
