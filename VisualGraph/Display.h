
#ifndef VISUALGRAPH_DISPLAY_H
#define VISUALGRAPH_DISPLAY_H

#include <iostream>
#include "Linear.h"
#include "/../Users/user-1/Desktop/SDL2stuff/SDL2.framework/Headers/SDL.h"
#include <stdlib.h>
#include <math.h>
#include <cmath>

class Display
{
public:
    static const int frameLimit;
    static int tickMarklen;
    static int tickMarkDis;
    static int lineLen;

    Display();

    void RenderXY();

    void RenderGraph(int xValuespos[], int yValuespos[], int xValuesneg[], int yValuesneg[]);

    void Show();
};

#endif // VISUALGRAPH_DISPLAY_H
