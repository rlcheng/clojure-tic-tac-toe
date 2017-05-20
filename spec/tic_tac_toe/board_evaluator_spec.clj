(ns tic-tac-toe.board-evaluator-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.board-evaluator :refer :all]
            [tic-tac-toe.board :refer :all]))

(def empty-board-3x3
  [space space space
   space space space
   space space space])

(def X-first-row-win-3x3
  [X X X
   space space space
   space space space])

(def X-first-diag-win-3x3
  [X space space
   space X space
   space space X])

(def O-fourth-col-win-4x4
  [space space space O
   space space space O
   space space space O
   space space space O])

(def stalemate-4x4
  [X O X X
   O X O X
   O O X O
   X O O O])

(describe "winner"
  (it "should return true if a row win is detected on a 3x3 board"
    (should= true (winner? X-first-row-win-3x3 X)))
  (it "should return true if a diagonal win is detected on a 3x3 board"
    (should= true (winner? X-first-diag-win-3x3 X)))
  (it "should return true if a column win is detected on a 4x4 board"
    (should= true (winner? O-fourth-col-win-4x4 O)))
  (it "should return false if win is not detected on an empty 3x3 board"
    (should= false (winner? empty-board-3x3 X)))
  (it "should return false if win is not detected on a full 4x4 board"
    (should= false (winner? stalemate-4x4 O))))

(describe "draw"
  (it "should return true if game is a draw"
    (should= true (draw? stalemate-4x4))))

(describe "game over"
  (it "should return true if game is over due to draw"
    (should= true (game-over? stalemate-4x4)))
  (it "should return true if game is over due to a winner"
    (should= true (game-over? X-first-diag-win-3x3)))
  (it "should return false if game has no winner and has open positions"
    (should= false (game-over? empty-board-3x3))))
