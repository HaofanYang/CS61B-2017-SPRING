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
    nextFirst = 3 
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
    /*
    resize an array


    OLD ONE:

      nextFirst
       | nextLast
       | |
     0 1 2 3 4 5 6
    [6,7,1,2,3,4,5]


    NEW ONE:

     nextLast     nextFirst
         |           |
         |           |
     0 1 2 3 4 5 6 7 8 9 10 11 12 13
    [6,7,0,0,0,0,0,0,0,1,2 ,3 ,4 ,5]

    */
    private void resizing(){
        datatype[] a = (datatype[]) new Object[size * 2];
        System.arraycopy(items, 0, a, 0, positionMinus(nextLast) + 1);
        int sizeIncreased = a.length - size;
        if (nextFirst == (size - 1) ){
            System.arraycopy(items, positionPlus(nextFirst), a, nextFirst + sizeIncreased + 1, 0 );
        }else{
             System.arraycopy(items, positionPlus(nextFirst), a, nextFirst + sizeIncreased + 1, size - positionPlus(nextFirst) );
        }
        nextLast = positionMinus(nextLast) + 1;
        nextFirst = nextFirst + sizeIncreased;
        items = a;
    }

    private void shrink(){
        datatype[] a = (datatype[]) new Object[size / 2];
        int sizeDecreased = items.length - a.length;
        System.arraycopy(items, 0, a, 0, positionMinus(nextLast) + 1);
        if (nextFirst == (size - 1) ){
            System.arraycopy(items, positionPlus(nextFirst), a, nextFirst - sizeDecreased + 1, 0 );
        }else{
             System.arraycopy(items, positionPlus(nextFirst), a, nextFirst - sizeDecreased + 1, size - positionPlus(nextFirst) );
        }
        nextLast = positionMinus(nextLast) + 1;
        nextFirst = nextFirst - sizeDecreased;
        items = a;
    }

    public double efficiency(){
        return (double) size / (double) items.length;
    }

    /** Add an item at the front */
    public void addFirst(datatype i){
        if (size == items.length){
            resizing();
        }
        items[nextFirst] = i;
        size += 1;
        nextFirst = positionMinus(nextFirst);
    }

    /** Add an item at the end */
    public void addLast(datatype l){
        if (size == items.length){
            resizing();
        }
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
    public void printDeque(){
        if (size == 0){
            System.out.println("Empty array");
            return;
        }
        int count = positionPlus(nextFirst);
        /* to solve the nasty boundary case, we print out the first item outside the loop */
        System.out.print(items[count]);
        System.out.print(" ");
        count = positionPlus(count);
        while (count != nextLast){
            System.out.print(items[count]);
            System.out.print(" ");
            count = positionPlus(count);
        }
    }

    /** remove the first item */
    public datatype removeFirst(){
        if (efficiency() < 0.25){
            shrink();
        }
        nextFirst = positionPlus(nextFirst);
        datatype result = items[nextFirst];
        items[nextFirst] = null;
        size -= 1;
        return result;
    }

    /** remove the last item */
    public datatype removeLast(){
        if (efficiency() < 0.25){
            shrink();
        }
        nextLast = positionMinus(nextLast);
        datatype result = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        return result;
    }

    /** TODO */
    public datatype get(int index){
        int firstIndex = positionPlus(nextFirst);
        /* number of elements from the first one to the end */
        int numOfRem = (items.length - firstIndex);
        if (index + 1 > numOfRem){
            return items[index - numOfRem];
        }
        return items[firstIndex + index];
    }
}