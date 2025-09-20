class Spreadsheet {
    int sheet[][];
    public Spreadsheet(int rows) {
        sheet = new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        sheet[row][col] = value;
    }
    
    public void resetCell(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        sheet[row][col] = 0;
    }
    
    public int getValue(String formula) {
        int op1 = 1;
        int op2 = formula.indexOf("+") + 1;

        String s1 = formula.substring(op1, op2 -1);
        String s2 = formula.substring(op2);
        int val1 = -1, val2 = -1;
        try {
            val1 = Integer.parseInt(s1);
        }
        catch (NumberFormatException e) {
            int col = s1.charAt(0) - 'A';
            int row = Integer.parseInt(s1.substring(1)) - 1;
            val1 = sheet[row][col];
        }

        try {
            val2 = Integer.parseInt(s2);
        }
        catch (NumberFormatException e) {
            int col = s2.charAt(0) - 'A';
            int row = Integer.parseInt(s2.substring(1)) - 1;
            val2 = sheet[row][col];
        }

        return val1 + val2;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */