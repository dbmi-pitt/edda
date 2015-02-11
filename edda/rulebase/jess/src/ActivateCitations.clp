(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/EddaTemplates)

(defrule activate-citations-0 
    "activates all citations"
    (declare (salience 100))
    ?g <- (goal (name activate-citations))
    ?citation <- (Citation (isActivated 0))
 =>
    (modify ?citation (isActivated 1)))
    
(defrule activate-citations-1 
    "activates all citations"
    (declare (salience 50))
    ?g <- (goal (name activate-citations))
 =>
    (retract ?g))
   
(deffunction activate-citations () "activates all the citations"
    (printout t "activating citations" crlf)
    (assert (goal (name activate-citations)))
    (run)
    (printout t "finished activating citations" crlf))  

(provide C:/Users/kjm84/git/edda/edda/rulebase/jess/src/ActivateCitations)
