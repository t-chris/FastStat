import java.util.Arrays;

public class Statistics {
    public static double[] convertData(String s) { //Converts textbox string into doubles array.
        String[] strData = s.split(" ");
        double[] data = new double[strData.length];
        for (int i = 0 ; i < strData.length ; i++) {
            data[i] = Integer.parseInt(strData[i]);
        }
        return data; //Data will be used to calculate everything else.
    }
    
    public static double mean(double[] d) {
        double sum = 0;
        for (int i = 0; i < d.length; i++) {
            sum += d[i];
        }
        return sum/d.length;
    }
    
    public static double median(double[] d) {
        Arrays.sort(d);
        if (d.length%2 == 0) {
            return (d[d.length%2] + d[d.length%2-1])/2;
        }
        else {
            return d[(int)d.length%2];
        }
    }
    
    public static double mode(double[] d) { //Multi-modal sets will be an issue.
        double maxVal = 0;
        double maxCount = 0;
        
        for (int i = 0 ; i < d.length ; i++) {
            int count = 0;
            for (int j = 0 ; j < d.length ; j++) {
                if (d[j] == d[i]) {
                    count++;
                }
                if (count > maxCount) {
                    maxVal = d[i];
                }
            }
        }
        return maxVal;
    }
    
    public static double range(double[] d) {
        Arrays.sort(d);
        return d[d.length-1] - d[0];
    }
    
    public static double var(double[] d) {
        double tempVal = 0;
        for (int i = 0 ; i < d.length ; i++) {
            tempVal += (d[i] - mean(d))*(d[i] - mean(d));
        }
        
        return tempVal/(d.length-1);
    }
    
    public static double std (double[] d) {
        return var(d)*var(d);
    }
    
    public static double max (double[] d) {
        double max = Double.MIN_VALUE;
        for (int i = 0 ; i < d.length ; i++) {
            if (d[i] > max) {
                max = d[i];
            }
        }
        return max;
    }
    
    public static double min (double[] d) {
        double min = Double.MAX_VALUE;
        for (int i = 0 ; i < d.length ; i++) {
            if (d[i] < min) {
                min = d[i];
            }
        }
        return min;
    }
}


