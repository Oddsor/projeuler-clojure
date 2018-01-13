(ns projeuler.core
  (:gen-class))

(use '[projeuler.euler1 :only [multiple]])

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (apply multiple (map #(Integer/parseInt %) args))))
