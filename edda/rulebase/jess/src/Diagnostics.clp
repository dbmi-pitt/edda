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
;; Citations
;;
;; =====================================================================

(defrule display-citation-false-positives-2
    "display next false positive citation"
    (declare (salience 150))
    ?g <- (goal (name display-false-positives))
    ?model <- (model (test-set ?testSetName))
    ?citation <- (Citation (id ?id)
        				   (isActivated 1)
        				   (partition ?testSetName)
        				   (predictedClassification ?p)
                           (actualClassification ?a&:(eq ?a "include"))        					
                           (OBJECT ?citationObj))
    
    =>
    (printout t "Citation " ?id " partition " ?testSetName " predicted: " ?p " actual: " ?a crlf)
    (modify ?citation (isActivated 0)))
(undefrule display-citation-false-positives-2)

(defrule display-citation-false-positives-0
    "display next false positive citation"
    (declare (salience 100))
    ?g <- (goal (name display-false-positives))
    ?model <- (model (test-set ?testSetName))
    ?citation <- (Citation (id ?id)
        				   (isActivated 1)
        				   (partition ?testSetName)
        				   (predictedClassification ?p&:(eq ?p "include"))
                           (actualClassification ?a&:(eq ?a "exclude"))        					
                           (OBJECT ?citationObj))
    
    =>
    (printout t "Citation " ?id " predicted: " ?p " actual: " ?a crlf)
    (bind ?content (call ?citationObj getContent))
    (printout t ?content crlf)
    (modify ?citation (isActivated 0))
    (retract ?g))

(defrule display-citation-false-positives-1
    "no more false positives so retract the goal"
      (declare (salience 80))
    ?g <- (goal (name display-false-positives))
    =>
    (printout t "no more false positives so retracting goal" crlf)
    (retract ?g))

(deffunction display-citation-false-positives () "display next false positive"
	(assert (goal (name display-false-positives)))
    (run))


(defrule display-citation-true-positives-0
    "display next false positive citation"
    (declare (salience 100))
    ?g <- (goal (name display-true-positives))
    ?model <- (model (test-set ?testSetName))
    ?citation <- (Citation (id ?id)
        				   (isActivated 1)
        				   (partition ?testSetName)
        				   (predictedClassification ?p&:(eq ?p "include"))
                           (actualClassification ?a&:(eq ?a "include"))        					
                           (OBJECT ?citationObj))
    
    =>
    (printout t "Citation " ?id " predicted: " ?p " actual: " ?a crlf)
    (bind ?content (call ?citationObj getContent))
    (printout t ?content crlf)
    (modify ?citation (isActivated 0))
    (retract ?g))

(defrule display-citation-true-positives-1
    "no more false positives so retract the goal"
      (declare (salience 80))
    ?g <- (goal (name display-true-positives))
    =>
    (printout t "no more false positives so retracting goal" crlf)
    (retract ?g))

(deffunction display-citation-true-positives () "display next false positive"
	(assert (goal (name display-true-positives)))
    (run))

(defrule display-citation-false-negatives-0
    "display next false positive citation"
    (declare (salience 100))
    ?g <- (goal (name display-false-negatives))
    ?model <- (model (test-set ?testSetName))
    ?citation <- (Citation (id ?id)
        				   (isActivated 1)
        				   (partition ?testSetName)
        				   (predictedClassification ?p&:(eq ?p "exclude"))
                           (actualClassification ?a&:(eq ?a "include"))        					
                           (OBJECT ?citationObj))
    
    =>
    (printout t "Citation " ?id " predicted: " ?p " actual: " ?a crlf)
    (bind ?content (call ?citationObj getContent))
    (printout t ?content crlf)
    (modify ?citation (isActivated 0))
    (retract ?g))

(defrule display-citation-false-negatives-1
    "no more false negatives so retract the goal"
      (declare (salience 80))
    ?g <- (goal (name display-false-negatives))
    =>
    (printout t "no more false negatives so retracting goal" crlf)
    (retract ?g))

(deffunction display-citation-false-negatives () "display next false negative"
	(assert (goal (name display-false-negatives)))
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
