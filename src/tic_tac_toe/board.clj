(ns tic-tac-toe.board)

(def space " ")

(defn get-size [width]
  (* width width))

(defn get-new-board [width]
  (repeat (get-size width) space))

(defn place-marker [board position marker]
  (if (= space (get board position))
    (assoc board position marker)
    nil))

(defn full? [board]
  (not-any? #(= space %) board))
