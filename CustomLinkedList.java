public class CustomLinkedList {
    class Node {
        Node next;
        double data;
    }

    private Node head;
    private Node curr;

    CustomLinkedList() {
        head = null;
        curr = head;
    }

    // adds a node to the front of the list
    public void addNode(double value) {
        // if there is only one item in the list
        if(head == null) {
            head = new Node();
            head.next = null;
            head.data = value;
            curr = head;
        } else {
            Node newNode = new Node();
            newNode.data = value;
            newNode.next = head;
            head = newNode;
        }
    }

    public void deleteFront() {
        head = head.next;
    }

    public void printNodes() {
        String res = "";
        if (head == null) {
            res = "No nodes in list";
        } else {
            Node currNode = head;
            while(currNode.next != null) {
                String strDouble = String.format("%.3f",currNode.data);
                res += strDouble + " --> ";
                currNode = currNode.next;
            }
            String strDouble = String.format("%.3f",currNode.data);
            res += strDouble;
        }
        System.out.println(res);
    }

    public String viewNextNode() {
        String res = "";
        if(head == null) {
            res = "";
        } else if (curr.next == null) {
            res += curr.data;
            curr = head;
        } else {
            res += curr.data;
            curr = curr.next;
        }

        return res;
    }


}