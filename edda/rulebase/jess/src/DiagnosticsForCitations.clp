(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/EddaTemplates)

;; =====================================================================
;;
;; Citations
;;
;; =====================================================================

(deffunction display-evidence (?citationObj)
    "display the evidence for this citation"
    (call ?citationObj iterateEvidence)
    (bind ?evidence (call ?citationObj nextPicoEvidence))
    (while  (neq ?evidence nil)
        (bind ?category (call ?evidence getPicoCategory))
        (bind ?term (call ?evidence getPicoTerm))
        (bind ?polarity (call ?evidence getPolarity))
        (if (and (or (neq ?category nil)
                     (eq ?category "Embase Keywords Category")
	             (eq ?category "Abstract Category")
                     (eq ?category "Intervention / Comparator Category"))
                     (eq ?polarity "present")) then
            (printout t "          "  ?category " ==> " ?term crlf))
        (bind ?evidence (call ?citationObj nextPicoEvidence))))

(deffunction display-ancestry-evidence (?citationObj)
    "display the ancestry evidence for this citation"
    (call ?citationObj iterateEvidence)
    (bind ?evidence (call ?citationObj nextPicoEvidence))
    (while  (neq ?evidence nil)
        (bind ?category (call ?evidence getPicoCategory))
        (bind ?term (call ?evidence getPicoTerm))
        (bind ?polarity (call ?evidence getPolarity))
        (if (and (or (neq ?category nil)
                     (eq ?category "Abstract Category")
                     (eq ?category "Intervention / Comparator Category"))
                     (eq ?polarity "ancestor")) then
            (printout t "         *"  ?category " ==> " ?term crlf))
        (bind ?evidence (call ?citationObj nextPicoEvidence))))

;; =====================================================================
;;
;; False Positives
;;
;; =====================================================================
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
        (lastRuleApplied ?lastRuleApplied)
        (OBJECT ?citationObj))  
    =>
    (printout t crlf crlf)
    (printout t "Citation " ?id " predicted: " ?p " actual: " ?a crlf)
    (printout t "      deciding rule: " ?lastRuleApplied crlf) 
    (printout t crlf crlf)
    (bind ?content (call ?citationObj getContent))
    (printout t ?content crlf)
    (display-evidence ?citationObj)
    (display-ancestry-evidence ?citationObj)
    (modify ?citation (isActivated 0))
    (retract ?g))

(defrule display-citation-false-positives-1
    "no more false positives so retract the goal"
    (declare (salience 80))
    ?g <- (goal (name display-false-positives))
    =>
    (printout t "no more false positives so retracting goal" crlf)
    (retract ?g))

(deffunction display-fps () "display next false positive"
    (assert (goal (name display-false-positives)))
    (run))

;; =====================================================================
;;
;; True Positives
;;
;; =====================================================================
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
        (lastRuleApplied ?lastRuleApplied)
        (OBJECT ?citationObj))
    
    =>
    (printout t crlf crlf)
    (printout t "Citation " ?id " predicted: " ?p " actual: " ?a crlf)
    (printout t "      deciding rule: " ?lastRuleApplied crlf) 
    (printout t crlf crlf)
    (bind ?content (call ?citationObj getContent))
    (printout t ?content crlf)
    (display-evidence ?citationObj)
    (display-ancestry-evidence ?citationObj)
    (modify ?citation (isActivated 0))
    (retract ?g))

(defrule display-citation-true-positives-1
    "no more false positives so retract the goal"
    (declare (salience 80))
    ?g <- (goal (name display-true-positives))
    =>
    (printout t "no more false positives so retracting goal" crlf)
    (retract ?g))

(deffunction display-tps () "display next true positive"
    (assert (goal (name display-true-positives)))
    (run))

;; =====================================================================
;;
;; False Negatives
;;
;; =====================================================================
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
        (lastRuleApplied ?lastRuleApplied)
        (OBJECT ?citationObj))
    
    =>
    (printout t crlf crlf)
    (printout t "Citation " ?id " predicted: " ?p " actual: " ?a crlf)
    (printout t "      deciding rule: " ?lastRuleApplied crlf) 
    (printout t crlf crlf)
    (bind ?content (call ?citationObj getContent))
    (printout t ?content crlf)
    (display-evidence ?citationObj)
    (display-ancestry-evidence ?citationObj)
    (modify ?citation (isActivated 0))
    (retract ?g))

(defrule display-citation-false-negatives-1
    "no more false negatives so retract the goal"
    (declare (salience 80))
    ?g <- (goal (name display-false-negatives))
    =>
    (printout t "no more false negatives so retracting goal" crlf)
    (retract ?g))

(deffunction display-fns () "display next false negative"
    (assert (goal (name display-false-negatives)))
    (run))

;; =====================================================================
;;
;; True Negatives
;;
;; =====================================================================
(defrule display-citation-true-negatives-0
    "display next false positive citation"
    (declare (salience 100))
    ?g <- (goal (name display-true-negatives))
    ?model <- (model (test-set ?testSetName))
    ?citation <- (Citation (id ?id)
        (isActivated 1)
        (partition ?testSetName)
        (predictedClassification ?p&:(eq ?p "exclude"))
        (actualClassification ?a&:(eq ?a "exclude"))
        (lastRuleApplied ?lastRuleApplied)
        (OBJECT ?citationObj))
    =>
    (printout t crlf crlf)
    (printout t "Citation " ?id " predicted: " ?p " actual: " ?a crlf)
    (printout t "      deciding rule: " ?lastRuleApplied crlf) 
    (printout t crlf crlf)
    (bind ?content (call ?citationObj getContent))
    (printout t ?content crlf)
    (display-evidence ?citationObj)
    (display-ancestry-evidence ?citationObj)
    (modify ?citation (isActivated 0))
    (retract ?g))

(defrule display-citation-true-negatives-1
    "no more true negatives so retract the goal"
    (declare (salience 80))
    ?g <- (goal (name display-true-negatives))
    =>
    (printout t "no more true negatives so retracting goal" crlf)
    (retract ?g))

(deffunction display-tns () "display next true negative"
    (assert (goal (name display-true-negatives)))
    (run))

(provide C:/Users/kjm84/git/edda/edda/rulebase/jess/src/DiagnosticsForCitations)
