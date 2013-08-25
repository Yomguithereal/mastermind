;;---------------------------------------
;; Mastermind Main File
;;---------------------------------------
;;
;; Author: Yomguithereal
;;

;; Namespace
(ns mastermind.core
  (:use mastermind.game)
  (:gen-class :main true))

;; Launching
(defn -main
  []
  (println "\n------------------\nHello Mastermind !\n------------------")
  (launch-game))