(ns riemann.bearychat
  "Post alerts to bearychat"
  (:require [clj-http.client :as client]
            [cheshire.core :as json])
  (:use [clojure.string :only [escape join upper-case]]))

(defn bearychat-escape [message]
  (escape message {\< "&lt;" \> "&gt;" \& "&amp;"}))

(defn default-formatter [event]
  {:text        "Attention!"
   :attachments [
                 {:title "Riemann Event"
                  :text  (bearychat-escape
                           (str "Host:   " (or (:host event) "-") "\n"
                             "Service:   " (or (:service event) "-") "\n"
                             "State:   " (or (:state event) "-") "\n"
                             "Description:   " (or (:description event) "-") "\n"
                             "Metric:   " (or (:metric event) "-") "\n"
                             "Tag:   " (or (:tag event) "-") "\n"))}]})

(defn bearychat
  ([webhook_uri & {:keys [markdown channel formatter] :or {formatter default-formatter}}]
   (fn [event]
     (let [{:keys [text attachments]} (formatter event)]
       (client/post webhook_uri
         {:form-params
          {:payload (json/generate-string
                      (merge
                        (when text {:text text})
                        (when markdown {:markdown markdown})
                        (when channel {:channel channel})
                        (when attachments {:attachments attachments})))}})))))

