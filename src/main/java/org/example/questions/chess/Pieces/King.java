package org.example.questions.chess.Pieces;

import org.example.questions.chess.Board;
import org.example.questions.chess.Cell;
import org.example.questions.chess.Enums.PieceColor;
import org.example.questions.chess.Enums.PieceType;

public class King extends Piece{
    public King(PieceColor pieceColor){
        super(PieceType.KING, pieceColor);
    }

    @Override
    public boolean isValidMove(Board board, Cell startCell, Cell endCell){
        // Actual implementation omitted for simplicity.
        return true;
    }
}
