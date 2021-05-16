package Aufgaben.singleNumber;

import java.util.*;

public class singleNumber {

    /*
    es ist nicht leer, d.h. 1 <= nums.length,
    jede Zahl in nums ist genau zwei Mal in nums enthalten, bis auf eine - diese existiert nur genau ein Mal in nums
    */
    public static int singleNumber(int[] nums) {
        Set<Integer> menge = new HashSet<>();  //Set - um die Zahlen zu verfolgen
        for (int zahl : nums) {
            if (!menge.add(zahl)) {   //wenn wir die Zahl nicht in der menge hinzufügen können,
                menge.remove(zahl);   //dann entfernen wir die Zahl, bis nur eine Zahl bleibt
            }
        }
        return menge.iterator().next();
    }
}
