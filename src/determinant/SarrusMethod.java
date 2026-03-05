package determinant;


import core.SquareMatrix;

public class SarrusMethod implements DeterminantCalculator {
    public double det(SquareMatrix A) {
        double right = A.getValueAt(0,0) * A.getValueAt(1,1) * A.getValueAt(2,2) + A.getValueAt(0,1) * A.getValueAt(1,2) * A.getValueAt(2,0) + A.getValueAt(0,2) * A.getValueAt(1,0) * A.getValueAt(2,1);
        double left = A.getValueAt(0,2) * A.getValueAt(1,1) * A.getValueAt(2,0) + A.getValueAt(0,0) * A.getValueAt(1,2) * A.getValueAt(2,1) + A.getValueAt(0,1) * A.getValueAt(1,0) * A.getValueAt(2,2);
        return right - left;
    }
}
