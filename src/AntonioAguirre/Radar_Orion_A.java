/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AntonioAguirre;


import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author gines
 */

public class Radar_Orion_A {
    private SortedSet<Meteorit> setObjectius = new TreeSet<Meteorit>();

    private int quantitatMisiles;
    private Semaphore semaforo;
    private boolean[] misiles;

    public Radar_Orion_A(int size) {
        quantitatMisiles = size;
        semaforo = new Semaphore(size);
        misiles = new boolean[size];
    }

    public Radar_Orion_A() {
        setObjectius.add(new Meteorit(1, 2000));
        setObjectius.add(new Meteorit(3, 2000));
        setObjectius.add(new Meteorit(2, 2000));
        setObjectius.add(new Meteorit(4, 12000));
        setObjectius.add(new Meteorit(5, 7000));
        setObjectius.add(new Meteorit(6, 7000));
    }


    public int assignarObjectiu(String nomSistemaDeGuia){
        for (Meteorit m : setObjectius){
            if(m.getSistemaDeGuiaAssignat()=="CAP"){
                m.setSistemaDeGuiaAssignat(nomSistemaDeGuia);
                return m.getId();
            }

        }
        System.out.println("assignarObjectiu ----"+Thread.currentThread().getName());

        return -1;
    }

    public synchronized int addObjectiu() {
        int i = 0;
        while (i < quantitatMisiles) {
            if (misiles[i] == false) {
                misiles[i] = true;
                break;
            }
            i++;
        }

        return (i);
    }

 public Integer carregarDadesObjectiu() {
        String name = Thread.currentThread().getName().toUpperCase();

        try {
            System.out.println("Radar.carregarDadesObjectiu(): " + name + " abefore semaforo.");
            semaforo.acquire();
            System.out.println("Radar.carregarDadesObjectiu(): " + name + " after semaforo.");

        } catch (InterruptedException ex) {
            Logger.getLogger(Radar_Orion_A.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (addObjectiu());
    }
  public synchronized void liberarObjetivo(Integer numCaixa) {
        misiles[numCaixa] = false;

        semaforo.release();
    }
    
    
}
