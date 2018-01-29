(ns macromagic.infix)

(defmacro infix
  "Write infixed mathemagics!"
  [ls]
  (list
    (second ls)
    (first ls)
    (last ls)))

(defn contains-operands
  [operands ls]
  (not (empty? (filter #(> % -1) (map #(.indexOf ls %) operands)))))

(defn earliest-operand 
  [operands ls] 
  (apply min (filter #(> % -1) (map #(.indexOf ls %) operands))))

(defn wrap [ls index]
  (println (str "folding element " index))
  (let [pre (take (dec index) ls) post (drop (+ index 2) ls)]
    (println pre)
    (println post)
    (println (list
      (nth ls index)
      (nth ls (dec index))
      (nth ls (inc index))
      ))
    (println (concat pre (cons  
      (list
        (nth ls index)
        (nth ls (dec index))
        (nth ls (inc index))
        ) post)))
    (concat pre (cons  
      (list
        (nth ls index)
        (nth ls (dec index))
        (nth ls (inc index))
        ) post))))


(defmacro superinfix 
  [ls]
  (println "superinfix")
  (println ls)
  (if (contains-operands '(* /) ls)
    (let [opindex (earliest-operand '(* /) ls)]
      `(superinfix ~(wrap ls opindex)))
    (if (contains-operands '(+ -) ls)
      (let [opindex (earliest-operand '(+ -) ls)]
        `(superinfix ~(wrap ls opindex)))
      (first ls))))
