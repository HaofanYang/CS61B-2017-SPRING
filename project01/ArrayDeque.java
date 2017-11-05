public class ArrayDeque<datatype>{

    /* 
    Circular structure, namely we start adding items from the middle of an array

    e.g.
        nextFirst
           | nextLast
           | |
     0 1 2 3 4 5 6
    [0,0,0,0,0,0,0]  (this is a empty list)
    size = 0
    nextFirst = 3 (this is the index of the array where you add an item by using 'addFirst')
    nextLast = 4

    if we implement addFirst(5), we will get：
      nextFist
         |  nextLast
         |   |
     0 1 2 3 4 5 6
    [0,0,0,5,0,0,0]  (this is a empty list)
    size = 1
    nextFirst = 2
    nextLast = 4          
    */


    private datatype[] items;
    private int size;
    public int nextLast;
    public int nextFirst;

    /** construct an empty list*/
    public ArrayDeque(){
        items = (datatype[]) new Object[7];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }

    /*
    private void resizing(){
        datatype[] a = (datatype[]) new Object[size * 2];
        System.arraycopy(items, 0, a, nextFirst - 1, size);
        items = a;
    }
    */

    /* increase a postion by 1, if the pointer is the end of the array, retrun to 0 */
    private int positionPlus(int p){
        if (p >= items.length - 1){
            p = 0;
        }else{
            p += 1;
        }
        return p;
    }

    /* decrease a postion by 1, if the pointer is 0, retrun to the end of the array */
    private int positionMinus(int p){
        if (p == 0){
            p = items.length - 1;
        }else{
            p -= 1;
        }
        return p;
    }

    /** TODO consider resizing and circular*/
    public void addFirst(datatype i){
        items[nextFirst] = i;
        size += 1;
        nextFirst = positionMinus(nextFirst);
    }

    /** TODO consider circular data structure*/
    public void addLast(datatype l){
        items[nextLast] = l;
        size += 1;
        nextLast = positionPlus(nextLast);
    }

    /** tell if a list is empty */
    public boolean isEmpty(){
        return (size == 0);
    }

    /** return the size value */
    public int size(){
        return size;
    }

    /** Print out the Deque */
    /** TODO boundary case!!! when the array is full */
    public void printDeque(){
        int start = positionPlus(nextFirst);
        int end = positionMinus(nextLast);
        int count = start;
        while (count != end){
            System.out.print(items[count]);
            System.out.print(" ");
            count = positionPlus(count);
        }
    }

    /** remove the first item */
    public datatype removeFirst(){
        nextFirst = positionMinus(nextFirst);
        datatype result = items[nextFirst];
        items[nextFirst] = null;
        size -= 1;
        return result;
    }

    /** remove the last item */
    public datatype removeLast(){
        nextLast = positionMinus(nextLast);
        datatype result = items[nextLast];
        items[nextLast] = null;
        return result;
    }

    /** TODO */
    public datatype get(int index){
        return null;
    }


}