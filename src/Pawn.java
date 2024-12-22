public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        // Проверка выхода за пределы доски
        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) {
            return false;
        }

        // Проверка хода на ту же клетку
        if (line == toLine && column == toColumn) {
            return false;
        }

        // Проверка хода белой фигуры
        if (color.equals("White")) {
            if (column == toColumn) {
                if (line == 1) {
                    if (toLine == 3) {
                        return (chessBoard.board[toLine][toColumn] == null && chessBoard.board[toLine - 1][toColumn] == null);
                    } else {
                        return (toLine - line == 1 && chessBoard.board[toLine][toColumn] == null);
                    }
                } else {
                    return (toLine - line == 1 && chessBoard.board[toLine][toColumn] == null);
                }
            } else { // Взятие фигуры противника по диагонали
                if (Math.abs(toColumn - column) == 1 && toLine - line == 1) {
                    if (chessBoard.board[toLine][toColumn] != null && !chessBoard.board[toLine][toColumn].color.equals(color)) {
                        System.out.println("Фигура противника '" + chessBoard.board[toLine][toColumn].getSymbol() + "' успешно сожрана!");
                        return true;
                    } else return false;
                } else return false;
            }
        }

        // Проверка хода черной фигуры
        else {
            if (column == toColumn) {
                if (line == 6) {
                    if (toLine == 4) {
                        return ( chessBoard.board[toLine][toColumn] == null && chessBoard.board[toLine + 1][toColumn] == null);
                    } else {
                        return (toLine - line == -1 && chessBoard.board[toLine][toColumn] == null);
                    }
                } else {
                    return (toLine - line == -1 && chessBoard.board[toLine][toColumn] == null);
                }
            } else { // Взятие фигуры противника по диагонали
                if (Math.abs(toColumn - column) == 1 && toLine - line == -1) {
                    if (chessBoard.board[toLine][toColumn] != null && !chessBoard.board[toLine][toColumn].color.equals(color)) {
                        System.out.println("Фигура противника '" + chessBoard.board[toLine][toColumn].getSymbol() + "' успешно сожрана!");
                        return true;
                    } else return false;
                } else return false;
            }
        }
    }


    @Override
    public String getSymbol() {
        return "P";
    }

}
