package org.example.questions.chess;

import org.example.questions.chess.Enums.GameStatus;
import org.example.questions.chess.Enums.PieceColor;
import org.example.questions.chess.Pieces.King;
import org.example.questions.chess.Pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Board board;
    Player player1;
    Player player2;
    Player currentTurn;
    GameStatus status;
    List <Move> moveHistory;

    Game(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        if(this.player1.getPlayingSide().equals(PieceColor.WHITE)){
            currentTurn = player1;
        }else currentTurn = player2;
        this.status = GameStatus.IN_PROGRESS;
        moveHistory = new ArrayList<>();
    }

    public boolean playMove(Player player, Position start, Position end){
        Cell startCell = board.getCell(start);
        Cell endCell = board.getCell(end);
        Move move = new Move(player, startCell , endCell);
        return makeMove(move, player);
    }

    public boolean makeMove(Move move, Player player) {
        Piece startPiece = move.getStart().getPiece();
        Piece endPiece = move.getEnd().getPiece();

        if (startPiece == null) return false;
        if (startPiece.getPieceColor() != (player.getPlayingSide())) return false;
        if (!startPiece.isValidMove(board, move.getStart(), move.getEnd())) return false;

        if (endPiece != null) {
            endPiece.setCaptured(true);
            move.setPieceKilled(endPiece);
        }

        //update the end cell to reflect the new piece
        move.getEnd().setPiece(startPiece);
        move.getStart().setPiece(null);

        this.moveHistory.add(move);

        if (endPiece instanceof King) {
            System.out.println("\n ====> It's a checkmate!!");
            if (player.getPlayingSide().equals(PieceColor.WHITE)) {
                this.setStatus(GameStatus.WHITE_WIN);
            } else {
                this.setStatus(GameStatus.BLACK_WIN);
            }
            System.out.println("====> Game status : " + this.getStatus());
        }
        if(currentTurn == player1) this.currentTurn = player2;
        else this.currentTurn = player1;
        return true;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(Player currentTurn) {
        this.currentTurn = currentTurn;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public List<Move> getMoveHistory() {
        return moveHistory;
    }

    public void setMoveHistory(List<Move> moveHistory) {
        this.moveHistory = moveHistory;
    }

    public void displayMovesHistory() {
        for (Move move : moveHistory) {
            System.out.println(move);
        }
    }

    public void display() {
        System.out.println("\nCurrent turn: " + currentTurn);
        System.out.println("Game status: " + status);
    }

}
