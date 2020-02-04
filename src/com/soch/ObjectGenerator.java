package com.soch;

import java.util.Random;

public class ObjectGenerator {
    long i = 0;

    public TestObject getNextTestObject() {
        return new TestObject(i++, 453, "asdf", true, 4.324);
    }

    public TestObject getRandomTestObject(Random random) {
        return new TestObject(i++, random.nextInt(), new Float(random.nextFloat()).toString(), false, random.nextDouble());
    }
}
