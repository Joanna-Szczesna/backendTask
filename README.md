# BACKEND TASKS

## TASK1

Task: 
The input is a long list of integers. Please write a small app that will output the list of distinct elements sorted in ascending order, plus the basic measurement information that contains the number of elements in the source, number of distinct elements, min and max value.

Sample:

For the input:

1 10 20 20 2 5

expected output is:

1 2 5 10 20
count: 6
distinct: 5
min: 1
max: 20


### requirements:

when input list contains olny one element - element is max and min in one time
when input list is empty output look like:

count: 0
distinct: 0 
min: 
max: 

when input list is null - behaviour like empty list
when input list cointains null values - count in input size, filter in next steps

### bonus:
unit tests 


## TASK2

Again, the input is a long list of integers. Provide a working code that will find all the pairs (in this integer list) that sum up to 13. Each pair in the output should have first number not greater than the second one and lines should be sorted in an ascending order.

Sample:

For the input:

1 2 10 7 5 3 6 6 13 0

expected output is:

0 13
3 10
6 7
6 7

### requirements:

one integer can be use to several pairs
sum must be exact 13
negative integers allowed
if empty list / null list / no pair found return "no pairs"

### bonus:
unit tests 

## TASK3

The first line of input contains a positive number n, next n lines contains pairs of positive integers, where each pair identifies a connection between two vertices in a graph. Please provide a working code that will give us the answer for the following questions: how many separated graphs are in the input.

Sample:

For the input:

3
4 3
1 4
5 6
expected output is:

2

### requirements:


### bonus:
TXT file as input :>