/* 
 * File:   intArray.h
 * Author: Kenneth Tjendra
 *
 * Created on November 4, 2015, 1:45 PM
 */

#ifndef INTARRAY_H
#define	INTARRAY_H

class intArray {
public:
    intArray();
    intArray(int arraySize, int initValue=0);
    intArray(int anArray[], int arraySize);
    intArray(const intArray& orig);
    int size() const;
    void set(int index, int value);
    int get(int index);
    virtual ~intArray();
    void copy(const intArray &anIntArray);
    bool equal(const intArray &anIntArray);
    intArray add(const intArray &anIntArray);
    intArray subtract(const intArray &anIntArray);
private:
    int* array,size;
};

#endif	/* INTARRAY_H */

