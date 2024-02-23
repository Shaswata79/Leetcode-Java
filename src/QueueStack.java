import java.util.Stack;

public class QueueStack {



    private static class MyQueue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            int returnVal;

            //push all to stack 2
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }

            //pop
            returnVal = stack2.pop();

            //push all back to stack 1
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }

            return returnVal;
        }

        public int peek() {
            int returnVal;

            //push all to stack 2
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }

            //pop
            returnVal = stack2.peek();

            //push all back to stack 1
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }

            return returnVal;
        }

        public boolean empty() {
            return stack1.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return false
    }

}
