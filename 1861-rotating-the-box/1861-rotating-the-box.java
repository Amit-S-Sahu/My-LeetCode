class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int row = box.length, col = box[0].length;
        char newBox[][] = new char[col][row];

        for (int i = 0; i < row; i++) {
            int cell = col - 1;
            for (int j = col - 1; j >= 0; j--) {
                if (box[i][j] == '*') cell = j - 1;
                else if (box[i][j] == '#') {
                    box[i][j] = '.';
                    box[i][cell--] = '#';
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                newBox[j][row - i - 1] = box[i][j];
            }
        }

        return newBox;
    }
}