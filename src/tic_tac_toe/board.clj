(ns tic-tac-toe.board)

(def space " ")

(defn get-size [width]
	(* width width))

(defn get-new-board [width]
  vector (replicate (get-size width) space))

(defn place-marker [board position marker]
  (if (= space (get board position))
    (assoc board position marker)
    nil))

(defn winning-rows [width]
	(partition width (range (get-size width))))

(defn winning-cols [width]
	(for [x (range 0 width)]
		(range x (get-size width) width)))

(defn determine-winner [board marker]
	true)
