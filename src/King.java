public class King extends ChessPiece {

    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) {
            return false;
        }

        if (line == toLine && column == toColumn) {
            return false;
        }

        return (((Math.abs(toLine - line)) == (Math.abs(toColumn - column))
                || (column == toColumn || line == toLine))
                && ((Math.abs(toLine - line)) == 1
                || (Math.abs(toColumn - column)) == 1));
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}
