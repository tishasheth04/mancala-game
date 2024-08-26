package mancala;

import java.io.Serializable;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;

public class MancalaGame implements Serializable{ 
    //added this
    private static final long serialVersionUID = 2516531281910888460L;
    private List<Player> playerArrayList;
    private Player currentPlayer;
    //private Board board = new Board(); 
    private GameRules board = new AyoRules();
    private int currPlayer = 0;
    private int numStones = 0; //is this right???
    

    public MancalaGame(){
        setBoard(board);
        //playerArrayList= new ArrayList<Player>();
        //setBoard(board);
        //board = new Board();
        //board.initializeBoard();
        //currentPlayer = ;
    }
    /*public void setGame(final int num){
        if(num == 1){
            board = new KalahRules();
        }
        else{
            board = new AyoRules();
        }
    }*/

    /* 
    public void testDis(){
        int value = 0;
        int value2 = 0;
     
            try {
                //value = board.moveStones(6, playerArrayList.get(1));
                value = board.moveStones(1, playerArrayList.get(0));
                //board.toString();
                value2 = board.moveStones(10, playerArrayList.get(1));
                //board.toString();
                value = board.moveStones(2, playerArrayList.get(0));
                //board.toString();
                value2 = board.moveStones(7, playerArrayList.get(1));
                //board.toString();
                value = board.moveStones(1, playerArrayList.get(0));
                System.out.println("Value: " + value);
                System.out.println("Value 2: " + value2);
                //board.toString();
            } catch (InvalidMoveException e) {
                // TODO Auto-generated catch block
                System.out.println(e.getMessage());
                //System.out.println("hello");
            }
            /* 
            for(int k = 0; k < 12; k++){
                System.out.println("before print");
                System.out.printf("%d, %d", (k+1), board.getNumStones(k+1));
    
            }
            System.out.println("STORE 0: " + storeArrayList.get(0).getTotalStones());
            System.out.println("STORE 1: " + storeArrayList.get(1).getTotalStones());
            */
    //}
    public void setPlayers(final Player onePlayer, final Player twoPlayer){     

        playerArrayList= new ArrayList<Player>();
        //setCurrentPlayer(onePlayer);
        playerArrayList.add(onePlayer);
        playerArrayList.add(twoPlayer);
        //System.out.println("SIZE: " + playerArrayList.size()); //this is printing 
        //board.registerPlayers(onePlayer, twoPlayer);
        board.registerPlayers(playerArrayList.get(0), playerArrayList.get(1));
        setCurrentPlayer(onePlayer);


    }
    /* 
    public ArrayList<Player> getPlayers(){
        //playerArrayList= new ArrayList<Player>();
        return playerArrayList;


    }*/
    public Player getCurrentPlayer(){
        return currentPlayer;  

    }
    public void setCurrentPlayer(final Player player){
        currentPlayer = player;

    }
    public void setBoard(final GameRules theBoard){
        board = theBoard;
        //System.out.println("setBoard");

    }
    public GameRules getBoard(){
        return board;

    }
    public int getNumStones(final int pitNum) {
        //throws PitNotFoundException {
        //int numStones = 0;
            numStones = board.getNumStones(pitNum);
        //System.out.println("NUM STONES: " + numStones);

        return numStones;
    }
    public int move(final int startPit) throws InvalidMoveException{ 
        //System.out.println("Start pit: " + startPit);

        //int storeReturn;
        //int sidePitTotal = 0;
        //int currPlayer = 0;

        try{
            if(startPit >= 1 && startPit <= 6){
                currPlayer = 1;
            }else if(startPit >= 7 && startPit <= 12){
                currPlayer = 2;
            }
            //board.getDataStructure().addStones(12, 2);
            //board.getDataStructure().removeStones(7);
            //board.getDataStructure().addStones(1,1);
            //board.moveStones(4,1);
            board.moveStones(startPit, currPlayer); //NEED THIS BACK
            //System.out.println("Store return: " + storeReturn);
        }catch(InvalidMoveException ex){
            //System.out.println("moVE CATCH BLOCK");
            throw new InvalidMoveException();
            //System.out.println(ex.getMessage());
        }

        int sidePitTotal = 0;
        if(startPit >= 1 && startPit <= 6){
            for(int i = 0; i < 6; i++){
                    sidePitTotal += board.getNumStones(i+1);
            }
            //return sidePitTotal;
        }else if(startPit >= 7 && startPit <= 12){
            for(int i = 6; i < 12; i++){
                    sidePitTotal += board.getNumStones(i+1);
            }
            //return sidePitTotal;
        }
        return sidePitTotal;
        //throw new InvalidMoveException();
    }

    public int getStoreCount(final Player player) throws NoSuchPlayerException{

        if(!player.equals(playerArrayList.get(0))&& !player.equals(playerArrayList.get(1))){
        //if(player != (playerArrayList.get(0)) && player != (playerArrayList.get(1))){
            throw new NoSuchPlayerException("This player does not exist.");
        }

        return player.getStoreCount();
        //return storeCount;

    }

    public Player getWinner() throws GameNotOverException{ //check this with eddie as well!

        if(!isGameOver()){
            throw new GameNotOverException("The game is not over.");
        }
        /* 
        try {
            System.out.println("Player 1 count: "  + 
            getStoreCount(playerArrayList.get(0)) + playerArrayList.get(0).getName());
        } catch (NoSuchPlayerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(board.getStores().get(0).getTotalStones());
        System.out.println(board.getStores().get(1).getTotalStones());
        
        try {
            System.out.println("Player 2 count: " +  
            getStoreCount(playerArrayList.get(1)) + playerArrayList.get(1).getName());
        } catch (NoSuchPlayerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        */
        
        
       // if(isGameOver()){
        Player playerWinner = null;
        final Player playerOne = playerArrayList.get(0);
        final Player playerTwo = playerArrayList.get(1);
            if(playerOne.getStoreCount() > playerTwo.getStoreCount()){
                playerWinner = playerOne;
            }else if (playerTwo.getStoreCount() > playerOne.getStoreCount()){
                playerWinner = playerTwo;
            }
            return playerWinner;
                      
        //}
        //throw new GameNotOverException();
        //return null;
            //throw new GameNotOverException();
        
            //return playerArrayList.get(1);
    }
    public boolean isGameOver(){
        boolean val = false;
        if(board.isSideEmpty(2) || board.isSideEmpty(8)){
                //System.out.println("in isGameOvertrue");
                val = true;
            }
        
       return val;

    }
    public void startNewGame(){
        //board.initializeBoard();
        board.resetBoard();
        //board.initializeBoard();
        //System.out.println("startNewGame");

    }
    @Override
    public String toString(){
        return board.toString();

    }
}