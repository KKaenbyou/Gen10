/* 
 * File:   myQuadratic.cpp
 * Author: Kenneth Tjendra
 */

#include "myQuadratic.h"
#include <iostream>

using namespace std;

myQuadratic::myQuadratic() {
    cout << "I am in the default constructor" << endl;
    SetA(0);
    SetB(0);
    SetC(0);
}

myQuadratic::myQuadratic(double _a, double _b, double _c){
    cout << "I am in the alternate constructor" << endl;
    SetA(_a);
    SetB(_b);
    SetC(_c);
}

myQuadratic::myQuadratic(const myQuadratic& orig) {
}

myQuadratic::~myQuadratic() {
}

void myQuadratic::SetC(double _c) {
    c = _c;
}

double myQuadratic::GetC() const {
    return c;
}

void myQuadratic::SetB(double _b) {
    b = _b;
}

double myQuadratic::GetB() const {
    return b;
}

void myQuadratic::SetA(double _a) {
    a = _a;
}

double myQuadratic::GetA() const {
    return a;
}
void myQuadratic::PrintCoefficients() {
    cout << GetA() << ", ";
    cout << GetB() << ", ";
    cout << GetC() << endl;
}