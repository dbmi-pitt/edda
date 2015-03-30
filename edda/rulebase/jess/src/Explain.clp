(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/EddaTemplates)

(defrule count-fired-rule-correct "count the times correct"
  (declare (salience 150))
  (goal (name "explain"))
  ?rg <- (rule-goal (name ?firedRule) (priority ?priorityOne) (isActivated 1))
  ?c <- (accumulate (bind ?count 0)                        ;; initializer
                    (bind ?count (+ ?count 1))             ;; action
                    ?count                                 ;; result
                    (Citation
                         (predictedClassification ?pCls)
                         (actualClassification ?aCls&:(eq ?pCls ?aCls))
                         (lastRuleApplied ?firedRule)))
   (not (rule-goal (name ?otherFiredRule) (priority ?priorityTwo&:(> ?priorityOne ?priorityTwo)) (isActivated 1)))
  =>
  (modify ?rg (tns ?c))
;;  (printout t ?firedRule " was correct " ?c " times" crlf)
)

(defrule count-fired-rule-error
  (declare (salience 125))
  (goal (name "explain"))
  ?rg <- (rule-goal (name ?firedRule) (priority ?priorityOne) (isActivated 1))
  ?c <- (accumulate (bind ?count 0)                        ;; initializer
                    (bind ?count (+ ?count 1))             ;; action
                    ?count                                 ;; result
                    (Citation
                         (predictedClassification ?pCls)
                         (actualClassification ?aCls&:(neq ?pCls ?aCls))
                         (lastRuleApplied ?firedRule)))
   (not (rule-goal (name ?otherFiredRule) (priority ?priorityTwo&:(> ?priorityOne ?priorityTwo)) (isActivated 1)))
  =>
  (modify ?rg (fns ?c))
;;  (printout t ?firedRule " was wrong " ?c " times" crlf)n
)

(defrule calculate-specificity "fns / fns + tns"
  (declare (salience 100))
  (goal (name "explain"))
  ?rg <- (rule-goal (name ?firedRule) 
                    (priority ?priorityOne) 
                    (tns ?tns)
                    (fns ?fns)
                    (isActivated 1))
  (not (rule-goal (name ?otherFiredRule) (priority ?priorityTwo&:(> ?priorityOne ?priorityTwo)) (isActivated 1)))
  =>
   (modify ?rg (isActivated 0))
   (bind ?denom (+ ?tns ?fns))
   (if (< ?denom 1) then (bind ?denom 1))
   (printout t ?firedRule ": tns = " ?tns " fns = " ?fns crlf)
   (printout t ?firedRule ": (negative predictive value " (/ ?tns ?denom) ")" crlf))
                            

(defrule done-explaining "done explaining"
  (declare (salience 90))
  ?g <- (goal (name "explain"))
=>
  (retract ?g))

(deffunction explain () "explain what each rule did"
   (assert (goal (name "explain")))
   (run)
;;   (printout t "done explaining " crlf)
)

(provide C:/Users/kjm84/git/edda/edda/rulebase/jess/src/Explain)