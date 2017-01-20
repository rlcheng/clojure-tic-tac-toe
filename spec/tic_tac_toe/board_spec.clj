(ns tic-tac-toe.board-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.board :refer :all]))

(def empty-board-3x3 [" " " " " " " " " " " " " " " " " "])
(def empty-board-4x4 [" " " " " " " " " " " " " " " " " " " " " " " " " " " " " " " "])
(def X "X")
(def O "O")
(def full-board-3x3 [X X X X X X X X X])
(def test-board [X " " " " " " " " " " " " " " " "])
(def X-first_row-win-board [X X X " " " " " " " " " " " "])
(def O-second-row-win-board [" " " " " " O O O " " " " " "])

(describe "size of board"
  (it "should figure out size of board given width"
    (should= 9 (get-size 3))
    (should= 16 (get-size 4))))

(describe "create empty board"
  (it "should create a board with size of 9 if width is 3"
    (should= empty-board-3x3 (get-new-board 3)))
  (it "should create a board with size of 16 if width is 4"
    (should= empty-board-4x4 (get-new-board 4))))

(describe "place marker"
  (it "should place a marker"
    (should= [X " " " " " " " " " " " " " " " "] (place-marker empty-board-3x3 0 X)))
  (it "should not place marker if position is not empty"
    (should= nil (place-marker test-board 0 O))))

(describe "board full"
  (it "should determine if board is full"
    (should= false (full? empty-board-3x3))
    (should= false (full? test-board))
    (should= true (full? full-board-3x3))))

(describe "winning row"
  (it "should return list of winning row combinations if width is 3"
    (should= '((0 1 2) (3 4 5) (6 7 8)) (winning-rows 3)))
  (it "should return list of winning row combinatiosn if width is 4"
    (should= '((0 1 2 3) (4 5 6 7) (8 9 10 11) (12 13 14 15)) (winning-rows 4))))

(describe "winning column"
  (it "should return list of winning column combinations if width is 3"
    (should= '((0 3 6) (1 4 7) (2 5 8)) (winning-cols 3)))
  (it "should return list of winning column combinations if width is 4"
    (should= '((0 4 8 12) (1 5 9 13) (2 6 10 14) (3 7 11 15)) (winning-cols 4))))

(describe "winning diagonal"
  (it "should return list of winning diagonal combinations if width is 3"
    (should= '((0 4 8) (2 4 6)) (winning-diagonals 3)))
  (it "should return list of winning diagonal combinations if width is 4"
    (should= '((0 5 10 15) (3 6 9 12)) (winning-diagonals 4))))

(describe "determine winner"
	(it "should return winner marker if player won"
		(should= true (determine-winner X-first_row-win-board X 3)))
	(it "should return winner marker if player won"
		(should= true (determine-winner O-second-row-win-board O 3))))
