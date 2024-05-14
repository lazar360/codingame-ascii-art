import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        String[] rowArray = new String[H];

        if (in.hasNextLine()) {
            in.nextLine();
        }
        String T = in.nextLine();
        for (int i = 0; i < H; i++) {
            String ROW = in.nextLine();
            // 1- save the ROW
            rowArray[i] = ROW;
        }

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");
        List<Character> listChar = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
                'y', 'z', '?'));
        Map<Character, String[]> mapChar = new HashMap<>();
        Map<Integer, List<String>> mapList = new HashMap<>();
        Map<Integer, String> mapLineString = new HashMap<>();

        // 2- cut every line in parts within a larger of L
        // iterate over lines
        for (int i = 0; i < rowArray.length; i++) {
            List<String> listString = new ArrayList<>();
            // iterate over columns
            for (int j = 0; j < 27; j++) {
                listString.add(rowArray[i].substring(j * L, (j + 1) * L));
            }
            mapList.put(i, listString);
        }

        // 3- create an array for each Char
        for (int i = 0; i < listChar.size(); i++) {
            String[] charArray = new String[H];
            for (int j = 0; j < H; j++) {
                charArray[j] = mapList.get(j).get(i);
            }
            // 4- create converter mapChar
            mapChar.put(listChar.get(i), charArray);
        }

        // 5- prepare sequence to sout
        for (Character character : T.toCharArray()) {
            // System.err.println("character= " + Character.toLowerCase(character));
            Character toConvert = Character.toLowerCase(character);
            for (int j = 0; j < H; j++) {
                if (mapLineString.containsKey(j)) {
                    String currentString = mapLineString.get(j);
                    if (mapChar.get(toConvert) != null) {
                        mapLineString.put(j, currentString + mapChar.get(toConvert)[j]);
                    } else {
                        mapLineString.put(j, currentString + mapChar.get('?')[j]);
                    }
                } else {
                    mapLineString.put(j, mapChar.get(toConvert)[j]);
                }
            }
        }

        // 6- sout
        for (int j = 0; j < H; j++) {
            System.out.println(mapLineString.get(j));
        }
    }
}