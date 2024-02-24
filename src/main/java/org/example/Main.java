package org.example;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {


    public static void main(String[] args) throws IOException {

//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("OUTPUT_FILE_PATH")));
//        bufferedWriter.write("\n");
//        bufferedWriter.close();
//        bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("OUTPUT_FILE_PATH"),true));
//        String S = bufferedReader.readLine();
//
//        int outPut = Main.solve(S);
//
//        bufferedWriter.write(outPut + "\n");
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();

        //String str ="20";
        //stringOperations(str);

        Map<String , String > hexa = new HashMap<>();
        hexa.put("Car", "Benz");
        hexa.put("Flight", "AirIndia");

        System.out.println("Trying to print a map"+hexa);

        List<String> hexaList = new ArrayList<>();

        hexaList.add("Moon");
        hexaList.add("Sun");
        System.out.println("Trying to print a list"+hexaList);
        //System.out.println("Length of the Substring is : "+solve(str));
    }

    private static void stringOperations(String str) {
        if(str.length()>0){
            System.out.println("String length : "+str.length());
            Character tmp = str.charAt(str.length() - 1);

            System.out.println("Char at end of string : "+tmp);
            System.out.println("Checking if its Alphabet : "+Character.isAlphabetic(tmp));
            System.out.println("Checking if its Alphabet : "+Character.isDigit(tmp));
            System.out.println("Char converted to String : "+tmp.toString().toUpperCase());
        }

    }

    private static int solve(String str) {
        System.out.println("*****");
        //int n = str.length();
        int maxlen = 0;
        //choose starting point of every substring
        for(int i = 0; i < str.length(); i++)
        {
            //choose ending point of even length substring
            for(int j = i+1; j < str.length(); j += 2)
            {
                //find length of current substr
                int length = j - i + 1;
                //Calculate left & right sums for current substr
                int leftsum = 0, rightsum = 0;
                for(int k = 0; k < length/2; k++)
                {
                    leftsum += (str.charAt(i + k) - '0');
                    rightsum += (str.charAt(i + k + length/2) - '0');
                }
                // Update result if needed
                if (leftsum == rightsum && maxlen < length)
                    maxlen = length;
            }
        }

        return maxlen;
    }
}