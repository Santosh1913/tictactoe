package org.example;

import java.util.*;

public class TicTacToe {

    static String[] board;
    static int turn = 1;
    static String checkWinner()
    {
        for (int a = 0; a < 8; a++) {
            String line = null;

            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            //For X winner
            if (line.equals("XXX")) {
                return "player 1";
            }

            // For O winner
            else if (line.equals("OOO")) {
                return "player 2";
            }
        }

        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(
                    String.valueOf(a + 1))) {
                break;
            }
            else if (a == 8) {
                return "draw";
            }
        }
        System.out.println(
                turn + "'s turn; enter a slot number to place "
                        + turn + " in:");
        return null;
    }

    static void printBoard()
    {

        System.out.println("|---|---|---|");
        for(int i=0;i<9;i=i+3){
            System.out.println("| " + board[i] + " | "
                    + board[i+1] + " | " + board[i+2]
                    + " |");
            System.out.println("|-----------|");
        }
    }

    public static void main(String[] args)
    {

        board = new String[9];
        String winner = null;
        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }

        System.out.println("Welcome to 3x3 Tic Tac Toe.");
        printBoard();
        Scanner in = new Scanner(System.in);


        while (winner == null) {
            int numInput;
            try {

                System.out.println(
                        "player "+turn+" will play. Enter a slot number to place "+(turn==1?"X":"O")+" in:");
                numInput = in.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println(
                            "Invalid input; re-enter slot number:");
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println(
                        "Invalid input");
                return;
            }
            if (board[numInput - 1].equals(
                    String.valueOf(numInput))) {
                board[numInput - 1] = turn==1?"X":"O";

                if (turn==1) {
                    turn = 2;
                }
                else {
                    turn = 1;
                }

                printBoard();
                winner = checkWinner();
            }
            else {
                System.out.println(
                        "Slot already taken; re-enter slot number:");
            }
        }
        if (winner.equalsIgnoreCase("draw")) {
            System.out.println(
                    "It's a draw! Thanks for playing.");
        }
        else {
            System.out.println(
                    "Congratulations! " + winner
                            + "'s have won! Thanks for playing.");
        }
    }
}
