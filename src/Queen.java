public class Queen extends ChessPiece{

    public Queen(String color) {
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

        for (int i = 1; i < Math.abs(toLine - line); i++) {
            if (chessBoard.board[line + i * ((toLine - line) / Math.abs(toLine - line))][column + i * ((toColumn - column) / Math.abs(toColumn - column))] != null) {
                return false;
            }
        }

        if (column == toColumn) {
            for (int i = line + ((toLine - line) / Math.abs(toLine - line)); i != toLine; i += ((toLine - line) / Math.abs(toLine - line))) {
                if (chessBoard.board[i][toColumn] != null) {
                    return false;
                }
            }
        } else if (line == toLine) {
            for (int j = column + ((toColumn - column) / Math.abs(toColumn - column)); j != toColumn; j += ((toColumn - column) / Math.abs(toColumn - column))) {
                if (chessBoard.board[toLine][j] != null) {
                    return false;
                }
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
        return "Q";
    }
}
