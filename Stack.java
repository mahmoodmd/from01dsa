public class Stack<T> {

    private class Node<T> {
        T data;
        Node next;

        public Node(T data){
            this.data = data;
        }

        public String toString(){
            return data.toString();
        }
    }

    private Node top;


    public Stack(T data){
        top = new Node<T>(data);
    }


    public T peek() throws NullPointerException {
        if(top != null)
            return (T)top.data;

        throw new NullPointerException("Empty Stack");
    }

    public void push(T data){
        Node node = new Node(data);
        if(top != null)
            node.next = top;

        top = node;

    }

    public T pop(){
        if(top == null)
            throw new NullPointerException("Empty Stack");
        Node node = top;
        top = node.next;
        return (T) node.data;
    }

    public static void main(String[] args){
        Stack<String> stack = new Stack<>("first");
        System.out.println("create, peek->"+ stack.peek());

        stack.push(new String("second"));
        System.out.println("push, peek->"+ stack.peek());

        stack.push(new String("third"));
        System.out.println("push, peek->"+ stack.peek());


        stack.pop();
        System.out.println("pop, peek->"+ stack.peek());

        stack.pop();
        System.out.println("pop, peek->"+ stack.peek());

        stack.pop();
        System.out.println("pop, peek->"+ stack.peek());

        stack.pop();
        System.out.println("pop, peek->"+ stack.peek());

    }
}
