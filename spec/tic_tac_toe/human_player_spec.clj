(ns tic-tac-toe.human-player-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.human-player :refer :all]))

(def X "X")
(def O "O")
(def empty-board-3x3
  [" " " " " "
   " " " " " "
   " " " " " "])
(def first-move-board
  [X " " " "
   " " " " " "
   " " " " " "])

(describe "human player makes a move"
  (it "should let player make a move and return board with marker on board"
    (should= first-move-board
      (with-in-str "0"
        (move empty-board-3x3 X)))))
