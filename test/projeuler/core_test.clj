(ns projeuler.core-test
  (:require [clojure.test :refer :all]
            [projeuler.euler1 :refer :all]))

(deftest multiple-test
  (testing "Confirm that the sum of all values that are multiples of 3 and 5 below 10 is 28"
    (is (= 23 (multiple 10 3 5)))))
