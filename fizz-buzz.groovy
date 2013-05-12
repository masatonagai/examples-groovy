1.upto(100) { n ->
  println(
    (n % 15 == 0) ? "fizzbuzz"
      : (n % 3 == 0) ? "fizz"
        : (n % 5 == 0) ? "buzz"
          : n)
}
