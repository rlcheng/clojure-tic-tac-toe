(ns tic-tac-toe.minmax-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.board :refer :all]
            [tic-tac-toe.minmax :refer :all]))

(def empty-board-3x3
  [space space space
   space space space
   space space space])

(def O-board-3x3
  [O O O
   space space space
   space space space])

(describe "minmax"
  (it "should return middle position if board is empty"
    (should= 4 (get-position empty-board-3x3 X))))

(describe "score"
	(it "should return score of win of current player"
		(should= 10 (score O-board-3x3 O X 0)))
	(it "should return score of win of other player"
		(should= -10 (score O-board-3x3 X O 0)))
	(it "should return score of 0 if no winner"
		(should= 0 (score empty-board-3x3 X O 0)))
  (it "should return score when depth is more than zero"
    (should= 8 (score O-board-3x3 O X 2))))

(describe "scores"
  (it "should do stuff"
    (should= 0 (scores O-board-3x3 O 0))))
