package com.soch;

import com.soch.operator.AddOperator;
import com.soch.operator.BrowseOperator;
import com.soch.operator.CheckIfExistsOperator;
import com.soch.operator.RemoveOperator;
import javafx.util.Pair;
import org.jfree.ui.RefineryUtilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {

    static ObjectGenerator objectGenerator = new ObjectGenerator();
    static Random random = new Random();

    static final int SET_SIZE_POWER_OF_TEN = 7;

    public static void main(String[] args) {
        System.out.println("PTOiSH");

        List<Set> setList = new LinkedList();
        setList.add(new HashSet());
        setList.add(new LinkedHashSet());
        setList.add(new TreeSet());

        List<Operator> operatorList = new LinkedList<>();
        operatorList.add(new AddOperator());
        operatorList.add(new RemoveOperator());
        operatorList.add(new BrowseOperator());
        operatorList.add(new CheckIfExistsOperator());

        for(Operator operator : operatorList) {
            Map<String, List<Pair>> operatorData = new HashMap<>();
            for (Set set : setList) {
                List<Pair> resultData = testSetWithOperator(set, operator);
                operatorData.put(set.getClass().getSimpleName(), resultData);
//                plotData(operator.getOperationName(), resultData);
            }
            plotData(operator.getOperationName(), operatorData);
        }
    }

    private static List<Pair> testSetWithOperator(Set set, Operator operator) {
        List<Pair> resultData = new LinkedList<Pair>();
        for (int i = 1; i < SET_SIZE_POWER_OF_TEN; i++) {
            set.clear();
            int numOfUnits = new Double(Math.pow(10, i)).intValue();
            fillSet(set, i);
            Long timeBefore = System.nanoTime();
            operator.performOperation(set, objectGenerator, random);
            Long timeAfter = System.nanoTime();
            Long timeElapsed = (timeAfter - timeBefore);
            System.out.println(operator.getOperationName() + " " + i + ": " + numOfUnits + ": " + timeElapsed);
            resultData.add(new Pair(numOfUnits, timeElapsed));
        }
        return resultData;
    }

    private static void fillSet(Set set, int browsingPowerOfTen) {
        int numOfUnits = new Double(Math.pow(10, browsingPowerOfTen)).intValue();
        ObjectGenerator objectGenerator = new ObjectGenerator();
        Random random = new Random();
        for(int i = 0; i < numOfUnits; i++) {
            set.add(objectGenerator.getRandomTestObject(random));
        }
    }

    private static void plotData(String operationName, Map<String, List<Pair>> resultData) {
        final Plotter plotter = new Plotter(operationName, resultData);
        plotter.pack();
        RefineryUtilities.centerFrameOnScreen(plotter);
        plotter.setVisible(true);
    }

    private static String getTimeAsString(Long time) {
        Date date = new Date(time);
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
        return formatter.format(date);
    }


}
