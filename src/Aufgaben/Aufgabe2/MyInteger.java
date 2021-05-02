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

    //wenn s eine Zahl ist, dann int-Zahl zurückgeben
    public static int parseInt(String s) throws IllegalArgumentException {

        //s ist leer
        if (s.length() == 0) {
            throw new IllegalArgumentException("Eingabe ist leer!");
        }


        else if () {

        }
        throw new IllegalArgumentException("Keine Zahl!");
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
