(ns tic-tac-toe.board
  (:require [clojure.math.numeric-tower :as math]))

(def space " ")

(defn get-size [width]
  (* width width))

(defn get-width [board]
  (math/sqrt (count board)))

(defn get-new-board [width]
  (repeat (get-size width) space))

(defn place-marker [board position marker]
  (if (= space (get board position))
    (assoc board position marker)
    nil))

(defn get-positions [board positions]
  (map (fn[x] (get board x)) positions))

(defn full? [board]
  (not-any? #(= space %) board))
