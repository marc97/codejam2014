package me.marcpacheco;

import java.io.*;

public class MagicTrick {
    private static BufferedReader buf;
    private static PrintStream writer;
   
    public static void main (String[] args) throws IOException {
        buf = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintStream(System.out);
        
        File fileIn = new File("C:/Users/Marc/Desktop/A-small-attempt1.in");
        File fileOut = new File("C:/Users/Marc/Desktop/magic-trick.out");
        
        if (fileIn.canRead() && fileIn.exists()) {
            buf = new BufferedReader(new FileReader(fileIn));
            writer = new PrintStream(fileOut);
        }
        
        init();
        writer.close();
    }
    
    private static void init() throws IOException {
        int cases = getNextInt();
        for (int i = 0; i < cases; i++) {
            writeCase(String.valueOf(i + 1), String.valueOf(trickResult()));
        }
    }
    
    private static String trickResult() throws IOException {
        int firstAnswer = getNextInt();
       
        String[][] table1 = new String[4][4];
        
        table1[0] = getNextString().split(" ");
        table1[1] = getNextString().split(" ");
        table1[2] = getNextString().split(" ");
        table1[3] = getNextString().split(" ");
        
        int secondAnswer = getNextInt();
        
        String[][] table2 = new String[4][4];
        
        table2[0] = getNextString().split(" ");
        table2[1] = getNextString().split(" ");
        table2[2] = getNextString().split(" ");
        table2[3] = getNextString().split(" ");
        
        int count = 0;
        int lastKey = 0;
        
        for (int i = 0; i < 4; i++) {
            int key = Integer.parseInt(table1[firstAnswer -1][i]);
            for (int j = 0; j < 4; j++) {
                int check = Integer.parseInt(table2[secondAnswer -1][j]);
                if (key == check) {
                    count++;
                    lastKey = key;
                }
            }
        }
        
        if (count == 0) {
            return "Volunteer cheated!";
        } else if (count > 1) {
            return "Bad magician!";
        } else if (count == 1) {
            return String.valueOf(lastKey);
        }
        
        return null;
    }
    
    private static int getNextInt() throws IOException {
        return Integer.parseInt(buf.readLine());
    }
    
    private static long getNextLong() throws IOException {
        return Long.parseLong(buf.readLine());
    }
    
    private static String getNextString() throws IOException {
        return buf.readLine();
    }
    
    private static void writeCase(String index, String value) {
        writer.println("Case #" + index + ": " + value);
        writer.flush();
    }
}
