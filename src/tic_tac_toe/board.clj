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

(defn winning-rows [width]
	(partition width (range (get-size width))))

(defn winning-cols [width]
	(for [x (range 0 width)]
		(range x (get-size width) width)))

(defn winning-diagonals [width]
	(list
		(for [x (range 0 (get-size width) (inc width))]
			x)
		(for [x (range 1 (inc width))]
			(* x (dec width)))))

(defn determine-winner [board marker width]
	true)
