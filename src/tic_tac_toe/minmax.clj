(ns tic-tac-toe.minmax
  (:require [tic-tac-toe.board :as board]
            [tic-tac-toe.board-evaluator :as board-evaluator]))

(def maxscore 10)
(def max-depth 10)
(declare minmax)

(defn- score [board player opponent depth]
	(cond
		(= (board-evaluator/winner? board player) true) (- maxscore depth) 
	  (= (board-evaluator/winner? board opponent) true) (- depth maxscore)
	  :else 0))

(defn- scores [board player opponent depth]
	(let [available (board/available-positions board)
				boards (map #(board/place-marker board % player) available)]
		(map #(- (minmax % opponent player (inc depth))) boards)))

(defn- minmax-score [board player opponent depth]
  (if (or (board-evaluator/game-over? board)
          (>= depth max-depth))
    (score board player opponent depth)
    (apply max (scores board player opponent depth))))

(def minmax (memoize minmax-score))

(defn get-position [board player]
	(let [opponent (board/get-other-marker player)
				available (board/available-positions board)
				scores (scores board player opponent 0)
				max-score (apply max scores)
				best-move (.indexOf scores max-score)]
  	(nth available best-move)))
