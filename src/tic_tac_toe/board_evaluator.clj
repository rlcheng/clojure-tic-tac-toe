(ns tic-tac-toe.board-evaluator
  (:require [tic-tac-toe.board :as board]))

(defn get-winning-rows [width]
  (partition width (range (board/get-size width))))

(defn get-winning-cols [width]
    (map (fn[x] (range x (board/get-size width) width)) (range 0 width)))

(defn get-winning-diagonals [width]
  (list
    (map (fn[x] x) (range 0 (board/get-size width) (inc width)))
    (map (fn[y] (* y (dec width))) (range 1 (inc width)))))

(defn get-winning-combos [width]
  (concat (get-winning-rows width) (get-winning-cols width) (get-winning-diagonals width)))

(defn get-positions [board positions]
  (map (fn[x] (get board x)) positions))

(defn same-marker? [row marker]
  (every? #(= marker %) row))

(defn winner? [board marker]
  (let [width (board/get-width board)
        combos (get-winning-combos width)]
    (boolean (some #(same-marker? (get-positions board %) marker) combos))))
