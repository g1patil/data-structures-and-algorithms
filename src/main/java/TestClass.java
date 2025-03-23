import org.junit.jupiter.api.Test;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */


public class TestClass {

    private boolean getLCA(TestNode head, int leftData, int rightData) {
        if (head == null)
            return false;
        
        if (head.data == leftData || head.data == rightData)
            return true;
        
        boolean left  = getLCA(head.left, leftData, rightData);
        boolean right  = getLCA(head.right, leftData, rightData);
        
        if (left && right) {
            System.out.println("LCA has been found : " + head.data );
        }
        
        return getLCA(head.left,leftData,rightData) || getLCA(head.right, leftData, rightData);
    }
    @Test
    public void test() {
        TestNode n4 = new TestNode(4,null,null);
        TestNode n3 = new TestNode(3,null,null);
        TestNode n2 = new TestNode(2,null,null);
        TestNode n1 = new TestNode(1,n3,n4);
        TestNode n0 = new TestNode(0,n1,n2);
        getLCA(n0, 3,4);
    }
}

class TestNode {
    int data;
    public TestNode left,right;

    public TestNode(int data, TestNode left, TestNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
