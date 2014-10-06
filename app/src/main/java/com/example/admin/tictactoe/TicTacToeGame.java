package com.example.admin.tictactoe;

import java.util.Random;

/**
 * Created by admin on 10/6/14.
 */
public class TicTacToeGame {

    private char mBoard[];
    private final static int boardSize = 9;

    public static final char humanPlayer = 'X';
    public static final char computerPlayer = 'O';
    public static final char emptySpace = ' ';

    private Random mRand;

    public static int getBoardSize() {
        return boardSize;
    }

    public TicTacToeGame () {

        mBoard = new char[boardSize];

        for (int i = 0; i < boardSize; i++)
            mBoard[i] = emptySpace;

        mRand = new Random();
    }

    public void clearBoard() {
        for (int i = 0; i < boardSize; i++) {
            mBoard[i] = emptySpace;
        }
    }

    public void setMove(char player, int location) {
        mBoard[location] = player;
    }

    public int getComputerMove() {
        int move;

        for (int i = 0; i < getBoardSize(); i++) {
            if (mBoard[i] != humanPlayer && mBoard[i] != computerPlayer) {
                char current = mBoard[i];
                mBoard[i] = computerPlayer;
                if (checkForWinner() == 3) {
                    setMove(computerPlayer, i);
                    return i;
                } else
                    mBoard[i] = current;
            }
        }
        for (int i = 0; i < getBoardSize(); i++) {
            if (mBoard[i] != humanPlayer && mBoard[i] != computerPlayer) {
                char current = mBoard[i];
                mBoard[i] = humanPlayer;
                if (checkForWinner() == 2) {
                    setMove(computerPlayer, i);
                    return i;
                } else
                    mBoard[i] = current;
            }
        }
        do {
            move = mRand.nextInt(getBoardSize());
        } while (mBoard[move] == humanPlayer || mBoard[move] == computerPlayer);
        setMove(computerPlayer, move);
        return move;
    }
    public int checkForWinner() {
        for (int i = 0; i <= 6; i +=3) {
            if (mBoard[i] == humanPlayer &&
            mBoard[i+1] == humanPlayer &&
            mBoard[i+2] == humanPlayer)
                return 2;
            if (mBoard[i] == computerPlayer &&
                    mBoard[i+1] == computerPlayer &&
                    mBoard[i+2] == computerPlayer)
                return 3;
        }
        for (int i = 0; i <= 2; i++) {
            if (mBoard[i] == humanPlayer &&
                    mBoard[i+3] == humanPlayer &&
                    mBoard[i+6] == humanPlayer)
                return 2;
            if (mBoard[i] == computerPlayer &&
                    mBoard[i+3] == computerPlayer &&
                    mBoard[i+6] == computerPlayer)
                return 3;
        }
        if ((mBoard[0] == humanPlayer &&
                mBoard[4] == humanPlayer &&
                mBoard[8] == humanPlayer) ||
                mBoard[2] == humanPlayer &&
                mBoard[4] == humanPlayer&&
                mBoard[6] == humanPlayer)
            return 2;
        if ((mBoard[0] == computerPlayer &&
                mBoard[4] == computerPlayer &&
                mBoard[8] == computerPlayer) ||
                mBoard[2] == computerPlayer &&
                mBoard[4] == computerPlayer &&
                mBoard[6] == computerPlayer)
            return 3;

        for (int i = 0; i < getBoardSize(); i++) {
            if (mBoard[i] != humanPlayer && mBoard[i] != computerPlayer)
                return 0;
        }
        return 1;
    }
}
