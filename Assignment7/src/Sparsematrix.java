public class Sparsematrix {
    private final int row[];
    private final int col[];
    private final int val[];
    private final int matrix_rows;
    private final int matrix_cols;
    int countNonZero = 0;

    public Sparsematrix(int matrix[][]) {

        int index = -1;
        int index1 = -1;
        int index2 = -1;
        this.matrix_rows = matrix.length;
        this.matrix_cols = matrix[0].length;

        for (int ind = 0; ind < matrix.length; ind++) {
            for (int ind1 = 0; ind1 < matrix[0].length; ind1++) {
                if (matrix[ind][ind1] != 0) {
                    countNonZero++;
                }
            }
        }
        this.row = new int[countNonZero];
        this.col = new int[countNonZero];
        this.val = new int[countNonZero];

        for (int ind = 0; ind < matrix.length; ind++) {

            for (int ind1 = 0; ind1 < matrix[0].length; ind1++) {

                if (matrix[ind][ind1] != 0) {

                    row[++index] = ind;
                    col[++index1] = ind1;
                    val[++index2] = matrix[ind][ind1];
                }
            }
        }
    }

    /**
     * This method is used to get transpovse of a matrix.
     * 
     * @return it returns an 2-D array.
     */
    public int[][] getTranspose() {

        int[][] transposeMatrix = new int[matrix_rows][matrix_cols];
        int temp;
        int trow[] = row.clone();
        int tcol[] = col.clone();

        for (int ind = 0; ind < trow.length; ind++) {
            temp = trow[ind];
            trow[ind] = tcol[ind];
            tcol[ind] = temp;
        }

        for (int ind = 0; ind < trow.length; ind++) {

            transposeMatrix[trow[ind]][tcol[ind]] = val[ind];

        }

        return transposeMatrix;
    }

    /**
     * This method is used to check whether the matrix is symmetrical or not.
     * 
     * @return it returns a boolean value.
     */
    public boolean isSymmetrical() {
        int trow[] = col.clone();
        int tcol[] = row.clone();
        int Matrix[][] = new int[matrix_rows][matrix_cols];

        for (int ind = 0, ind1 = 0; ind < row.length; ind++, ind1++) {

            Matrix[row[ind]][col[ind1]] = val[ind];

        }

        int transpose[][] = getTranspose();

        for (int ind = 0; ind < row.length; ind++) {

            for (int ind1 = 0; ind1 < col.length; ind1++) {

                if (Matrix[ind][ind1] != transpose[ind][ind1]) {

                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This method is used to add two sparse matrix.
     * 
     * @param s1
     * @return it returns a 2D matrix.
     */
    public int[][] add(Sparsematrix s1) {

        if ((matrix_rows != s1.matrix_rows) || (matrix_cols != s1.matrix_cols)) {
            throw new AssertionError("Addition is not possible.");
        }

        int add[][] = new int[matrix_rows][matrix_cols];

        for (int ind = 0; (ind < row.length); ind++) {

            add[row[ind]][col[ind]] = val[ind];

        }

        for (int ind = 0; ind < s1.row.length; ind++) {

            add[s1.row[ind]][s1.col[ind]] += s1.val[ind];
        }
        return add;
    }

    /**
     * This method is used to multiply two sparse matrix.
     * 
     * @param s1
     * @return It returns a matrix.
     */
    public int[][] multiply(Sparsematrix s1) {

        if (this.matrix_cols != s1.matrix_rows) {

            throw new AssertionError(
                    "Number of columns of first matrix is not equal to number of rows in the second Matrix");
        }

        int multi[][] = new int[this.matrix_rows][s1.matrix_cols];

        Sparsematrix s2 = new Sparsematrix(s1.getTranspose());

        for (int ind = 0; ind < this.countNonZero; ind++) {

            for (int ind1 = 0; ind1 < s2.countNonZero; ind1++) {

                if (this.col[ind] == s2.col[ind1]) {

                    multi[row[ind]][s2.row[ind1]] += this.val[ind]
                            * s2.val[ind1];
                }
            }
        }
        return multi;
    }
}
