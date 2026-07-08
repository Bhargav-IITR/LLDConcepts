package org.example.questions.chess;

import org.example.questions.chess.Enums.PieceColor;

public class Player {
    String name;
    PieceColor playingSide;

    public Player(String name, PieceColor playingSide) {
        this.name = name;
        this.playingSide = playingSide;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PieceColor getPlayingSide() {
        return playingSide;
    }

    public void setPlayingSide(PieceColor playingSide) {
        this.playingSide = playingSide;
    }
}
