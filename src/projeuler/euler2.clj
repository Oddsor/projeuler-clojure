(ns projeuler.euler2)

(defn fibo [maxValue]
  (loop [series [1 2] val1 1 val2 2] 
    (let [newVal (+ val1 val2)]
      (if (> newVal maxValue)
        series
        (recur (conj series newVal) val2 newVal)
      )
    )
  )
)

(defn filter-even 
  [list]
  (filter #(= 0 (mod % 2)) list)
)
