
#ifndef VISUALGRAPH_SIN_H
#define VISUALGRAPH_SIN_H


#include <iostream>
#include <iostream>
#include "Linear.h"
#include <stdlib.h>
#include <math.h>
#include <cmath>
#include "Function.h"
#include "Quadratic.h"

class Sin : public Function
{
public:

    static float a;
    static float b;
    static float d;
    static float c;

    void getInput();


    void equation();

};

#endif //VISUALGRAPH_SIN_H
