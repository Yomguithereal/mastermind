;;---------------------------------------
;; Mastermind Game Operator
;;---------------------------------------
;;
;; Author: Yomguithereal
;;

;; Namespace
(ns mastermind.game)

(declare main-loop)
(declare exiting?)
(declare create-secret)
(declare end-of-game)

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

(defn create-secret
    "Randomly generates the secret of the game"
    []
    (let [colors '("red" "green" "blue" "yellow" "orange")]
        (map (fn [x] (rand-nth colors)) (range 0 4))))

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