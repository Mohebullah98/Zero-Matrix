class Main {
  public static void zeroMatrix(int Matrix[][]){
    boolean rowHasZero=false;
    boolean colHasZero=false;
    //check to see if first row and column contain any zeroes
    for(int i=0;i<Matrix[0].length;i++){
      if(Matrix[0][i]==0) {
        rowHasZero=true;
        break;
      }
    }
    for(int i=0;i<Matrix.length;i++){
      if(Matrix[i][0]==0) {
        colHasZero=true;
        break;
      }
    }
    //Store 0 indeces for row and col in 1st row and col to save space
    for(int i=0;i<Matrix.length;i++){
      for(int j=0;j<Matrix[i].length;j++){
        if(Matrix[i][j]==0){
          Matrix[0][j]=0;
          Matrix[i][0]=0;
        }
      }
    }
    //nullify row and col of corresponding 0s in first row and col
    for(int i=1;i<Matrix[0].length;i++){
      if(Matrix[0][i]==0) nullifyCol(Matrix,i);
    }
    for(int j=1;j<Matrix.length;j++){
      if(Matrix[j][0]==0) nullifyRow(Matrix,j);
    }
    //finally,nullify first row and col if they should be based off initial check
    if(rowHasZero==true)nullifyRow(Matrix,0);
    if(colHasZero==true)nullifyCol(Matrix,0);
  }
  public static void nullifyRow(int Matrix[][],int r){
    for(int i=0;i<Matrix[0].length;i++){
      Matrix[r][i]=0;
    }
  }
  public static void nullifyCol(int Matrix[][],int c){
    for(int i=0;i<Matrix.length;i++){
      Matrix[i][c]=0;
    }
  }
  public static void printMatrix(int Matrix[][]){
    for(int i=0;i<Matrix.length;i++){
      for(int j=0;j<Matrix[i].length;j++){
        System.out.print(Matrix[i][j]+" ");
      }
      System.out.print("\n");
    }
  }
  public static void main(String[] args) {
    int Matrix[][] = new int[][] {{4,2,0,1,4,2},{2,3,2,5,1,9},{2,4,1,8,5,0},{2,5,3,8,5,7}};
    System.out.println("Original Matrix");
    printMatrix(Matrix);
    System.out.println("Zero Matrix");
    zeroMatrix(Matrix);
    printMatrix(Matrix);
  }
}