(ns tic-tac-toe.human-player
  (:require [tic-tac-toe.board :as board]
            [tic-tac-toe.ui-console :as ui-console]))

(defn move [board marker]
  (let [position (ui-console/get-position board)]
    (board/place-marker board position marker)))
