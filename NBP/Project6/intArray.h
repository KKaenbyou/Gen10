/* 
 * File:   intArray.h
 * Author: Kenneth Tjendra
 *
 * Created on November 29, 2015, 9:53 PM
 */

#ifndef INTARRAY_H
#define INTARRAY_H
#include <iostream>
using namespace std;

class intArray {
public:
    intArray();
    intArray(int arraySize, int initValue=0);
    intArray(int anArray[], int arraySize);
    intArray(const intArray& orig);
    int size() const;
    void set(int index, int value);
    int get(int index) const;
    virtual ~intArray();
    void copy(const intArray & anIntArray);
    bool equal(const intArray & anIntArray) const;
    intArray add(const intArray & anIntArray) const;
    intArray subtract(const intArray & anIntArray) const;
    void insert(int index, int value);
    void remove(int index);

    void Print(void) const;
    const intArray & operator=(const intArray & anIntArray);
    const intArray & operator+(const intArray & anIntArray) const;
    const intArray & operator-(const intArray & anIntArray) const;
    const intArray & operator+=(const intArray & rhs);
    const intArray & operator-=(const intArray & rhs);
    
    const intArray & operator++();
    const intArray & operator--() const;
    
    bool operator==(const intArray & anIntArray) const;
    int operator[](int index) const; // Equivalent to get
    int & operator[](int index); // Equivalent to set
    
    friend ostream & operator<<(ostream & outStream, intArray & anIntArray);
    friend istream & operator>>(istream & inStream, intArray & anIntArray);
private:
    int* array;
    int asize;
};

#endif    /* INTARRAY_H */