;;---------------------------------------
;; Mastermind Guess Checker
;;---------------------------------------
;;
;; Author: Yomguithereal
;;

;; Namespace
(ns mastermind.checker)

(defn check-precise
  "Get the number of correct guesses"
  [guess secret]
  (count (filter true? (map = guess secret))))

(defn check-blurry
  "Get the number of blurry guesses"
  [guess secret]
  (reduce + (for [guess-color-map (frequencies guess)
    secret-color-map (frequencies secret)
    :when (= (key guess-color-map) (key secret-color-map))]
    (min (val guess-color-map) (val secret-color-map)))))

(defn check-guess
  "Get the score"
  [guess secret]
  (let [precise (check-precise guess secret)
    blurry (check-blurry guess secret)]
    [precise (- blurry precise)]))