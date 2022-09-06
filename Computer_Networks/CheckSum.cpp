#include <iostream>
#include <string>
using namespace std;

string addBinary(string A, string B)
{
    // If the length of string A is greater than the length
    // of B then just swap the string by calling the
    // same function
    if (A.length() > B.length()) {
        return addBinary(B, A);
    }
        
 
    // Calculating the difference between the length of the
    // two strings.
    int diff = B.length() - A.length();
 
    // Append leading zeroes if needed
    if (diff) {
        A = string(diff,'0') + A;
    }

    string res;
    char carry = '0';
 
    for (int i = A.length() - 1; i >= 0; i--) {
        // This if condition solves 110 111 possible cases
        if (A[i] == '1' && B[i] == '1') {
            if (carry == '1') {
                res = "1" + res;
                carry = '1';
            }
            else {
                res = "1" + res;
                carry = '1';
            }       
        }
        // This if condition solves 000 001 possible cases
        else if (A[i] == '0' && B[i] == '0') {
            if (carry == '1') {
                res = "1" + res;
                carry = '0';
            }
            else {
                res = "0" + res;
                carry = '0';
            }
        }
        // This if condition solves 100 101 010 011 possible
        // cases
        else if (A[i] != B[i]) {
            if (carry == '1') {
                res = "0" + res;
                carry = '1';
            }
            else {
                res = "1" + res;
                carry = '0';
            }
        }
    }
 
    // If at the end their is carry then just add it to the
    // result
    if (carry == '1')
        addBinary(res,"1");
 
    // To remove leading zeroes
    int index = 0;
    while (index + 1 < res.length() && res[index] == '0')
        index++;
    return (res.substr(index));
}

string checkSumGenerator(string dataword, int csLength) {
    //Function to generate codeword using Checksum method.
    //It takes two arguments dataword - from user input and csLength - length of Checksum.

    //Step 1 - Decompose dataword into group of n bits, where n is length of checkSum.
    int extraBits = dataword.length() % csLength;
    if (extraBits != 0) {
        dataword = string(extraBits,'0') + dataword;
    };
    //Store the groups in an array
    int grpCount = dataword.length() / csLength;
    int group[grpCount];
    for (int i = 0; i < grpCount; i++) {
        group[i] = dataword.substr()
    }

    //Step 2 - Perform binary addition for each group
    string sum = group[0];
    for (int i = 1; i < grpCount-1; i++) {
        sum = addBinary(group[i],group[i+1]);
    }

}