/* 
 * File:   main.cpp
 * Author: Kenneth Tjendra
 */

#include <cstdlib>
#include <iostream>
#include <cmath>

using namespace std;

int main(int argc, char** argv) {
    
    char userInput = 'z';
    cout << "Enter q to quit, or s to solve a new problem." << endl;
        
    while(userInput != 's' || 'q') {
        cin >> userInput;
        if (userInput == 'q') {
            exit(0);
        }
        if (userInput == 's') {
            break;
        }
        cout << "Please enter only q or s." << endl;
    }
    
    // settings the variables
    cout << "Enter coefficients a, b and c: " << endl;
    double a;
    double b;
    double c;
    double x1;
    double x2;
    double r;
    double i;
    
    cin >>  a >> b >> c;
    
    // math starts here, d = determinant
    int d = b*b - 4*a*c;
    if (d > 0) {
        // real roots
        x1 = (-b + sqrt(d)) / (2*a);
        x2 = (-b - sqrt(d)) / (2*a);
        cout << "x1 = " << x1 << endl;
        cout << "x2 = " << x2 << endl;
    } else if (d == 0) {
        // real roots, both the same
        x1 = (-b + sqrt(d)) / (2*a);
        cout << "x1 = " << x1 << endl;
        cout << "x2 = " << x1 << endl;
    } else {
        // complex/imaginary roots
        r = -b/(2*a);
        i =sqrt(-d)/(2*a);
        cout << "x1 = " << r << "+" << i << "i" << endl;
        cout << "x2 = " << r << "-" << i << "i" << endl;
    }
    return 0;
}