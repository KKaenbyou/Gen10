/***************************************************************************
 * File: Project3.cpp
 * Author: Kenneth Tjendra
 * Function: Bubblesort 2D Array
 * Open Source
 ***************************************************************************/

#include <cstdlib>
#include <iostream>
#include <string>
#include <fstream>

using namespace std;
const int COL(20);
int myArray[1][COL];

// This function reads the data from the inputed file and assigns it to 2D array myArray
void ReadData(int rows, int data, char filename[]){
  ifstream myfile;
  myfile.open(filename); 
  for(int j = 0; j < rows; j++){
    for(int i = 0; i < 20; i++) {
      myfile >> myArray[j][i];
    }
  }
  myfile.close();
}

// This function prints out the 2D array myArray
void PrintData(int rows, int data, char filename[]){
  ReadData(rows, data, filename);
  for(int n = 0; n < rows; n++){
    for(int i = 0; i < 20; i++){
    cout << myArray[n][i] << " ";
    }
    cout << endl;
  }
  cout << endl;
}

// This function bubblesorts the 2D array myArray by breaking it up into a 1D array
// and then bubble sorting it normally.
void SortData(int rows, int data){
  int number = rows*data;
  int count = 1;
  
  int tempArray[number], swap;
  for(int n = 0; n < rows; n++){
    for(int m = 0; m < data; m++){
      tempArray[count] = myArray[n][m]; 
      count++;
      }
  }

  for (int c = 0; c < number; c++){
    for (int d = 0; d < number-c; d++){
      if (tempArray[d] > tempArray[d+1]){
        swap       = tempArray[d];
        tempArray[d]   = tempArray[d+1];
        tempArray[d+1] = swap;
      }
    }
  }
  
  int count2 = 1;
  for(int n = 0; n < rows; n++){
    for(int m = 0; m < data; m++){
      myArray[n][m]= tempArray[count2];
      count2++;
    }
  }
  cout << "0 ";
  for(int n = 0; n < rows; n++){
    for(int k = 0; k < 20; k++){
      cout << myArray[n][k] << " ";
    }
    cout << endl;
  }
}

int main (int argc, char **argv){
  // Parses command line argument into number of rows
  // e.g. /a.out 20 = 20 rows
  int a(atoi(argv[1]));
  cout << "Number of rows entered in the command line: " << a << endl;
  char filename[a];
  cout << "Please enter the file name: ";
  cin >> filename;
  cout << "Before Sorting:" << endl; 
  PrintData(a, COL, filename);
  cout << "After Sorting:" << endl; 
  SortData(a, COL); 
  return 0;
}

