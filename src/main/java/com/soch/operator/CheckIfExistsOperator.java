package com.soch.operator;

import com.soch.ObjectGenerator;
import com.soch.Operator;

import java.util.Random;
import java.util.Set;

public class CheckIfExistsOperator implements Operator {

    @Override
    public void performOperation(Set set, ObjectGenerator objectGenerator, Random random) {
        set.contains(objectGenerator.getRandomTestObject(random));
    }

    @Override
    public String getOperationName() {
        return "Check if exists";
    }
}
