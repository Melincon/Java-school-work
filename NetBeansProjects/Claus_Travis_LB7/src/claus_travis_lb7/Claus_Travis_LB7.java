package claus_travis_lb7;
public class Claus_Travis_LB7 {
    public static void main(String[] args) {
        double sum = 0.0;
        final int rowCount = 11;
        final int columnCount = 2;
        double average = 0.0;
        double highest = 0.0;
        double lowest = 0.0;
        double[][] oilTable = new double[rowCount]
                [columnCount];
        
        oilTable[0][0] = 333;
        oilTable[1][0] = 246;
        oilTable[2][0] = 129;
        oilTable[3][0] = 126;
        oilTable[4][0] = 105;
        oilTable[5][0] = 94;
        oilTable[6][0] = 87;
        oilTable[7][0] = 84;
        oilTable[8][0] = 78;
        oilTable[9][0] = 71;
        oilTable[10][0] = 609;
        
        for(int i = 0; i < rowCount; i++)
        sum += oilTable[i][0];
        
        for(int i = 0; i < rowCount; i++)
        oilTable[i][1] = (oilTable[i][0] / sum)
                * 100;
        
        for(int i = 0; i < rowCount; i++)
            System.out.printf("%.0%f %.1%\n", 
                    oilTable[i][0], oilTable[i][1]);
        
        for(int i = 0; i < rowCount; i++)
            if (oilTable[i][0] > highest)
                highest = oilTable[i][0];
        
        lowest = oilTable[1][0];
        for(int i = 0; i < rowCount; i++)
            if(oilTable[i][0] < lowest)
                lowest = oilTable[i][0];
                    
        System.out.printf("The average is %.1f\n",
                average);
        System.out.printf("The sum is %.0f\n",
                sum);
        System.out.print("");  
    } 
}
