public class MyNode {
    private int hash;
    private Object element;
    private MyNode nextNode;
    public void setNextNode(MyNode nextNode){
        this.nextNode = nextNode;
    }
    public MyNode nextNode(){
        return this.nextNode;
    }

    public Object getElement(){return this.element;}

    MyNode(int hash, Object element){
        this.hash = hash;
        this.element = element;
    }
}
