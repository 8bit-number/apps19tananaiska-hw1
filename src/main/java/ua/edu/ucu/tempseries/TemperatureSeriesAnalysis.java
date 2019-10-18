package ua.edu.ucu.tempseries;

import java.util.Arrays;
import java.util.InputMismatchException;


/**
 * The type TemperatureSeriesAnalysis.
 */
public class TemperatureSeriesAnalysis {
    private static final double MIN_TEMPERATURE = -273.0;
    private double[] temperatureSeries;
    private int len;


    /**
     * Instantiates a new Temperature series analysis object.
     *
     * @param temperatureSeries the temperature series -
     *                          initial array,
     *                          that contains values of temperatures.
     */
    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] < MIN_TEMPERATURE) {
                throw new InputMismatchException();
            }
        }
        this.temperatureSeries = Arrays.copyOf(temperatureSeries,
                temperatureSeries.length);
        this.len = this.temperatureSeries.length;
    }

    private void isEmpty() {
        if (len < 1) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Average double.
     *
     * @return the double - average value in whole array.
     */
    public double average() {
        isEmpty();
        double sum = 0;
        for (int i = 0; i < len; i++) {
            sum = sum + temperatureSeries[i];
        }
        return sum / len;
    }

    /**
     * Deviation double.
     *
     * @return the double - standard deviation for all values in array.
     */
    public double deviation() {
        isEmpty();
        double averageVal = average();
        double nom = 0;
        for (int i = 0; i < len; i++) {
            nom = nom + (temperatureSeries[i] - averageVal)*
                    (temperatureSeries[i] - averageVal);
        }
        return Math.sqrt(nom / len);
    }

    /**
     * Min double.
     *
     * @return the double - minimum value in the array.
     */
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

    /**
     * Max double.
     *
     * @return the double - maximum value in the array.
     */
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

    /**
     * Find temp closest to zero double.
     *
     * @return the double - temperature, which value is the closest to zero.
     */
    public double findTempClosestToZero() {
        return findTempClosestToValue(0);
    }

    /**
     * Find temp closest to value double.
     *
     * @param tempValue the temp value
     * @return the double - temperature,
     * which value is the closest to one particular value.
     */
    public double findTempClosestToValue(double tempValue) {
        isEmpty();
        double val = temperatureSeries[0];
        double delta = temperatureSeries[0] - tempValue;
        for (int i = 0; i < len; i++) {
            if (Math.abs(temperatureSeries[i] - tempValue) < Math.abs(delta)) {
                delta = temperatureSeries[i] - tempValue;
                val = temperatureSeries[i];
            }
        }
        return val;
    }

    /**
     * Find temps less then double [ ].
     *
     * @param tempValue the temp value
     * @return the double [ ] - new array,
     * that contains values of temperatures,
     * that are less then the particular one.
     */
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

    /**
     * Find temps greater then double [ ].
     *
     * @param tempValue the temp value
     * @return the double [ ] - new array,
     * that contains values of temperatures,
     * that are greater then the particular one.
     */
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

    /**
     * Summary statistics temp summary statistics.
     *
     * @return the temp summary statistics -
     * the overall statistics for the input data.
     */
    public TempSummaryStatistics summaryStatistics() {
        double avgTemp = this.average();
        double devTemp = this.deviation();
        double minTemp = this.min();
        double maxTemp = this.max();

        return new TempSummaryStatistics(avgTemp, devTemp, minTemp, maxTemp);

    }

    /**
     * Add temps int.
     *
     * @param temps the temps
     * @return the int - the number of elements after new values of \
     * temperatures were added to the initial array of temperatures.
     */
    public int addTemps(double... temps) {
        int tempsLen = temps.length;
        int newLength = len;
        while (newLength < len + tempsLen) {
            newLength = newLength * 2;
        }
        double[] arr = Arrays.copyOf(temperatureSeries, newLength);
        for (int i = len, k = 0; i < newLength && k < tempsLen; i++, k++) {
            arr[i] = temps[k];
        }

        temperatureSeries = Arrays.copyOf(arr, arr.length);
        return len + tempsLen;
    }
}

