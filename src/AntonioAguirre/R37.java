/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AntonioAguirre;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gines
 */
public class R37{
    int id;
    boolean senseUtilitzar;
    int objectiuID;

    
    
    
    public R37(int misilId) {
        id = misilId;
        senseUtilitzar = true;
        objectiuID = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSenseUtilitzar() {
        return senseUtilitzar;
    }

    public void setSenseUtilitzar(boolean senseUtilitzar) {
        this.senseUtilitzar = senseUtilitzar;
    }

    public int getObjectiuID() {
        return objectiuID;
    }

    public void setObjectiuID(int objectiuID) {
        this.objectiuID = objectiuID;
    }
}
