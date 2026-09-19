class Solution {
    public void setZeroes(int[][] matrix) {
      //entire row and column stt to zero
      int[][] ans = new int[matrix.length][];
       for(int i = 0; i < matrix.length; i++){
            ans[i] = matrix[i].clone();
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    for(int k=0;k<matrix[0].length;k++){
                        ans[i][k] = 0;
                    }
                    for(int k=0;k<matrix.length;k++){
                        ans[k][j] = 0;
                    }
                }
                
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                matrix[i][j] = ans[i][j];
            }
        }
    }
}