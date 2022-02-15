/* 
 * File:   intArray.cpp
 * Author: Kenneth Tjendra
 * 
 * Created on November 29, 2015, 9:53 PM
 */

#include "intArray.h"
#include <iostream>
#include <cstdlib>

int asize;
intArray::intArray() {
    asize = 0;
    array = 0;
}
intArray::intArray(int arraySize, int initValue) {
    int i = 0;
    asize = arraySize;
    array = new int[arraySize];
    while(i<arraySize){
            array[i] = initValue;
            i++;
    }
}
intArray::intArray(int anArray[], int arraySize){
    int i = 0;
    asize = arraySize;
    array = new int[arraySize];
    while(i<arraySize){
            array[i] = anArray[i];
            i++;
    }
}
int intArray::size() const{
    return asize;
}
void intArray::set(int index, int value){
    if(index >= asize || index < 0){
            exit(0);
    }
    array[index] = value;
}
int intArray::get(int index) const {
    if(index >= asize || index < 0){
            exit(0);
    }
    return array[index];
}
void intArray::copy(const intArray & anIntArray){
    int i = 0;
    if(size()==anIntArray.size()){
            while(i < size()){
                    array[i] = anIntArray.get(i);
                    i++;
            }
    } else {
            exit(0);
    }
}
bool intArray::equal(const intArray & anIntArray) const {
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
intArray intArray::add(const intArray & anIntArray) const {
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
intArray intArray::subtract(const intArray & anIntArray) const {
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
const intArray & intArray::operator+(const intArray & anIntArray) const {
     return add(anIntArray);
}
const intArray & intArray::operator-(const intArray & anIntArray) const {
     return subtract(anIntArray);
}
const intArray & intArray::operator=(const intArray & anIntArray){
     copy(anIntArray);
    return *this;
}
bool intArray::operator==(const intArray & anIntArray) const {
     return equal(anIntArray);
}
const intArray & intArray::operator++(){
    int i = 0;
    if (i == asize){
        i = 0;
    } else {
        ++i;
    }
    return *this;
}
const intArray & intArray::operator--() const {
    int i = 0;
    if (i == asize){
        i = 0;
    } else {
        --i;
    }
    return *this;
}
const intArray & intArray::operator+=(const intArray & anIntArray){
    return *this;
}
const intArray & intArray::operator-=(const intArray & anIntArray){
    return *this;
}
void intArray::insert(int index, int value){
int* placeholder;
placeholder = new int[size() + 1];
for(int i = 0; i < index; ++i){
        array[i] = placeholder[i];
}
for(int i = index; i < size(); ++i){
        placeholder[i+1] = array[i];
}
placeholder[index] = value;
array = placeholder;
}
void intArray::remove(int index){
    int* placeholder;
placeholder = new int[size() - 1];
for(int i = 0; i < index; ++i){
        array[i] = placeholder[i];
}
    for(int i = index; i < size(); ++i){
            placeholder[index] = array[i + 1];
}
array = placeholder;
}
intArray::intArray(const intArray & orig) {
}
intArray::~intArray() {
    delete[] array;
}