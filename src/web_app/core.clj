(ns web-app.core
  (:require [ring.adapter.jetty :as jetty]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :as route]
            [ring.util.response :as response]))

(defroutes app-routes
  (GET "/" [] (response/resource-response "index.html" {:root "public"}))
  (GET "/hello" [] "Hello World!")
  (route/resources "/")
  (route/not-found "Page not found"))

(defn -main []
  (jetty/run-jetty app-routes {:port 3000 :join? false})
  (println "Server started on http://localhost:3000"))