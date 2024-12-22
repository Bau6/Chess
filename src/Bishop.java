public class Bishop extends ChessPiece {

    public Bishop(String color) {
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

        return ((Math.abs(toLine - line)) == (Math.abs(toColumn - column)));
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}