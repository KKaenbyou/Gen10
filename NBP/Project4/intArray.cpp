/* 
 * File:   intArray.cpp
 * Author: Kenneth Tjendra
 * 
 * Created on November 4, 2015, 1:45 PM
 */

#include "intArray.h"

intArray::intArray() {
    size = 0;
    array = 0;
}
intArray::intArray(int arraySize, int initValue) {
    int i = 0;
    size = arraySize;
    array = new int[arraySize];
    while(i<arraySize){
        array[i] = initValue;
        i++;
    }
}
intArray::intArray(int anArray[], int arraySize){
    int i = 0;
    size = arraySize;
    array = new int[arraySize];
    while(i<arraySize){
        array[i] = anArray[i];
        i++;
    }
}
int intArray::size() const{
    return size;
}
void intArray::set(int index, int value){
    if(index >= size || index < 0){
        exit(0);
    }
    array[index] = value;
}
int intArray::get(int index){
    if(index >= size || index < 0){
        exit(0);
    }
    return array[index];
}
void intArray::copy(intArray anIntArray){
    int i = 0;
    if(size()==anIntArray.size()){
        while(i < size()){
            array[i] = anIntArray[i];
            i++;
        }
    } else {
        exit(0);
    }
}
bool intArray::equal(intArray anIntArray){
    if(size()==anIntArray.size()){
    for(int i=0; i<size(); ++i){
        if(array[i] != anIntArray.get(i)) {
            return false;
            }
        return true;
        }
    }
    return false;
}
intArray intArray::add(intArray anIntArray){
    intArray placeholder = intArray(size());
    if(size()==anIntArray.size()){
        for (int i=0; i < size() ; ++i) {
             placeholder.set(i, array[i] + anIntArray.get(i));
         }
    return placeholder;
        } else {
        exit(0);
    }
}
intArray intArray::subtract(intArray anIntArray){
    intArray placeholder = intArray(size());
    if(size()==anIntArray.size()){
        for (int i=0; i < size() ; ++i) {
             placeholder.set(i, array[i] - anIntArray.get(i));
         }
    return placeholder;
        } else {
        exit(0);
    }
}
intArray::intArray(const intArray& orig) {
}
intArray::~intArray() {
    delete[] array;
}