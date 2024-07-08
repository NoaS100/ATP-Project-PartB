package algorithms.mazeGenerators;


import java.io.Serializable;
import java.util.Objects;

public class Position implements Serializable {

    private int rowIndex;
    private int columnIndex;

    /***
     * Position Constructor initializing row and column
     */
    public Position(int row, int column) {
        this.rowIndex = row;
        this.columnIndex = column;
    }

    /***
     *
     * @return index of the row
     */
    public int getRowIndex() {
        return rowIndex;
    }

    /***
     *
     * @return index of the column
     */
    public int getColumnIndex() {
        return columnIndex;
    }

    /***
     * changing the index of the column
     * @param newColumn
     */
    public void setColumnIndex(int newColumn) {
        this.columnIndex = newColumn;
    }

    /***
     * changing the index of the column
     * @param newRow
     */
    public void setRowIndex(int newRow) {
        this.rowIndex = newRow;
    }

    /***
     *
     * @return The print configuration of Position
     */
    @Override
    public String toString() {
        return "{" + rowIndex + "," + columnIndex + "}";
    }

    /***
     *
     * @param postionString
     * @return instance of Position
     */
    public static Position fromString(String postionString){
        String positionStringWithoutBrackets = postionString.substring(1, postionString.length() -1);
        String[] res = positionStringWithoutBrackets.split(",");
        int row = Integer.parseInt(res[0]);
        int column = Integer.parseInt(res[1]);
        return new Position(row,column);
    }

    /***
     *Comparison between objects
     * @param o
     * @return whether equal or not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return rowIndex == position.rowIndex && columnIndex == position.columnIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowIndex, columnIndex);
    }

}

