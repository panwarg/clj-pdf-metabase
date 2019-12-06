(ns clj-pdf-metabase.core
  (:use clj-pdf.core)
  (:require [dk.ative.docjure.spreadsheet :as spreadsheet])
  (:gen-class))

  

; (def msg1
;     (println "Hello GP!")
;     )

(defn export-to-xlsx-file
  "Write an XLS file to `file` with the header a and rows found in `results`"
[]
          (println "Starting export-to-xlsx-file...")
          (spreadsheet/create-workbook "Query result")
          (spreadsheet/save-workbook! "foo.xlsx"))

(defn pdf-table [column-widths & rows]
  (into
    [:pdf-table column-widths]
    (map (partial map (fn [element] [:pdf-cell element])) rows)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ; (msg1)
  (let [
    column-names ["Name" "Price"]
    rows ["Foo Widget" 100]
    wb (spreadsheet/create-workbook "Price List"
    [["Name" "Price"]
     ["Foo Widget" 100]
     ["Bar Widget" 200]])
    ; sheet (spreadsheet/select-sheet "Price List" wb)
    ; header-row (first (spreadsheet/row-seq sheet))
    ]
    ; (spreadsheet/set-row-style! header-row (spreadsheet/create-cell-style! wb {:background :yellow,
    ;                               :font {:bold true}}))
    (spreadsheet/save-workbook! "foo.xlsx" wb))

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
    {:header ["c1" "c2" "c3"]}
      ["v11" "v12" "v13"]
      ["v21" "v22" "v23"]]
  ]
    "foo.pdf")

  ; (pdf-table 
  ;   [10 20 15]
  ;   ["foo" [:chunk {:style :bold} "bar"] [:phrase "baz"]]
  ;   ["foo" "foo" "foo"]
  ;   ["foo" "foo" "foo"])


  ; (spreadsheet/create-workbook "Query result")
  ; (spreadsheet/save-workbook! "foo.xlsx")

  (println "Stopping...")
  )

