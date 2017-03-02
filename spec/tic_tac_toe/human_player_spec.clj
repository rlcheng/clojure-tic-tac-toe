(ns tic-tac-toe.human-player-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.human-player :refer :all]
            [tic-tac-toe.board :refer :all]))

(def empty-board-3x3
  [space space space
   space space space
   space space space])

(def first-move-board
  [X space space
   space space space
   space space space])

(defn test-prompt [message]
  (read-line))

(defn mock-output [message]
  message)

(describe "human player makes a move"
  (it "should let player make a move and return board with marker on board"
    (should= first-move-board
      (with-in-str "0"
        (make-move empty-board-3x3 X test-prompt mock-output)))))
