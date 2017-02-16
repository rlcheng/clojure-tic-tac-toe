(ns tic-tac-toe.ui-console-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.ui-console :refer :all]
            [tic-tac-toe.board :refer :all]))

(def test-board
  [X space O
   O space O
   X space X])

(describe "console prompt"
  (it "should print a message and ask user for input"
    (should= "Richard"
      (with-in-str "Richard"
        (prompt "What is your name?")))))

(describe "console message"
  (it "should print a message"
    (should= "console message\n"
      (with-out-str
        (output "console message")))))

(describe "print board"
  (it "should print the board to console and use underscore instead of space"
    (should= "X _ O\nO _ O\nX _ X\n"
      (with-out-str
        (print-board test-board)))))
