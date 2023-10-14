#include <iostream>
#include "Linear.h"
#include <stdlib.h>
#include "Function.h"
#include "Quadratic.h"
#include "Sin.h"
#include "Tan.h"
#include "AbsoluteValue.h"
#include "Display.h"
using namespace std;

int main()
{

    int choice = 0;
    system("clear");
    cout << "Welcome to the Visual Graphing Calculator." << endl;
    cout << "Please pick a function to graph" << endl;
    cout << "1 Linear\n2 Quadratic\n3 Absolute Value\n4 Sin\n5 Tangent" << endl;
    cout << "Enter the number of your function here: ";
    cin >> choice;

    Display display1;
    Linear *line = new Linear;
    Quadratic quad;
    AbsoluteValue abs;
    Sin sin;
    Tan tan;

    if (choice == 1)
    {
        line->Function::SetVars();
        line->Linear::getInput();
        line->Linear::equation();
        display1.RenderXY();
        display1.RenderGraph(line->xValuespos, line->yValuespos, line->xValuesneg, line->yValuesneg);
        display1.Show();
    }

    if (choice == 2)
    {
        quad.SetVars();
        quad.getInput();
        quad.equation();
        display1.RenderXY();
        display1.RenderGraph(quad.xValuespos, quad.yValuespos, quad.xValuesneg, quad.yValuesneg);
        display1.Show();
    }
    else if (choice == 3)
    {
        abs.SetVars();
        abs.getInput();
        abs.equation();
        display1.RenderXY();
        display1.RenderGraph(abs.xValuespos, abs.yValuespos, abs.xValuesneg, abs.yValuesneg);
        display1.Show();
    }
    else if (choice == 4)
    {
        sin.SetVars();
        sin.getInput();
        sin.equation();
        display1.RenderXY();
        display1.RenderGraph(sin.xValuespos, sin.yValuespos, sin.xValuesneg, sin.yValuesneg);
        display1.Show();
    }
    else if (choice == 5)
    {
        tan.SetVars();
        tan.getInput();
        tan.equation();
        display1.RenderXY();
        display1.RenderGraph(tan.xValuespos, tan.yValuespos, tan.xValuesneg, tan.yValuesneg);
        display1.Show();
    }

    return 0;
}
