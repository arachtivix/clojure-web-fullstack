(defproject web-app "0.1.0"
  :description "Simple Clojure web application"
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [ring/ring-core "1.9.6"]
                 [ring/ring-jetty-adapter "1.9.6"]
                 [compojure "1.7.0"]]
  :main web-app.core
  :profiles {:dev {:dependencies [[ring/ring-devel "1.9.6"]]}})