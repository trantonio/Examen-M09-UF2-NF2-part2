/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AntonioAguirre;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gines
 */
public class Sistema_de_guia_IRST extends Thread{
    int id;
    Radar_Orion_A radar_orion_a;

    public Sistema_de_guia_IRST(int id, Radar_Orion_A radar_orion_a) {
        this.id = id;
        this.radar_orion_a = radar_orion_a;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();


        int numRadar;
        Santabarbara s = new Santabarbara();
        s.assignarR37(2,2);
        System.out.println(name + ": INICI "+HoraActual.hora());

        numRadar = radar_orion_a.carregarDadesObjectiu();

        System.out.println(name + ": add misil" + numRadar + " + sleep(7000)");
 try {
            Thread.currentThread().sleep(7000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Sistema_de_guia_IRST.class.getName()).log(Level.SEVERE, null, ex);
        }
 radar_orion_a.liberarObjetivo(numRadar);

        System.out.println(name + ": FI "+HoraActual.hora() + numRadar);


    }
}
