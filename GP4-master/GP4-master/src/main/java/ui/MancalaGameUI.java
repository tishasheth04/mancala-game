
package ui;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

import mancala.InvalidMoveException;
import mancala.MancalaGame;
import mancala.Player;



public class MancalaGameUI extends JFrame {

    private JButton submitButton;
    private JTextField usernameField;
    private JLabel statusLabel;

    private boolean isButtonEnabled;
    private String userInputText;
    private int selectedComboBoxIndex;


    private JPanel gameContainer;
    private JLabel messageLabel;
    private JMenuBar menuBar;
    private JMenuBar moreMenu;
    private PositionAwareButton[][] buttons;
    private MancalaGame game;
    private Player playerOne = new Player();
    private Player playerTwo = new Player();
    
    


    public MancalaGameUI(String title){
        super();
        basicSetUp(title);
        setUpGameContainer();
        setSize(600,500);
        add(gameContainer, BorderLayout.NORTH);
        gameContainer.setLayout(new BorderLayout());
        //add(makeNewGameButton(), BorderLayout.WEST);
        //add(makeMancalaGameButton(), BorderLayout.EAST);
        setUpMenu();
        setJMenuBar(menuBar);
        //addMoreToMenu();
        //setJMenuBar(moreMenu);
        game = new MancalaGame();
        JPanel gameBoard = new JPanel();
        gameBoard.setLayout(new BorderLayout());
        gameBoard.add(makeMancalaGame(2, 6), BorderLayout.CENTER); 
        gameBoard.setPreferredSize(new Dimension(200,100));
        gameBoard.add(player1Store(), BorderLayout.EAST);
        gameBoard.add(player2Store(), BorderLayout.WEST);
        gameContainer.add(gameBoard);
        preGameSetUp();
        //game.setPlayers(playerOne, playerTwo);
        
        //pack();
       // gameContainer.setPreferredSize(new Dimension(5,5));

        revalidate();
        repaint();

        
    }
    private void setUpMenu(){
        menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JButton quit = new JButton("Quit");
        int selection = 0;
        JOptionPane quitGame = new JOptionPane();
        String confirm = "Would you like to save your game?";
        
        
        if(selection == JOptionPane.NO_OPTION){
            System.exit(0);
        }
        else{
            //call the file chooser code
        }
        menu.add(quit);
        menuBar.add(menu);
        //game = new MancalaGame();

        //setMenuBar(menuBar);

    }


    private void addMoreToMenu(){
        moreMenu = new JMenuBar();
        JMenu menu = new JMenu("More");
        JButton open = new JButton("Open file");
        menu.add(open);
        menuBar.add(menu);

        //allow to open saved file
        //game = new MancalaGame();

        //setMenuBar(menuBar);

    }

    private void basicSetUp(String title){
        this.setTitle(title);
        gameContainer = new JPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }

    private JPanel makeButtonPanel(){ //dont need this
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(makeMancalaGameButton());
        buttonPanel.add(makeNewGameButton());
        //buttonPanel.setPreferredSize(new Dimension(10,10));
        return buttonPanel;
    }

    private JButton makeNewGameButton(){ //dont need this
        JButton button = new JButton("New Game");
        //Dimension size = new Dimension(100,100);
        
        //button.setPreferredSize(size);
        return button;
    }

    private JButton makeMancalaGameButton(){ //dont need this either
        int selection = 0;
        JButton button = new JButton("Quit");
        JOptionPane quitGame = new JOptionPane();
        String confirm = "Would you like to save your game?";
        if(selection == JOptionPane.NO_OPTION){
            System.exit(0);
        }
        else{
            //call the file chooser code
        }
        
        //Dimension size = new Dimension(100,100);
        
        //button.setPreferredSize(size);
        return button;
    }
   
