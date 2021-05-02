package Aufgaben.Aufgabe2;

public class MyInteger {

    public static int MAX_VALUE = 2147483647;
    public static int MIN_VALUE = -2147483648;
    private int value;

    //Konstruktor
    public MyInteger(int value) {
        this.value = value;
    }
    public MyInteger(String s) throws IllegalArgumentException {
        this.value = parseInt(s);
    }

    public int intValue(){
        return this.value;
    }

    public double doubleValue() {
        return this.value;
    }

    public static MyInteger valueOf(String s) throws IllegalArgumentException
    {
        return new MyInteger(s);
    }

    public static MyInteger valueOf(int value)
    {
        return new MyInteger(value);
    }

    private static boolean charIsDigit(char c)
    {
        return (c >= '0' && c <= '9');
    }


    public static boolean EingabeIstZahl(String s) {

        for (int i = 0; i < s.length(); i++) {
            if(!charIsDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static int charToInt (char c){
        int acsii = c;
        int valueInt = acsii-48;  //sehe ascii
        return valueInt;
    }

    //wenn s eine Zahl ist, dann int-Zahl zurückgeben
    public static int parseInt(String s) throws IllegalArgumentException {

        //s ist leer
        if (s.length() == 0) {
            throw new IllegalArgumentException("Eingabe ist leer!");
        }
        boolean negative = false;

        //wenn erster Index ist '+' oder '-'
        if (s.charAt(0) == '+') {
            s = s.substring(1); // weiter wird geprueft ob unter nächstem Index eine Zahl steht
        } else if (s.charAt(0) == '-') {
           s = s.substring(1);
           negative = true;
        }
        if (s.length() == 0) {
            throw new IllegalArgumentException("Eingabe ist keine Zahl!");
        }


        //pruefen on Eingabe Zahl ist >> EingabeIstZahl()
        if (!EingabeIstZahl(s)) throw new IllegalArgumentException ("Eingabe ist keine Zahl!");

        int exp = 1;
        int zahl = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            zahl = zahl + charToInt(s.charAt(i)) * exp;
            exp *= 10;
        }
        if (negative) {
            return -zahl;
        }
        else return zahl;
    }



    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;

        MyInteger Int = (MyInteger)o;
        return (this.value == Int.value);
    }

    @Override
    public int hashCode() {
        return this.value;
    }

    @Override
    public String toString() {
        String s = "";
        s = String.format("MyInteger value = %d", this.value);
        return s;
    }
}
