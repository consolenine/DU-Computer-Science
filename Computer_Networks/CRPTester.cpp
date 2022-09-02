#include <iostream>
#include <string>
#include <cmath>
using namespace std;

class Polynomial {
    private:
        int *arr;
    public:
        int degree;
        Polynomial() {
            cout << "Enter highest degree of polynomial: ";
            cin >> degree;

            arr = new int[degree];

            for (int i = degree; i >= 0; i--) {
                int coeff;
                cout << "Enter coefficient for x^" << i << " : ";
                cin >> arr[i];
            }
        }
        string getBinaryStream() {
            string bs = "";
            for (int i = degree; i >= 0; i--) {
                if (arr[i] != 0) bs += "1";
                else bs += "0";
            }
            return bs;
        }
};

string XOR(string x, string y) {
    string out = "";
    for (int i = 0; i < x.length(); i++) out += (x[i] == y[i]) ? "0" : "1";
    return out;
}

string binaryDiv(string divisor, string dividend) {
    int bitSize = divisor.length();
    int bit = divisor.length();
    int n = dividend.length();

    string rem = dividend.substr(0,bit);

    while (bit < n) {
        if (rem[0] == '1') {
            rem = XOR(divisor, rem) + dividend[bit];
        }
        else {
            rem = XOR(string(bitSize, '0'), rem) + dividend[bit];
        }
        bit += 1;
    };

    if (rem[0] == '1') {
        rem = XOR(divisor, rem);
    }
    else {
        rem = XOR(string(bitSize, '0'), rem);
    };

    return rem;
}

string CRCEncoder(string dataword, Polynomial p) {
    //Step 1 - Generate Binary stream from polynomial
    string bs = p.getBinaryStream();

    //Step 2 - Append n zeroes at LSB to data word, where n is highest degree of polynomial
    string d = dataword + string(p.degree, '0');

    //Step 3 - Perform binary division to obtain CRC bits.
    string CRC = binaryDiv(bs, d);

    //Step 4 - Append CRC bits at LSB within dataword and return dataword as codeword.
    return dataword + CRC;
}

bool CRCChecker(string codeword, Polynomial p) {
    string rem = binaryDiv(p.getBinaryStream(), codeword);
    for (int i = 0; i < rem.length(); i++) {
        if (rem[i] != '0') return false;
    }
    return true;
}

int main() {
    string s;
    cout << "Enter dataword: ";
    cin >> s;

    Polynomial p;
    string codeword = CRCEncoder(s, p);

    bool result = CRCChecker(codeword, p);

    if (result) cout << "Data is good.\n";
    else cout << "Corrupted Data found\n";
}
