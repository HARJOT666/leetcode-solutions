class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int rows = matrix.length;
        int columns = matrix[0].length;
        pataNhi(matrix, list, 0, 0, rows, columns);
        return list;
    }
    public void pataNhi(int[][] matrix,
                        List<Integer> list,
                        int startRow,
                        int startColumn,
                        int rows,
                        int columns) {
        // No elements left
        if (rows <= 0 || columns <= 0) {
            return;
        }
        // Top row
        for (int j = startColumn; j < startColumn + columns; j++) {
            list.add(matrix[startRow][j]);
        }
        // Right column
        for (int i = startRow + 1; i < startRow + rows; i++) {
            list.add(matrix[i][startColumn + columns - 1]);
        }
        // Bottom row
        if (rows > 1) {
            for (int j = startColumn + columns - 2; j >= startColumn; j--) {
                list.add(matrix[startRow + rows - 1][j]);
            }
        }
        // Left column
        if (columns > 1) {
            for (int i = startRow + rows - 2; i > startRow; i--) {
                list.add(matrix[i][startColumn]);
            }
        }
        // Move to the inner matrix
        pataNhi(
            matrix,
            list,
            startRow + 1,
            startColumn + 1,
            rows - 2,
            columns - 2
        );
    }
}