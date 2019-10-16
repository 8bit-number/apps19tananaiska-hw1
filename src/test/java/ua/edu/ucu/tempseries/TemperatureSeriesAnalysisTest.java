package ua.edu.ucu.tempseries;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TemperatureSeriesAnalysisTest {

    private TemperatureSeriesAnalysis seriesAnalysis1;
    private TemperatureSeriesAnalysis seriesAnalysis2;

    @Before
    public void setup() {
        double[] tSeries1 = {3.0, -5.0, 1.0, 5.0};
        double[] tSeries2 = {5, 122, 0.1, 9, -0.1, 10};

        TemperatureSeriesAnalysis seriesAnalysis1 = new TemperatureSeriesAnalysis(tSeries1);
        TemperatureSeriesAnalysis seriesAnalysis2 = new TemperatureSeriesAnalysis(tSeries2);

        this.seriesAnalysis1 = seriesAnalysis1;
        this.seriesAnalysis2 = seriesAnalysis2;

    }

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        double expResult = 1.0;
        double actualResult = seriesAnalysis1.average();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testDeviation() {
        double expResult = 43.85079500102846;
        double actResult = seriesAnalysis2.deviation();
        assertEquals(expResult, actResult, 0.000001);

    }

    @Test
    public void testMin() {
        double expResult = -0.1;
        double actResult = seriesAnalysis2.min();
        assertEquals(expResult, actResult, 0);
    }

    @Test
    public void testMax() {
        double expResult = 122;
        double actResult = seriesAnalysis2.max();
        assertEquals(expResult, actResult, 0);
    }

    @Test
    public void testFindTempClosestToZero() {
        double expResult = 0.1;
        double actResult = seriesAnalysis2.findTempClosestToZero();
        assertEquals(expResult, actResult, 0);
    }

    @Test
    public void testFindTempClosestToValue() {
        double expResult = 10;
        double actResult = seriesAnalysis2.findTempClosestToValue(9);
        assertEquals(expResult, actResult, 0);
    }

    @Test
    public void testFindTempsLessThen() {
        double[] expResult = {5, 0.1, 9, -0.1};
        double[] actResult = seriesAnalysis2.findTempsLessThen(10);
        Assert.assertArrayEquals(expResult, actResult, 0);
    }

    @Test
    public void testFindTempsGreaterThen() {
        double[] expResult = {5, 122, 0.1, 9, 10};
        double[] actResult = seriesAnalysis2.findTempsGreaterThen(0.1);
        Assert.assertArrayEquals(expResult, actResult, 0);
    }

    @Test
    public void testSummaryStatistics() {
        double expResult = 122;
        double actResult = seriesAnalysis2.summaryStatistics().getMaxTemp();
        assertEquals(expResult, actResult, 0);
    }

    @Test
    public void testAddTemps() {
        double expResult = 169.3;
        double actResult = seriesAnalysis2.addTemps(2, -9.7, 12, 19);
        assertEquals(expResult, actResult, 0);

    }
}