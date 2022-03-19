import java.util.EmptyStackException;

public class LinkedStack<T> implements StackInterface<T> {
    private Node topNode;

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
       
            private T data;
            private Node next;
                
            
               
                public void setData (T val) {
                data = this.data
                public T getData () {
                }
                return data;
                public Node getNext () {
                return next;
                }
                public void setNext (Node n) {
                    next = n;
                }
                
                

        }}
        @Override
        public String convertToPostfix() {
            // TODO Auto-generated method stub
            return null;
        }
        @Override
        public String evaluatePostfix() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String convertToPostfix(String infix) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String evaluatePostfix(String postfix) {
            // TODO Auto-generated method stub
            return null;
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