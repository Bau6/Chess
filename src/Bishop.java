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

        if (Math.abs(toLine - line) != Math.abs(toColumn - column)) {
            return false;
        }

        for (int i = 1; i < Math.abs(toLine - line); i++) {
            if (chessBoard.board[line + i * ((toLine - line) / Math.abs(toLine - line))][column + i * ((toColumn - column) / Math.abs(toColumn - column))] != null) {
                return false;
            }
        }

        if ((chessBoard.board[toLine][toColumn] == null)) {
            return true;
        } else if (chessBoard.board[toLine][toColumn] != null && !chessBoard.board[toLine][toColumn].color.equals(color)) {
            System.out.println("Фигура противника '" + chessBoard.board[toLine][toColumn].getSymbol() + "' успешно сожрана!");
            return true;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
