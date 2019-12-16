(ns clj-pdf-metabase.core
  ; (:use clj-pdf.core)
  (:require [dk.ative.docjure.spreadsheet :as spreadsheet]
    [clj-pdf.core :as pdf])
  (:import [java.io ByteArrayInputStream ByteArrayOutputStream File])
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

(defn tableCreator[column-names & rows]
  ; (println column-names)
  ; (println rows)
  [:table rows]
  )

(defn -m21[]

  (println "In m21...")
  
  )

(defn -ExcelCreation[]

  (let [
    column-names ["c1" "c2"]
    rows [
      ["v1" "v12"]
      ["v2" "v22"]
      ["v3" "v32"]
    ]
    wb (spreadsheet/create-workbook "Price List"
    ; [["Name" "Price"]
    ;  ["Foo Widget" 100]
    ;  ["Bar Widget" 200]]
    (cons (mapv name column-names) rows)
     )
    ; sheet (spreadsheet/select-sheet "Price List" wb)
    ; header-row (first (spreadsheet/row-seq sheet))
    ]
    ; (spreadsheet/set-row-style! header-row (spreadsheet/create-cell-style! wb {:background :yellow,
    ;                               :font {:bold true}}))
    (spreadsheet/save-workbook! "foo.xlsx" wb)
    ; (tableCreator column-names rows)
  ; (apply tableCreator rows)
    (pdf/pdf [
      {:orientation :landscape}

      ; (apply tableCreator rows)
      [:table ["v1" "v12"]
      ["v2" "v22"]
      ["v3" "v32"]]

      ; (let [[i1 & all] rows]
      ;   [:table all]
      ; )

    ]
     
    
      "foo.pdf")
    )

  )

(defn -PdfCreation[]
  (def out (ByteArrayOutputStream.))
  (pdf/pdf [{} "first document"] out)
  (ByteArrayInputStream. (.toByteArray out))
  (println "PDF creation done...")
  )

(defn -PdfFile[]

  (def column-names ["c1" "c2"])
  (def rows [
    ["v1" "v12"]
    ["v2" "v22"]
    ["v3" "v32"]
    ; [1 2]
    ; [3 4]
    ; [4 5]
  ]) 

  ; (for [x (range 1 10)]
  ;   (do (println x) x))

  ; (loop [x 10]
  ;   (when (> x 1)
  ;      (println x)
  ;      (recur (- x 2))))

  (pdf/pdf [
    {:orientation :landscape}

    ; (apply tableCreator rows)
    ; [:table (flatten rows)]

    (into
      [:table {:header column-names}]
       (for [row rows]
         [
          
         
        ;  (let [[c1 c2] row]            
        ;     [:cell c1])
        ; [:cell "c1"]
        ; [:cell "c2"]
      (into      
        
        [:cell]
        (for [c row]
          c)
        
        
      )]))
          
      ; (for [c row]
      ;     [:cell c])
          
          
      ;       ]))
    
    ; (let [[i1 & all] rows]
    ;   [:table all]
    ; )

  ]
    "foo.pdf")
  

  
  )

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Starting...")
  (-PdfFile)
  ; (-m21)
  ; (-ExcelCreation)
  ; (def a "a1")
  ; (println a)
  ; (-PdfCreation)
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
  


  ; (pdf-table 
  ;   [10 20 15]
  ;   ["foo" [:chunk {:style :bold} "bar"] [:phrase "baz"]]
  ;   ["foo" "foo" "foo"]
  ;   ["foo" "foo" "foo"])


  ; (spreadsheet/create-workbook "Query result")
  ; (spreadsheet/save-workbook! "foo.xlsx")

  (println "Stopping...")
  )

