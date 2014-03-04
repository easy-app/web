(require '[easy-app.web :as web :refer [Get send]])
(require '[easy-app.web.server.jetty :as jetty])

(Get "/" :fn (fn [] (send "Hello world!")))

(Get "/{greeting}"
  :args [:http-req]
  :fn (fn [{g :greeting}]
        (send (str g " world!"))))

(jetty/run (web/dev-request-handler)
           {:port 3000})
