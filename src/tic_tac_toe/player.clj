(ns tic-tac-toe.player
  (:require [tic-tac-toe.board :as board]
            [tic-tac-toe.ui :as ui]))

(defprotocol Player
  (make-move [this board marker]))

(deftype Human [prompt output]
  Player
  (make-move [this board marker]
    (let [position (ui/get-position board prompt output)]
      (board/place-marker board position marker))))

(defn new-human [prompt output]
  (Human. prompt output))
