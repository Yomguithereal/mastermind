;;---------------------------------------
;; Mastermind Game Operator
;;---------------------------------------
;;
;; Author: Yomguithereal
;;

;; Namespace
(ns mastermind.game
  (:require clojure.string)
  (:require clojure.set)
  (:use mastermind.checker)
  (:use mastermind.colors))

;; Constants
(def colors '("red" "green" "blue" "yellow" "orange"))

;; Declarations
(declare main-loop)
(declare exiting?)
(declare winning?)
(declare printable-guess)
(declare wrong-input)
(declare game-won)
(declare end-of-game)

(declare create-secret)
(declare parse-proposition)
(declare check-proposition)

;; Game Operations
(defn launch-game
  "Game Launcher"
  []
  (let [game-settings {:secret (create-secret)
                       :nb-positions 4
                       :nb-colors 5}]                   
    (println "Starting Game...")
    (println (str "Secret : [" (clojure.string/join (repeat (game-settings :nb-positions) "X")) "]"))
    (main-loop game-settings)))

(defn main-loop
  "Main Game Loop"
  [game-settings]
  (do
    (print "Your Guess : ")
    (flush)
    (let [input (read-line)]
      (if (exiting? input)
        (end-of-game)
        ((let [guess (parse-proposition input)]
          (if (check-proposition guess (game-settings :nb-positions))
              (println (printable-guess guess) (check-guess guess (game-settings :secret)))
              (wrong-input)))
        (main-loop game-settings))))))

(defn exiting?
  "Check whether the user want to quit."
  [input]
  (or (= input "exit") (= input "quit")))

(defn winning?
  "Has the player won the game?"
  [score]
  (= [4 0] score))

(defn printable-guess
  "Print the user's guess with fancy colors"
  [guess]
  (apply str (map #(background-color "  " (keyword %)) guess)))

(defn wrong-input
  "When user delivers a wrongly written input"
  []
  (print "Wrong Input."))

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
  (map (fn [x] (rand-nth colors)) (range 0 4)))

(defn parse-proposition
  "Parse the proposition made by user"
  [proposition]
  (if (nil? (some #(= \, %) (vec proposition)))
    (let [color-map (zipmap '(\r \g \b \y \o) colors)]
      (mapv #(color-map %) (vec proposition)))
    (mapv #(clojure.string/trim %) (clojure.string/split proposition #","))))

(defn check-proposition
  "Check whether the proposition made by user is correct or not"
  [guess nb-positions]
  (and (= (count guess) nb-positions) (= 0 (count (clojure.set/difference (set guess) (set colors))))))