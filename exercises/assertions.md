# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1. The assertion fails because of the floating point precision. The correct way to check this is to use `assertEquals(1.2, 3 * .4, 0.0001)`.

2. `assertEquals` checks that two objects are equal, while `assertSame` checks that two objects are the same. For example, `assertEquals("foo", "foo")` is true, while `assertSame("foo", "foo")` is false.

3. `fail` can be used to mark code that should not be executed because it is not implemented yet. For example, if you have a method that is not implemented yet, you can write `fail("Not implemented yet")` in the method body.

4. The advantage of the new way is that it is more explicit. It is easier to understand that the test is checking that an exception is thrown.
