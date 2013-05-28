// A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
// 
// a^2 + b^2 = c^2
// For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
// 
// There exists exactly one Pythagorean triplet for which a + b + c = 1000.
// Find the product abc.

def squareRoot = { n ->
  Math.sqrt(n)
}

def square = { n ->
  n * n
}

def pytha = { a, b ->
  squareRoot(square(a) + square(b))
}

def answer = { sum ->
  def a, b, c
  (1..<sum).find {
    a = it
    ((a + 1)..<sum).find {
      b = it
      c = pytha(a, b)
      (a + b + c == sum)
    }
  }
  a * b * (int) pytha(a, b)
}

assert answer(12) == 60

println(answer(1000))
