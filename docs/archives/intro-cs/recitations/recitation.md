# Recitations

## Week 2

```
Beginner Algorithm:

READ num1
READ num2

SET count to 0
SET result to 0

WHILE count < num2
	COMPUTE result AS num1 + result
	COMPUTE count AS count + 1
ENDWHILE

DISPLAY result


Mod Algo:

SET count AS 1
WHILE count <= 100
	IF count%15 == 0 THEN
		DISPLAY Fizzbuzz
	ELIF count%5 == 0 THEN
		DISPLAY Buzz
	ELIF count%3 == 0 THEN
		DISPLAY Fizz
	ELSE
		DISPLAY count
	ENDIF
	ADD 1 to count
ENDWHILE
```

Beginner Algorithm:
```
READ num1
READ num2

SET count to 0
SET result to 0

```
Fizz Buzz thingy

```

WHILE count < num2
        COMPUTE result AS num1 + result
        COMPUTE count AS count + 1
ENDWHILE

DISPLAY result


Mod Algo:

SET count AS 1
WHILE count <= 100
        IF count%15 == 0 THEN
                DISPLAY Fizzbuzz
        ELIF count%5 == 0 THEN
                DISPLAY Buzz
        ELIF count%3 == 0 THEN
                DISPLAY Fizz
        ELSE
                DISPLAY count
        ENDIF
        ADD 1 to count
ENDWHILE


```

## Week 4

Is the following true?


1. Does 1/7 == 1.0/7.0? <br>
No, 1/7 evaluates to 0 because of integer division.
2. Does 'a' + 'b' == "ab"? <br>
No, this evaluates to a number.
3. Does 15 % 10 == 10 % 15? <br>
No, 5 does not equal 10.
4. Does 4/2 == 4.0/2.0? <br>
Yes, same number, the **int** will be promoted to a **double**.
5. Does "2" + 2 == "22"? <br>
Yes, string concat. But no, because we don't usually use equal signs to compare strings. We use .equals()

Booleans 

Simplify

1. (!a &&b) || (a || !b)

Everything is true

2. (a || b) || (!a && !b) || !(a && !b)

Everything is true

Challenge:

(a || c) || ((a && d) ||(a && !d))|| (a && c) || c

Simplified: a || c


