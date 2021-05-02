package Aufgaben.Aufgabe2;

public class TestMyInteger {
    public static void main(String[] args) {

        try {
            MyInteger Myint = new MyInteger("liue89");
            System.out.println("MyInteger : " + Myint.intValue());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

