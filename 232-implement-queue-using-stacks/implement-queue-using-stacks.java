import java.util.Stack;

class MyQueue {
    private Stack<Integer> stack;

    public MyQueue() {
        stack = new Stack<>();
    }

    // Push operation is simple
    public void push(int x) {
        stack.push(x);
    }

    // Pop operation - simulate FIFO using recursion
    public int pop() {
        if (stack.isEmpty()) {
            return -1; // or throw exception
        }

        int top = stack.pop();

        if (stack.isEmpty()) {
            // This is the bottom element => front of queue
            return top;
        }

        int result = pop();  // recursive call

        stack.push(top);     // push back others
        return result;
    }

    // Peek operation - similar to pop, but we keep the bottom value
    public int peek() {
        if (stack.isEmpty()) {
            return -1; // or throw exception
        }

        int top = stack.pop();

        if (stack.isEmpty()) {
            // This is the front of the queue
            stack.push(top); // put it back for peek
            return top;
        }

        int result = peek();

        stack.push(top); // push back others
        return result;
    }

    // Check if queue is empty
    public boolean empty() {
        return stack.isEmpty();
    }
}
