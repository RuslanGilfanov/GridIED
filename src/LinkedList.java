public class LinkedList extends GameGrid{

    public Node headNode;

    public void addHeadNode(int x, int y){

        Node oNewNode = new Node();
        oNewNode.xPosition = x;
        oNewNode.yPosition = y;

        oNewNode.nextNode = headNode;
        headNode = oNewNode;
    }

    public Node removeHeadNode(){

        Node oTempNode = headNode;
        headNode = headNode.nextNode;
        return oTempNode;
    }
}