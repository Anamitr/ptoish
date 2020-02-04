package com.soch;

public class TestObject implements Comparable {

    Long id;

    Integer testInt;
    String testString;
    Boolean testBoolean;
    Double testDouble;

    public TestObject(Long id, Integer testInt, String testString, Boolean testBoolean, Double testDouble) {
        this.id = id;
        this.testInt = testInt;
        this.testString = testString;
        this.testBoolean = testBoolean;
        this.testDouble = testDouble;
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
