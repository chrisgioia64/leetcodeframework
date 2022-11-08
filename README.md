
# Leetcode Framework

**Core Idea**: About half of the time when solving leetcode questions, there exists a naive, simple algorithm and then one or more complex algorithms that provide a more optimized solution.

I use an approach called the **bootstrap** where the user provides two algorithms (a simple algorithm and an optimized algorithm). We test the simple algorithm against a small set of manually generated test input (consisting of input/output pairs). If that passes, we assume the simple algorithm is correct and use that to generate output over a larger set of auto-generated input. We then test the output of the simple algorithm against the output of the optimized algorithm over the auto-generated set to determine if the optimized algorithm is correct.

## Current Features
- Use of the `Strategy` design pattern to implement the Bootstrap algorithm.
- Algorithms, manual test data, and auto-generated input data for the *TwoSum* and *PalindromicSubstring* leetcode problems.
- A wide variety of iterators that support auto-generation of the input data including: *StringProductIterator* (for generating different combinations of strings from a character set), *PermutationIterator* (complex algorithm for supporting an iterator version of the backtracking algorithm approach for generating permutations), *FilterMapIterator* (using Java 8 functional programming for supporting an iterator that does filter and map operations.).
- Conversion between data types (e.g. String that correspond to input and output of an algorithm) and a database string representation to be used for flexible data persistence of a wide variety of data types. Will be used to persist Strings, Integer Arrays, Linked List, and Trees.
- A parallel merge sort algorithm that makes use of simple concurrency constructs such as `Thread`, `Runnable`, and `joins`.
- Unit testing of each problem and its related algorithms to easily determine if the simple and advance algorithms are working correctly.

## Proposed Features

- Use of Spring Aspects to provide cross-cutting concerns like timing and logging.
- Persistence of the problem and the algorithm results into a relational database.