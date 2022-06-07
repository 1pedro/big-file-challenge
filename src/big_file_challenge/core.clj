(ns big-file-challenge.core)

(def my-store (atom {}))
(defn process-file
  ([filename fn ]
   (process-file filename fn (atom {})))
  ([filename fn store]
   (with-open [rdr (clojure.java.io/reader filename)]
     (doseq [line (line-seq rdr)]
       (fn line store)))))


(defn update-count
  [line store]
  (swap! store assoc-in [line] (inc (get @store line 0))))


(defn -main [& _]
  (process-file "/tmp/testing2.txt" update-count my-store)
  (doseq [[k v] (into [] @my-store)]
    (println k v)))