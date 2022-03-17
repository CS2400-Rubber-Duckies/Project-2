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
        integrityOK = false;
        checkCapacity(initialCapacity);

        @SuppressWarnings("unchecked"
        )
    }

    public void push(T newEntry) {
        checkIntegrity();
        ensureCapacity();

    }
}
