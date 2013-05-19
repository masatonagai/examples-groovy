// The prime factors of 13195 are 5, 7, 13 and 29.
// What is the largest prime factor of the number 600851475143 ?

/*
def primeFactors(long n) {
  def results = []
  long tmp = n
  for (long i = 2; i <= (n / i); i++) {
    while (tmp % i == 0) {
      results << i
      tmp /= i
    }
  }
  results
}
*/

def factor = { n, x ->
  n % x == 0
}

def prime
prime = { n, x = 2 ->
  if (x >= n) true
  else factor(n, x) ? false : prime.trampoline(n, x + 1)
}.trampoline()

def primeFactor = { n, x ->
  factor(n, x) && prime(x)
}

def primeFactors
primeFactors = { n, x = 2, prv = [] ->
  if (x >= (n / x)) prv
  else primeFactors.trampoline(n, x + 1, prv + (primeFactor(n, x) ? [x] : []))
}.trampoline()

assert primeFactors(13195) == [5, 7, 13, 29]

println(primeFactors(600851475143).last())
