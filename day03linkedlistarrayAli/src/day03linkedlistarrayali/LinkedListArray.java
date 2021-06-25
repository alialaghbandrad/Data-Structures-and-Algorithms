package day03linkedlistarrayali;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

/* @author alagh */
public class LinkedListArray<T> {
    
    private class Container {
        Container next;
        T value;
    }

    private Container start, end;
    private int size;

    public void add(T value) {
        Container newCont = new Container();
        newCont.value = value;
        if (size == 0) { // special case: list is empty
            start = newCont;
            end = newCont;
            size = 1;
        } else {
            end.next = newCont; // last container's next changed to point to the new container
            end = newCont;
            size++;
        }
    }
    
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        // optional: special case for the last item
        if (index == size-1) {
            return end.value;
        }
        // regular search for the wanted item
        Container current = start;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public void deleteByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index == 0) { // special case: removing the first item
            start = start.next; // go "over" the 0th item
            size--;
            return; 
        }
        // find the container just before the one we want to delete
        Container before = start;
        for (int i = 0; i < index-1; i++) {
            before = before.next;
        }
        // when removing the last item adjust end reference
        //if (before.next.next == null) {
        if (index == size - 1) {
            end = before;
        }
        before.next = before.next.next; // go "over" the item being deleted
        size--;        
    }
    
    public boolean deleteByValue(T value) { // delete first value found
        Container current = start;
        for (int i = 0; i < size; i++) {
            if(current.value == value) {
                deleteByIndex(i);
                return true;
            }
            current = current.next;
        }
        return false;
    }
       
    
    
    public void insertValueAtIndex(T value, int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (size == 0 || index == size) {
            // Why? this avoids having to handle two special cases in our code
            // insert to an empty list is an add
            // insert at the end is an add
            add(value);
            return;
        }
        if (index == 0) { // insert at the beginning of a non-empty list
            Container newCont = new Container();
            newCont.value = value;
            newCont.next = start;
            start = newCont;
            size++;
            return;
        }
        // find the container just before the position at which we want to insert
        Container before = start;
        for (int i = 0; i < index-1; i++) {
            before = before.next;
        }
        Container newCont = new Container();
        newCont.value = value;
        newCont.next = before.next;
        before.next = newCont;
        size++;
    }
    
    public int getSize() {
        return size;
    }

    @Override
    public String toString() { // comma-separated values list similar to: [5,8,11]
        StringBuilder sb = new StringBuilder("[");
        for (Container current = start; current != null; current = current.next) {
            sb.append(current == start ? "" :  ",");
            sb.append(current.value); // this will call toString() on any type T object
        }
        sb.append("]");
        return sb.toString();
    } 

    public T[] toArray() { // could be used for Unit testing
        @SuppressWarnings("unchecked")
        // creating an array requires a template object so we instantiate Container() class
        T[] result = (T[]) Array.newInstance(new Container().value.getClass(), size);
        Container current = start;
        for (int i = 0; i < size; i++) {
            result[i] = current.value;
            current = current.next;
        }
        return result;
    }
    
}
