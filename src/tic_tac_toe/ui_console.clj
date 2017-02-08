(ns tic-tac-toe.ui-console
  (:require [tic-tac-toe.board :as board]))

(defn- prompt [message]
  (println message)
  (read-line))

(defn go-first? []
  (let [input (prompt "Do you want to go first? y/n")]
    (if (or (= input "y") (= input "n"))
      input
      (recur))))

(defn- replace-space [board]
  (map (fn[x] (clojure.string/replace x board/space "_")) board))

(defn print-board [board]
  (let [width (board/get-width board)
        replaced-board (replace-space board)]
    (doseq [row (partition width replaced-board)]
      (apply println row))))
