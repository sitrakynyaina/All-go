package determinant;

import core.SquareMatrix;

public class LaplaceMethod implements DeterminantCalculator{

    public double det(SquareMatrix A){
        if(A.size()==2){
            return (A.getValueAt(0,0) * A.getValueAt(1,1)  - A.getValueAt(1,0) * A.getValueAt(0,1));
        }

        //to optimize !!!!!
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
