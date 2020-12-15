public class MyLinkedList<T extends Comparable<T>> {

    private class Node<T extends Comparable<T>> {
        Node next;
        T data;

        Node(T data){
            this.data = data;
            next = null;
        }

    }

    Node<T> head;
    public MyLinkedList(){
        head = null;
    }

    public boolean add(T data){
        if(data == null)
            return false;

        if(head == null){
            head = new Node<T>(data);
            return true;
        }
        Node node = head;
        while(node.next != null){
            node = node.next;
        }

        node.next = new Node<T>(data);
        return true;
    }

    public boolean remove(T data){
        if(data == null)
            return false;
        Node node = head;
        //if match found in first node
        if(node.data.equals(data)) {
            head = head.next;
            return true;
        }

        //if match found in 2nd node and beyond
        while(node.next != null){
            if(node.next.data.equals(data)) {
                node.next = node.next.next;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void printAll(){
        Node node = head;
        while(node !=null){
            System.out.println("-> "+ node.data);
            node = node.next;
        }
        System.out.println("-------------");
    }

    public static void main(String[] args){
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(new String("first"));
        linkedList.add(new String("second"));
        linkedList.add(new String("third"));
        linkedList.printAll();

        linkedList.remove(new String("second"));
        linkedList.add(new String("fourth"));
        linkedList.printAll();

        linkedList.remove(new String("third"));
        linkedList.add(new String("fifth"));
        linkedList.add(new String("sixth"));
        linkedList.printAll();

    }


}





