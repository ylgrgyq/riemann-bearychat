(defproject riemann-bearychat "0.1.0-SNAPSHOT"
  :description "riemann output plugin for bearychat"
  :url "https://bearychat.com/"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [clj-http "1.0.1" :exclusions [org.clojure/tools.reader]]
                 [cheshire "5.4.0"]
                 [riemann "0.2.10-SNAPSHOT"]]
  )

