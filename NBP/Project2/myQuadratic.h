/* 
 * File:   myQuadratic.h
 * Author: Kenneth Tjendra
 */

#ifndef MYQUADRATIC_H
#define	MYQUADRATIC_H

class myQuadratic {
public:
    myQuadratic(); //Default
    myQuadratic(double a, double b, double c); //Alternate
    myQuadratic(const myQuadratic& orig); //Copy constructor
    virtual ~myQuadratic();
    
    void PrintCoefficients();
    void GetCoefficients();
    bool HasImaginary();
    void PrintSolution();
    void SolveSolutions();
    
    void SetC(double c);
    double GetC() const;
    void SetB(double b);
    double GetB() const;
    void SetA(double a);
    double GetA() const;
private:
    double a, b, c;
};

#endif	/* MYQUADRATIC_H */