(ns projeuler.core-test
  (:require [clojure.test :refer :all]
            [projeuler.euler1 :refer :all]
            [projeuler.euler2 :refer :all]
))

(deftest multiple-test
  (testing "Confirm that the sum of all values that are multiples of 3 and 5 below 10 is 28"
    (is (= 23 (multiple 10 3 5)))))

(deftest even-fibo-test
  (testing 
    "The sum of all even fibonacci-numbers below 4 000 000 should equal 4 613 732"
    (is (= 4613732 (apply + (filter-even (fibo 4000000)))))
  )
)
