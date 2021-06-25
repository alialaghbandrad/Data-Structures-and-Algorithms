/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day03linkedlistarrayali;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alagh
 */
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

public class LinkedListArrayTest {
    
    @Test
    public void addTest() {
    LinkedListArray<Person> llap = new LinkedListArray<>();
        llap.add(new Person("Jerry", 33));
        llap.add(new Person("Terry", 33));
        llap.add(new Person("Larry", 33));
        assertEquals("[Person{name=Jerry, age=33},Person{name=Terry, age=33},Person{name=Larry, age=33}]", llap.toString());
    }
    
    @Test
    public void addInsertTest() {
    LinkedListArray<Person> llap = new LinkedListArray<>();
        llap.add(new Person("Jerry", 33));
        llap.add(new Person("Terry", 33));
        llap.add(new Person("Larry", 33));
        llap.insertValueAtIndex(new Person("Jack", 45), 1);
        assertEquals("[Person{name=Jerry, age=33},Person{name=Jack, age=45},Person{name=Terry, age=33},Person{name=Larry, age=33}]", llap.toString());
    }
    
    @Test
    public void addDeleteByIndexTest() {
    LinkedListArray<Person> llap = new LinkedListArray<>();
        llap.add(new Person("Jerry", 33));
        llap.add(new Person("Terry", 33));
        llap.add(new Person("Larry", 33));
        llap.deleteByIndex(1);
        assertEquals("[Person{name=Jerry, age=33},Person{name=Larry, age=33}]", llap.toString());
    }
    
    @Test
    public void addDeleteByValueTest() {
    LinkedListArray<Person> llap = new LinkedListArray<>();
        llap.add(new Person("Jerry", 33));
        Person per = new Person("Terry", 34);
        llap.add(per);
        llap.add(new Person("Larry", 33));
        llap.deleteByValue(per);
        assertEquals("[Person{name=Jerry, age=33},Person{name=Larry, age=33}]", llap.toString());
    }
    
    @Test
    public void testAddToStringToArray() {
        LinkedListArray<Person> llap = new LinkedListArray<>();
        llap.add(new Person("Jerry", 33));
        llap.add(new Person("Terry", 33));
        llap.add(new Person("Larry", 33));
        assertEquals(3, llap.getSize());    // testGetSize()
        assertEquals("[Person{name=Jerry, age=33},Person{name=Terry, age=33},Person{name=Larry, age=33}]", llap.toString());   // testToString()
        
        String[] expResult = {"Person{name=Jerry, age=33","Person{name=Terry, age=33}","Person{name=Larry, age=33"};
        Person[] result = llap.toArray();
        assertArrayEquals(expResult, result);
        
    }
    
}
