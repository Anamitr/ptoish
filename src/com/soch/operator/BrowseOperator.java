package com.soch.operator;

import com.soch.ObjectGenerator;
import com.soch.Operator;

import java.util.Random;
import java.util.Set;

public class BrowseOperator implements Operator {

    @Override
    public void performOperation(Set set, ObjectGenerator objectGenerator, Random random) {
        for(Object object : set) {
            object.toString();
        }
    }

    @Override
    public String getOperationName() {
        return "Browse";
    }
}
