(ns tic-tac-toe.board)

(def space " ")

(defn init []
  vector (replicate 9 space))

(defn place-marker [board position marker]
  (if (= space (get board position))
    (assoc board position marker)
    nil))
