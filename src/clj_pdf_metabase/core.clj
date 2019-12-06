(ns clj-pdf-metabase.core
  (:use clj-pdf.core)
  (:gen-class))

; (def msg1
;     (println "Hello GP!")
;     )

(defn pdf-table [column-widths & rows]
  (into
    [:pdf-table column-widths]
    (map (partial map (fn [element] [:pdf-cell element])) rows)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ; (msg1)
  (println "Starting...")
  ; (pdf
  ;   [{}
  ;    [:list {:roman true}
  ;           [:chunk {:style :bold} "a bold item"]
  ;           "another item"
  ;           "yet another item"]
  ;    [:phrase "some text"]
  ;    [:phrase "some more text"]
  ;    [:paragraph "yet more text"]]
  ;   "doc.pdf")
  (pdf [
    {:orientation :landscape}
    ; [:table {:header ["Name" "ID" "Make" "Model" "Year"]}]
    ; ]
    [:table      
      ["v11" "v12" "v13"]
      ["v21" "v22" "v23"]]
  ]
    "foo.pdf")

  ; (pdf-table 
  ;   [10 20 15]
  ;   ["foo" [:chunk {:style :bold} "bar"] [:phrase "baz"]]
  ;   ["foo" "foo" "foo"]
  ;   ["foo" "foo" "foo"])

  (println "Stopping...")
  )

