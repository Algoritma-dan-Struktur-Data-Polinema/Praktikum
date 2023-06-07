public class DLLPasien {
    NodePasien head;
    int size = 0;

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Pasien item) {
        if(isEmpty()) {
            head = new NodePasien(null, item, null);
        } else {
            NodePasien newNode = new NodePasien(null, item, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(Pasien item) {
        if(isEmpty()) {
            addFirst(item);
        } else {
            NodePasien current = head;
            while(current.next != null) {
                current = current.next;
            }
            NodePasien newNode = new NodePasien(current, item, null);
            current.next = newNode;
        }
        size++;
    }

    public void add(Pasien item, int index) throws Exception {
        if(isEmpty()) {
            addFirst(item);
        } else if (index < 0 || index > size) {
            throw new Exception("Nilai indeks diluar batas");
        } else {
            NodePasien current = head;
            int i = 0;
            while(i < index) {
                current = current.next;
                i++;
            }
            if(current.prev == null) {
                NodePasien newNode = new NodePasien(null, item, current);
                current.prev = newNode;
                head = newNode;
            } else {
                NodePasien newNode = new NodePasien(current.prev, item, current);
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;
            }
        }
        size++;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    private void headerPrint() {
        System.out.println("=================");
        System.out.println("Daftar Antre Vaksin");
        System.out.println("=================");
        System.out.println("|No\t|Nama\t|");
    }

    public void print() {
        if(!isEmpty()) {
            NodePasien tmp = head;
            headerPrint();
            while(tmp != null) {
                System.out.println("|"+tmp.data.getNoAntre() + "\t|"+tmp.data.getNama()+"\t|");
                tmp = tmp.next;
            }
            System.out.println("\nberhasil diisi");
        } else {
            System.out.println("Linked Lists Kosong");
        }
    }

    public void removeFirst() throws Exception {
        if(isEmpty()) {
            throw new Exception("Linked List masih kosong, tidak dapat dihapus");
        } else if (size==1) {
            removeLast();
        } else {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void removeLast() throws Exception {
        if(isEmpty()) {
            throw new Exception("Linked List masih kosong, tidak dapat dihapus");
        } else if (head.next == null) {
            head = null;
            size--;
            return;
        }
        NodePasien current = head;
        while(current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        size--;
    }

    public void remove(int index) throws Exception {
        if(isEmpty() || index >= size) {
            throw new Exception("Nilai indeks diluar batas");
        } else if (index == 0) {
            removeFirst();
        } else {
            NodePasien current = head;
            int i = 0;
            while (i<index) {
                current = current.next;
                i++;
            }
            if(current.next == null) {
                current.prev.next = null;
            } else if(current.prev == null) {
                current = current.next;
                current.prev = null;
                head = current;
            } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            size--;
        }
    }
}
