// The sum of the squares of the first ten natural numbers is,
// 1^2 + 2^2 + ... + 10^2 = 385
// The square of the sum of the first ten natural numbers is,
// (1 + 2 + ... + 10)^2 = 55^2 = 3025
// Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
// Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

def square = { n ->
  n * n
}

assert square(2) == 4

def sum = { coll ->
  coll.inject(0) { r, n -> r + n }
}

assert sum([1, 2, 3]) == 6

def sumOfSquares = { coll ->
  sum(coll.collect { n -> square(n) })
}

assert sumOfSquares(1..10) == 385

def squareOfSum = { coll ->
  square(sum(coll))
}

assert squareOfSum(1..10) == 3025

def answer = { coll ->
  squareOfSum(coll) - sumOfSquares(coll)
}

assert answer(1..10) == 2640

println(answer(1..100))
