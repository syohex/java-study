(defn read-input [file]
  (->> (clojure.java.io/reader file)
       (line-seq)
       (map read-string)))

(defn problem1 [nums]
  (->> (map < nums (rest nums))
       (filter true?)
       (count)))

;; 7
(let [test '(199 200 208 210 200 207 240 269 260 263)]
  (problem1 test))

;; 1448
(->> (read-input "input.txt")
     (problem1)
     (println "answer1: "))

(defn problem2 [nums]
  (->> (map + nums (next nums) (nnext nums))
       (problem1)))

;; 1471
(->> (read-input "input.txt")
     (problem2)
     (println "answer2: "))
