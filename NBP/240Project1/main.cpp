/* 
 * File:   main.cpp
 * Author: Kenneth Tjendra
 * Created on August 24, 2016, 12:55 PM
 */

#include <cstdlib>
#include <iostream>
using namespace std;

int main(int argc, char** argv) {
    string fn;
    string ln;
    string usc;
    int year;
    cout << "Please enter your first name: ";
    cin >> fn;
    cout << "Please enter your last name: ";
    cin >> ln;
    cout << "Please enter the number of years you have been at USC: ";
    cin >> year;
    if (year < 1) {
        usc = "freshman";
    }
    if (year>=1 & year<2){
        usc = "sophomore";
    }
    if (year>=2 & year<3){
        usc = "junior";
    }
    if (year>=3){
        usc = "senior";
    }
    cout << fn << " " << ln << " is a " << usc;
    return 0;
}