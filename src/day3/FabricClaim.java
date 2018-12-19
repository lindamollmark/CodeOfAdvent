package day3;

public class FabricClaim {

    private final int startColumn;
    private final int startRow;
    private final int noOfROws;
    private final int noOfColumn;
    private boolean overlap;

    public FabricClaim(final String startColumn, final String startRow, final String noOfROws, final String noOfColumn) {
        this.startColumn = Integer.parseInt(startColumn);
        this.startRow = Integer.parseInt(startRow);
        this.noOfROws = Integer.parseInt(noOfROws);
        this.noOfColumn = Integer.parseInt(noOfColumn);
        this.overlap = false;
    }

    public int getNoOfColumn() {
        return noOfColumn;
    }

    public int getNoOfRows() {
        return noOfROws;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getStartColumn() {
        return startColumn;
    }

    public boolean overlap() {
        return overlap;
    }

    public void overlap(final boolean overlap) {
        this.overlap = overlap;
    }
}
