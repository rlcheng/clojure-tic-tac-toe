(ns tic-tac-toe.ui
  (:require [tic-tac-toe.board :as board]))

(def error-message "Bad input, please try again.")

(defn go-first? [prompt output]
  (let [input (prompt "Do you want to go first? y/n")]
    (if (or (= input "y") (= input "n"))
      input
      (do
        (output error-message)
        (recur prompt output)))))

(defn print-board [board output]
  (output board))

(defn get-position [board prompt output]
  (let [input (prompt "Place your move")
        start-index 0
        last-index (dec (count board))]
    (if (board/valid-position? board input)
      (read-string input)
      (do
        (output error-message)
        (recur board prompt output)))))
