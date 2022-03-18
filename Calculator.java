import java.util.*;
 public class Calculator {

    public static void main(String args[]) {
        ResizeableArrayStack <String> tStack = new  ResizeableArrayStack<>();

        String infix = "a*b/(c-a)+d*e" ;
        String postfix = "23*42-/56*+"; 

        System.out.println("Infix : " + infix);
        System.out.println("Postfix : " +  tStack.convertToPostfix(infix));
        System.out.println("Evaluate post fix: " + tStack.evaluatePostfix(postfix));


    }
     
 } 

