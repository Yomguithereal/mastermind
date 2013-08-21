(ns mastermind.test.game
    (:use [mastermind.game])
    (:use [clojure.test]))

(deftest exiting
    (is (= true (exiting? "quit")))
    (is (= true (exiting? "exit")))
    (is (= false (exiting? "test")))
    (is (= false (exiting? 4))))