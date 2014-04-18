package me.marcpacheco;

import java.io.*;

public class CookieClicker {
    private static BufferedReader buf;
    private static PrintStream ps;
   
    
    public static void main (String[] args) throws IOException {
        buf = new BufferedReader(new InputStreamReader(System.in));
        ps = new PrintStream(System.out);
        
        File fileIn = new File("C:/Users/Marc/Desktop/B-large.in");
        File fileOut = new File("C:/Users/Marc/Desktop/cookie-clicker.out");
        
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
            writeCase(String.valueOf(i + 1), String.valueOf(cookiesTimeResult()));
        }
    }
    
    static double C = 0.0d;
    static double F = 0.0d;
    static double X = 2.0d;
    
    static double cookiesPerSecond = 2.0d;
    static double time = 0.0d;
    
    private static double cookiesTimeResult() throws IOException {
        String[] data = getNextString().split(" ");
        
        C = Double.parseDouble(data[0]);
        F = Double.parseDouble(data[1]);
        X = Double.parseDouble(data[2]);
            
        time = 0.0d;
        cookiesPerSecond = 2.0d;
       
        while(true) {

            double tFarm = farm();
            double tNoFarm = noFarm();
            
            if (tFarm < tNoFarm) {
                applyFarm();
            } else {
                time += tNoFarm;
                break;
            }
        }
                
        return time;
    }
    
    
    private static void applyFarm() {
        time += calculateCookiesTime(cookiesPerSecond, C);
        cookiesPerSecond += F;
    }
    
    private static double farm() {
        double time2 = 0.0d;
        time2 += calculateCookiesTime(cookiesPerSecond, C);
        time2 += calculateCookiesTime((cookiesPerSecond + F), X);

        return time2;
    }
    
    private static double noFarm() {
        return calculateCookiesTime(cookiesPerSecond, X);
    }
    
    private static double calculateCookiesTime(double rate, double cookies) {
        return cookies / rate;
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
