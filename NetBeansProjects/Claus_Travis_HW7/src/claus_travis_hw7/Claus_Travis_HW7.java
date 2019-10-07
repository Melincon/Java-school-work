package claus_travis_hw7;
import java.util.ArrayList;
public class Claus_Travis_HW7 {
    private final static int cS = 6;
    private final static int rS = 12;
    public static double cTotal(double[][] array, int c){
        double total = 0;
        for(int i = 0; i < cS; i++)
            total += array[i][c];
        return total;
    }
    public static double rTotal(double[][] array, int r){
        double total = 0;
        for(int i = 0; i <rS; i++)
            total += array[r][i];
        return total;
    }
    public static void fillArray(int[][] data, double[][] rate,
            double[][] populate){
       for(int r = 0; r < cS; r++)
           for(int c = 0; c < rS; c++)
               populate[r][c] = data[r][c]*rate[r][c];
       for(int i = 0; i < cS; i++)
           populate[i][12] = rTotal(populate,i)/rS;
       for(int i = 0; i <rS; i++)
           populate[6][i] = cTotal(populate,i)/cS;     
    }
    public static void fillTotal(double[][] populate, double[][] ccf,
            double[][] kw){
        for(int r = 0; r < cS; r++)
           for(int c = 0; c < rS; c++)
               populate[r][c] = ccf[r][c]+kw[r][c];
       for(int i = 0; i < cS; i++)
           populate[i][12] = rTotal(populate,i)/rS;
       for(int i = 0; i <rS; i++)
           populate[6][i] = cTotal(populate,i)/cS;
    }
    public static void printArray(double[][] array){
       for(int r = 0; r <= cS;r++){
           for(int c = 0; c <= rS; c++){
               System.out.printf("%4.2f",array[r][c]);
           System.out.print("  ");}
               System.out.println();}
       System.out.print("\n\n");
    } 
    public static void main(String[] args) {
        double[][] finalCcf = new double[7][13];
        double[][] finalKw = new double[7][13];
        double[][] finalTotal = new double[7][13];
   int[][] dataCcf = {{115,92,48,46,24,14,19,24,19,21,58,52},
       {97,45,40,59,36,21,17,19,21,17,28,33},
       {69,105,77,48,24,20,21,17,37,15,53,27},
       {136,117,164,45,72,23,29,21,26,22,24,38},
       {152,128,88,53,54,20,6,18,9,14,20,55},
       {59,80,111,72,32,26,13,13,15,17,18,26}};
   int[][] dataKw = {{536,259,216,289,217,255,
       283,314,173,183,323,474},
       {282,202,323,239,229,360,273,265,340,77,981,474},
       {366,248,182,397,209,345,312,177,514,101,411,125},
       {465,435,898,299,422,375,446,156,668,98,430,137},
       {580,457,450,356,344,412,444,163,344,176,326,165},
       {499,464,411,289,126,117,195,180,115,145,124,107}};
   double[][] ratesCcf = {{.56,.61,.67,.74,.68,.63,
       .58,.54,.50,.50,.55,.60,.65},
       {.67,.73,.80,.87,.81,.75,.69,.64,.59,.65,.70,.77},
       {.80,.85,.91,.97,.90,.93,.77,.71,.66,.70,.75,.80},
       {.85,.89,.93,.97,.90,.83,.77,.71,.66,.69,.72,.75},
       {.95,.99,1.03,1.07,.99,.92,.85,.78,.73,.76,.79,.82},
       {1.04,1.09,1.15,1.21,1.12,1.03,.96,.88,.82,.86,.90,.95}};
   double[][] ratesKw = {{.19,.26,.35,.48,.65,.88,
       1.2,.77,.49,.32,.20,.13},
       {.22,.30,.41,.55,.75,1.02,1.39,.89,.57,.36,.23,.15},
       {.45,.61,.83,1.13,1.54,2.09,2.85,1.82,1.17,.75,.48,.31},
       {.56,.76,1.04,1.41,1.92,2.61,3.54,2.27,1.45,0.93,.59,.38},
       {.59,.8,1.09,1.48,2.02,2.75,3.73,2.39,1.53,.98,.63,.4},
       {.7,.95,1.29,1.76,2.39,3.26,4.43,2.83,1.81,1.16,.74,.48}};  
   fillArray(dataCcf,ratesCcf,finalCcf);
   fillArray(dataKw,ratesKw,finalKw);
   fillTotal(finalTotal,finalCcf,finalKw);
   printArray(finalCcf);
   printArray(finalKw);
   printArray(finalTotal);
    }  
}