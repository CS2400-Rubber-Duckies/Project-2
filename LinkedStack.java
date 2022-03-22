import java.util.EmptyStackException;

public class LinkedStack<T> implements StackInterface<T> {
    private Node topNode;

    public LinkedStack() {
        topNode = null;
    }

    public void push(T newEntry) {
        topNode = new Node(newEntry, topNode);
    }

    public T pop() {
        T top = peek();
        topNode = topNode.getNext();
        return top;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return topNode.getData();
        }
    }

    public boolean isEmpty() {
        return topNode == null;
    }

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

    private static boolean isOperator(char i) {
        return precedence(i) > 0;
    }

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
