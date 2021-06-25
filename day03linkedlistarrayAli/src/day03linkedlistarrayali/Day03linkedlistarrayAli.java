package day03linkedlistarrayali;

import java.lang.reflect.Array;

class Person {

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    String name;
    int age;

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", age=" + age + '}';
    }

}

/*
class TestMe<T> {
    // Example: how to create and return a generic array
    public T[] makeArray(Class<T> type, T val0, T val1) {
        T[] array = (T[]) Array.newInstance(type, 2);
        array[0] = val0;
        array[1] = val1;
        return array;
    }

} */

/* @author alagh */
public class Day03linkedlistarrayAli {

    public static void main(String[] args) {
       /*  
        LinkedListArray<Person> llap = new LinkedListArray<>();
        llap.add(new Person("Jerry", 33));
        llap.add(new Person("Terry", 33));
        llap.add(new Person("Larry", 33));
        System.out.println(llap);
        */
        LinkedListArray<Person> llap = new LinkedListArray<>();
        llap.add(new Person("Jerry", 33));
        Person per = new Person("Terry", 33);
        llap.add(per);
        llap.add(new Person("Larry", 33));
        llap.deleteByValue(per);
        System.out.println(llap);
        
        /*
        LinkedListArray<Person> llap = new LinkedListArray<>();
        llap.add(new Person("Jerry", 33));
        llap.add(new Person("Terry", 33));
        llap.add(new Person("Larry", 33));
        System.out.println(llap.toArray());
        */
        

    }
    
}
