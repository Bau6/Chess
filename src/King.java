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

        if (((Math.abs(toLine - line)) == (Math.abs(toColumn - column))
                || (column == toColumn || line == toLine))
                && ((Math.abs(toLine - line)) == 1
                || (Math.abs(toColumn - column)) == 1)) {
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
        return "K";
    }
}
