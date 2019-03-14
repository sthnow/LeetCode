

import algorithm.Node;
import org.junit.Before;
import org.junit.Test;

public class NodeTest {

    @Before
    public void setUp() {
        Node node = new Node(1);
        node.addNode(2);

        NodeTest nt = new NodeTest();
        System.out.println(node.length());

    }

    @Test
    public void length() {
    }
}