// 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
// What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

// lcm(a, b) * gcd(a, b) == (a * b)
// lcm(a, b) == (a * b) / gcd(a, b)

def gcd2 = { long a, long b ->
  if (a < b) {
    (a, b) = [b, a]
  }
  while (b != 0) {
    (a, b) = [b, a % b]
  }
  a
}

def gcd = { coll ->
  if (coll.size() == 1) {
    coll.first()
  } else {
    call(coll.collate(2).collect {
      if (it.size() <= 1) {
        it.first()
      } else {
        def (long a, long b) = it
        (a * b) / gcd2(a, b)
      }
    })
  }
}

assert gcd(1..10) == 2520

println gcd(1..20)
