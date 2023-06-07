public class DoublyLinkedList<T> {
    private Node<T> head, tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data, Node<T> next, Node<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        public Node(T data) {
            this(data, null, null);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<T>(data, head, null);
        //Jika DLL tidak kosong
        if(head != null) {
            head.prev = newNode;
        }
        // Set head
        head = newNode;

        // Jika DLL kosong
        if(tail == null) {
            tail = newNode;
        }

        size++;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<T>(data, null, tail);
        
        if(tail != null) {
            tail.next = newNode;
        }
        
        tail = newNode;

        if(head == null) {
            head = newNode;
        }

        size++;
    }

    public void addAtPost(int index, T data) {
        if(index < 0 || index > this.size()) {
            throw new IllegalArgumentException("Invalid Index");
        } else if (index == 0) {
            this.addFirst(data);
        } else if (index == this.size()) {
            this.addLast(data);
        } else {
            Node<T> newNode = new Node<T>(data);
            Node<T> currNode = head;

            for(int i=0; i < index; i++) {
                currNode = currNode.next;
            }

            newNode.next = currNode;
            newNode.prev = currNode.prev;
            currNode.prev = newNode;
            newNode.prev.next = newNode;
            size++;
        }
    }

    public void displayFwd() {
        if(this.isEmpty()) {
            System.out.println("DLL is empty");
            return;
        }
        Node<T> currNode = head;
        while(currNode != null) {
            System.out.println(currNode.data);
            currNode = currNode.next;
        }
    }

    public void displayBwd() {
        if(this.isEmpty()) {
            System.out.println("DLL is empty");
            return;
        }
        Node<T> currNode = tail;
        while(currNode != null) {
            System.out.println(currNode.prev);
            currNode = currNode.prev;
        }
    }

    public void removeFirst() {
        if(this.isEmpty()) {
            System.out.println("DLL is empty");
        } else {
            if(head.next == null) {
                tail = null;
            } else {
                head.next.prev = null;
            }
            head = head.next;
            size--;
        }
    }

    public void removeLast() {
        if(this.isEmpty()) {
            System.out.println("DLL is empty");
        } else {
            if (head.next == null) {
                head = null;
            } else {
                tail.prev.next = null;
            }
            tail = tail.prev;
            size--;
        }
    }

    public void removeAtPos(int index) {
        if(index < 0 || index > this.size()) {
            throw new IllegalArgumentException("Invalid Index");
        } else if(index == 0) {
            this.removeFirst();
        } else if (index == this.size() - 1) {
            this.removeLast();
        } else {
            Node<T> currNode = head;
            for(int i=0; i < index; i++) {
                currNode = currNode.next;
            }
            currNode.prev.next = currNode.next;
            currNode.next.prev = currNode.prev;
            size--;
        }
    }

    public Node<T> getFirst() {
        return head;
    }

    public Node<T> getLast() {
        return tail;
    }

    public Node<T> getByValue(T value) {
        Node<T> currNode = head;
        while(currNode != null) {
            if(currNode.data.equals(value))
            return currNode;
            currNode = currNode.next;
        }
        return null;
    }

    public Node<T> getByIndex(int index) {
        if(index < 0 || index > this.size()) {
            throw new IllegalArgumentException("Invalid Index");
        }
        Node<T> currNode = head;
        for(int i=0; i < index; i++) {
            currNode = currNode.next;
        }
        return currNode;
    }
}
