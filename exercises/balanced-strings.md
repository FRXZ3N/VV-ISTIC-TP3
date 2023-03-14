# Balanced strings

A string containing grouping symbols `{}[]()` is said to be balanced if every open symbol `{[(` has a matching closed symbol `]}` and the substrings before, after and between each pair of symbols is also balanced. The empty string is considered as balanced.

For example: `{[][]}({})` is balanced, while `][`, `([)]`, `{`, `{(}{}` are not.

Implement the following method:

```java
public static boolean isBalanced(String str) {
		Deque<Character> stack = new ArrayDeque<>();
		boolean result = true;
		for(int i=0; i<str.length(); i++) {
		switch (str.charAt(i)) {
		case '(' : stack.push(str.charAt(i));
		break;
		case '[' : stack.push(str.charAt(i));
		break;
		case '{' : stack.push(str.charAt(i));
		break;
		case ')' : {
		if (stack.pop() != '(') result = false;
		break;
		}
		case ']' : {
		if (stack.pop() != '[') result = false;
		break;
		}
		case '}' : {
		if (stack.pop() != '{') result = false;
		break;
		}
        default: break;
		}
		return result;
}
```

`isBalanced` returns `true` if `str` is balanced according to the rules explained above. Otherwise, it returns `false`.

Use the coverage criteria studied in classes as follows:

1. Use input space partitioning to design an initial set of inputs. Explain below the characteristics and partition blocks you identified.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written so far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Write below the actions you took on each step and the results you obtained.
Use the project in [tp3-balanced-strings](../code/tp3-balanced-strings) to complete this exercise.

## Answer

1. The input space is a set of strings. There is only one argument so we don't need to make cartesian products of the domains of all parameters. 
Characteristics identified: empty, balanced or unbalanced curly braces, balanced or unbalanced parenthesis and balanced or unbalanced square brackets.

2. Statement coverage is 100%. To achieve this, we need to test all the possible cases in `switch` statement, including empty string.

3. We don't have any predicate with more than two boolean operators.

4. PIT generate 11 mutants and killed 11 mutants. The mutation score is 100%.