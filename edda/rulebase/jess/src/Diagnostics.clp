(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/EddaTemplates)

;; ==================================================================
;;
;; Model
;;
;; ==================================================================
(defrule display-model-0
    "display the models"
    (declare (salience 100))
    ?g <- (goal (name display-models))
    ?m <- (model (training-set ?trainSetName) (test-set ?testSetName))
    =>
    (printout t "model training " ?trainSetName " and testing " ?testSetName crlf)
    )
(defrule display-model-1
    "display the models"
    (declare (salience 80))
    ?g <- (goal (name display-models))
    =>
    (printout t "no more models" crlf)
    (retract ?g)
    )
(deffunction display-models () "displays models"
    (assert (goal (name display-models)))
    (run))


;; =====================================================================
;;
;; goals
;;
;; =====================================================================

(defrule display-goals-0
    "display all goals in wm"
    (declare (salience 100))
    ?g <- (goal (name display-goals))
    ?otherGoal <- (goal (name ?goalName&:(neq ?goalName display-goals)))
    =>
    (printout t "goal " ?goalName crlf))

(defrule display-goals-1
    "display all goals in wm"
    (declare (salience 50))
    ?g <- (goal (name display-goals))
    =>
    (retract ?g))

(deffunction display-goals () "display all goals in wm"
    (assert (goal (name display-goals)))
    (run))

;; =====================================================================
;;
;; classify-goals
;;
;; =====================================================================

(defrule display-classify-goals-0
    "display all classify goals in wm"
    (declare (salience 100))
    ?g <- (goal (name display-classify-goals))
    ?otherGoal <- (classify-goal (name ?goalName&:(neq ?goalName display-classify-goals))
        (priority ?p)
        (isActivated ?isActivated))
    =>
    (printout t "classify sub goal " ?goalName " priority: " ?p " isActivated: " ?isActivated crlf))

(defrule display-classify-goals-1
    "display all classify-goals in wm"
    (declare (salience 50))
    ?g <- (goal (name display-classify-goals))
    =>
    (retract ?g))

(deffunction display-classify-goals () "display all classify-goals in wm"
    (assert (goal (name display-classify-goals)))
    (run))


;; =====================================================================
;;
;; ClassificationEvidence
;;
;; =====================================================================

(defrule display-evidence-0
    "display all evidence in wm"
    (declare (salience 100))
    (goal (name display-evidence))
    (ClassificationEvidence (id ?id))
    =>
    (printout t "ClassificationEvidence " ?id crlf))

(defrule display-evidence-1
    "display all mention evidence in wm"
    (declare (salience 100))
    (goal (name display-evidence))
    ?e <- (MentionEvidence (id ?id) (mention ?mention))
    =>
    (printout t "MentionEvidence factId = " (fact-id ?e) " id = " ?id " mention = " ?mention crlf))

(defrule display-evidence-2
    "retract goal to display evidence"
    (declare (salience 50))
    ?g <- (goal (name display-evidence))
    =>
    (retract ?g))

(deffunction display-evidence () "display all evidence in wm"
    (assert (goal (name display-evidence)))
    (run))



;; =====================================================================
;;
;; words
;;
;; =====================================================================

(defrule display-words-0
    "display all words in wm"
    (declare (salience 100))
    ?g <- (goal (name display-words))
    ?w <- (Word (text ?text) (rank ?rank))
    =>
    (printout t "Word " ?text " with rank: " ?rank crlf))

(defrule display-words-1
    "display all words in wm"
    (declare (salience 50))
    ?g <- (goal (name display-words))
    =>
    (retract ?g))

(deffunction display-words () "display all words in wm"
    (assert (goal (name display-words)))
    (run))

;; =====================================================================
;;
;; ranker
;;
;; =====================================================================

(defrule display-ranker-0
    "display all ranker in wm"
    (declare (salience 100))
    ?g <- (goal (name display-ranker))
    ?r <- (word-ranker (rank-iterator ?currentRank))
    =>
    (printout t "word-ranker " ?currentRank crlf))

(defrule display-ranker-1
    "display all ranker in wm"
    (declare (salience 50))
    ?g <- (goal (name display-ranker))
    =>
    (retract ?g))

(deffunction display-ranker () "display all ranker in wm"
    (assert (goal (name display-ranker)))
    (run))


(provide C:/Users/kjm84/git/edda/edda/rulebase/jess/src/Diagnostics)
