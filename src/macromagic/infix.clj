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
  (let [pre (take (dec index) ls) post (drop (+ index 2) ls)]
    (concat 
      pre 
      (cons  
        `(infix 
          ~(drop (dec index) (take (+ index 2) ls))) 
        post))))


(defmacro superinfix 
  [ls]
  (if (contains-operands '(* /) ls)
    (let [opindex (earliest-operand '(* /) ls)]
      `(superinfix ~(wrap ls opindex)))
    (if (contains-operands '(+ -) ls)
      (let [opindex (earliest-operand '(+ -) ls)]
        `(superinfix ~(wrap ls opindex)))
      (first ls))))
