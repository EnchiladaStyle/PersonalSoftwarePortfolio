
#include "Display.h"

const int Display::frameLimit = 800;
int Display::tickMarklen;
int Display::tickMarkDis = 0;
int Display::lineLen = 1;
SDL_Window *window = nullptr;
SDL_Renderer *renderer = nullptr;

Display::Display()
{

    SDL_Init(SDL_INIT_VIDEO);
    SDL_CreateWindowAndRenderer(Display::frameLimit, Display::frameLimit, 0, &window, &renderer);

    SDL_SetRenderDrawColor(renderer, 0, 0, 0, 255);
    SDL_RenderClear(renderer);

    SDL_SetRenderDrawColor(renderer, 255, 255, 255, 255);
}

void Display::RenderXY()
{
    SDL_SetRenderDrawColor(renderer, 0, 0, 0, 255);
    SDL_RenderClear(renderer);

    SDL_SetRenderDrawColor(renderer, 255, 255, 255, 255);

    // This makes the x,y graph
    while (Display::lineLen < Display::frameLimit)
    {
        Display::tickMarklen = 5;

        SDL_RenderDrawPoint(renderer, Display::lineLen, Display::frameLimit / 2);
        SDL_RenderDrawPoint(renderer, Display::frameLimit / 2, Display::lineLen);

        if (Display::tickMarkDis == 10)
        {

            while (Display::tickMarklen > 0)
            {
                SDL_RenderDrawPoint(renderer, Display::frameLimit / 2 + Display::tickMarklen - 3, Display::lineLen);
                SDL_RenderDrawPoint(renderer, Display::lineLen, Display::frameLimit / 2 + Display::tickMarklen - 3);
                Display::tickMarklen--;
            }
            Display::tickMarkDis = 0;
        }

        Display::tickMarkDis++;
        Display::lineLen++;
    } // end of the x, y graph
}

void Display::RenderGraph(int xValuespos[], int yValuespos[], int xValuesneg[], int yValuesneg[])
{
    // this makes the function
    for (int i = 0; i < 400; i++)
    {
        int k = 1;
        for (int j = 0; j < 5; j++)
        {

            SDL_RenderDrawPoint(renderer, xValuespos[i] - j + 2, yValuespos[i] - j + 2);
            SDL_RenderDrawPoint(renderer, xValuesneg[i] - j + 2, yValuesneg[i] - j + 2);
            SDL_RenderDrawPoint(renderer, xValuespos[i] - k, yValuespos[i] + k + 2);
            SDL_RenderDrawPoint(renderer, xValuesneg[i] - k, yValuesneg[i] + k + 2);
            k++;
        }
    }
}
void Display::Show()
{
    SDL_RenderPresent(renderer);

    bool windowRunning = true;
    while (windowRunning)
    {

        SDL_Event event;

        while (SDL_PollEvent(&event))
        {
            if (event.type == SDL_QUIT)
            {
                windowRunning = false;
            }
        }
    }
}
