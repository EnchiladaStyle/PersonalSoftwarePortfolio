#include "Function.h"

const int Function::domainLimit = 400;
const int Function::rangeLimit = 400;
const int Function::center = 400;
int Function::rangepos[400] = {};
int Function::rangeneg[400] = {};
int Function::xValuespos[400] = {};
int Function::xValuesneg[400] = {};
int Function::yValuespos[400] = {};
int Function::yValuesneg[400] = {};

void Function::SetVars()
{


    for (int i = 0; i < domainLimit; i++)
    {
        rangepos[i] = i;
        rangeneg[i] = 0 - i;
        xValuespos[i] = i + center;
        xValuesneg[i] = center - i;
    }
}


