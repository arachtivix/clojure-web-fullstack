(defproject web-app "0.1.0"
  :description "Simple Clojure web application"
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.clojure/clojurescript "1.11.60"]
                 [ring/ring-core "1.9.6"]
                 [ring/ring-jetty-adapter "1.9.6"]
                 [compojure "1.7.0"]]
  :main web-app.core
  :plugins [[lein-cljsbuild "1.1.8"]]
  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src-cljs"]
                        :compiler {:output-to "resources/public/js/main.js"
                                   :optimizations :advanced
                                   :main web-app.main}}]}
  :profiles {:dev {:dependencies [[ring/ring-devel "1.9.6"]]}
             :uberjar {:cljsbuild {:builds [{:id "prod"
                                             :source-paths ["src-cljs"]
                                             :compiler {:output-to "resources/public/js/main.js"
                                                        :optimizations :advanced}}]}}})