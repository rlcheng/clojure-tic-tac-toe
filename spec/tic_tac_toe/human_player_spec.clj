(ns tic-tac-toe.human-player-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.human-player :refer :all]))

(def X "X")
(def empty-board-3x3
  [" " " " " "
   " " " " " "
   " " " " " "])
(def first-move-board
  [X " " " "
   " " " " " "
   " " " " " "])

(defn mock-prompt [message]
  (read-line))

(defn mock-output [message]
  (println message))

(describe "human player makes a move"
  (it "should let player make a move and return board with marker on board"
    (should= first-move-board
      (with-in-str "0"
        (move empty-board-3x3 X mock-prompt mock-output)))))
