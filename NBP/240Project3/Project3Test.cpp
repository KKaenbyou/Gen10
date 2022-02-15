#include <cstdlib>
#include <iostream>
#include <string>
#include <fstream>

using namespace std;
const int COL(20);
int myArray[1][COL];

void ReadData(int rows, int columns, char filename[]){
  ifstream myfile;
  myfile.open(filename);
  for(int j = 0; j < rows; j++){
    for(int i = 0; i < 20; ++i) {
      myfile >> myArray[j][i];
    }
  }
  myfile.close();
}

void PrintData(int rows, int columns, char filename[]){
  ReadData(rows, columns, filename);
  for(int n = 0; n < rows; ++n){
    for(int i = 0; i < 20; ++i){
    cout << myArray[n][i] << " ";
    }
    cout << endl;
  }
  cout << endl;
}

void SortData(int rows, int data){
  int number = (rows)*data;
  int count = 0;
 
  int tempArray[number], swap;
  for(int n = 0; n < rows; n++){
    for(int m = 0; m < data-1; m++){
      count++;
      tempArray[count] = myArray[n][m];
      }
  }

  for (int c = 0; c < (number-1); c++){
    for (int d = 0; d < number-c-1; d++){
      if (tempArray[d] > tempArray[d+1]){
        swap       = tempArray[d];
        tempArray[d]   = tempArray[d+1];
        tempArray[d+1] = swap;
      }
    }
  }
 
  int count2;
  for(int n = 0; n < rows; n++){
    for(int m = 0; m < data-1; m++){
    count2++;
    myArray[n][m]= tempArray[count2];
    }
  }

  for(int n = 0; n < rows; n++){
    for(int k = 0; k < 19; ++k){
      cout << myArray[n][k] << " ";
    }
    cout << endl;
  }
}

int main (int argc, char **argv){
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
