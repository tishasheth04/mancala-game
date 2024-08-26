package ui;

import mancala.MancalaGame;
//import mancala.Board;
import mancala.GameNotOverException;
//import mancala.InvalidMoveException;
//import mancala.NoSuchPlayerException;
//import mancala.Pit;
//import mancala.PitNotFoundException;
import mancala.Player;
//import mancala.Store;
import mancala.Saver;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class TextUI implements Serializable {
    private static final long serialVersionUID = 1113409962982395665L;
    private MancalaGame game;
    private Scanner scanner;
    //private Board board;
    private Player playerOne = new Player();
    private Player playerTwo = new Player();
    private String playerOneName = "";
    private String playerTwoName = "";
    private int pitNum = 0;

    public TextUI() {
        game = new MancalaGame();
        //board = new Board();
        scanner = new Scanner(System.in);
    }


    public void startGame() {
        System.out.println("hello");
         String filename = "Tishais.txt";
        try {
                        System.out.println("filename: " + filename);
                        Saver.saveObject(game, filename);
                        //System.out.println();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("outside tryu");
        System.out.println("Welcome to the Mancala Game");
        game.setPlayers(playerOne,playerTwo); 
        System.out.println("Enter your first player's name: ");
        playerOneName = scanner.nextLine();
        System.out.println("Enter your second player's name: ");
        playerTwoName = scanner.nextLine();
        playerOne.setName(playerOneName);
        playerTwo.setName(playerTwoName);

        /*for(int i = 0; i < 2; i++){
            System.out.println("Player " + game.getPlayers().get(i).getName());
        }*/
        game.setCurrentPlayer(playerOne);
   
    }

    public void playGame(){
        while (!game.isGameOver()) {
            System.out.println(game.getCurrentPlayer().getName() + "'s turn.");
            System.out.println("Please enter your pit num: ");
            pitNum = scanner.nextInt();      
            try {
                //if(game.getNumStones(pitNum) != 0){
                    System.out.println("in trye ");
                    game.move(pitNum);
                    System.out.println("after move");
                    System.out.println(game.toString());
                    //displayBoard();
                    //.out.println("free move: " + game.getBoard().getFreeMove());
                    /* 
                    if(game.getBoard().getFreeMove() == 1){
                        if(game.getCurrentPlayer() == playerOne){
                            game.setCurrentPlayer(playerOne);
                            System.out.println("Player 1's turn.");
                        }else{
                            game.setCurrentPlayer(playerTwo);
                            System.out.println("Player 2's turn.");
                        }
                    }else{*/                   
                        if(game.getCurrentPlayer() == playerOne){
                            game.setCurrentPlayer(playerTwo);
                        }else{
                            game.setCurrentPlayer(playerOne);
                        }
                    //}
                //}
            } catch (Exception e) {
                System.out.println("Catch textUI");
                if(game.getCurrentPlayer() == playerOne){
                        game.setCurrentPlayer(playerOne);
                        System.out.println("Player 1's turn.");
                    }else{
                        game.setCurrentPlayer(playerTwo);
                        System.out.println("Player 2's turn.");
                    }

                //System.out.println(e.getMessage());
            }  
        }
        if(game.isGameOver()){
            String filename = "/assets";
            Player winner;
            try {
                winner = game.getWinner();
                if(winner != null){
                    System.out.println("The winner is: " + winner.getName());
                    try {
                        Saver.saveObject(game, filename);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            } catch (GameNotOverException e) {
                System.out.println("Game textUI exception");
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
     
    //private void displayBoard() {
      //  System.out.println(game.toString());
    //}
    

    public static void main(String[] args) {
        TextUI textUI = new TextUI();
        textUI.startGame();
        textUI.playGame();
    }
}
