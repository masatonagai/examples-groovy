// A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
// Find the largest palindrome made from the product of two 3-digit numbers.

def palindromic = { int n ->
  int tmp = n
  def ns = []
  while (tmp > 0) {
    ns << (tmp % 10)
    tmp /= 10
  }
  def (upper, lower) = ns.collate((int) ns.size()/2)
  upper.reverse() == lower
}

assert palindromic(9009)
assert !palindromic(9008)

def maxPalindromic = { int digit ->
  int maxOp = (Math.pow(10, digit) - 1)
  int maxPldPrd = 0
  for (int i = maxOp; i > 0; i--) {
    for (int j = maxOp; j > 0; j--) {
      int prd = i * j
      if (prd <= maxPldPrd) {
        break
      }
      if (palindromic(prd)) {
        maxPldPrd = prd
        break
      }
    }
  }
  maxPldPrd
}

assert maxPalindromic(2) == 9009

println(maxPalindromic(3))
