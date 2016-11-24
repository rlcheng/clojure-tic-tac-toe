(ns tic-tac-toe.board-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.board :refer :all]))

(def empty-board [" " " " " " " " " " " " " " " " " "])
(def X "X")
(def O "O")
(def test-board [X " " " " " " " " " " " " " " " "])

(describe "create board array"
  (it "should create a board array with size of 9"
    (should= empty-board (init))))

(describe "place-marker"
  (it "should place a marker"
    (should= [X " " " " " " " " " " " " " " " "] (place-marker empty-board 0 X)))
  (it "should not place marker if position is not empty"
    (should= nil (place-marker test-board 0 O))))
