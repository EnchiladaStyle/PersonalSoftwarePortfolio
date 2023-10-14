

#ifndef VISUALGRAPH_TAN_H
#define VISUALGRAPH_TAN_H

#include <iostream>
#include <iostream>
#include "Linear.h"
#include <stdlib.h>
#include <math.h>
#include <cmath>
#include "Function.h"

class Tan : public Function
{
public:
    static float a;
    static float b;
    static float d;
    static float c;
    void getInput();

    void equation();
};

#endif // VISUALGRAPH_TAN_H
