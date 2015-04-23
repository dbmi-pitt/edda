(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/EddaTemplates)

(defrule list-rule-fns "report the fns"
  (declare (salience 150))
  (goal (name "explain-rule-fns"))
  (rule-goal (name ?lastRule))
  ?citation <- (Citation (isActivated 1) 
                         (actualClassification ?actual&:(eq ?actual "include"))
                         (predictedClassification ?predicted&:(eq ?predicted "exclude"))
                         (lastRuleApplied ?lastRule)
                         (path ?pathToCitation))
  =>
  (modify ?citation (isActivated 0))
  (printout t ?pathToCitation crlf))

(defrule recind-rule-fns "quit reporting"
  (declare (salience 100))
  ?g <- (goal (name "explain-rule-fns"))
  ?rg <-  (rule-goal (name ?lastRule))
  =>
  (retract ?rg)
  (retract ?g)
  (printout t "done with " ?lastRule " reporting" crlf))

(deffunction explain-rule-fns (?ruleToExplain) "explain the rules false negatives"
  (activate-citations)
  (assert (goal (name "explain-rule-fns")))
  (assert (rule-goal (name ?ruleToExplain)))
  (run))

(provide C:/Users/kjm84/git/edda/edda/rulebase/jess/src/ExplainRuleFns)