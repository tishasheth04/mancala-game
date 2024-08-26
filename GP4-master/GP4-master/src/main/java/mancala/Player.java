package mancala;

import java.io.Serializable;

public class Player implements Serializable{
    private static final long serialVersionUID = 3888626968871563214L;
    //private int storeCount;
    private Store storePlayer;
    private String nameOfPlayer;
    final private UserProfile userProfile = new UserProfile(); //check this as well brah

    public Player(){
        nameOfPlayer = userProfile.getNameOfPlayer();
        //storeCount = 0;
        //store = new Store();     
    }
    /* 
    public Player(String name){
         nameOfPlayer = name;
    }*/
    public String getName(){
        return nameOfPlayer;
    }
      
    public void setName(final String name){ //do we need this now?
        nameOfPlayer = name;
        //System.out.println("setName");

    }
    public void setStore(final Store store){
        storePlayer = store;
        //System.out.println("setStore");

    }
     
    public Store getStore(){
       return storePlayer;
    }

    public int getStoreCount(){
        
        return storePlayer.getStoneCount();

    }
    @Override
    public String toString(){
        return "Player " + nameOfPlayer + " store count: " + storePlayer.getStoneCount();
    }
}