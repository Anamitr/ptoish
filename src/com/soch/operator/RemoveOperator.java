package com.soch.operator;

import com.soch.ObjectGenerator;
import com.soch.Operator;

import java.util.Random;
import java.util.Set;

public class RemoveOperator implements Operator {
    @Override
    public void performOperation(Set set, ObjectGenerator objectGenerator, Random random) {
        set.remove(objectGenerator.getRandomTestObject(random));
    }

    @Override
    public String getOperationName() {
        return "Remove";
    }
}
