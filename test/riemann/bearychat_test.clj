(ns riemann.bearychat-test
  (:require [clojure.test :refer :all]
            [riemann.bearychat :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (let [webhook_url "https://hook.bearychat.com/XXXXX"
          event {:host "host" :service "service > <" :state "ok" :description "hahaha" :metric 12 :tag ["index"]}]
      ((bearychat webhook_url) event))))
