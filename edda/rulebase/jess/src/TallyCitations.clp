(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/EddaTemplates)

(defrule tally-citations-0 
    "finds the frequency of citations in each category"
    (declare (salience 100))
    ?g <- (goal (name tally-citations))
    ?citation <- (Citation (partition ?p) (actualClassification ?c) (isActivated 1))
    ?counter <- (citation-counter (partition ?p) (actual-classification ?c))
    =>
    (modify ?citation (isActivated 0))
    (modify ?counter (frequency (+ (fact-slot-value ?counter frequency) 1))))

(defrule tally-citations-1
    "finds the frequency of citations in each category"
    (declare (salience 50))
    ?g <- (goal (name tally-citations))
    ?counter <- (citation-counter (partition ?p) (actual-classification ?c) (frequency ?f))
    =>
    (printout t "Partition " ?p " classification " ?c " has frequency of " ?f crlf)
    (retract ?counter))

(defrule tally-citations-2
    "retracts the goal to tally citations"
    (declare (salience 25))
    ?g <- (goal (name tally-citations))
    =>
    (retract ?g))
 
(deffunction tally-citations () "runs the tally citations suite of rules"
    (printout t "tallying citations" crlf)
    (assert (citation-counter (partition "train") (actual-classification "include")))
    (assert (citation-counter (partition "test") (actual-classification "include")))
    (assert (citation-counter (partition "train") (actual-classification "exclude")))
    (assert (citation-counter (partition "test") (actual-classification "exclude")))
    (assert (goal (name tally-citations)))
    (run)
    (printout t "finished tallying citations" crlf))  

(provide C:/Users/kjm84/git/edda/edda/rulebase/jess/src/TallyCitations)
