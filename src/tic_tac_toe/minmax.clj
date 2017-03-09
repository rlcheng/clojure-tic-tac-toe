(ns tic-tac-toe.minmax
  (:require [tic-tac-toe.board :as board]
            [tic-tac-toe.board-evaluator :as board-evaluator]))

(def maxscore 10)

(defn score [board player opponent depth]
	(cond
		(= (board-evaluator/winner? board player) true) (- maxscore depth) 
	  (= (board-evaluator/winner? board opponent) true) (- depth maxscore)
	  :else 0))

(defn scores [board marker depth]
	(let [available (board/available-positions board)
				boards (map #(board/place-marker board % marker) available)]
				boards))

(defn minmax [board player opponent]
  4)

(defn get-position [board player]
	(let [opponent (board/get-other-marker player)]
  (minmax board player opponent)))
