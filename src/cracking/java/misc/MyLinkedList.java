public class MyLinkedList {
    private MyNode currentNode;
    public MyNode next(){
        if(currentNode == null)
            return null;

        var ret = currentNode;

        currentNode = currentNode.nextNode();

        return ret;
    }

    public void add(int hash, Object element){
        var node = new MyNode(hash, element);

        if(currentNode == null)
            currentNode = node;
        else
        {
            lastNode().setNextNode(node);
        }
    }
    private MyNode lastNode(){
        var tempNode = currentNode;

        while(tempNode.nextNode()!=null)
            tempNode = tempNode.nextNode();

        return tempNode;
    }
}
