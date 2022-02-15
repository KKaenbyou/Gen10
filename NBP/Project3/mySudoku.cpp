/* 
 * File:   mySudoku.cpp
 * Author: Kenneth Tjendra
 * 
 * Created on September 30, 2015, 3:06 PM
 */

#include <iostream>
#include "mySudoku.h"

using namespace std;

mySudoku::mySudoku() {
    for(int row = 0; row < Size; row++) {
        for(int col = 0; col < Size; col++){
            Data[row][col] = 0;
        }
    }
}

mySudoku::mySudoku(int anArray[][Size]) {
}

mySudoku::mySudoku(const mySudoku& orig) {
}

mySudoku::~mySudoku() {
}

void mySudoku::ReadPuzzle() {
     for(int row = 0; row < Size; row++) {
        for(int col = 0; col < Size; col++){
            cin >> Data[row][col];
        }
    }
}
void mySudoku::PrintPuzzle() {
    for(int row = 0; row < Size; row++) {
        for(int col = 0; col < Size; col++){
            cout << Data[row][col] << " ";
        }
        cout << endl;
    }
}
bool mySudoku::CheckRow(int row, int number) {
        for (int col = 0; col < Size; col++) {
            if (number == Data [row][col]){
                return true;
            }
         }
        return false;
}
bool mySudoku::CheckCol(int col, int number) {
         for (int row = 0; row < Size; row++) {
                 if (number == Data[row][col]){
                     return true;
                  }
         }
         return false;
}
bool mySudoku::CheckSubBox(int row, int col, int number){
    int rowStart = (row - (row%3)), colStart = (col - (col%3)), rowEnd = (row - (row%3)) + 3, colEnd = (col - (col%3)) + 3;
    for (row = rowStart; row < rowEnd; row++){
        for (col = colStart; col < colEnd; col++){
            if (Data[row][col] == number) {
                return true;
            }
        }
    }
    return false;
}
void mySudoku::printSubBox(int row, int col){
    int rowStart = (row - (row%3)), colStart = (col - (col%3)), rowEnd = (row - (row%3)) + 3, colEnd = (col - (col%3)) + 3;
    for (row = rowStart; row < rowEnd; row++){
        for (col = colStart; col < colEnd; col++){
            cout << Data[row][col] << " ";    
        }
        cout << endl;
    }
}
bool mySudoku::checkZero(){
    for (int row = 0;  row < Size; row++) {
        for (int col = 0;  col < Size; col++) {
            if(Data[row][col] == 0) {
                return true;
            }
        }
    }
    return false;
}
int  SolvePuzzle(int iterations){
    bool checkZero = checkZero();
    cout <<  checkZero();
    /*while(true){ // a function that returns true or false depending on zero
        for(){ 
            for(){
                if(){
                    while(){
                        if(){
                            if(){
                                
                            }
                        }
                    }
                }
            }
        }
     checkZero = checkZero();
    }*/
    return iterations;
}