import java.util.*;
 public class Calculator {

    public static void main(String args[]) {
        ResizeableArrayStack <String> tStack = new  ResizeableArrayStack<>();

        String infix = "a*b/(c-a)+d*e" ;
        String postfix = "2 3 * 4 2 - / 5 6 * +"; 

        System.out.println("Infix : " + infix);
        System.out.println("Postfix : " +  tStack.convertToPostfix(infix));
        System.out.println("Evaluate post fix: " + tStack.evaluatePostfix(postfix));


    }
     
 } 

