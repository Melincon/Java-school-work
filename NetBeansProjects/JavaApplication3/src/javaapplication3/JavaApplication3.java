package javaapplication3;
public class JavaApplication3 {
    final static int rowCount = 2;
    final static int colCount = 12;
    public static void main(String[] args) {
        double[][] ccfrate = {{4.0,1.5,.2,51.45},
            {154.1,121,1.5,4.3,48.6}};
        double sum = 0.0;
        for(int i = 0; i < rowCount; i++){
            for(int j = 0; i < colCount; i++){
                System.out.print(ccfrate[i][j] + " ");
                sum+= ccfrate[i][j];
            }
            System.out.print(sum/colCount);
        }System.out.println();
        }
    }
    

