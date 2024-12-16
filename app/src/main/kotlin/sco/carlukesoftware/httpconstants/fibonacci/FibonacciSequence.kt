package sco.carlukesoftware.httpconstants.fibonacci

/**
 * 4 'solutions' to return fibonacci sequences
 */

/**
- * #1 The Classic Way:
- * Naturally but slow, based on the Fibonacci formula F(n+1)=F(n)+F(n−1)
+ * Calculates the nth Fibonacci number using a recursive approach.
+ *
+ * This function implements the classic recursive definition of the Fibonacci sequence:
+ * F(0) = 0
+ * F(1) = 1
+ * F(n) = F(n-1) + F(n-2) for n > 1
+ *
+ * While this method is conceptually straightforward, it is highly inefficient for larger values of 'n'
+ * due to its exponential time complexity.
 *
- * Time Complexity: O(2^N)
+ * @param n The index of the desired Fibonacci number (non-negative integer).
+ * @return The nth Fibonacci number.
+ * @throws IllegalArgumentException if n is negative.
+ * @Time Complexity: O(2^n) - Exponential
+ * @Space Complexity: O(n) - due to recursive call stack
 */
fun fibonacciRecursive(n: Int): Int {
    return if (n <= 1) {
        n
    } else {
        fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2)
    }
}

/**
 * Calculates the nth Fibonacci number using an iterative approach.
 *
 * This method calculates the Fibonacci sequence iteratively, starting from the base cases
 * (0 and 1) and building up to the nth number. This approach is generally more efficient
 * than a recursive approach for larger values of n, as it avoids the overhead of
 * repeated function calls.
 *
 * The iterative method is efficient but might be considered less readable than a
 * recursive solution because it obscures the inherent recursive nature of the Fibonacci
 * sequence.
 *
 * Time Complexity: O(N) - The loop iterates 'n' times to calculate the nth Fibonacci number.
 * Space Complexity: O(1) - The algorithm uses a constant amount of extra space, regardless of the input 'n',
 *                         as it only stores a fixed number of variables (prev, current, next).
 *
 * @param n The index of the desired Fibonacci number (non-negative).
 * @return The nth Fibonacci number.
 * @throws IllegalArgumentException if n is negative.
 * @sample
 * // Example Usage:
 * val result = fibonacciIterative(6) // result will be 8 (0, 1, 1, 2, 3, 5, 8)
 * println(result)
 */
fun fibonacciIterative(n: Int): Int {
    if (n <= 1) return n

    var prev = 0
    var current = 1
    for (i in 2..n) {
        val next = prev + current
        prev = current
        current = next
    }

    return current
}

/**
- * #3 Tail Call Optimization (TCO):
- * TCO eliminates the need for a growing stack by reusing the same stack frame.
+ * Calculates the nth Fibonacci number using tail recursion.
+ *
+ * This function utilizes Tail Call Optimization (TCO) to avoid stack overflow errors that can occur with standard recursion when calculating large Fibonacci numbers.
+ * TCO eliminates the need for a growing call stack by reusing the same stack frame for each recursive call.
+ *
+ * @param n The index of the desired Fibonacci number (non-negative).
+ * @param a The (n-2)th Fibonacci number (default is 0, for n=0).
+ * @param b The (n-1)th Fibonacci number (default is 1, for n=1).
+ * @return The nth Fibonacci number.
 *
 * Time Complexity: O(N)
 */
fun fibonacciTailRecursive(n: Int, a: Int = 0, b: Int = 1): Int {
    return when (n) {
        0 -> a
        1 -> b
        else -> fibonacciTailRecursive(n - 1, b, a + b)
    }
}

/**
 * Calculates the nth Fibonacci number using dynamic programming (bottom-up approach).
 *
 * This function utilizes dynamic programming to compute the Fibonacci sequence iteratively.
 * It stores previously calculated Fibonacci numbers in an array (`dp`) to avoid redundant computations.
 *
 * Time Complexity: O(N) - The loop iterates 'n' times.
 * Space Complexity: O(N) - An array of size 'n+1' is used to store the Fibonacci numbers.
 *
 * @param n The index (non-negative integer) of the desired Fibonacci number.
 * @return The nth Fibonacci number.
 * @throws IllegalArgumentException if n is negative.
 *
 * Examples:
 * fibonacciDynamicProgramming(0) == 0
 * fibonacciDynamicProgramming(1) == 1
 * fibonacciDynamicProgramming(2) == 1
 * fibonacciDynamicProgramming(3) == 2
 * fibonacciDynamicProgramming(4) == 3
 * fibonacciDynamicProgramming(5) == 5
 */
fun fibonacciDynamicProgramming(n: Int): Int {
    if (n <= 1) return n

    val dp = IntArray(n + 1)
    dp[0] = 0
    dp[1] = 1
    for (i in 2..n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }

    return dp[n]
}
