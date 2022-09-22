package org.mehmetakgul.NumberSystem;

import java.util.HashMap;
import java.util.Map;

public class ConvertABinaryNumberToHexadecimalNumber {
    /**
     * Difficulty level: Medium
     * we all know that , 2^4 =16^1
     * in other words, single digit in base 16 can be represented using 4 digit in base 2.
     * <p>
     * <p>
     * To convert Binary number to HexaDecimal, the below steps are taken:
     * <p>
     * 1) Group the given Binary Number into groups of 4 bits,
     * each group taken individually from the left and right of the decimal point.
     * 2) Get length of substring to the left and right of the decimal point(‘.’)
     * as left_len and right_len.
     * 3) If left_len is not a multiple of 4, i.e.,
     * grouping into exact group of 4 bits is not possible,
     * then add minimum number of 0’s in the beginning to make length of left substring a multiple of 4.
     * 4) Similarly, If right_len is not a multiple of 4,
     * then add minimum number of 0’s in the end to make length of right substring a multiple of 4.
     * 5) Now, from the left, extract each group (substrings of length 4) one by one and
     * add its corresponding Hexadecimal code to the result.
     * 6) If in between a decimal(‘.’) is encountered then add it to the result.
     */
// Function to create map between binary
// number and its equivalent hexadecimal
    static void createMap(Map<String, Character> um) {
        um.put("0000", '0');
        um.put("0001", '1');
        um.put("0010", '2');
        um.put("0011", '3');
        um.put("0100", '4');
        um.put("0101", '5');
        um.put("0110", '6');
        um.put("0111", '7');
        um.put("1000", '8');
        um.put("1001", '9');
        um.put("1010", 'A');
        um.put("1011", 'B');
        um.put("1100", 'C');
        um.put("1101", 'D');
        um.put("1110", 'E');
        um.put("1111", 'F');

    }

    static String convertBinToHex(String bin) {
        int l = bin.length();
        int t = bin.indexOf('.'); // decimal point location

        // length of string before '.' eğer t =-1 ise hiç ondalık kısım yoktur
        int len_left = t != -1 ? t : l;


        /**
         * burda soldaki sayıyı 4 bölüp kalanı 4 den çıkarıp tekrar 4 bölüyor
         * böylece 4'lü grup oluşturmak için eksik eleman sayısını buluyor.
         */
        for (int i = 1;
             i <= (4 - len_left % 4) % 4;
             i++)
            bin = '0' + bin;

        // if decimal point exists ozaman sağ tarafıda vardır.
        if (t != -1) {
            int len_right = l - len_left - 1;
            for (int i = 1;
                 i <= (4 - len_right % 4) % 4;
                 i++)
                bin = bin + '0';
        }

        // Create map between binary and its equivalent hex code
        Map<String, Character> bin_hex_map = new HashMap<String, Character>();
        createMap(bin_hex_map);
        int i = 0;
        String hex = "";
        while (true) {
            // One by one extract from left, substring of size 4 and add its hex code
            hex += bin_hex_map.get(bin.substring(i, i + 4));
            i += 4;
            if (i == bin.length()) break;
            if (bin.charAt(i) == '.') {
                hex += '.';
                i++;
            }
        }
        return hex;
    }

    public static void main(String[] args) {
        String bin = "1111001010010100001.010110110011011";

        System.out.println("HexaDecimal Number = "+convertBinToHex(bin));
    }
}
