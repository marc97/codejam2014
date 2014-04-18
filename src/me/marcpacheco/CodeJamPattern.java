package me.marcpacheco;

import java.io.*;

public class CodeJamPattern {
    private static BufferedReader buf;
    private static PrintStream ps;
   
    public static void main (String[] args) throws IOException {
        buf = new BufferedReader(new InputStreamReader(System.in));
        ps = new PrintStream(System.out);
        
        File fileIn = new File("C:/Users/Marc/Desktop/A-small-attempt1.in");
        File fileOut = new File("C:/Users/Marc/Desktop/magic-trick.out");
        
        if (fileIn.canRead() && fileIn.exists()) {
            buf = new BufferedReader(new FileReader(fileIn));
            ps = new PrintStream(fileOut);
        }
        
        init();
        ps.close();
    }
    
    private static void init() throws IOException {
        int cases = getNextInt();
        for (int i = 0; i < cases; i++) {
            writeCase(String.valueOf(i + 1), String.valueOf(makeWork()));
        }
    }
    
    private static String makeWork() throws IOException {
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
        ps.println("Case #" + index + ": " + value);
        ps.flush();
    }
}