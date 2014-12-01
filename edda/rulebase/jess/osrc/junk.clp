
(deffunction newAvPair (?attr ?val ?uom)
    (bind ?avPair (assert (av-pair (attribute ?attr) (value ?val) (uom ?uom))))
    (bind ?avPairID (call ?avPair getFactId))
    (modify ?avPair (ID ?avPairID)))
(deffunction ppAvPair (?avPair)
    (printout t "av-pair instance" crlf)
    (printout t  "	ID = " (fact-slot-value ?avPair ID) crlf)
    (printout t  "	attribute = " (fact-slot-value ?avPair attribute) crlf)
    (printout t  "	value = " (fact-slot-value ?avPair value) crlf)
    (printout t  "	uom = " (fact-slot-value ?avPair uom) crlf))
 
;;(list-deftemplates)
 (ppdeftemplate av-pair)
(reset)
(bind ?ford01  (assert (automobile (make ford)(model festiva)(year 2011)(color black) (msrp 16250.00))))
(bind ?ford02  (assert (automobile (make ford)(model taurus)(year 2013)(color gray) (msrp 22500.00))))

(printout t (fact-slot-value ?ford01 color) crlf)

(reset)
(facts)

(deffunction runSample () 
    (assert (automobile (model LeBaron) (make Chrysler)(year 1997))))

(bind ?avpair (assert (av-pair (attribute tmn) (value T1N0MX))))
(fact-id ?avpair)
