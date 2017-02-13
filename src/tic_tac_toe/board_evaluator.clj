(ns tic-tac-toe.board-evaluator
  (:require [tic-tac-toe.board :as board]))

(defn- get-winning-rows [width size]
  (partition width (range size)))

(defn- get-winning-cols [width size]
    (map (fn[x] (range x size width)) (range 0 width)))

(defn- get-winning-diagonals [width size]
  (list
    (map (fn[x] x) (range 0 size (inc width)))
    (map (fn[y] (* y (dec width))) (range 1 (inc width)))))

(defn- get-winning-combos [width size]
  (concat (get-winning-rows width size) (get-winning-cols width size) (get-winning-diagonals width size)))

(defn- same-marker? [row marker]
  (every? #(= marker %) row))

(defn winner? [board marker]
  (let [width (board/get-width board)
        size (board/get-size width)
        combos (get-winning-combos width size)]
    (boolean (some #(same-marker? (board/get-positions board %) marker) combos))))
