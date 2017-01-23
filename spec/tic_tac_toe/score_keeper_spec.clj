(ns tic-tac-toe.score-keeper-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.score-keeper :refer :all]))

(def X "X")
(def O "O")
(def X-row-3 [X X X])
(def mix-row-3 [X O X])
(def O-row-4 [O O O O])
(def mix-row-4 [X O X O])
(def empty-board-3x3 [" " " " " " " " " " " " " " " " " "])
(def partial-board-3x3 [X O X O O X X " " O])
(def X-first-row-win-3x3 [X X X " " " " " " " " " " " "])
(def O-second-row-win-3x3 [" " " " " " O O O " " " " " "])
(def X-third-row-win-3x3 [" " " " " " " " " " " " X X X])
(def O-first-col-win-3x3 [O " " " " O " " " " O " " " "])
(def X-second-col-win-3x3 [" " X " " " " X " " " " X " "])
(def O-third-col-win-3x3 [" " " " O " " " " O " " " " O])
(def X-first-diag-win-3x3 [X " " " " " " X " " " " " " X])
(def O-second-diag-win-3x3 [" " " " O " " O " " O " " " "])
(def X-first-row-win-4x4 [X X X X " " " " " " " " " " " " " " " " " " " " " " " "])
(def O-second-row-win-4x4 [" " " " " " " " O O O O " " " " " " " " " " " " " " " "])
(def X-third-row-win-4x4 [" " " " " " " " " " " " " " " " X X X X " " " " " " " "])
(def O-fourth-row-win-4x4 [" " " " " " " " " " " " " " " " " " " " " " " " O O O O])
(def X-first-col-win-4x4 [X " " " " " " X " " " " " " X " " " " " " X " " " " " "])
(def O-second-col-win-4x4 [" " O " " " " " " O " " " " " " O " " " " " " O " " " "])
(def X-third-col-win-4x4 [" " " " X " " " " " " X " " " " " " X " " " " " " X " "])
(def O-fourth-col-win-4x4 [" " " " " " O " " " " " " O " " " " " " O " " " " " " O])
(def X-first-diag-win-4x4 [X " " " " " " " " X " " " " " " " " X " " " " " " " " X])
(def O-second-diag-win-4x4 [" " " " " " O " " " " O " " " " O " " " " O " " " " " "])
(def stalemate-3x3 [X O X O O X X X O])

(describe "winning rows"
  (it "should return list of winning row combinations if width is 3"
    (should= '((0 1 2) (3 4 5) (6 7 8)) (winning-rows 3)))
  (it "should return list of winning row combinatiosn if width is 4"
    (should= '((0 1 2 3) (4 5 6 7) (8 9 10 11) (12 13 14 15)) (winning-rows 4))))

(describe "winning columns"
  (it "should return list of winning column combinations if width is 3"
    (should= '((0 3 6) (1 4 7) (2 5 8)) (winning-cols 3)))
  (it "should return list of winning column combinations if width is 4"
    (should= '((0 4 8 12) (1 5 9 13) (2 6 10 14) (3 7 11 15)) (winning-cols 4))))

(describe "winning diagonals"
  (it "should return list of winning diagonal combinations if width is 3"
    (should= '((0 4 8) (2 4 6)) (winning-diagonals 3)))
  (it "should return list of winning diagonal combinations if width is 4"
    (should= '((0 5 10 15) (3 6 9 12)) (winning-diagonals 4))))

(describe "winning combos"
  (it "should return list of all winning combinations for given width"
    (should= '((0 1 2) (3 4 5) (6 7 8) (0 3 6) (1 4 7) (2 5 8) (0 4 8) (2 4 6)) (winning-combos 3))))

(describe "get positions"
  (it "should return list of markers at given positions of the board"
    (should= (list X X X) (get-positions X-first-row-win-3x3 '(0 1 2)))))

(describe "match"
  (it "should return true if marker matches list, false otherwise"
    (should= true (has-same-marker? X-row-3 X))
    (should= false (has-same-marker? mix-row-3 X))
    (should= true (has-same-marker? O-row-4 O))
    (should= false (has-same-marker? mix-row-4 O))))

(describe "winner"
  (it "should return true if marker wins, nil otherwise"
    (should= true (winner? X-first-row-win-3x3 X 3))
    (should= true (winner? O-second-row-win-3x3 O 3))
    (should= true (winner? X-third-row-win-3x3 X 3))
    (should= true (winner? O-first-col-win-3x3 O 3))
    (should= true (winner? X-second-col-win-3x3 X 3))
    (should= true (winner? O-third-col-win-3x3 O 3))
    (should= true (winner? X-first-diag-win-3x3 X 3))
    (should= true (winner? O-second-diag-win-3x3 O 3))
    (should= true (winner? X-first-row-win-4x4 X 4))
    (should= true (winner? O-second-row-win-4x4 O 4))
    (should= true (winner? X-third-row-win-4x4 X 4))
    (should= true (winner? O-fourth-row-win-4x4 O 4))
    (should= true (winner? X-first-col-win-4x4 X 4))
    (should= true (winner? O-second-col-win-4x4 O 4))
    (should= true (winner? X-third-col-win-4x4 X 4))
    (should= true (winner? O-fourth-col-win-4x4 O 4))
    (should= true (winner? X-first-diag-win-4x4 X 4))
    (should= true (winner? O-second-diag-win-4x4 O 4))
    (should= nil (winner? empty-board-3x3 X 3))
    (should= nil (winner? stalemate-3x3 X 3))
    (should= nil (winner? stalemate-3x3 O 3))))
