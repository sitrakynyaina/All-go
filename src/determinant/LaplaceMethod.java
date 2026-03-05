package determinant;

import core.SquareMatrix;


public class LaplaceMethod implements DeterminantCalculator{

    public double det(SquareMatrix A){
        if(haveZeroRow(A))
            return 0;
        if(haveZeroColumn(A))
            return 0;
        if (haveTwoSameRow(A))
            return 0;
        if (haveTwoSameColumn(A))
            return 0;
        return calculate(A);
    }


    private double calculate(SquareMatrix A){
        if(A.size()==2){
            return (A.getValueAt(0,0) * A.getValueAt(1,1)  - A.getValueAt(1,0) * A.getValueAt(0,1));
        }

        double res = 0;
        for(int i = 0; i < A.size(); i++){
            SquareMatrix minA = minor(A,0,i);
            double coef = A.getValueAt(0,i);
            if((i&1) == 1)
                coef = -coef;
            res += coef * det(minA);
        }
        return res;
    }

    private boolean haveZeroRow(SquareMatrix A)
    {

        for(int i = 0; i < A.size(); i++){
            int j = 0;
            while(j < A.size()){
                if(A.getValueAt(i,j) != 0){
                    break;
                }
                j++;
            }
            if(j == A.size() && A.getValueAt(i,j - 1) == 0)
                return true;
            i++;
        }
        return false;
    }

    private boolean haveZeroColumn(SquareMatrix A)
    {
        int i = 0;
        while(i < A.size()){
            int j = 0;
            while(j < A.size()){
                if(A.getValueAt(j,i) != 0){
                    break;
                }
                j++;
            }
            if(j == A.size() && A.getValueAt(j - 1,i) == 0)
                return true;
            i++;
        }
        return false;
    }

    public boolean haveTwoSameRow(SquareMatrix A){
        double[] row = new double[A.size()];
        for(int rowIndex = 0;rowIndex < A.size(); rowIndex++) {
            System.out.println(rowIndex);
            //fetching a row
            for (int j = 0; j < A.size(); j++) {

                row[j] = A.getValueAt(rowIndex, j);
            }

            //comparison
            for(int i = 0;i < A.size();i++){
                //avoid to compare the same row at same index
                if(i != rowIndex) {
                    int j = 0;
                    System.out.println("line = " + j);
                    while (j < A.size()) {
                        if (A.getValueAt(i, j) != row[j]) {
                            break;
                        }
                        j++;
                    }
                    if (j == A.size() && row[j - 1] == A.getValueAt(i, j - 1)) {

                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean haveTwoSameColumn(SquareMatrix A) {
        double[] row = new double[A.size()];
        for(int colIndex = 0;colIndex < A.size(); colIndex++) {
            System.out.println(colIndex);
            //fetching a row
            for (int j = 0; j < A.size(); j++) {

                row[j] = A.getValueAt(j,colIndex);
            }

            //comparison
            for(int i = 0;i < A.size();i++){
                //avoid to compare the same row at same index
                if(i != colIndex) {
                    int j = 0;
                    System.out.println("line = " + j);
                    while (j < A.size()) {
                        if (A.getValueAt(j, i) != row[j]) {
                            break;
                        }
                        j++;
                    }
                    if (j == A.size() && row[j - 1] == A.getValueAt(j - 1, i)) {

                        return true;
                    }
                }
            }
        }

        return false;
    }

    private SquareMatrix minor(SquareMatrix A,int y,int x){
        double[][] res =  new double[A.size()][A.size()];
        int posX = 0;
        int posY = 0;
        for(int i = 0;i < A.size();i++){
            if(i == y)
                continue;
            for(int j = 0;j < A.size();j++){
                if(j == x)
                    continue;
                res[posY][posX] = A.getValueAt(i,j);
                posX = (posX + 1) % (A.size() - 1);
            }
            posY++;
        }
        return new SquareMatrix(A.size() - 1,res);
    }

}
