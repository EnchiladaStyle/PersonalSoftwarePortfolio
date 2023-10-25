cmake_minimum_required(VERSION 3.26)
project(VisualGraph)

set(CMAKE_CXX_STANDARD 17)

add_executable(VisualGraph main.cpp
        Function.cpp
        Linear.cpp
        Quadratic.cpp
        Sin.cpp
        Tan.cpp
        AbsoluteValue.cpp
        Display.h
        Display.cpp)
