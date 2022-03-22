import java.util.EmptyStackException;

public class LinkedStack<T> implements StackInterface<T> {
    private Node topNode;

    public LinkedStack() {
        topNode = null;
    }

    /**
     * Adds a new entry to the top of this stack.
     * 
     * @param newEntry An object to be added to the stack
     */
    public void push(T newEntry) {
        topNode = new Node(newEntry, topNode);
    }

    /**
     * Removes and returns this stack's top entry.
     * 
     * @return The object at the top of the stack
     * @throws EmptyStackException if the stack is empty before the operation
     */
    public T pop() {
        T top = peek();
        topNode = topNode.getNext();
        return top;
    }

    /**
     * Retrieves this stack's top entry.
     * 
     * @return The object at the top of the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return topNode.getData();
        }
    }

    /**
     * Detects whether this stack is empty.
     * 
     * @return True if the stack is empty.
     */
    public boolean isEmpty() {
        return topNode == null;
    }

    /**
     * Removes all entries from this stack
     */
    public void clear() {
        topNode = null;
    }

    private class Node {
        T data;
        Node next;

        public Node(T val, Node n) {
            data = val;
            next = n;
        }

        public T getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        // public void setData(T val) {
        // data = val;
        // }
        // public void setNext(Node n) {
        // next = n;
        // }
    }

    /**
     * Checks if character parameter is an operator character.
     * 
     * @return Boolean for whether character is an operator.
     */
    private static boolean isOperator(char i) {
        return precedence(i) > 0;
    }

    /**
     * Assigns value of precendence based on PEMDAS.
     * 
     * @return Integer value of precedence.
     */
    private static int precedence(char i) {
        if (i == '(' || i == ')') {
            return 1;
        } else if (i == '-' || i == '+') {
            return 2;
        } else if (i == '*' || i == '/') {
            return 3;
        } else {
            return 0;
        }

    }

    /**
     * Converts an infix expression to postfix.
     * 
     * @return String of postfix expression.
     */
    @Override
    public String convertToPostfix(String infix) {
        LinkedStack<Character> operatorStack = new LinkedStack<Character>();
        String postfix = "";
        char popped;

        for (int i = 0; i < infix.length(); i++) {
            char character = infix.charAt(i);

            if (!isOperator(character)) {
                postfix += character;
            } else if (character == ')') {
                while ((popped = operatorStack.pop()) != '(') {
                    postfix += popped;
                }
            } else {
                while (!operatorStack.isEmpty() && character != '('
                        && precedence(operatorStack.peek()) >= precedence(character)) {
                    postfix += operatorStack.pop();
                }
                operatorStack.push(character);
            }
        }

        while (!operatorStack.isEmpty()) {
            postfix += operatorStack.pop();
        }

        return postfix;

    }

    /**
     * Evaluates postfix expression given numerical values.
     * 
     * @return String of postfix expression result.
     */
    @Override
    public String evaluatePostfix(String postfix) {
        LinkedStack<Integer> valueStack = new LinkedStack<Integer>();
        int result;

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (Character.isDigit(c)) {
                valueStack.push(c - '0');
            } else {
                int operandTwo = valueStack.pop();
                int operandOne = valueStack.pop();
                if (c == '+') {
                    result = operandTwo + operandOne;
                    valueStack.push(result);
                } else if (c == '-') {
                    result = operandTwo - operandOne;
                    valueStack.push(result);
                } else if (c == '/') {
                    result = operandTwo / operandOne;
                    valueStack.push(result);
                } else if (c == '*') {
                    result = operandTwo * operandOne;
                    valueStack.push(result);
                }
            }
        }
        return valueStack.peek().toString();
    }

    // Algorithm convertToPostfix(infix)
    // // Converts an infix expression to an equivalent postfix expression.
    // operatorStack = a new empty stack
    // postfix = a new empty string
    // while (infix has characters left to parse)
    // {
    // nextCharacter = next nonblank character of infix switch (nextCharacter)
    // {
    // case variable:
    // Append nextCharacter to postfix break
    // case '^' : operatorStack.push(nextCharacter) break
    // case '+' : case '-' : case '*' : case '/' : while (!operatorStack.isEmpty()
    // and
    // precedence of nextCharacter <= precedence of operatorStack.peek())
    // {
    // Append operatorStack.peek() to postfix operatorStack.pop()
    // } operatorStack.push(nextCharacter) break
    // case '( ' : operatorStack.push(nextCharacter) break
    // case ')' : // Stack is not empty if infix expression is valid topOperator =
    // operatorStack.pop()
    // while (topOperator != '(')
    // {
    // Append topOperator to postfix
    // topOperator = operatorStack.pop() }
    // break
    // default: break // Ignore unexpected characters
    // while (!operatorStack.isEmpty()) {
    // topOperator = operatorStack.pop()
    // Append topOperator to postfix }
    // return postfix

}
