(ns tic-tac-toe.human-player
  (:require [tic-tac-toe.board :as board]
            [tic-tac-toe.ui :as ui]))

(defn move [board marker prompt output]
  (let [position (ui/get-position board prompt output)]
    (board/place-marker board position marker)))
