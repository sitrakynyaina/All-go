package core;

public class SquareMatrix extends Matrix{

    public SquareMatrix(int m,double[][] data) {
        super(m,m,data);
    }

    public int size(){
        return super.m;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                s.append((int)data[i][j]).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public boolean equals(Object o){
        if(!(o instanceof SquareMatrix)){
            return false;
        }
        for(int j=0;j<m;j++){
            for(int k=0;k<n;k++){
                if(data[j][k]!=((SquareMatrix) o).getValueAt(j,k)){
                    return false;
                }
            }
        }
        return true;
    }
}
