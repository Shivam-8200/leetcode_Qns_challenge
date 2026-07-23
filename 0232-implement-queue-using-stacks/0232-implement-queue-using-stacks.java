class MyQueue {
    Stack<Integer> stack1;  // inbox
    Stack<Integer> stack2;  // outbox

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);  // inbox mein daalo!
    }

    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());  // transfer!
            }
        }
        return stack2.pop();  // outbox se nikalo!
    }

    public int peek() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());  // transfer!
            }
        }
        return stack2.peek();  // outbox ka top!
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}