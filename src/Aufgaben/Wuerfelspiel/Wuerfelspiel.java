package Aufgaben.Wuerfelspiel;

import javax.swing.*;

    public class Wuerfelspiel {

    public static int GewinnPunkte;
    public Spieler[] spieler;

    public Wuerfelspiel ()  //Konstruktor
    {
        AnzahlSpieler ();
        getSpieler();
        Gewinn();
    }

    public void AnzahlSpieler () {
        int anzspieler = 0;
        String n = JOptionPane.showInputDialog("Geben Sie Anzahl der Spieler ein");
        anzspieler = Integer.parseInt(n);
        spieler = new Spieler[anzspieler];
    }

    public void getSpieler() {
    for (int index = 0; index < this.spieler.length; index++) {
        String name = "Spieler " + (index + 1);
        this.spieler [index] = new Spieler(name);
        }
    }

    public void Gewinn() {
        this.GewinnPunkte = 0;
        String m = JOptionPane.showInputDialog("Geben Sie Gewinnpunkte ein");
        this.GewinnPunkte = Integer.parseInt(m);
    }

    public void spielen (){
        int index = 0;   //Spieler1 ist unter dem Index 0
        boolean gewonnen = false;
        while(!gewonnen)
        {
            gewonnen = spieler[index].wuerfeln(); //Spielt Spieler mit index ..
            index = (index<spieler.length-1) ? index+1 : 0;  //if - else
        }
    }

    public static void main(String[] args)
    {
        Wuerfelspiel spiel = new Wuerfelspiel();
        spiel.spielen ();
    }
}
