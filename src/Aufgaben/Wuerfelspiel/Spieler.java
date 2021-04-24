package Aufgaben.Wuerfelspiel;

import javax.swing.*;
import java.util.Random;

    public class Spieler {
        private String name;   //Name #Spieler 1
        private int Punkterstandact;

    public Spieler(String name) {
        this.name = name;
        this.Punkterstandact = 0; //der Punkterstand am Anfang der Spiel ist 0
    }

    public boolean wuerfeln() {
        System.out.printf("%n%s ist im Spiel. Aktueller Punktestand ist %d %n", this.name, this.Punkterstandact );
        Random rand = new Random();
        int VersuchPunkte = 0;  //Punkte in jedem Versuch
        int wurf = 0;
        boolean end = false;
        while (!end) {
            wurf = rand.nextInt(6) + 1;
            System.out.printf("Es wurde %d gewürfelt %n", wurf);

            if (wurf == 6) {
                VersuchPunkte = 0;
                System.out.printf("Der Versuch ist am Ende.%n");
                end = true;
                System.out.printf("%s, ihrer aktueller Punkterstand : %d%n", this.name, this.Punkterstandact);
            }

            else if ((Punkterstandact + VersuchPunkte + wurf) >= Wuerfelspiel.GewinnPunkte) {
                System.out.printf("Der %s mit %d Punkte hat gewonnen%n", this.name, this.Punkterstandact+VersuchPunkte+wurf);
                return true;
            }

            else {
                VersuchPunkte += wurf;
                System.out.printf("In diesem Versuch hat %s bisher %d Punkte. Aktueller Punkterstand %d%n", this.name, VersuchPunkte, (Punkterstandact+VersuchPunkte));
                int dialogResult = JOptionPane.showConfirmDialog (null, this.name+ ", weiter wuerfeln? ", "Weiter wuerfeln?", JOptionPane.YES_NO_OPTION);
                end = (dialogResult==JOptionPane.NO_OPTION);

                if(end)
                {
                    Punkterstandact += VersuchPunkte;
                    System.out.printf("%s, der Versuch ist am Ende %n",this.name);
                }

                System.out.printf("%s, ihrer aktueller Punkterstand : %d%n", this.name, this.Punkterstandact);
            }


        }
        return false;
    }
}

