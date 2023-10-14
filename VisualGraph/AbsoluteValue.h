
#ifndef VISUALGRAPH_ABSOLUTEVALUE_H
#define VISUALGRAPH_ABSOLUTEVALUE_H


#include <iostream>
#include <iostream>
#include "Linear.h"
#include <stdlib.h>
#include <math.h>
#include <cmath>
#include "Function.h"
#include "Quadratic.h"
#include "Sin.h"
#include "Tan.h"

class AbsoluteValue : public Function
{
public:
    static double a;
    static double b;
    static double h;
    static double k;

    void getInput();

    void equation();

};

#endif //VISUALGRAPH_ABSOLUTEVALUE_H
