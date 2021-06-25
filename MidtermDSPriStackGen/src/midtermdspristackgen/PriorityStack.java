package midtermdspristackgen;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

/* @author ali alaghbandrad */
public class PriorityStack<T> {
    private class Container<T> {
		// add a constructor and/or toString if you like
        T value;
        boolean hasPriority;
        Container<T> nextBelow;
		// you are NOT allowed to add "previousAbove" reference
    }
    
    private Container<T> top; // top of the stack element

    private int size;

    public void push(T value) {
        push(value, false);
    }
    
    public void push(T value, boolean hasPriority) {
        Container newCont = new Container();
        newCont.value = value;
        newCont.hasPriority = hasPriority;
        newCont.nextBelow = top;
        top = newCont;
        size++;
    }
    
    public T pop() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Container<T> topCont = top;
        top = top.nextBelow;
        size--;
        return topCont.value;
    }

    public T popPriority() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Container<T> belowCont = null;
        for (Container<T> current = top; current !=null; current = current.nextBelow) {
            if (current.hasPriority) {
                if (current == top) {
                    return pop();
                }
                belowCont.nextBelow = current.nextBelow;
                size--;
                return current.value;
            }
            belowCont = current;
        }
        return pop();
    }
    
    
    public int hasValue(T value) {
        int place = 0;
        for (Container current = top; current != null; current = current.nextBelow) {
            if (current.value.equals(value)) {
                return place;
            }
            place++;
        }
        return -1;  // returns -1 if value is not on the stack
    }
    
    public T removeValue(T value) {
        Container<T> belowCont = null;
        for (Container<T> current = top; current != null; current = current.nextBelow) {
            if (current.value.equals(value)) {
                if (current == top) {   // Special case: removing the first item
                    return pop();
                }
                belowCont.nextBelow = current.nextBelow;
                size--;
                return current.value;
            }
            belowCont = current;
        }
        throw new NoSuchElementException();
    }
    
    public int getSize() {
        return size;
    }
    
    public void reorderByPriority() {
        Object[] newStack = new Object[size];   // re-create a new stack
        int itemNum = 0;
        for (Container<T> current = top; current != null; current = current.nextBelow) {    // To obtain items that have Priority
            if (current.hasPriority) {
                newStack[itemNum] = current;
                itemNum++;
            }
        }
        for (Container<T> current = top; current != null; current = current.nextBelow) {    // To obtain items that DON'T have Priority
            if (!current.hasPriority) {
                newStack[itemNum] = current;
                itemNum++;
            }
        }
        
        size = 0;
        top = null;
        for (int x = newStack.length-1; x >= 0; x--) {  // To fill the new stack
            Container<T> item = (Container<T>) newStack[x];
            push(item.value, item.hasPriority);
        }
  
    }
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");         
        for (Container<T> current = top; current != null; current = current.nextBelow) {
            sb.append(current == top ? "" : ","); // comma comes after first item
            sb.append(current.value.toString());
            sb.append(current.hasPriority ? ":P" : ":N");
        }
        sb.append("]");
        return sb.toString();
    }
    
    private T[] reversed;
    private int reversedCount;
    
   
    public T[] toArrayReversed(Class<T> type) {
        //@SuppressWarnings("unchecked")
        // T[] reversed = (T[]) Array.newInstance(new Container().value.getClass(), size);

        reversed = (T[]) Array.newInstance(type, size);
        ReversingItems(top);
        return reversed;
    }
    
    private void ReversingItems(Container<T> item) {
        if (item != null) {
            ReversingItems(item.nextBelow);
            reversed[reversedCount] = item.value;
            reversedCount++;
        }
    }
 
}
