//
// Created by user-1 on 10/1/23.
//

#ifndef VISUALGRAPH_QUADRATIC_H
#define VISUALGRAPH_QUADRATIC_H

#include <iostream>
#include <iostream>
#include "Linear.h"
#include <stdlib.h>
#include <math.h>
#include <cmath>
#include "Function.h"


class Quadratic : public Function
{
public:
    static double a;
    static double h;
    static double k;

    void getInput();
    void equation();

};


#endif //VISUALGRAPH_QUADRATIC_H
