import java.util.*;

public class Calculator {

    public static void main(String args[]) {
        ResizeableArrayStack<String> arrayStack = new ResizeableArrayStack<>();

        String infix = "a*b/(c-a)+d*e";
        String postfix = "2 3 * 4 2 - / 5 6 * +";

        // System.out.println("RESIZEABLE ARRAY STACK:");
        // System.out.println("Infix: " + infix);
        // System.out.println("Postfix: " + arrayStack.convertToPostfix(infix));
        // System.out.println("Evaluate Postfix: " +
        // arrayStack.evaluatePostfix(postfix));

        LinkedStack<String> linkedStack = new LinkedStack<String>();
        System.out.println("\nLINKED STACK:");
        System.out.println("Infix: " + infix);
        System.out.println("Postfix: " + linkedStack.convertToPostfix(infix));
        System.out.println("Evaluate Postfix: " + linkedStack.evaluatePostfix(postfix));

    }

}
