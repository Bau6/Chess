public class Horse extends ChessPiece {

    public Horse(String color) {
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

        if (
                ((line + 2) == toLine && (column + 1) == toColumn) ||
                        ((line + 1) == toLine && (column + 2) == toColumn) ||
                        ((line - 1) == toLine && (column + 2) == toColumn) ||
                        ((line - 2) == toLine && (column + 1) == toColumn) ||
                        ((line - 2) == toLine && (column - 1) == toColumn) ||
                        ((line - 1) == toLine && (column - 2) == toColumn) ||
                        ((line + 1) == toLine && (column - 2) == toColumn) ||
                        ((line + 2) == toLine && (column - 1) == toColumn)
        ) {
            if ((chessBoard.board[toLine][toColumn] == null)) {
                return true;
            } else if (chessBoard.board[toLine][toColumn] != null && !chessBoard.board[toLine][toColumn].color.equals(color)) {
                System.out.println("Фигура противника '" + chessBoard.board[toLine][toColumn].getSymbol() + "' успешно сожрана!");
                return true;
            } else return false;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }

}
