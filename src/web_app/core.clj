(ns web-app.core
  (:require [ring.adapter.jetty :as jetty]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :as route]
            [ring.util.response :as response]))

(defroutes app-routes
  (GET "/" [] (response/resource-response "index.html" {:root "public"}))
  (GET "/hello" [] "Hello World!")
  (GET "/api/data" [] 
    (-> {:users [{:id 1 :name "Alice" :email "alice@example.com"}
                 {:id 2 :name "Bob" :email "bob@example.com"}
                 {:id 3 :name "Charlie" :email "charlie@example.com"}]
         :timestamp (java.util.Date.)}
        pr-str
        response/response
        (response/content-type "application/edn")))
  (route/resources "/")
  (route/not-found "Page not found"))

(defn -main []
  (jetty/run-jetty app-routes {:port 3000 :join? false})
  (println "Server started on http://localhost:3000"))