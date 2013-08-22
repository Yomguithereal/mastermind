(ns mastermind.test.game
    (:use [mastermind.game])
    (:use [clojure.test]))

(def basic-guess ["red" "blue" "orange"])

(deftest exiting?-test
    (is (= true (exiting? "quit")))
    (is (= true (exiting? "exit")))
    (is (= false (exiting? "test")))
    (is (= false (exiting? 4))))

(deftest parse-proposition-test
    (is (= basic-guess (parse-proposition "red,blue,orange")))
    (is (= basic-guess (parse-proposition "red, blue, orange ")))
    (is (= basic-guess (parse-proposition "rbo"))))