(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/EddaTemplates)

(defrule recind-predictions-0 
    "activates all citations"
    (declare (salience 100))
    ?g <- (goal (name recind-predictions))
    ?citation <- (Citation (predictedClassification ?p&:(neq ?p "NA")))
 =>
    (modify ?citation (predictedClassification "NA")))
    
(defrule recind-predictions-1 
    "activates all citations"
    (declare (salience 50))
    ?g <- (goal (name recind-predictions))
 =>
    (retract ?g))
   
(deffunction recind-predictions () "activates all the citations"
    (printout t "recinding predictions" crlf)
    (assert (goal (name recind-predictions)))
    (run)
    (printout t "finished recinding predictions" crlf))  

(provide C:/Users/kjm84/git/edda/edda/rulebase/jess/src/RecindPredictions)
