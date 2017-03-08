(ns tic-tac-toe.player-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.player :refer :all]
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

(def human-player (new-human test-prompt mock-output))

(describe "human player makes a move"
  (it "should let player make a move and return board with marker on board"
    (should= first-move-board
      (with-in-str "0"
        (make-move human-player empty-board-3x3 X)))))
