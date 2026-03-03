package core;

public class Matrix {
    protected int m;
    protected int n;
    protected double[][] data;

    public Matrix(int m,int n,double[][] data) {
        this.m = m;
        this.n = n;
        this.data = new double[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(data[i], 0, this.data[i], 0, n);
        }
    }

    public int[] dim() {
        int[] res = new int[2];
        res[0] = m;
        res[1] = n;
        return res;
    }

    public double[][] getData(){
        return data;
    }
    public void setValueAt(int x, int y, double value){
        this.data[x][y] = value;
    }
    public void replaceRowAt(int index,double[] value){
        if(value.length != n){
            throw new IllegalArgumentException("length not equal to the current row");
        }
        for(int i = 0; i < n; i++){
            this.data[i][index] = value[i];
        }
    }
    public void replaceColumnAt(int index,double[] value){
        if(value.length != n){
            throw new IllegalArgumentException("length not equal to the current column");
        }
        for(int i = 0; i < m; i++){
            this.data[index][i] = value[i];
        }
    }

    public double getValueAt(int y,int x){
        return data[y][x];
    }
}
