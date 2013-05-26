// By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
// What is the 10001st prime number?

def isPrime = { num ->
  if (num < 2) { false }
  else {
    { numSqrt = Math.sqrt(num) ->
      { n = 2 ->
        if (n > numSqrt) { true }
        else if (num % n == 0) { false }
        else { trampoline(n + 1) }
      }.trampoline()()
    }()
  }
}

assert (2..10).findAll { n -> isPrime(n) } == [2, 3, 5, 7]

def takePrimes = { num ->
  { primes = [], n = 2 ->
    if (primes.size() == num) {
      primes
    } else {
      trampoline(
        isPrime(n) ? (primes << n) : primes, n + 1)
    }
  }.trampoline()()
}

assert takePrimes(6) == [2, 3, 5, 7, 11, 13]

def answer = { nth ->
  takePrimes(nth).last()
}

assert answer(6) == 13

println(answer(1001))
