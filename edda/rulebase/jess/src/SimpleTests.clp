(defrule count-bad-pub-type-successes
  (declare (salience 100))
  (goal (name "explain"))
  ?c <- (accumulate (bind ?count 0)                    ;; initializer
                (bind ?count (+ ?count 1))             ;; action
                ?count                                 ;; result
                (Citation
                    (predictedClassification ?pCls)
                    (actualClassification ?aCls&:(eq ?pCls ?aCls))
                    (lastRuleApplied "bad-pub-type")))
  =>
  (printout t "bad-pub-type was correct " ?c " times" crlf))

(defrule count-bad-pub-type-errors
  (declare (salience 100))
  (goal (name "explain"))
  ?c <- (accumulate (bind ?count 0)                    ;; initializer
                (bind ?count (+ ?count 1))             ;; action
                ?count                                 ;; result
                (Citation
                    (predictedClassification ?pCls)
                    (actualClassification ?aCls&:(neq ?pCls ?aCls))
                    (lastRuleApplied "bad-pub-type")))
  =>
  (printout t "bad-pub-type was wrong " ?c " times" crlf))

(defrule count-no-case-studies-successes
  (declare (salience 100))
  (goal (name "explain"))
  ?c <- (accumulate (bind ?count 0)                    ;; initializer
                (bind ?count (+ ?count 1))             ;; action
                ?count                                 ;; result
                (Citation
                    (predictedClassification ?pCls)
                    (actualClassification ?aCls&:(eq ?pCls ?aCls))
                    (lastRuleApplied "no-case-studies")))
  =>
  (printout t "no-case-studies was correct " ?c " times" crlf))

(defrule count-no-case-studies-errors
  (declare (salience 100))
  (goal (name "explain"))
  ?c <- (accumulate (bind ?count 0)                    ;; initializer
                (bind ?count (+ ?count 1))             ;; action
                ?count                                 ;; result
                (Citation
                    (predictedClassification ?pCls)
                    (actualClassification ?aCls&:(neq ?pCls ?aCls))
                    (lastRuleApplied "no-case-studies")))
  =>
  (printout t "no-case-studies was wrong " ?c " times" crlf))


(defrule count-only-infants-successes
  (declare (salience 100))
  (goal (name "explain"))
  ?c <- (accumulate (bind ?count 0)                    ;; initializer
                (bind ?count (+ ?count 1))             ;; action
                ?count                                 ;; result
                (Citation
                    (predictedClassification ?pCls)
                    (actualClassification ?aCls&:(eq ?pCls ?aCls))
                    (lastRuleApplied "only-infants")))
  =>
  (printout t "only-infants was correct " ?c " times" crlf))

(defrule count-only-infants-errors
  (declare (salience 100))
  (goal (name "explain"))
  ?c <- (accumulate (bind ?count 0)                    ;; initializer
                (bind ?count (+ ?count 1))             ;; action
                ?count                                 ;; result
                (Citation
                    (predictedClassification ?pCls)
                    (actualClassification ?aCls&:(neq ?pCls ?aCls))
                    (lastRuleApplied "only-infants")))
  =>
  (printout t "only-infants was wrong " ?c " times" crlf))

(defrule count-only-nonhumans-successes
  (declare (salience 100))
  (goal (name "explain"))
  ?c <- (accumulate (bind ?count 0)                    ;; initializer
                (bind ?count (+ ?count 1))             ;; action
                ?count                                 ;; result
                (Citation
                    (predictedClassification ?pCls)
                    (actualClassification ?aCls&:(eq ?pCls ?aCls))
                    (lastRuleApplied "only-nonhumans")))
  =>
  (printout t "only-nonhumans was correct " ?c " times" crlf))

(defrule count-only-nonhumans-errors
  (declare (salience 100))
  (goal (name "explain"))
  ?c <- (accumulate (bind ?count 0)                    ;; initializer
                (bind ?count (+ ?count 1))             ;; action
                ?count                                 ;; result
                (Citation
                    (predictedClassification ?pCls)
                    (actualClassification ?aCls&:(neq ?pCls ?aCls))
                    (lastRuleApplied "only-nonhumans")))
  =>
  (printout t "only-nonhumans was wrong " ?c " times" crlf))

(defrule count-no-mpa-blood-but-others-successes
  (declare (salience 100))
  (goal (name "explain"))
  ?c <- (accumulate (bind ?count 0)                    ;; initializer
                (bind ?count (+ ?count 1))             ;; action
                ?count                                 ;; result
                (Citation
                    (predictedClassification ?pCls)
                    (actualClassification ?aCls&:(eq ?pCls ?aCls))
                    (lastRuleApplied "no-mpa-blood-but-others")))
  =>
  (printout t "no-mpa-blood-but-others was correct " ?c " times" crlf))

(defrule count-no-mpa-blood-but-others-errors
  (declare (salience 100))
  (goal (name "explain"))
  ?c <- (accumulate (bind ?count 0)                    ;; initializer
                (bind ?count (+ ?count 1))             ;; action
                ?count                                 ;; result
                (Citation
                    (predictedClassification ?pCls)
                    (actualClassification ?aCls&:(neq ?pCls ?aCls))
                    (lastRuleApplied "no-mpa-blood-but-others")))
  =>
  (printout t "no-mpa-blood-but-others was wrong " ?c " times" crlf))

;;
;; include-all-others
;;
(defrule count-include-all-others-successes
  (declare (salience 100))
  (goal (name "explain"))
  ?c <- (accumulate (bind ?count 0)                    ;; initializer
                (bind ?count (+ ?count 1))             ;; action
                ?count                                 ;; result
                (Citation
                    (predictedClassification ?pCls)
                    (actualClassification ?aCls&:(eq ?pCls ?aCls))
                    (lastRuleApplied "include-all-others")))
  =>
  (printout t "include-all-others was correct " ?c " times" crlf))

(defrule count-include-all-others-errors
  (declare (salience 100))
  (goal (name "explain"))
  ?c <- (accumulate (bind ?count 0)                    ;; initializer
                (bind ?count (+ ?count 1))             ;; action
                ?count                                 ;; result
                (Citation
                    (predictedClassification ?pCls)
                    (actualClassification ?aCls&:(neq ?pCls ?aCls))
                    (lastRuleApplied "include-all-others")))
  =>
  (printout t "include-all-others was wrong " ?c " times" crlf))

(defrule finished-explaining "done explaining"
  (declare (salience 50))
  ?g <- (goal (name "explain"))
  =>
  (printout t "done explaining " crlf))

(deffunction explain () "explain what each rule did"
   (assert (goal (name "explain")))
   (run))


(defrule eTester "Can we grab a PicoEvidence?" 
   (declare (salience 4000))
   ?myEvidence <- (PicoEvidence)
=> 
   (bind ?pCategory (fact-slot-value ?myEvidence picoCategory))
   (bind ?pTerm (fact-slot-value ?myEvidence picoTerm))
   (printout t "category: " ?pCategory crlf " term: " ?pTerm crlf))

(deffunction eTest () "Try to fire a rule"
   (bind ?myEvidence (assert (PicoEvidence (picoCategory "Publication Type")
                                           (picoTerm "conference paper"))))
   (run)
   (retract ?myEvidence))

(deffunction eTest2 () "Try to fire a rule"
   (bind ?myObj (new PicoEvidence))
   (call ?myObj setPicoCategory "Publication Type")
   (call ?myObj setPicoTerm "conference paper")
   (bind ?myEvidence (definstance PicoEvidence ?myObj static))
   (run)
   (retract ?myEvidence))

(undefrule eTester)
