## Introduction

Imagine you are developing an application for the National Lottery, which is going to perform a series of complex calculations on a list of integer values in order to determine the winner.   

## Problem Statement

As you can see, the `findDuplicates` method is missing its implementation. It should return a list of values, that are repeated `numberOfDuplicates` times.

For instance, if you invoke:
```java
findDuplicates(asList(-1, 1, 3, 2, 2, 2, 5, 6, -1, 3, 6), 2);
```
it should return `-1, 3 and 6` since these values are repeated twice,
but not `2` which is repeated three times. 

Note: null values should be omitted.

## Hints

1. Please pay attention to correctness but also to the quality of your solution.
2. The `findDuplicates` method should not return a `null` value (if null is produces, return empty list).
