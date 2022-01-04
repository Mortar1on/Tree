import java.util.ArrayList;
import java.util.List;

public class Tree {

    public static void main(String[] args) {
        Node root = new Node("Root");

        Node level1 = new Node("Level-1");
        Node level2 = new Node("Level-2");
        Node level1a = new Node("Level-1a");
        Node level1b = new Node("Level-1b");
        Node level3 = new Node("Level-3");

        Node some = new Node("insert child");

        root.add(level1);
        root.add(level1a);
        root.add(level1b);
        level1.add(level2);
        level2.add(level3);

        System.out.println("The initial state:\n");

        root.print(0);

        root.insert(some, "Level-1");
        root.insert(some, "Level-3");

        System.out.println("\nAfter inserting a branch:\n");
        root.print(0);

    }

    static class Node {
        private final String name;
        private final List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        public void add(Node child) {
            children.add(child);
        }

        public void print(int lv) {
            for (int i = 0; i < lv; i++) System.out.print(" ");

            System.out.println(this.name);

            for (Node a : this.children) {
                a.print(lv + 5);
            }
        }

        public void insert(Node newNode, String parentName) {
            for (Node element : children) {
                if (parentName.equals(element.name)) {
                    element.add(newNode);
                }
            }
        }

    }

}