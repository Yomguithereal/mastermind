(ns mastermind.test.game
    (:use [mastermind.game])
    (:use [clojure.test]))

(def basic-guess ["red" "blue" "purple"])

(deftest exiting?-test
    (is (= true (exiting? "quit")))
    (is (= true (exiting? "exit")))
    (is (= false (exiting? "test")))
    (is (= false (exiting? 4))))

(deftest parse-proposition-test
    (is (= basic-guess (parse-proposition "red,blue,purple")))
    (is (= basic-guess (parse-proposition "red, blue, purple ")))
    (is (= basic-guess (parse-proposition "rbp"))))

(deftest check-proposition-test
    (is (= true (check-proposition ["blue" "red" "purple" "yellow" "cyan"])))
    (is (= false (check-proposition ["blue" "red" "purple"])))
    (is (= false (check-proposition ["inexistant-color" "red" "purple" "yellow"]))))