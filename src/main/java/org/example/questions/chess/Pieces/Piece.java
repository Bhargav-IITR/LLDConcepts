package org.example.questions.chess.Pieces;

import org.example.questions.chess.Board;
import org.example.questions.chess.Cell;
import org.example.questions.chess.Enums.*;

public abstract class Piece {
    private PieceType pieceType;
    private PieceColor pieceColor;
    private boolean isCaptured;

    public Piece(PieceType pieceType, PieceColor pieceColor){
        this.pieceType = pieceType;
        this.pieceColor = pieceColor;
        this.isCaptured = false;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public void setPieceColor(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public boolean isCaptured() {
        return isCaptured;
    }

    public void setCaptured(boolean captured) {
        isCaptured = captured;
    }

    public abstract boolean isValidMove(Board board, Cell startCell, Cell endCell);
}
