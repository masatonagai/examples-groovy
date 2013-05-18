println((3..<1000).inject(0) { sum, n -> if (n % 3 == 0 || n % 5 == 0) { sum + n } else { sum } })
