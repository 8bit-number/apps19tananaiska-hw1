package ua.edu.ucu.tempseries;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The type Temperature series analysis test.
 */
public class TemperatureSeriesAnalysisTest {

    private TemperatureSeriesAnalysis series4El;
    private TemperatureSeriesAnalysis series6El;
    private TemperatureSeriesAnalysis series1El;
    private TemperatureSeriesAnalysis series0El;

    /**
     * Sets .
     */
    @Before
    public void setup() {
        double[] series1 = {3.0, -5.0, 1.0, 5.0};
        double[] series2 = {5, 122, 0.1, 9, -0.1, 10};
        double[] series3 = {-1.0};
        double[] series4 = {};

        this.series0El = new TemperatureSeriesAnalysis(series4);
        this.series1El = new TemperatureSeriesAnalysis(series3);
        this.series4El = new TemperatureSeriesAnalysis(series1);
        this.series6El = new TemperatureSeriesAnalysis(series2);
    }

    /**
     * Test average with empty array.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        series0El.average();
    }

    /**
     * Test average with one element array.
     */
    @Test
    public void testAverageWithOneElementArray() {
        double expResult = -1.0;
        double actualResult = series1El.average();
        assertEquals(expResult, actualResult, 0.00001);
    }

    /**
     * Test average.
     */
    @Test
    public void testAverageWithFourElementArray() {
        double expResult = 1;
        double actualResult = series4El.average();
        assertEquals(expResult, actualResult, 0.00001);
    }

    /**
     * Test average.
     */
    @Test
    public void testAverageWithSixElementArray() {
        double expResult = 24.333333333333332;
        double actualResult = series6El.average();
        assertEquals(expResult, actualResult, 0.00001);
    }

    /**
     * Test deviation.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        series0El.deviation();

    }

    /**
     * Test deviation.
     */
    @Test
    public void testDeviationWithOneElementArray() {
        double expResult = 0.0;
        double actResult = series1El.deviation();
        assertEquals(expResult, actResult, 0.000001);
    }


    /**
     * Test deviation.
     */
    @Test
    public void testDeviationWithFourElementArray() {
        double expResult = 3.7416573867739413;
        double actResult = series4El.deviation();
        assertEquals(expResult, actResult, 0.000001);
    }

    /**
     * Test deviation.
     */
    @Test
    public void testDeviationWithSixElementArray() {
        double expResult = 43.85079500102846;
        double actResult = series6El.deviation();
        assertEquals(expResult, actResult, 0.000001);
    }

    /**
     * Test min.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        series0El.min();
    }

    /**
     * Test min.
     */
    @Test
    public void testMinWithOneElementArray() {
        double expResult = -1.0;
        double actResult = series1El.min();
        assertEquals(expResult, actResult, 0);
    }

    /**
     * Test min.
     */
    @Test
    public void testMinWithFourElementArray() {
        double expResult = -5.0;
        double actResult = series4El.min();
        assertEquals(expResult, actResult, 0);
    }

    /**
     * Test min.
     */
    @Test
    public void testMinWithSixElementArray() {
        double expResult = -0.1;
        double actResult = series6El.min();
        assertEquals(expResult, actResult, 0);
    }

    /**
     * Test min.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        series0El.max();
    }

    /**
     * Test min.
     */
    @Test
    public void testMaxWithOneElementArray() {
        double expResult = -1.0;
        double actResult = series1El.max();
        assertEquals(expResult, actResult, 0);
    }

    /**
     * Test min.
     */
    @Test
    public void testMaxWithFourElementArray() {
        double expResult = 5.0;
        double actResult = series4El.max();
        assertEquals(expResult, actResult, 0);
    }

    /**
     * Test min.
     */
    @Test
    public void testMaxWithSixElementArray() {
        double expResult = 122;
        double actResult = series6El.max();
        assertEquals(expResult, actResult, 0);
    }

    /**
     * Test find temp closest to zero.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToZeroWithEmptyArray() {
        series0El.findTempClosestToValue(0);
    }

    /**
     * Test find temp closest to zero.
     */
    @Test
    public void testFindTempClosestToZeroWithOneElementArray() {
        double expResult = -1.0;
        double actResult = series1El.findTempClosestToValue(0);
        assertEquals(expResult, actResult, 0);
    }

    /**
     * Test find temp closest to zero.
     */
    @Test
    public void testFindTempClosestToZeroWithFourElementArray() {
        double expResult = 1.0;
        double actResult = series4El.findTempClosestToValue(0);
        assertEquals(expResult, actResult, 0);
    }

    /**
     * Test find temp closest to zero.
     */
    @Test
    public void testFindTempClosestToZeroWithSixElementArray() {
        double expResult = 0.1;
        double actResult = series6El.findTempClosestToValue(0);
        assertEquals(expResult, actResult, 0);
    }

    /**
     * Test find temp closest to value.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToValueWithEmptyArray() {
        series0El.findTempClosestToValue(9);
    }

    /**
     * Test find temp closest to value.
     */
    @Test
    public void testFindTempClosestToValueWithOneElementArray() {
        double expResult = -1.0;
        double actResult = series1El.findTempClosestToValue(-1.0);
        assertEquals(expResult, actResult, 0);
    }

    /**
     * Test find temp closest to value.
     */
    @Test
    public void testFindTempClosestToValueWithFourElementArray() {
        double expResult = 9;
        double actResult = series6El.findTempClosestToValue(9);
        assertEquals(expResult, actResult, 0);
    }

    /**
     * Test find temp closest to value.
     */
    @Test
    public void testFindTempClosestToValueWithSixElementArray() {
        double expResult = 122;
        double actResult = series6El.findTempClosestToValue(123);
        assertEquals(expResult, actResult, 0);
    }

    /**
     * Test find temps less then.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsLessThenWithEmptyArray() {
        series0El.findTempsLessThen(10);
    }

    /**
     * Test find temps less then.
     */
    @Test
    public void testFindTempsLessThenWithOneElementArray() {
        double[] expResult = {-1.0};
        double[] actResult = series1El.findTempsLessThen(2);
        Assert.assertArrayEquals(expResult, actResult, 0);
    }

    /**
     * Test find temps less then.
     */
    @Test
    public void testFindTempsLessThenWithFourElementArray() {
        double[] expResult = {-5.0, 1.0};
        double[] actResult = series4El.findTempsLessThen(3.0);
        Assert.assertArrayEquals(expResult, actResult, 0);
    }

    /**
     * Test find temps less then.
     */
    @Test
    public void testFindTempsLessThenWithSixElementArray() {
        double[] expResult = {5, 0.1, 9, -0.1};
        double[] actResult = series6El.findTempsLessThen(10);
        Assert.assertArrayEquals(expResult, actResult, 0);
    }

    /**
     * Test find temps greater then.
     */
    @Test
    public void testFindTempsGreaterThenWithSixElementArray() {
        double[] expResult = {5, 122, 0.1, 9, 10};
        double[] actResult = series6El.findTempsGreaterThen(0.1);
        Assert.assertArrayEquals(expResult, actResult, 0);
    }

    /**
     * Test summary statistics.
     */
    @Test
    public void testSummaryStatistics() {
        double expResult = 122;
        double actResult = series6El.summaryStatistics().getMaxTemp();
        assertEquals(expResult, actResult, 0);
    }

    /**
     * Test add temps.
     */
    @Test
    public void testAddTemps() {
        double expResult = 10;
        double actResult = series6El.addTemps(2, -9.7, 12, 19);
        assertEquals(expResult, actResult, 0);

    }
}