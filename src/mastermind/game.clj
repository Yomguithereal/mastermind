;;---------------------------------------
;; Mastermind Game Operator
;;---------------------------------------
;;
;; Author: Yomguithereal
;;

;; Namespace
(ns mastermind.game
    (:require clojure.string))

;; Declarations
(declare main-loop)
(declare exiting?)
(declare end-of-game)

(declare create-secret)
(declare parse-proposition)

;; Game Operations
(defn launch-game
    "Game Launcher"
    []
    (let [game-settings {:secret (create-secret)}]
        (println "Starting Game...")
        (main-loop game-settings)))

(defn main-loop
    "Main Game Loop"
    [game-settings]
    (let [input (read-line)]
        (if (exiting? input)
            (end-of-game)
            ((println input) (main-loop game-settings)))))

(defn exiting?
    "Check whether the user want to quit."
    [input]
    (or (= input "exit") (= input "quit")))

(defn game-won
    "Winning the game hook"
    []
    (println "You Won!")
    (end-of-game))

(defn end-of-game
    "Final game hook"
    []
    (println "Bye.")
    (System/exit 0))


;; Utilities
(defn create-secret
    "Randomly generates the secret of the game"
    []
    (let [colors '("red" "green" "blue" "yellow" "orange")]
        (map (fn [x] (rand-nth colors)) (range 0 4))))

(defn parse-proposition
    "Parse the proposition made by user"
    [proposition]
    (vec (map #(clojure.string/trim %) (clojure.string/split proposition #","))))