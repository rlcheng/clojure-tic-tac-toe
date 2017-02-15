(ns tic-tac-toe.ui-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.ui :refer :all]
            [tic-tac-toe.ui-console :as ui-console]))

(def X "X")
(def O "O")
(def test-board
  [X " " O
   O " " O
   X " " X])
(def empty-board-3x3
  [" " " " " "
   " " " " " "
   " " " " " "])
(def empty-board-4x4
  [" " " " " " " "
   " " " " " " " "
   " " " " " " " "
   " " " " " " " "])

(defn mock-prompt [message]
  (read-line))

(defn mock-output [message]
  (println message))

(defn mock-print [board]
  (print board))

(describe "go first"
  (it "should read player's choice to go first"
    (should= "y"
      (with-in-str "y"
        (go-first? mock-prompt mock-output))))
  (it "should read player's choice to go last"
    (should= "n"
      (with-in-str "n"
        (go-first? mock-prompt mock-output))))
  (it "should reject bad inputs and try until correct input occurs"
    (should= "y"
      (with-in-str "bad first input\nbad second input\ny"
        (go-first? mock-prompt mock-output)))))

(describe "print board"
  (it "should print the board using the method in the argument"
    (should= "[X   O O   O X   X]"
      (with-out-str
        (print-board test-board mock-print)))))

(describe "get player position input"
  (it "should return integer representation of player input to set location of marker"
    (should= 1
      (with-in-str "1"
        (get-position empty-board-3x3 mock-prompt mock-output))))
  (it "should reject bad input for marker location until a good one is entered"
    (should= 15
      (with-in-str "abc\n16\n15"
        (get-position empty-board-4x4 mock-prompt mock-output)))))
