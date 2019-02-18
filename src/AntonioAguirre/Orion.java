/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AntonioAguirre;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gmartinez
 */
public class Orion {
    public static void menuOrion() throws IOException  {
        String opcio;
        Scanner sc = new Scanner(System.in);
        StringBuilder menu = new StringBuilder("");


        
        do {
            menu.delete(0, menu.length());
            
            menu.append(System.getProperty("line.separator"));
            menu.append("RPO Orion-A");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));
            
            menu.append("1. Activar sistema Delta");
            menu.append(System.getProperty("line.separator"));
            menu.append("2. Activar sistema IRST");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));
            
            menu.append("50. Tornar al menú pare (PNS-24 Puma)");
            menu.append(System.getProperty("line.separator"));
            
            System.out.print(MenuConstructorPantalla.constructorPantalla(menu));
            
            opcio = sc.next();
//            opcio = "2";
            switch (opcio) {
                case "1":
                    break;
                case "2":
                    activarSistemaIRST();
                    break;
                case "50":
                    break; 
                default:
                    System.out.println("COMANDA NO RECONEGUDA");
            }   
        } while (!opcio.equals("50"));
    }

    private static void activarSistemaIRST() {
        System.out.println("Orion.activarSistemaIRST(): INICI a les " + HoraActual.hora());
        int size = 6;
        Sistema_de_guia_IRST[] arrayIrsts = new Sistema_de_guia_IRST[size];


        Radar_Orion_A recursos = new Radar_Orion_A(6);

        for (int i = 0; i < size; i++){
            arrayIrsts[i] = new Sistema_de_guia_IRST(i, recursos);
            arrayIrsts[i].setName("IRST-" + i);
            arrayIrsts[i].start();
        }



    }


}
