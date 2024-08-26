package mancala;

import java.io.Serializable;

public class Pit implements Serializable, Countable{
    private static final long serialVersionUID = -8581857526535546531L;

    private int stoneCount;

    public Pit(){
        stoneCount = 0;
    }

    @Override
    public int getStoneCount(){
        return stoneCount;

    }
    @Override
     public void addStone(){
        stoneCount = stoneCount+1;
        //System.out.println("STONE COUNT IN ADDSTONE: " + stoneCount);
        

    }

    @Override
    public int removeStones(){
        //System.out.println("STONE COUNT: " + stoneCount);
        final int count = stoneCount;
        stoneCount = 0;
        //System.out.println("Count: " + count);
        
        return count;

    }
    //Possibly change this toString method
    /* 
    @Override
    public String toString(){
        return " " + stoneCount;
    }*/

    @Override
    public void addStones(final int numToAdd) {
        stoneCount = numToAdd +stoneCount;
    }

   
}