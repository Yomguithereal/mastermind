(ns mastermind.test.checker
    (:use [mastermind.checker])
    (:use [clojure.test]))

(def secret ["red" "blue" "green" "orange"])
(def secret-redundant ["red" "red" "red" "orange"])

(deftest precise
    (is (= 4 (check-precise ["red" "blue" "green" "orange"] secret)))
    (is (= 3 (check-precise ["blue" "blue" "green" "orange"] secret)))
    (is (= 2 (check-precise ["blue" "blue" "green" "blue"] secret)))
    (is (= 1 (check-precise ["green" "red" "green" "blue"] secret)))
    (is (= 0 (check-precise ["orange" "orange" "orange" "green"] secret))))

(deftest blurry
    (is (= 4 (check-blurry ["red" "green" "blue" "orange"] secret)))
    (is (= 3 (check-blurry ["yellow" "blue" "green" "red"] secret)))
    (is (= 2 (check-blurry ["blue" "yellow" "green" "green"] secret)))
    (is (= 1 (check-blurry ["yellow" "yellow" "yellow" "blue"] secret)))
    (is (= 0 (check-blurry ["yellow" "yellow" "yellow" "yellow"] secret))))

(deftest total
    (is (= [4 0] (check-guess ["red" "blue" "green" "orange"] secret)))
    (is (= [3 0] (check-guess ["red" "blue" "orange" "orange"] secret)))
    (is (= [0 4] (check-guess ["blue" "red" "orange" "green"] secret)))
    (is (= [0 3] (check-guess ["blue" "red" "yellow" "green"] secret))))