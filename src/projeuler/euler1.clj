(ns projeuler.euler1)

(defn ismultiple 
  "Check if a given value is a multiple of one or more values"
  [number & multiples]
  (not 
    (empty? 
      (filter
        #(-> (= 0 (mod number %1)))
        multiples
      )
    )
  )
)

(defn multiple 
  "Given a maximum value, sum up all values that are multiples of the given valuesl"
  [maxNum & multiples]
  (apply +
    (filter 
      #(-> (apply ismultiple (concat [%1] multiples))) 
      (range 0 maxNum)
    )
  )
)
