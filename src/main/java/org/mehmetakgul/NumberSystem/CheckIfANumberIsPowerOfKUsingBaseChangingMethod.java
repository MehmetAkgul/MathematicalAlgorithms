package org.mehmetakgul.NumberSystem;

public class CheckIfANumberIsPowerOfKUsingBaseChangingMethod {
    // this program checks whatever a number n can be expressed
    // as power of k and is yes , then to what power should k
    // be raised to make it n. Following example will clarify:
    // Example
    // Input :   n = 16, k = 2
    //Output :  yes : 4
    //Explanation : Answer is yes because 16 can
    //be expressed as power of 2.
    //
    //Input :   n = 27, k = 3
    //Output :  yes : 3
    //Explanation : Answer is yes as 27 can be
    //expressed as power of 3.
    //
    //Input :  n = 20, k = 5
    //Output : No
    //Explanation : Answer is No as 20 cannot
    //be expressed as power of 5.

    static boolean isPowerOfK(int n, int k) {
        boolean oneSeen = false;
        while (n > 0) {
            int digit = n % k;
            if (digit > 1)
                return false;

            if (digit == 1) {
                if (oneSeen)
                    return false;
                oneSeen = true;
            }
            n /= k;
        }
        return true;
    }

    // Driver code
    public static void main(String[] args) {
        int n = 64, k = 4;

        if (isPowerOfK(n, k))
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}

// This code is contributed by Anant Agarwal.

