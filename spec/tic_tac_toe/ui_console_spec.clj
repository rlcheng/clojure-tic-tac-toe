(ns tic-tac-toe.ui-console-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.ui-console :refer :all]))

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

(describe "go first"
  (it "should read player's choice to go first"
    (should= "y"
      (with-in-str "y"
        (go-first?))))
  (it "should read player's choice to go last"
    (should= "n"
      (with-in-str "n"
        (go-first?))))
  (it "should reject bad inputs and try until correct input occurs"
    (should= "y"
      (with-in-str "bad first input\nbad second input\ny"
        (go-first?)))))

(describe "print board"
  (it "should print the board and use underscore instead of space"
    (should= "X _ O\nO _ O\nX _ X\n"
      (with-out-str
        (print-board test-board)))))

(describe "get player position input"
  (it "should get player input to set location of marker"
    (should= 1
      (with-in-str "1"
        (get-position empty-board-3x3))))
  (it "should reject bad input for marker location until a good one is entered"
    (should= 15
      (with-in-str "abc\n16\n15"
        (get-position empty-board-4x4)))))
