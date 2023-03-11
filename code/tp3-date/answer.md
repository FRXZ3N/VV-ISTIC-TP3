## Question 1
### isValidDate

| Characteristic | Block 1   | Block 2                      | Block 3                     | Block 4            | Block 5 |
|----------------|-----------|------------------------------|-----------------------------|--------------------|---------|
| Value of year  | leap year | not leap year                |                             |                    |         |
| Value of month | < 1       | {1, 3, 5, 7, 8, 10, 12}      | {4, 6, 9, 11}               | 2                  | (>12)    |
| Value of day   | < 1       | (>= 1) && <= max(month, year)| (> max(month, year))        |

### isLeapYear

| Characteristic | Block 1                                           |Block 2                                              |Block 3                          |Block 4       |
|----------------|---------------------------------------------------|-----------------------------------------------------|---------------------------------|--------------|
|Value of year   | year %4 == 0 and year % 100 == 0 or year % 400 == 0| year%4 == 0 and year % 100 == 0 and year % 400 !=0 |year % 4 == 0 and year % 100 != 0|year % 4 != 0 |


Next blocks for other methods have the same enter value but in Date object

## Question 2

for this step we had 95% of coverage, to have 100% we had tests for some methods and delete some methods, like getters because they were used only to check the value of the attributes of the object.

## Question 3

for predicate with more than 2 boolean expressions, we check the all boolean expressions and their negation, when it is relevant.

## Question 4

We had 90% mutation coverage, because we had some mutations like negative value, or change operator, in isValidDate and compareTo methods survived.
So we had to somme tests and refactor some methods to have 100% mutation coverage.
