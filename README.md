# Polynomial
Rutgers CS112-Assignment 1
The main data structure for this project is Linked List.
Programing Language: JAVA
Background:
A polynomial may be represented using a linked list as follows: for every term in the polynomial there is one entry in the linked list consisting of the term's coefficient and degree. The entries are ordered according to ASCENDING values of degree, i.e. lowest degree term first, then next lowest degree term and so on, all the way up to the highest degree term. IMPORTANT: Zero-coefficient terms are NOT stored.

For example, the following polynomial (the symbol '^' is used to mean 'raised to the power'):

      4x^5 - 2x^3 + 2x +3
can be represented as the linked list of terms:
      (3,0) -> (2,1) -> (-2,3) -> (4,5)
where each term is a (coefficient,degree) pair.
In the assignment, I need to write 3 parts.
Part1. "Add" method:
I need to add two polynomials together.
The inputs are two Linked Lists, which contain the coefficient and degree we need.
I should output a Linked list contains the answer of the sum.
Part2. "Multiply" method:
Inputs are two linked lists.
The Output is the result after the multiplication.
Part3. "Evaluate" method:
The inputs are linked list and the value of x.
I need to return the result of the polynomial after evaluation.

More Details of the Project is in the Program_Description.pdf