    private JPanel makeMancalaGame(int wide, int tall){
        //int returnVal = 0;
        //int pitNum = 1;
        JPanel panel = new JPanel();
        buttons = new PositionAwareButton[tall][wide];
        panel.setLayout(new GridLayout(wide, tall));
        for(int y = 0; y <wide; y++){
            for(int x = 0; x < tall; x++){
                buttons[x][y] = new PositionAwareButton();
                buttons[x][y].setAcross(x+1);
                buttons[x][y].setAcross(y+1);
               
                System.out.println("INDEX: " + x + " " + y);
                

                panel.add(buttons[x][y]);
            }
        }
        buttons[0][0].setText("Pit 12: " + game.getNumStones(12));
        buttons[1][0].setText("Pit 11: " + game.getNumStones(11));
         buttons[2][0].setText("Pit 10: " + game.getNumStones(10));
         buttons[3][0].setText("Pit 9: " + game.getNumStones(9));
         buttons[4][0].setText("Pit 8: " + game.getNumStones(8));
         buttons[5][0].setText("Pit 7: " + game.getNumStones(7));
         buttons[0][1].setText("Pit 1: " + game.getNumStones(1));
         buttons[1][1].setText("Pit 2: " + game.getNumStones(2));
          buttons[2][1].setText("Pit 3: " + game.getNumStones(3));
          buttons[3][1].setText("Pit 4: " + game.getNumStones(4));
          buttons[4][1].setText("Pit 5: " + game.getNumStones(5));
          buttons[5][1].setText("Pit 6: " + game.getNumStones(6));

        buttons[0][0].addActionListener(e -> {
            //Pit: " + pitNum + ": " + game.getNumStones(pitNum))
            int pitNum = 1;
            //buttons[0][0].setText("0,0");
            int returnVal = 0;
                int pitOne = 12;
                    try {
                        returnVal = gameOver(pitOne);
                        //returnVal = game.move(pitOne);
                    } catch (InvalidMoveException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                });

        buttons[1][0].addActionListener(e -> {
            //buttons[1][0].setText("1,0");
            int returnVal = 0;
                int pitTwo = 11;
                    try {
                         returnVal = gameOver(pitTwo);
                    } catch (InvalidMoveException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                });

        buttons[2][0].addActionListener(e -> {
            //buttons[2][0].setText("2,0");
            int returnVal = 0;
            int pitThree = 10;
                    try {
                      returnVal = gameOver(pitThree);
                         
                    } catch (InvalidMoveException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                });
        
        buttons[3][0].addActionListener(e -> {
            //buttons[3][0].setText("3,0");
            int returnVal = 0;
            int pitFour = 9;
                    try {
                       returnVal = gameOver(pitFour);
                    } catch (InvalidMoveException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                });
        
        buttons[4][0].addActionListener(e -> {
            //buttons[4][0].setText("4,0");

            int returnVal = 0;
            int pitFive = 8;
                    try {
                        returnVal = gameOver(pitFive);
                    } catch (InvalidMoveException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                });

        buttons[5][0].addActionListener(e -> {
            //buttons[5][0].setText("5,0");

            int returnVal = 0;
            int pitSix = 7;
                    try {
                        returnVal = gameOver(pitSix);
                    } catch (InvalidMoveException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                });

        buttons[0][1].addActionListener(e -> {
                        //buttons[0][0].setText("0,1");

            int returnVal = 0;
            int pitSeven = 1;
                    try {
                        returnVal = gameOver(pitSeven);
                    } catch (InvalidMoveException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                });

        buttons[1][1].addActionListener(e -> {
                        //buttons[0][0].setText("1,1");

            int returnVal = 0;
            int pitEight = 2;
                    try {
                        returnVal = gameOver(pitEight);
                    } catch (InvalidMoveException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                });
        
        buttons[2][1].addActionListener(e -> {
            //buttons[2][1].setText("2,1");

            int returnVal = 0;
            int pitNine = 3;
                    try {
                        returnVal = gameOver(pitNine);
                    } catch (InvalidMoveException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                });
        
        buttons[3][1].addActionListener(e -> {
            //buttons[3][1].setText("3,1");
            int returnVal = 0;
            int pitTen = 4;
                    try {
                        returnVal = gameOver(pitTen);
                    } catch (InvalidMoveException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                });

        buttons[4][1].addActionListener(e -> {
            //buttons[4][1].setText("4,1");
            int returnVal = 0;
            int pitEleven = 5;
           
                    try {
                        returnVal = gameOver(pitEleven);
                    } catch (InvalidMoveException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                });
        
        buttons[5][1].addActionListener(e -> {
            //buttons[5][1].setText(",1");
            int returnVal = 0;
            int pitTwelve = 6;
                    try {
                        returnVal = gameOver(pitTwelve);
                    } catch (InvalidMoveException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                });
        panel.setSize(100,200);
        return panel;
    }

    /*private playGame(int wide, int tall){
        JPanel panel = new JPanel();
        buttons = new PositionAwareButton[tall][wide];
        panel.setLayout(new GridLayout(wide, tall));
        for(int y = 0; y < wide; y++){
            for(int x = 0; x < tall; x++){
                buttons[x]
            }
        }
    }
    }*/

    private JPanel startUpMessage(){
        JPanel temp = new JPanel();
        temp.add(new JLabel("Time to play Mancala! Good Luck!"));
        return temp;
    }
    private JPanel player1Store(){
        JPanel temp = new JPanel();
        temp.add(new JLabel("Player 1 Store: "));
        return temp;
    }
    private JPanel player2Store(){
        JPanel temp = new JPanel();
        temp.add(new JLabel("Player 2 Store: "));
        return temp;
    }
    public void setUpGameContainer(){
        gameContainer.add(startUpMessage());
    }

    private int gameOver(int pit) throws InvalidMoveException{
        int temp = 0;
        if(!game.isGameOver()){
          temp = game.move(pit);
          if(game.getCurrentPlayer() == playerOne){
            game.setCurrentPlayer(playerTwo);
        }else{
            game.setCurrentPlayer(playerOne);
        }
        }
        return temp;
    }

    private void preGameSetUp(){
        game.setPlayers(playerOne, playerTwo);
        var name = JOptionPane.showInputDialog("Enter the first player's name");
        playerOne.setName(name);
        var name2 = JOptionPane.showInputDialog("Enter the second player's name");
        playerTwo.setName(name);

    }

     public static void main(String[] args){
        MancalaGameUI example = new MancalaGameUI("Mancala Game");
        example.setVisible(true);
    }
   


}