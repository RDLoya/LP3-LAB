import java.util.*;

class Node {
    char data;
    int freq;
    Node left, right;

    public Node(char data, int freq) {
        this.data = data;
        this.freq = freq;
        left = right = null;
    }
}

class MinHeapComparator implements Comparator<Node> {
    public int compare(Node a, Node b) {
        return a.freq - b.freq;
    }
}

public class Huffman_Coding {

    static void printTree(Node head, String str) {
        if (head == null)
            return;
        if (head.left == null && head.right == null) {
            System.out.println(head.data + " -> " + str);
            return;
        }
        printTree(head.left, str + "0");
        printTree(head.right, str + "1");
    }

    static Node buildTree(ArrayList<Character> arr, ArrayList<Integer> frequency) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new MinHeapComparator());
        for (int i = 0; i < arr.size(); i++) {
            pq.add(new Node(arr.get(i), frequency.get(i)));
        }
        while (pq.size() > 1) {
            Node a = pq.poll();
            Node b = pq.poll();
            Node c = new Node('$', a.freq + b.freq);
            c.left = a;
            c.right = b;
            pq.add(c);
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of characters: ");
        int n = sc.nextInt();
        ArrayList<Character> arr = new ArrayList<>();
        ArrayList<Integer> frequency = new ArrayList<>();

        System.out.println("Enter characters and their frequencies:");

        for (int i = 0; i < n; i++) {
            arr.add(sc.next().charAt(0));
            frequency.add(sc.nextInt());
        }

        Node head = buildTree(arr, frequency);

        System.out.println("Huffman Codes are:");
        printTree(head, "");
    }
}
//Time complexity is O(n logn) and Space complexity is O(n)

// Enter the number of characters: 5
// Enter characters and their frequencies:
// A 5
// B 9
// C 12
// D 13
// E 16
// Huffman Codes are:
// C -> 00
// D -> 01
// A -> 100
// B -> 101
// E -> 11
