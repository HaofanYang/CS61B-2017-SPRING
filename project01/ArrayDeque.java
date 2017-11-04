Public class LinkedListDeque<datatype>{


    /** StuffNode is the actual core data */
    public static class StuffNode{
        public StuffNode previous;
        public datatype item;
        public StuffNode next;

        public void StuffNode(StuffNode p, datatype i, StuffNode n){
            previous = p;
            item = i;
            next = n;
        }
    }

    private StuffNode sentinel;
    private int size();

    /** construct an empty list*/
    public void LinkedListDeque(){
        sentinel = new StuffNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.previous = sentinel.next;
        size = 0;
    }

    /** a precious of sentinel is itself and so does next*/
    public void LinkedListDeque(datatype i){
        sentinel = new StuffNode(null, null, null);
        sentinel.next = new StuffNode(sentinel, i, sentinel.next);
        sentinel.previous = sentinel.next;
        size = 1;
    }


    /** add i at the front of the list */
    public void addFirst(datatype i){
        sentinel.next = new StuffNode(sentinel, i, sentinel.next);
        size = size + 1;
    }

    /** add i at the end of the list */
    public void addLast(datatype l){
        sentinel.previous = new StuffNode(sentinel.previous, l, sentinel);
        size = size + 1;
    }

    /** tell if a list is empty */
    public boolean isEmpty(){
        return (size == 0);
    }

    /** return the size value */
    public int size(){
        return size;
    }

    /** print out the list */
    public void printDeque(){
        if (this.isEmpty()){
            System.out.println("the queue is empty");
            return;
        }
        LinkedListDeque p = sentinel;
        p = p.next;
        while (p.next != sentinel){
            System.out.print(p.item);
            System.out.print(" ");
            p = p.next;
        }
    }

    /** Remove the first item of the queue */
    public datatype removeFirst(){
        datatype result = sentinel.next.item;
        sentinel.next = new StuffNode(sentinel)
        return result;
    }

    /** TODO */
    public Item removeLast(){
        return null;
    }

    /** TODO */
    public Item get(int index){
        return null;
    }

}