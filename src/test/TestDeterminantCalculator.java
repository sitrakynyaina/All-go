package test;

import core.SquareMatrix;
import determinant.DeterminantCalculator;
import determinant.LaplaceMethod;
import determinant.SarrusMethod;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestDeterminantCalculator {
    @Test
    public void SarrusMethodTest(){
        double[][] table = {
                {5, 0, 2},
                {1, 1, 5},
                {2, 3, 1}
        };
        SquareMatrix A = new SquareMatrix(3,table);
        DeterminantCalculator determinantCalculator = new SarrusMethod();
        double det = determinantCalculator.det(A);
        assertEquals(-68, det, 1e-6);
    }

    @Test
    //square matrix determinant using laplace method
    public void LaplaceDetTestTriangleMatrix(){

        double[][] m = {
                {1, 2, 0, 0, 0},
                {0, 3, 4, 0, 0},
                {0, 0, 5, 6, 0},
                {0, 0, 0, 7, 8},
                {0, 0, 0, 0, 9},
        };
        SquareMatrix M = new SquareMatrix(5,m);
        LaplaceMethod l = new LaplaceMethod();
        double res = l.det(M);
        assertEquals(945,res);
    }

    @Test
    //square matrix determinant using laplace method
    public void LaplaceDetTest1(){

        double[][] m = {
                {2, 1, 3, 0, 4},
                {1, 0, 2, 1, 3},
                {3, 2, 1, 4, 0},
                {0, 1, 4, 2, 1},
                {2, 3, 0, 1, 5},
        };
        SquareMatrix M = new SquareMatrix(5,m);
        LaplaceMethod l = new LaplaceMethod();
        double res = l.det(M);
        assertEquals(300,res);
    }

    @Test
    //square matrix determinant using laplace method
    public void LaplaceDetTest2(){

        double[][] m = {
                {2, 10, 3, 0, 4},
                {1, 0, 2, 1, 3},
                {3, 2, 1, 4, 0},
                {0, 1, 4, 2, 1},
                {2, 3, 1, 1, 5},
        };
        SquareMatrix M = new SquareMatrix(5,m);
        LaplaceMethod l = new LaplaceMethod();
        double res = l.det(M);
        assertEquals(373,res);
    }

    @Test
    //square matrix determinant using laplace method
    public void LaplaceDetTest3(){

        double[][] m = {
                {-2, 2, -3},
                {-1, 1, 3},
                {4, 0, 1},
        };
        SquareMatrix M = new SquareMatrix(3,m);
        LaplaceMethod l = new LaplaceMethod();
        double res = l.det(M);
        assertEquals(36,res);
    }

    @Test
    //square matrix determinant using laplace method
    public void LaplaceDetTest4(){

        double[][] m = {
                {2, 10, 3, 0, 4},
                {1, 0, 2, 1, 3},
                {3, 2, 1, 4, 0},
                {0, 1, 4, 2, 1},
                {2, 10, 3, 0, 4},
        };
        SquareMatrix M = new SquareMatrix(5,m);
        LaplaceMethod l = new LaplaceMethod();
        double res = l.det(M);
        assertEquals(0,res);
    }

    @Test
    //square matrix determinant using laplace method
    public void LaplaceDetTest5(){

        double[][] m = {
                {2, 10, 3, 0, 2},
                {1, 0, 2, 1, 1},
                {3, 2, 1, 4, 3},
                {0, 1, 4, 2, 0},
                {2, 3, 1, 1, 2},
        };
        SquareMatrix M = new SquareMatrix(5,m);
        LaplaceMethod l = new LaplaceMethod();
        double res = l.det(M);
        assertEquals(0,res);
    }
/*
    @Test
    //square matrix determinant using laplace method
    public void haveZeroRowTest(){

        double[][] m = {
                {2, 10, 3, 0, 2},
                {1, 0, 2, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 4, 2, 0},
                {2, 3, 1, 1, 2},
        };
        SquareMatrix M = new SquareMatrix(5,m);
        LaplaceMethod l = new LaplaceMethod();
        assertTrue(l.haveZeroRow(M));
    }

    @Test
    public void haveZeroColumnTest(){

        double[][] m = {
                {2, 10, 0, 0, 2},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 0, 2, 0},
                {2, 3, 0, 1, 2},
        };
        SquareMatrix M = new SquareMatrix(5,m);
        LaplaceMethod l = new LaplaceMethod();
        assertTrue(l.haveZeroColumn(M));
    }*/
/*
    @Test
    public void haveTwoSameRowTest(){
        double[][] m = {
                {2, 10, 0, 0, 2},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 0, 2, 0},
                {2, 10, 0, 0, 2},
        };
        SquareMatrix M = new SquareMatrix(5,m);
        LaplaceMethod l = new LaplaceMethod();
        assertTrue(l.haveTwoSameRow(M));
    }

    @Test
    public void haveTwoSameColumnTest(){
        double[][] m = {
                {2, 10, 0, 0, 2},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 0, 2, 0},
                {2, 10, 0, 0, 2},
        };
        SquareMatrix M = new SquareMatrix(5,m);
        LaplaceMethod l = new LaplaceMethod();
        assertTrue(l.haveTwoSameColumn(M));
    }*/
}
