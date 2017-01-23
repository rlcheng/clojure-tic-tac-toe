(ns tic-tac-toe.score-keeper
  (:require [tic-tac-toe.board :as board]))

(defn winning-rows [width]
  (partition width (range (board/get-size width))))

(defn winning-cols [width]
  (for [x (range 0 width)]
    (range x (board/get-size width) width)))

(defn winning-diagonals [width]
  (list
    (for [x (range 0 (board/get-size width) (inc width))]
      x)
    (for [x (range 1 (inc width))]
      (* x (dec width)))))

(defn winning-combos [width]
  (concat (winning-rows width) (winning-cols width) (winning-diagonals width)))

(defn get-positions [board positions]
  (for [x positions]
    (get board x)))

(defn has-same-marker? [row marker]
  (every? #(= marker %) row))

(defn winner? [board marker width]
  (some #(has-same-marker? (get-positions board %) marker) (winning-combos width)))
