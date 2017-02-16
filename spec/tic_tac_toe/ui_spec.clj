(ns tic-tac-toe.ui-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.ui :refer :all]
            [tic-tac-toe.ui-console :as ui-console]
            [tic-tac-toe.board :refer :all]))

(def test-board
  [X space O
   O space O
   X space X])

(def empty-board-3x3
  [space space space
   space space space
   space space space])

(def empty-board-4x4
  [space space space space
   space space space space
   space space space space
   space space space space])

(defn test-prompt [message]
  (read-line))

(defn mock-output [message]
  (do message))

(describe "go first"
  (it "should read player's choice to go first"
    (should= "y"
      (with-in-str "y"
        (go-first? test-prompt mock-output))))
  (it "should read player's choice to go last"
    (should= "n"
      (with-in-str "n"
        (go-first? test-prompt mock-output))))
  (it "should reject bad inputs and try until correct input occurs"
    (should= "y"
      (with-in-str "bad first input\nbad second input\ny"
        (go-first? test-prompt mock-output)))))

(describe "print board"
  (it "should print the board using the method in the argument"
    (should= "[X   O O   O X   X]"
      (with-out-str
        (print-board test-board print)))))

(describe "get player position input"
  (it "should return integer representation of player input to set location of marker"
    (should= 1
      (with-in-str "1"
        (get-position empty-board-3x3 test-prompt mock-output))))
  (it "should reject bad input for marker location until a good one is entered"
    (should= 15
      (with-in-str "abc\n16\n15"
        (get-position empty-board-4x4 test-prompt mock-output)))))
