package com.sriashi.fundamentals;

import java.util.Arrays;

/**
 * 
 * @author ashimita
 *
 *         Class for storing high scores in an array in ascending order
 */
public class Scoreboard {
    private int numEntries = 0;
    private GameEntry[] board;

    public Scoreboard(int capacity) {
        board = new GameEntry[capacity];
    }

    public void add(GameEntry ge) {
        int newScore = ge.getScore();
        if (numEntries < board.length) {
            numEntries++;
            int j = numEntries - 1;
            while (j > 0 && newScore < board[j - 1].getScore()) {
                board[j] = board[j - 1];
                j--;
            }
            board[j] = ge;
        } else if (newScore > board[0].getScore() && numEntries >= board.length) {
            int pointer = numEntries - 1; // pointing to the last element of the
                                          // array

            while (board[pointer].getScore() > newScore) {
                pointer--; // locates index to be inserted at
            }

            for (int i = 0; i < pointer; i++) {
                board[i] = board[i + 1];
            }

            board[pointer] = ge;

        }
    }

    public GameEntry remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > numEntries)
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        GameEntry toRemove = board[index];
        for (int i = index; i < numEntries - 1; i++) {
            board[i] = board[i + 1];
        }
        board[numEntries - 1] = null;
        numEntries--;
        return toRemove;
    }

    @Override
    public String toString() {
        return "Scoreboard [numEntries=" + numEntries + ", board=" + Arrays.toString(board) + "]";
    }

}
