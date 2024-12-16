package markdown;

import java.util.Arrays;

/**
 * Table class.
 */
public class Table extends Element {
    String [][]table;
    Align []aligns;
    int cntRows;
    int cntCols;
    int cntRowLimit;


    /**
     * Constructor by builder.
     *
     * @param builder builder
     */
    public Table(TableBuilder builder) {
        cntCols = builder.cntCols;
        cntRows = builder.cntRows;
        cntRowLimit = builder.limitToCell;
        aligns = Arrays.copyOf(builder.aligns, cntCols);
        table = Arrays.copyOf(builder.table, cntRows);
        str = this.toString();
    }

    /**
     * Make string.
     *
     * @return string
     */
    @Override
    public String toString() {
        str = "";
        for (int i = 0; i < cntRows; i++) {
            str += "| ";
            for (int j = 0; j < cntCols; j++) {
                str += table[i][j] + " | ";
            }
            str += "\n";
        }
        return this.str;
    }

    /**
     * Compare objects.
     *
     * @param obj object to compare
     * @return is equal
     */
    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Table table1 = (Table) obj;
        if (cntCols != table1.cntCols || cntRows != table1.cntRows) {
            return false;
        }
        for (int i = 0; i < cntCols; i++) {
            if (aligns[i] != table1.aligns[i]) {
                return false;
            }
        }
        for (int i = 0; i < cntRows; i++) {
            for (int j = 0; j < cntCols; j++) {
                if (!table[i][j].equals(table1.table[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * Builder class.
     */
    public static class TableBuilder {
        String [][]table;
        Align []aligns;
        int cntRows;
        int maxRows;
        int cntCols;
        int limitToCell;
        private boolean isMaxSet = false;
        private boolean isLimitSet = false;

        /**
         * Builder constructor.
         */
        public TableBuilder() {
            table = null;
        }

        /**
         * Set alignments.
         *
         * @param mass aligns
         * @return builder
         */
        public TableBuilder withAlignments(Align ... mass) {
            if (cntCols == 0) {
                cntCols = mass.length;
            }
            if (cntCols != mass.length) {
                throw new RuntimeException("count of align not equal to columns");
            }
            aligns = new Align[cntCols];
            System.arraycopy(mass, 0, aligns, 0, mass.length);
            return this;
        }

        /**
         * Set max cnt of Rows.
         *
         * @param rows cnt rows
         * @return builder
         */
        public TableBuilder setMaxRows(int rows) {
            if (isMaxSet || cntRows > rows) {
                throw new RuntimeException("Rewriting max of rows");
            }

            isMaxSet = true;
            maxRows = rows;
            return this;
        }

        /**
         * Set max cnt of Rows.
         *
         * @param limit cnt rows
         * @return builder
         */
        public TableBuilder withRowLimit(int limit) {
            if (isLimitSet) {
                throw new RuntimeException("Rewriting max of rows");
            }
            isLimitSet = true;
            limitToCell = limit;
            return this;
        }

        /**
         * Add Row by String.
         *
         * @param strs nodes of row
         * @return builder
         */
        public TableBuilder addRow(String ... strs) {
            if (strs.length != cntCols && cntCols != 0) {
                throw new RuntimeException("Rewriting count of columns");
            }
            cntCols = strs.length;
            if (table == null) {
                if (!isMaxSet) {
                    maxRows = 10;
                    cntRows = 0;
                }
                if (!isLimitSet) {
                    limitToCell = 0;
                    for (int i = 0; i < cntCols; i++) {
                        if (limitToCell < strs[i].length()) {
                            limitToCell = strs[i].length();
                        }
                    }
                    isLimitSet = true;
                }
                table = new String[maxRows][cntCols];
            }
            if (cntRows == maxRows) {
                throw new RuntimeException("row count more than acceptable");
            }
            for (int i = 0; i < cntCols; i++) {
                if (strs[i].length() > limitToCell) {
                    throw new RuntimeException("row longer than acceptable");
                }
                StringBuilder sb = new StringBuilder(limitToCell);
                switch (aligns[i]) {
                    case ALIGN_LEFT:
                        sb.append(strs[i]);
                        for (int j = 0; j < (limitToCell - strs[i].length()); j++) {
                            sb.append(' ');
                        }
                        table[cntRows][i] = sb.toString();
                        break;
                    case ALIGN_RIGHT:
                        for (int j = 0; j < (limitToCell - strs[i].length()); j++) {
                            sb.append(' ');
                        }
                        sb.append(strs[i]);
                        table[cntRows][i] = sb.toString();
                        break;
                    case ALIGN_CENTER:
                        int leftSpace;
                        int rightSpace;
                        if ((limitToCell - strs[i].length()) % 2 == 1) {
                            leftSpace =  ((limitToCell - strs[i].length()) / 2) + 1;
                        } else {
                            leftSpace =  ((limitToCell - strs[i].length()) / 2);
                        }
                        rightSpace =  ((limitToCell - strs[i].length()) / 2);
                        for (int j = 0; j < leftSpace; j++) {
                            sb.append(' ');
                        }
                        sb.append(strs[i]);
                        for (int j = 0; j < rightSpace; j++) {
                            sb.append(' ');
                        }
                        table[cntRows][i] = sb.toString();
                        break;
                    default:
                        table[cntRows][i] = strs[i];
                        break;
                }
            }
            cntRows++;
            return this;
        }

        /**
         * Add row by Elements.
         *
         * @param elements nodes of row
         * @return builder
         */
        public TableBuilder addRow(Element ... elements) {
            if (elements.length != cntCols && cntCols != 0) {
                throw new RuntimeException("Rewriting count of columns");
            }
            cntCols = elements.length;
            if (table == null) {
                if (!isMaxSet) {
                    maxRows = 10;
                    cntRows = 0;
                }
                if (!isLimitSet) {
                    limitToCell = 0;
                    for (int i = 0; i < cntCols; i++) {
                        if (limitToCell < elements[i].str.length()) {
                            limitToCell = elements[i].str.length();
                        }
                    }
                    isLimitSet = true;
                }
                table = new String[maxRows][cntCols];
            }
            if (cntRows == maxRows) {
                throw new RuntimeException("row count more than acceptable");
            }
            for (int i = 0; i < cntCols; i++) {
                if (elements[i].str.length() > limitToCell) {
                    throw new RuntimeException("row longer than acceptable");
                }
                StringBuilder sb = new StringBuilder(limitToCell);
                switch (aligns[i]) {
                    case ALIGN_LEFT:
                        sb.append(elements[i].str);
                        for (int j = 0; j < (limitToCell - elements[i].str.length()); j++) {
                            sb.append(' ');
                        }
                        table[cntRows][i] = sb.toString();
                        break;
                    case ALIGN_RIGHT:
                        for (int j = 0; j < (limitToCell - elements[i].str.length()); j++) {
                            sb.append(' ');
                        }
                        sb.append(elements[i].str);
                        table[cntRows][i] = sb.toString();
                        break;
                    case ALIGN_CENTER:
                        int leftSpace;
                        int rightSpace;
                        if ((limitToCell - elements[i].str.length()) % 2 == 1) {
                            leftSpace = ((limitToCell - elements[i].str.length()) / 2) + 1;
                        } else {
                            leftSpace = ((limitToCell - elements[i].str.length()) / 2);
                        }
                        rightSpace = ((limitToCell - elements[i].str.length()) / 2);
                        for (int j = 0; j < leftSpace; j++) {
                            sb.append(' ');
                        }
                        sb.append(elements[i].str);
                        for (int j = 0; j < rightSpace; j++) {
                            sb.append(' ');
                        }
                        table[cntRows][i] = sb.toString();
                        break;
                    default:
                        table[cntRows][i] = elements[i].str;
                        break;
                }
            }
            cntRows++;
            return this;
        }

        /**
         * Build builder.
         *
         * @return built Table
         */
        public Table build() {
            return new Table(this);
        }
    }

    /**
     * Enum alignments.
     */
    public enum Align {
        ALIGN_LEFT,
        ALIGN_RIGHT,
        ALIGN_CENTER
    }
}