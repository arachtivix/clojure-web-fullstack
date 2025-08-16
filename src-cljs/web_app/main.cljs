(ns web-app.main
  (:require [cljs.reader :as reader]))

(defn fetch-data []
  (-> (js/fetch "/api/data")
      (.then #(.text %))
      (.then #(reader/read-string %))
      (.then display-data)
      (.catch #(js/console.error "Error fetching data:" %))))

(defn display-data [data]
  (let [container (js/document.getElementById "data-container")
        users (:users data)
        timestamp (:timestamp data)]
    (set! (.-innerHTML container)
          (str "<h3>Users (loaded at " timestamp ")</h3>"
               "<ul>"
               (apply str (map #(str "<li>" (:name %) " - " (:email %) "</li>") users))
               "</ul>"))))

(defn init []
  (js/console.log "ClojureScript loaded!")
  (let [button (js/document.getElementById "load-data")]
    (.addEventListener button "click" #(fetch-data))))

(init)