package org.example.questions.chess;
import org.example.questions.chess.Enums.PieceColor;
import org.example.questions.chess.Pieces.*;

public class Board {
    Cell [][] cells;

    public Board(){
        cells = new Cell[8][8];
        for(int i = 0 ; i < 8 ; i++){
            for(int j = 0 ; j < 8 ; j++){
                Position position = new Position(i, j);
                cells[i][j] = new Cell(null, position);
            }
        }
    }

    public Cell getCell(Position position){
        int i = position.getX();
        int j = position.getY();
        if (i < 0 || i > 7 || j < 0 || j > 7) {
            System.out.println("[ERR] Index out of bound");
            System.exit(0); // end game
        }
        return cells[i][j];
    }

    public void initBoard(){
        // Initialize white pieces
        cells[0][0].setPiece(new Rook(PieceColor.WHITE));
        cells[0][1].setPiece(new Knight(PieceColor.WHITE));
        cells[0][2].setPiece(new Bishop(PieceColor.WHITE));
        cells[0][3].setPiece(new Queen(PieceColor.WHITE));
        cells[0][4].setPiece(new King(PieceColor.WHITE));
        cells[0][5].setPiece(new Bishop(PieceColor.WHITE));
        cells[0][6].setPiece(new Knight(PieceColor.WHITE));
        cells[0][7].setPiece(new Rook(PieceColor.WHITE));

        // Initialize white pawns
        for (int i = 0; i < 8; i++) {
            cells[1][i].setPiece(new Pawn(PieceColor.WHITE));
        }

        // Initialize black pieces
        cells[7][0].setPiece(new Rook(PieceColor.BLACK));
        cells[7][1].setPiece(new Knight(PieceColor.BLACK));
        cells[7][2].setPiece(new Bishop(PieceColor.BLACK));
        cells[7][3].setPiece(new Queen(PieceColor.BLACK));
        cells[7][4].setPiece(new King(PieceColor.BLACK));
        cells[7][5].setPiece(new Bishop(PieceColor.BLACK));
        cells[7][6].setPiece(new Knight(PieceColor.BLACK));
        cells[7][7].setPiece(new Rook(PieceColor.BLACK));

        // Initialize black pawns
        for (int i = 0; i < 8; i++) {
            cells[6][i].setPiece(new Pawn(PieceColor.BLACK));
        }
    }
}
