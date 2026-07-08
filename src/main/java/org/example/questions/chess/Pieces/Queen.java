package org.example.questions.chess.Pieces;

import org.example.questions.chess.Board;
import org.example.questions.chess.Cell;
import org.example.questions.chess.Enums.PieceColor;
import org.example.questions.chess.Enums.PieceType;

public class Queen extends Piece{
    public Queen(PieceColor pieceColor){
        super(PieceType.QUEEN, pieceColor);
    }

    @Override
    public boolean isValidMove(Board board, Cell startCell, Cell endCell){
        // Actual implementation omitted for simplicity.
        return true;
    }
}
