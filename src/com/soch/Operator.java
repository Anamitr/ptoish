package com.soch;

import java.util.Random;
import java.util.Set;

public interface Operator {
    void performOperation(Set set, ObjectGenerator objectGenerator, Random random);
    String getOperationName();

}
