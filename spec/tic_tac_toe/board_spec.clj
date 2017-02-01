(ns tic-tac-toe.board-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.board :refer :all]))

(def empty-board-3x3
  [" " " " " "
   " " " " " "
   " " " " " "])
(def empty-board-4x4
  [" " " " " " " "
   " " " " " " " "
   " " " " " " " "
   " " " " " " " "])
(def X "X")
(def O "O")
(def full-board-3x3
  [X O X
   O X X
   O X O])
(def test-board
  [X " " " "
   " " " " " "
   " " " " " "])

(describe "size of board"
  (it "should figure out size of board given width"
    (should= 9 (get-size 3))
    (should= 16 (get-size 4))))

(describe "width of board"
  (it "should figure out the width of a given board"
    (should= 3 (get-width full-board-3x3))
    (should= 4 (get-width empty-board-4x4))))

(describe "create empty board"
  (it "should create a board with size of 9 if width is 3"
    (should= empty-board-3x3 (get-new-board 3)))
  (it "should create a board with size of 16 if width is 4"
    (should= empty-board-4x4 (get-new-board 4))))

(describe "place marker"
  (it "should place a marker"
    (should= test-board (place-marker empty-board-3x3 0 X)))
  (it "should not place marker if position is not empty"
    (should= nil (place-marker test-board 0 O))))

(describe "get positions"
  (it "should return list of markers at given positions of the board"
    (should= (list X O X) (get-positions full-board-3x3 '(0 1 2)))))

(describe "board full"
  (it "should determine if board is full"
    (should= false (full? empty-board-3x3))
    (should= false (full? test-board))
    (should= true (full? full-board-3x3))))
