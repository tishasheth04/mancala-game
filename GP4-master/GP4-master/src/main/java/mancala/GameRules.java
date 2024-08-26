package mancala;

import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;

/**
 * Abstract class representing the rules of a Mancala game.
 * KalahRules and AyoRules will subclass this class.
 */
public abstract class GameRules implements Serializable {
    private static final long serialVersionUID = 4951959849095311137L;
    private final MancalaDataStructure gameBoard;
    //private List<Store> storeArrayList = new ArrayList<Store>();
    private int currentPlayer; 
    private boolean val = true;// Player number (1 or 2)
   

    /**
     * Constructor to initialize the game board.
     */
    public GameRules() {
        gameBoard = new MancalaDataStructure();
        gameBoard.setUpPits();

    }

    /**
     * Get the number of stones in a pit.
     *
     * @param pitNum The number of the pit.
     * @return The number of stones in the pit.
     */
    public int getNumStones(final int pitNum) {
        return gameBoard.getNumStones(pitNum);
    }

    /**
     * Get the game data structure.
     *
     * @return The MancalaDataStructure.
     */
    /* default */ MancalaDataStructure getDataStructure() {
        return gameBoard;
    }

    /**
     * Check if a side (player's pits) is empty.
     *
     * @param pitNum The number of a pit in the side.
     * @return True if the side is empty, false otherwise.
     */
    /* default */ boolean isSideEmpty(final int pitNum) { 
        //boolean val = true;//ask eddie
         if(pitNum <=6 && pitNum > 0){
            for(int i = 0; i < 6; i++){
                if(gameBoard.getNumStones(i+1) != 0){
                    val = false;
                }
            }
        }else if (pitNum > 6 && pitNum <=12){
            for(int i = 6; i < 12; i++){
                if(gameBoard.getNumStones(i+1) != 0){
                    val = false;
                }
            }
        }
        return val;
        // This method can be implemented in the abstract class.
    }

    /**
     * Set the current player.
     *
     * @param playerNum The player number (1 or 2).
     */
    public void setPlayer(final int playerNum) {
        currentPlayer = playerNum;
    }

    /**
     * Perform a move and return the number of stones added to the player's store.
     *
     * @param startPit  The starting pit for the move.
     * @param playerNum The player making the move.
     * @return The number of stones added to the player's store.
     * @throws InvalidMoveException If the move is invalid.
     */
    public abstract int moveStones(int startPit, int playerNum) throws InvalidMoveException;

    /**
     * Distribute stones from a pit and return the number distributed.
     *
     * @param startPit The starting pit for distribution.
     * @return The number of stones distributed.
     */
    /* default */ abstract int distributeStones(int startPit);

    /**
     * Capture stones from the opponent's pit and return the number captured.
     *
     * @param stoppingPoint The stopping point for capturing stones.
     * @return The number of stones captured.
     */
   /* default */ abstract int captureStones(int stoppingPoint);

    /**
     * Register two players and set their stores on the board.
     *
     * @param one The first player.
     * @param two The second player.
     */
    public void registerPlayers(final Player one, final Player two) { 
        final Store playerOneStore = new Store();
        final Store playerTwoStore = new Store();
        //System.out.println("hello"); //printing
        playerOneStore.setOwner(one);
        //storeArrayList.get(0).setOwner(one);
        //System.out.println("Store array list owner one: " + storeArrayList.get(0).getOwner().getName()); //not printing
        playerTwoStore.setOwner(two);
        //storeArrayList.get(1).setOwner(two);

        gameBoard.setStore(playerOneStore, 1);
        gameBoard.setStore(playerTwoStore, 2);
        
        one.setStore(playerOneStore);
        two.setStore(playerTwoStore);
        // this method can be implemented in the abstract class.


        /* make a new store in this method, set the owner
         then use the setStore(store,playerNum) method of the data structure*/
    }

    /**
     * Reset the game board by setting up pits and emptying stores.
     */
    public void resetBoard() {
        gameBoard.setUpPits();
        gameBoard.emptyStores();
    }

    /*private void printStuff(){
        System.out.println("Player 1's Store: " + gameBoard.getStoreCount(1));
        for(int k = 5; k >=0; k--){
            //System.out.println("before print");
            //System.out.println("\t " + (k+1)+ " " +(pitArrayList.get(k)));
            System.out.println("\t Pit " + (k+ 1) + ": " + gameBoard.getNumStones(k+1));

        }
        for(int k = 6; k < 12; k++){
            //System.out.println("before print");
            //System.out.println((k+1)+ " " +(pitArrayList.get(k)));
            System.out.println("Pit " + (k+1) + ": " + gameBoard.getNumStones(k+1));
            //System.out.printf("%d, %d\n", (k+1), pitArrayList.get(k));

        }
        System.out.println("\nPlayer 2 Store: " + gameBoard.getStoreCount(2));
    }*/

    @Override
    public String toString() {
        //System.out.println("Hello in toString");
        //printStuff();
        return " ";
        // Implement toString() method logic here.
    }
}
