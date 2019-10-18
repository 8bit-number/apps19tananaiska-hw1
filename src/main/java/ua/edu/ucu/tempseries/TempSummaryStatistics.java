package ua.edu.ucu.tempseries;

/**
 * The type Temp summary statistics.
 */
public class TempSummaryStatistics {
    private double avgTemp;
    private double devTemp;
    private double minTemp;
    private double maxTemp;


    /**
     * Instantiates a new Temp summary statistics.
     *
     * @param avg the avg
     * @param dev the dev
     * @param min the min
     * @param max the max
     */
    public TempSummaryStatistics(double avg, double dev, double min,
                                 double max) {

        avgTemp = avg;
        devTemp = dev;
        minTemp = min;
        maxTemp = max;
    }

    /**
     * Gets avg temp.
     *
     * @return the avg temp
     */
    public double getAvgTemp() {
        return avgTemp;
    }

    /**
     * Gets dev temp.
     *
     * @return the dev temp
     */
    public double getDevTemp() {
        return devTemp;
    }

    /**
     * Gets min temp.
     *
     * @return the min temp
     */
    public double getMinTemp() {
        return minTemp;
    }

    /**
     * Gets max temp.
     *
     * @return the max temp
     */
    public double getMaxTemp() {
        return maxTemp;
    }
}
