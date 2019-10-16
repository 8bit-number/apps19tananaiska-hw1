package ua.edu.ucu.tempseries;
//import sun.tools.tree.ThisExpression;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    private double[] temperatureSeries;
    private int len;

//    public TemperatureSeriesAnalysis() {
//        this.temperatureSeries = new double[1];
//        this.len = 1;
//    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] < -273.0) {
                throw new InputMismatchException();
            }
        }
        this.temperatureSeries = temperatureSeries;
        this.len = this.temperatureSeries.length;
    }

//    private double[] getArray() {
//        return temperatureSeries;
//    }
//
//    private int getSize() {
//        return len;
//    }

    private void isEmpty() {
        if (len < 1) {
            throw new IllegalArgumentException();
        }
    }

    public double average() {
        isEmpty();
        double sum = 0;
        for (int i = 0; i < len; i++) {
            sum = sum + temperatureSeries[i];
        }
        return sum / len;
    }

    public double deviation() {
        isEmpty();
        double averageVal = average();
        double nom = 0;
        for (int i = 0; i < len; i++) {
            nom = nom + Math.pow(temperatureSeries[i] - averageVal, 2);
        }
        return Math.sqrt(nom / len);
    }

    public double min() {
        isEmpty();
        double curr = temperatureSeries[0];
        for (int i = 0; i < len; i++) {
            if (temperatureSeries[i] < curr) {
                curr = temperatureSeries[i];
            }
        }
        return curr;
    }

    public double max() {
        isEmpty();
        double curr = temperatureSeries[0];
        for (int i = 0; i < len; i++) {
            if (temperatureSeries[i] >= curr) {
                curr = temperatureSeries[i];
            }
        }
        return curr;
    }

    public double findTempClosestToZero() {
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) {
        isEmpty();
        double delta = temperatureSeries[0] - tempValue;
        for (int i = 0; i < len; i++) {
            if (Math.abs(temperatureSeries[i] - tempValue) < Math.abs(delta)) {
                delta = temperatureSeries[i];
            }
        }
        return delta;
    }

    public double[] findTempsLessThen(double tempValue) {
        isEmpty();
        int counter = 0;
        for (int i = 0; i < len; i++) {
            if (temperatureSeries[i] < tempValue) {
                counter++;
            }
        }
        double[] array = new double[counter];
        int k = 0;
        for (int i = 0; i < len; i++) {
            if (temperatureSeries[i] < tempValue && k < len) {
                array[k] = temperatureSeries[i];
                k++;

            }

        }
        return array;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        isEmpty();
        int counter = 0;
        for (int i = 0; i < len; i++) {
            if (temperatureSeries[i] >= tempValue) {
                counter++;
            }
        }
        double[] array = new double[counter];
        int k = 0;
        for (int i = 0; i < len; i++) {
            if (temperatureSeries[i] >= tempValue && k < len) {
                array[k] = temperatureSeries[i];
                k++;

            }

        }
        return array;
    }

    public TempSummaryStatistics summaryStatistics() {
        double avgTemp = this.average();
        double devTemp = this.deviation();
        double minTemp = this.min();
        double maxTemp = this.max();

        return new TempSummaryStatistics(avgTemp, devTemp, minTemp, maxTemp);

    }

    public double addTemps(double... temps) {
        int newLength = 2 * len;
        double[] arr = new double[newLength];
//        for (int i = 0; i < len; i++) {
//            arr[i] = temperatureSeries[i];
//        }
        int startingIndex = newLength - len;
        int k = 0;
        for (int i = startingIndex; i < newLength; i++) {
            if (k < temps.length) {
                arr[i] = temps[k];
                k++;
            }
        }
        double sum = 0;
        for (int i = 0; i < newLength; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }

}

