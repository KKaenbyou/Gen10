/* 
 * File:   main.cpp
 * Author: Kenneth Tjendra
 *
 * Created on September 30, 2015, 3:22 PM
 */

#include <cstdlib>
#include <iostream>
#include "mySudoku.h"

using namespace std;

int main(int argc, char** argv) {
    mySudoku puzzle1;
    puzzle1.PrintPuzzle();
    cout << endl;
    puzzle1.ReadPuzzle();
    puzzle1.PrintPuzzle();
    cout << endl;
    cout << "Checking for number 7 in row 0: ";
    if (puzzle1.CheckRow(0,7)){
        cout << "True" << endl;
    } else {
        cout << "False" << endl;
    }
    cout << "Checking for number 1 in column 8: ";
    if (puzzle1.CheckCol(8,1)){
        cout << "True" << endl;
    } else {
        cout << "False" << endl;
    }
    puzzle1.printSubBox(3, 6);
    return 0;
}

