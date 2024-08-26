package mancala;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Saver implements Serializable {

    private static final long serialVersionUID = -2991510898634391193L;

    static public void saveObject(final Serializable toSave, final String filename) throws IOException{
        try{
            final String path = "assets/" + filename;
            final FileOutputStream outPutStream = new FileOutputStream(path);
            final ObjectOutputStream outPutDest = new ObjectOutputStream(outPutStream);
            outPutDest.writeObject(toSave);
            outPutDest.close();
            //outPutStream.close();
        }catch(IOException io){
            io.printStackTrace();
        }

    }

    static public Serializable loadObject(final String filename) throws IOException{
        
        Object myReadObj = null;
        final String path = "assets/" + filename;
    
        try{
            final ObjectInputStream input = new ObjectInputStream(new FileInputStream(path));
            myReadObj = input.readObject();
            //input.close();
        
        }catch(IOException | ClassNotFoundException io){
            io.printStackTrace();
        }
        //input.close();
        
        return (Serializable) myReadObj;
    }
    
}

