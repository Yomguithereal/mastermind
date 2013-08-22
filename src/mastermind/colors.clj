;;---------------------------------------
;; Coloring output
;;---------------------------------------
;;
;; Author: Yomguithereal
;;

;; Namespace
(ns mastermind.colors)

(def __colors (zipmap [:black :red :green :yellow :blue :magenta :cyan :white] (range 0 8)))

(defn color
    "Return an ANSI colored string"
    [string color]
    (str "\033[3" (__colors color) "m" string "\033[0m"))

(defn background-color
    "Return an ANSI background colored string"
    [string color]
    (str "\033[4" (__colors color) "m" string "\033[0m"))