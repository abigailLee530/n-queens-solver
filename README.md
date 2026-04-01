# N-Queens Solver (Java)

## Overview
This project implements a solution to the **N-Queens problem** using a backtracking algorithm in Java.

The goal of the problem is to place **N queens on an N × N chessboard** such that no two queens threaten each other. This means:
- No two queens share the same row
- No two queens share the same column
- No two queens share the same diagonal

The program takes a user-defined board size and outputs a valid configuration.

---

## Features
- Uses **backtracking** to efficiently explore possible solutions  
- Validates queen placement using row and diagonal checks  
- Handles invalid user input gracefully  
- Prints a clear visual representation of the board  

---

## How It Works
The algorithm places queens **column by column**:
1. For each column, try placing a queen in every row  
2. Check if the position is safe  
3. If safe, place the queen and move to the next column  
4. If no valid position is found, **backtrack** and try a different placement  

---

## Key Concepts Demonstrated
- Recursion and backtracking  
- 2D array manipulation  
- Input validation and exception handling  
- Algorithmic problem solving  

---

## Possible Improvements
- Display **all possible solutions** instead of just one  
- Add a graphical user interface   

---

## Author
Abigail Lee
