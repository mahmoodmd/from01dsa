public class Queue<T> {

    private class Node<T> {
        T data = null;
        Node next=null;

        Node(T data){
            this.data = data;
        }

        public String toString(){
            return data.toString();
        }
    }

    private Node head, tail;


    // [t]-[]-[]-[]-[]-[h]
    public Queue(){
        Node head = null;
        Node tail = null;
    }


    public T peek() throws NullPointerException {

        if(head != null)
            return (T)head.data;
        else
            throw new NullPointerException("Empty Queue");

    }

    public void add(T  data){
        Node node = new Node(data);
        if(tail != null) {
            tail.next = node;
        }
        //tail == null
        tail = node;

        if(head == null) {
            head = node;
        }
    }

    public T remove() throws NullPointerException{
        if(head == null)
            throw new NullPointerException("Empty Queue");

        Node node = head;
        head = head.next;

        if(head !=null && head.next == null)
            tail = null;

        return (T)node.data;

    }


    public static void main(String[] args){
        Queue queue = new Queue();
        queue.add(new String("first"));
        System.out.println("peek->"+ queue.peek());
        queue.add(new String("second"));
        queue.add(new String("third"));
        System.out.println("peek->"+ queue.peek());

        System.out.println("remove->"+ queue.remove());
        System.out.println("peek->"+ queue.peek());
        queue.add(new String("fourth"));
        System.out.println("peek->"+ queue.peek());


        System.out.println("remove->"+ queue.remove());
        System.out.println("peek->"+ queue.peek());

        System.out.println("remove->"+ queue.remove());
        System.out.println("peek->"+ queue.peek());

        System.out.println("remove->"+ queue.remove());
        System.out.println("peek->"+ queue.peek());

    }
}


