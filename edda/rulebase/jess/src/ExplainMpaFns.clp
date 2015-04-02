(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/EddaTemplates)

(defrule list-mpa-fns "report the fns"
  (declare (salience 150))
  (goal (name "explain-mpa"))
  ?citation <- (Citation (isActivated 1) 
                         (actualClassification ?actual&:(eq ?actual "include"))
                         (predictedClassification ?predicted&:(eq ?predicted "exclude"))
                         (lastRuleApplied ?lastRule&:(eq ?lastRule
			 		  		  "pico-classify-exclude-not-mpa"))
                         (path ?pathToCitation))

  =>
  (modify ?citation (isActivated 0))
  (printout t ?pathToCitation crlf))

(defrule recind-mpa-fns "quit reporting"
  (declare (salience 100))
  (goal (name "explain-mpa"))
  =>
  (printout t "done with mpa search" crlf))

(deffunction explain-mpas () "explain the mpa false negatives"
  (activate-citations)
  (assert (goal (name "explain-mpa")))
  (run))

(provide C:/Users/kjm84/git/edda/edda/rulebase/jess/src/ExplainMpaFns)