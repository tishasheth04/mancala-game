package mancala;

import java.io.Serializable;

public class Store implements Serializable, Countable {
    private static final long serialVersionUID = 625942305929771717L;
    private Player owner;
    private int totalStones; 

    public Store(){
       // owner = new Player();
        totalStones = 0;
        //System.out.println("Stores");

    }
  
    public void setOwner(final Player player){
        owner = player;
        //System.out.println("setOwner");

    }
    public Player getOwner(){
        //Player owner = new Player();
        return owner;

    }
    
    @Override
    public void addStones(final int amount){
        totalStones+= amount;
        //System.out.println("addStones");

    }
    /* 
    public int getTotalStones(){
        
        return totalStones;

    }
    public int emptyStore(){
        int storeValue = totalStones;
        totalStones = 0;
        return storeValue;

    }

    /* 
    @Override
    public String toString(){
        return " " + totalStones;
    }*/

    @Override
    public int getStoneCount() {
        return totalStones;
    }

    @Override
    public void addStone() {
        totalStones = totalStones + 1;
    }

    @Override
    public int removeStones() {
       final int storeValue = totalStones;
        totalStones = 0;
        return storeValue;
    }
}