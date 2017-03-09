(ns tic-tac-toe.board
  (:require [clojure.math.numeric-tower :as math]))

(def X "X")
(def O "O")
(def space " ")

(defn get-size [width]
  (* width width))

(defn get-width [board]
  (math/sqrt (count board)))

(defn get-new-board [width]
  (repeat (get-size width) space))

(defn place-marker [board position marker]
  (assoc board position marker))

(defn get-positions [board positions]
  (map (fn[x] (get board x)) positions))

(defn full? [board]
  (not-any? #(= space %) board))

(defn- in-range? [start position stop]
  (<= start position stop))

(defn- position-open? [board position]
  (= space (get board position)))

(defn valid-position? [board position]
  (let [position-int (read-string position)
        start-index 0
        last-index (dec (count board))]
  (if (number? position-int)
    (and (in-range? start-index position-int last-index) (position-open? board position-int))
    false)))

(defn- open-position [board position]
  (if (position-open? board position)
    position))

(defn available-positions [board]
  (let [positions (range (count board))]
    (remove nil? (map (fn[x] (open-position board x)) positions))))

(defn get-other-marker [marker]
  (if (= X marker)
    O
    X))
