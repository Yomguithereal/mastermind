(ns mastermind.test.game
  (:use [mastermind.game])
  (:use [clojure.test]))

(def basic-guess ["red" "blue" "orange"])

(deftest exiting?-test
  (is (= true (exiting? "quit")))
  (is (= true (exiting? "exit")))
  (is (= false (exiting? "test")))
  (is (= false (exiting? 4))))

(deftest winning?-test
  (is (= true (winning? [4 0])))
  (is (= false (winning? [3 0])))
  (is (= false (winning? [0 4]))))

(deftest parse-proposition-test
  (is (= basic-guess (parse-proposition "red,blue,orange")))
  (is (= basic-guess (parse-proposition "red, blue, orange ")))
  (is (= basic-guess (parse-proposition "rbo"))))

(deftest check-proposition-test
  (is (= true (check-proposition ["blue" "red" "orange" "yellow"] 4)))
  (is (= false (check-proposition ["blue" "red" "orange"] 4)))
  (is (= false (check-proposition ["inexistant-color" "red" "orange" "yellow"] 4))))