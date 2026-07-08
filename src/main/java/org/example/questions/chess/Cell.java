package org.example.questions.chess;

import org.example.questions.chess.Pieces.Piece;

public class Cell {
    Piece piece;
    Position position;

    public Cell(Piece piece, Position position) {
        this.piece = piece;
        this.position = position;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String toString(){
        return "Cell [piece=" + piece + " , position=" + position + "]";
    }
}
