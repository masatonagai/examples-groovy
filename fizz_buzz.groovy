def r = (1..100).inject([]) { r, n ->
  r << (
    (n % 15 == 0) ? "fizzbuzz" :
    (n % 3 == 0) ? "fizz" :
    (n % 5 == 0) ? "buzz" :
    n)
}
println(r.join('\n'))
