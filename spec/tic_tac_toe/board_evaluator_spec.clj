(ns tic-tac-toe.board-evaluator-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.board-evaluator :refer :all]))

(def X "X")
(def O "O")
(def X-row-3 [X X X])
(def mix-row-3 [X O X])
(def O-row-4 [O O O O])
(def mix-row-4 [X O X O])
(def empty-board-3x3
  [" " " " " "
   " " " " " "
   " " " " " "])
(def partial-board-3x3
  [X O X
   O O X
   X " " O])
(def X-first-row-win-3x3
  [X X X
   " " " " " "
   " " " " " "])
(def X-first-diag-win-3x3
  [X " " " "
   " " X " "
   " " " " X])
(def empty-board-4x4
  [" " " " " " " "
   " " " " " " " "
   " " " " " " " "
   " " " " " " " "])
(def O-fourth-col-win-4x4
  [" " " " " " O
   " " " " " " O
   " " " " " " O
   " " " " " " O])
(def stalemate-3x3
  [X O X
   O O X
   X X O])
(def stalemate-4x4
  [X O X X
   O X O X
   O O X O
   X O O O])

(describe "winning rows"
  (it "should return list of winning row combinations if width is 3"
    (should= '((0 1 2) (3 4 5) (6 7 8)) (get-winning-rows 3)))
  (it "should return list of winning row combinatiosn if width is 4"
    (should= '((0 1 2 3) (4 5 6 7) (8 9 10 11) (12 13 14 15)) (get-winning-rows 4))))

(describe "winning columns"
  (it "should return list of winning column combinations if width is 3"
    (should= '((0 3 6) (1 4 7) (2 5 8)) (get-winning-cols 3)))
  (it "should return list of winning column combinations if width is 4"
    (should= '((0 4 8 12) (1 5 9 13) (2 6 10 14) (3 7 11 15)) (get-winning-cols 4))))

(describe "winning diagonals"
  (it "should return list of winning diagonal combinations if width is 3"
    (should= '((0 4 8) (2 4 6)) (get-winning-diagonals 3)))
  (it "should return list of winning diagonal combinations if width is 4"
    (should= '((0 5 10 15) (3 6 9 12)) (get-winning-diagonals 4))))

(describe "winning combos"
  (it "should return list of all winning combinations for given width"
    (should= '((0 1 2) (3 4 5) (6 7 8) (0 3 6) (1 4 7) (2 5 8) (0 4 8) (2 4 6)) (get-winning-combos 3))))

(describe "get positions"
  (it "should return list of markers at given positions of the board"
    (should= (list X X X) (get-positions X-first-row-win-3x3 '(0 1 2)))))

(describe "match"
  (it "should return true if marker matches list"
    (should= true (same-marker? X-row-3 X))
    (should= true (same-marker? O-row-4 O)))
  (it "should return false if marker does not match list"
    (should= false (same-marker? mix-row-3 X))
    (should= false (same-marker? mix-row-4 O))))

(describe "winner"
  (it "should return true if win detected on a 3x3 board"
    (should= true (winner? X-first-diag-win-3x3 X)))
  (it "should return false if win is not detected on a 3x3 board"
    (should= false (winner? empty-board-3x3 X))
    (should= false (winner? stalemate-3x3 O)))
  (it "should return true if win detected on a 4x4 board"
    (should= true (winner? O-fourth-col-win-4x4 O)))
  (it "should return false if win is not detected on a 4x4 board"
    (should= false (winner? empty-board-4x4 X))
    (should= false (winner? stalemate-4x4 O))))
