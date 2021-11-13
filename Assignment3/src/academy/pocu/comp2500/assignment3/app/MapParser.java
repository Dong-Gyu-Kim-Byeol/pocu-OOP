package academy.pocu.comp2500.assignment3.app;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

class MapParser {
    public static void parser(){
        InputStream in = System.in;
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        ArrayList<String> grid = new ArrayList<>();
        ArrayList<String> positions = new ArrayList<>();

        String buffer;
        int lineCount = 0;
        try {
            while ((buffer = br.readLine()) != null) {
                grid.add(buffer);
                lineCount++;

                if (lineCount > 7) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (String line : grid) {
            for (int i = 2; i < line.length(); i++) {
                if (Character.isAlphabetic(line.charAt(i)) || Character.isDigit(line.charAt(i))) {
                    positions.add(String.format("%c: [%d,%d]", line.charAt(i), i - 2, grid.indexOf(line)));
                }
            }
        }

        positions.sort((String s0, String s1) -> {
            Character a = s0.charAt(0);
            Character b = s1.charAt(0);

            return a.compareTo(b);
        });

        for (String pos : positions) {
            System.out.println(pos);
        }
    }
}