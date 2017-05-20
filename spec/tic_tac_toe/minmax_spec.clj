(ns tic-tac-toe.minmax-spec
  (:require [speclj.core :refer :all]
            [tic-tac-toe.board :refer :all]
            [tic-tac-toe.minmax :refer :all]))

(def empty-board-3x3
  [space space space
   space space space
   space space space])

(def O-center-3x3
  [space space space
   space O space
   space space space])

(def O-win-3x3
  [O O O
   space space space
   space space space])

(def O-almost-win-3x3
  [O O space
   X space space
   X space space])

(def O-two-from-win-3x3
  [O space space
   X O space
   space space X])

(def X-one-from-win-3x3
  [X O X
   O X X
   space space O])

(describe "minmax"
  (it "should return middle position if board is empty"
    (should= 0 (get-position empty-board-3x3 X)))
  (it "should return a corner position if center is taken"
    (should= 0 (get-position O-center-3x3 X)))
  (it "should return the winning move"
    (should= 2 (get-position O-almost-win-3x3 X)))
  (it "should return move that sets up two wining paths"
    (should= 1 (get-position O-two-from-win-3x3 O)))
  (it "should return move that blocks opponent from winning"
    (should= 6 (get-position X-one-from-win-3x3 O))))
