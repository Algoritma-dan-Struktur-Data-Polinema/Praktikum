public class NodePasien {
    Pasien data;
    NodePasien prev;
    NodePasien next;

    public NodePasien(NodePasien prev, Pasien data, NodePasien next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}
