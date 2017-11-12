public class LinkedListDeque<datatype>{


    /** StuffNode is the actual core data */
    public class StuffNode{
        public StuffNode previous;
        public datatype item;
        public StuffNode next;

        public StuffNode(StuffNode p,datatype i, StuffNode n){
            previous = p;
            item = i;
            next = n;
        }
    }

    private StuffNode sentinel;
    private int size;

    /** construct an empty list*/
    public LinkedListDeque(){
        sentinel = new StuffNode(null,null,null);
        sentinel.next = sentinel;
        sentinel.previous = sentinel.next;
        size = 0;
    }

    /** a precious of sentinel is itself and so does next*/
    public LinkedListDeque(datatype i){
        sentinel = new StuffNode(null,null,null);
        sentinel.next = new StuffNode(sentinel, i, sentinel);
        sentinel.previous = sentinel.next;
        size = 1;
    }


    /** add i at the front of the list */
    public void addFirst(datatype i){
        sentinel.next = new StuffNode(sentinel, i, sentinel.next);
        sentinel.next.previous = sentinel.next;
        size = size + 1;
    }

    /** add i at the end of the list */
    public void addLast(datatype l){
        sentinel.previous = new StuffNode(sentinel.previous, l, sentinel);
        sentinel.previous.previous.next = sentinel.previous;
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
        StuffNode p = sentinel;
        p = p.next;
        while (p != sentinel){
            System.out.print(p.item);
            System.out.print(" ");
            p = p.next;
        }
    }

    /** Remove the first item of the queue and return it*/
    public datatype removeFirst(){
        if (this.size == 0){
            return null;
        }
        datatype result = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.previous = sentinel;
        size = size - 1;
        return result;
    }

    /** Remove the last item and return it */
    public datatype removeLast(){
        if (this.size == 0){
            return null;
        }
        datatype result = sentinel.previous.item;
        sentinel.previous = sentinel.previous.previous;
        sentinel.previous.next = sentinel;
        size = size - 1;
        return result;
    }

    /** return ith value of the queue */
    public datatype get(int index){
        if (index > (size - 1)){
            return null;
        }
        StuffNode q = sentinel;
        q = q.next;
        int count = 0;
        while (count < index){
            q = q.next;
            count = count + 1;
        }
        return q.item;
    }

    public datatype getRecursive(int index){
        if (index > (size - 1)){
            return null;
        }
        LinkedListDeque<datatype> p = this;
        if (index == 0){
            return sentinel.next.item;
        }
        p.sentinel = p.sentinel.next;
        return p.getRecursive(index - 1);

    }
}
