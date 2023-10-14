//
// Created by user-1 on 10/1/23.
//

#ifndef VISUALGRAPH_LINEAR_H
#define VISUALGRAPH_LINEAR_H


#include <iostream>
#include <iostream>
#include "Linear.h"
#include <stdlib.h>
#include <math.h>
#include <cmath>
#include "Function.h"
using namespace std;


class Linear : public Function
{
public:
    static double m;
    static double b;
    static double f;

    void getInput();
    void equation();

};




#endif //VISUALGRAPH_LINEAR_H

