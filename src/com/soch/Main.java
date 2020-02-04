package com.soch;

import com.soch.operator.AddOperator;
import com.soch.operator.BrowseOperator;
import com.soch.operator.CheckIfExistsOperator;
import com.soch.operator.RemoveOperator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {

    static ObjectGenerator objectGenerator = new ObjectGenerator();
    static Random random = new Random();

    static final int ADDING_POWER_OF_TEN = 7;
    static final int REMOVING_POWER_OF_TEN = 5;
    static final int BROWSING_POWER_OF_TEN = 5;
    static final int CHECKING_IF_EXISTS_POWER_OF_TEN = 5;

    public static void main(String[] args) {
        System.out.println("PTOiSH");

        List<Set> setList = new LinkedList();
        setList.add(new HashSet());
        setList.add(new LinkedHashSet());
        setList.add(new TreeSet());

        for (Set set : setList) {
            System.out.println("Testing class " + set.getClass().getSimpleName());
            testSetWithOperator(set, new AddOperator());
            testSetWithOperator(set, new RemoveOperator());
            testSetWithOperator(set, new BrowseOperator());
            testSetWithOperator(set, new CheckIfExistsOperator());
//            testAdding(set);
//            testRemoving(set);
//            testBrowsing(set);
//            testCheckingIfExists(set);
        }

//        while (true) {
//            testSet.add("testString");
//        }
    }

    private static void testSetWithOperator(Set set, Operator operator) {
        for (int i = 1; i < ADDING_POWER_OF_TEN; i++) {
            set.clear();
            int numOfUnits = new Double(Math.pow(10, i)).intValue();
            fillSet(set, i);
            Long timeBefore = System.nanoTime();
            operator.performOperation(set, objectGenerator, random);
            Long timeAfter = System.nanoTime();
            System.out.println(operator.getOperationName() + " " + i + ": " + numOfUnits + ": " + (timeAfter - timeBefore));
        }
    }

    private static void fillSet(Set set, int browsingPowerOfTen) {
        int numOfUnits = new Double(Math.pow(10, browsingPowerOfTen)).intValue();
        ObjectGenerator objectGenerator = new ObjectGenerator();
        Random random = new Random();
        for(int i = 0; i < numOfUnits; i++) {
            set.add(objectGenerator.getRandomTestObject(random));
        }
    }

    private static String getTimeAsString(Long time) {
        Date date = new Date(time);
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
        return formatter.format(date);
    }


}
