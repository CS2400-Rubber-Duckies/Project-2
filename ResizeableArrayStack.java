import java.util.Arrays;
import java.util.EmptyStackException;

public final class ResizeableArrayStack<T> implements StackInterface {
    private T[] stack;
    private int topIndex;
    private boolean IntegrityOK = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public ResizeableArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ResizeableArrayStack(int initialCapacity)
    {
        IntegrityOK = false;
        checkCapacity(initialCapacity);

        @SuppressWarnings("unchecked" )
        T[] tempStack = (T[])new Object[initialCapacity];
       stack = tempStack;
topIndex = -1;
       IntegrityOK = true;
    }
    private void checkCapacity(int initialCapacity) {
//TO DO 
    }

    private void ensureCapacity()
{
   if (topIndex >= stack.length - 1) // If array is full, double its size
   {
      int newLength = 2 * stack.length;
      checkCapacity(newLength);
      stack = Arrays.copyOf(stack, newLength);
   } // end if
} 
    @Override
    public void push(Object newEntry) {
       // checkInyegrity();
   ensureCapacity();
   stack[topIndex + 1] = (T) newEntry;
   topIndex++;
        
    }

  

    @Override
    public Object pop() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object peek() {
       // checkIntegrity();
        if (isEmpty())
           throw new EmptyStackException();
        else
           return stack[topIndex];
    }

    @Override
    public boolean isEmpty() {
        return topIndex < 0;
    }

    @Override
    public void clear() {
       // checkIntegrity();
      
      // Remove references to the objects in the stack,
      // but do not deallocate the array
      while (topIndex > -1)
      {
          stack[topIndex] = null;
          topIndex--;
      }
        
    }
    private static boolean isOperator(char i) {
        return precedence(i) > 0;
    }
    private static int precedence(char i) {

        if (i == '(' || i == ')') return 1;
        else if (i == '-' || i == '+') return 2;
        else if (i == '*' || i == '/') return 3;
        else return 0;
    }

    @Override
    public String convertToPostfix(String infix) {
        String postfix = "";
        ResizeableArrayStack<Character> operator = new ResizeableArrayStack<Character>();
        
char popped;

        for (int i = 0; i < infix.length(); i++) {

            char get = infix.charAt(i);

            if (!isOperator(get))
                postfix += get;

            else if (get == ')')
                while ((popped = (char) operator.pop()) != '(')
                    postfix += popped;

            else {
                while (!operator.isEmpty() && get != '(' && precedence((char) operator.peek()) >= precedence(get))
                    postfix += operator.pop();

                operator.push(get);
            }
        }
        // pop any remaining operator
        while (!operator.isEmpty())
            postfix += operator.pop();

        return postfix;
        
    }


    @Override
    public String evaluatePostfix(String postfix) {
       
        ResizeableArrayStack<Integer> stack=new ResizeableArrayStack<>();
         
        // Scan all characters one by one
        for(int i=0;i<postfix.length();i++)
        {
            char c=postfix.charAt(i);
             
            // If the scanned character is an operand (number here),
            // push it to the stack.
            if(Character.isDigit(c))
            stack.push(c - '0');
             
            //  If the scanned character is an operator, pop two
            // elements from stack apply the operator
            else
            {
                int val1 = (int) stack.pop();
                int val2 = (int) stack.pop();
                 
                switch(c)
                {
                    case '+':
                    stack.push(val2+val1);
                    break;
                     
                    case '-':
                    stack.push(val2- val1);
                    break;
                     
                    case '/':
                    stack.push(val2/val1);
                    break;
                     
                    case '*':
                    stack.push(val2*val1);
                    break;
              }
            }
        }
        return (String) stack.pop();   
    }

   
}
