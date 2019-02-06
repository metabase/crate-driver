(defproject metabase/crate-driver "1.0.0-crate-jdbc-2.3.0"
  :min-lein-version "2.5.0"

  :dependencies
  [[io.crate/crate-jdbc "2.3.0"
    :exclusions [com.fasterxml.jackson.core/jackson-core
                 org.slf4j/slf4j-api]]]

  :repositories
  [["bintray" "https://dl.bintray.com/crate/crate"]] ; Repo for Crate JDBC driver

  :profiles
  {:provided
   {:dependencies
    [[org.clojure/clojure "1.10.0"]
     [metabase-core "1.0.0-SNAPSHOT"]]}

   :uberjar
   {:auto-clean    true
    :aot           :all
    :omit-source   true
    :javac-options ["-target" "1.8", "-source" "1.8"]
    :target-path   "target/%s"
    :uberjar-name  "crate.metabase-driver.jar"}})
