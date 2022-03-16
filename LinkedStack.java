public class LinkedStack<T> implements StackInterface<T> {
    private Node topNode;

    /**
     * Default Constructor
     */
    public LinkedStack() {
        topNode = null;
    }

    public void push(T newEntry) {
        topNode = new Node(newEntry, topNode);
    }

    public T pop()
    {
        if (topNode != null)
        T top = peek();
        topNode = topNode.getNextNode();
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
        public Node(T newEntry, LinkedStack<T>.Node topNode) {

        }

        private T data;
        private Node next;

    }

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