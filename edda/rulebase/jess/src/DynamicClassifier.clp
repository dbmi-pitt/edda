(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/EddaTemplates)

;; ===================================
;;
;; Hand jammed evidence
;;
;; ===================================

(deffunction establishEvidence (?evidenceName ?*evidenceTerms) "Cost evidence "
    (bind ?evidenceObj (new MentionEvidence))
    (call ?evidenceObj setMention ?evidenceName)
    (foreach ?x ?*evidenceTerms 
        (call ?evidenceObj addOrEnd ?x))
    (return (add ?evidenceObj)))

(deffunction establishTitleEvidence (?evidenceName ?*evidenceTerms) "Cost evidence "
    (bind ?evidenceObj (new TitleEvidence))
    (call ?evidenceObj setMention ?evidenceName)
    (foreach ?x ?*evidenceTerms 
        (call ?evidenceObj addOrEnd ?x))
    (return (add ?evidenceObj)))

(deffunction establishAbstractEvidence (?evidenceName ?*evidenceTerms) "Cost evidence "
    (bind ?evidenceObj (new AbstractEvidence))
    (call ?evidenceObj setMention ?evidenceName)
    (foreach ?x ?*evidenceTerms 
        (call ?evidenceObj addOrEnd ?x))
    (return (add ?evidenceObj)))

(deffunction createMpaEvidence () "create mpa evidence"
    (bind ?*terms (create$))
    (bind ?*terms (insert$ ?*terms 1 "\\s+Acide mycophenolique\\s+"))
    (bind ?*terms (insert$ ?*terms 1 "\\s+Lilly-68618\\s+"))
    (bind ?*terms (insert$ ?*terms 1 "\\s+Ly 68618\\s+"))
    (bind ?*terms (insert$ ?*terms 1 "\\s+MPA\\s+"))
    (bind ?*terms (insert$ ?*terms 1 "\\s+Mycophenolic Acid\\s+"))
    (bind ?*terms (insert$ ?*terms 1 "\\s+Myfortic\\s+"))
    (bind ?*terms (insert$ ?*terms 1 "\\s+mycophenolate\\s+"))
    (return (fact-slot-value (establishEvidence "mpa" ?*terms) id)))

(deffunction createTitleAndAbstractMpaEvidence () "create mpa evidence"
    (bind ?*terms (create$))
    (bind ?*terms (insert$ ?*terms 1 "\\s+Acide mycophenolique\\s+"))
    (bind ?*terms (insert$ ?*terms 1 "\\s+Lilly-68618\\s+"))
    (bind ?*terms (insert$ ?*terms 1 "\\s+Ly 68618\\s+"))
    (bind ?*terms (insert$ ?*terms 1 "\\s+MPA\\s+"))
    (bind ?*terms (insert$ ?*terms 1 "\\s+Mycophenolic Acid\\s+"))
    (bind ?*terms (insert$ ?*terms 1 "\\s+Myfortic\\s+"))
    (bind ?*terms (insert$ ?*terms 1 "\\s+mycophenolate\\s+"))
    (establishTitleEvidence "mpa" ?*terms)
    (establishAbstractEvidence "mpa" ?*terms))

(deffunction createTransplantEvidence () "create transplant evidence"
    (bind ?*terms (create$))
    (bind ?*terms (insert$ ?*terms 1 "\\btransplant\\b"))
    (bind ?*terms (insert$ ?*terms 1 "\\ballograft\\b"))
    (return (fact-slot-value (establishEvidence "transplant" ?*terms) id)))

(defglobal ?*positive-evidence* = (create$))
(defglobal ?*negative-evidence* = (create$ ))
(defglobal ?*positive-evidence* = 
    (insert$ ?*positive-evidence* 1 (fact-slot-value (establishEvidence "skpt" (create$ "skpt")) id)))
(defglobal ?*positive-evidence* =    
    (insert$ ?*positive-evidence* 1 (fact-slot-value (establishEvidence "cohort" (create$ "the patient\\b")) id)))
(defglobal ?*positive-evidence* =    
    (insert$ ?*positive-evidence* 1 (fact-slot-value (establishEvidence "cost" (create$ "\\bcost\\b" "\\beconomic\\b")) id))) 
(defglobal ?*positive-evidence* =    
    (insert$ ?*positive-evidence* 1 (fact-slot-value (establishEvidence "animal" (create$ "\\banimal model\\b")) id))) 

(defglobal ?*negative-evidence* =    
    (insert$ ?*negative-evidence* 1 (createMpaEvidence)))
(defglobal ?*negative-evidence* =    
    (insert$ ?*negative-evidence* 1 (createTransplantEvidence)))
(defglobal ?*negative-evidence* =    
    (insert$ ?*negative-evidence* 1 (fact-slot-value 
            (establishEvidence "blood" 
                (create$ "plasmapheresis" "\\bblood\\b" "\\bserum\\b" "\\bplasma\\b")) id)))
;;
;; This function kicks off the classification process.
;;
(deffunction dynamic-classify () "classifies each test deck citation"
    (printout t "dynamic classifying" crlf)
    (assert (goal (name dynamic-classify)))
    (run)
    (printout t "finished dynamic classifying" crlf))

;;
;; This function creates a sub goal stack
;;
(deffunction stack-classify-subgoals (?citationId)
    "Creates prioritized set of subgoals"
    (bind ?priority 0)
    (assert (classify-goal (id ?citationId)
            (name activate-evidence)
            (priority ?priority)
            (isActivated 1)))
    (printout t "stacked activate-evidence " ?citationId crlf)
    (bind ?priority (+ ?priority 1))
    (assert (classify-goal (id ?citationId)
            (name build-evidence)
            (priority ?priority)
            (isActivated 0)))
    (printout t "stacked build-evidence " ?citationId crlf)
    (bind ?priority (+ ?priority 1))
    (assert (classify-goal (id ?citationId)
            (name activate-evidence)
            (priority ?priority)(isActivated 0)))
    (printout t "stacked activate-evidence " ?citationId crlf)
    (bind ?priority (+ ?priority 1))
    (assert (classify-goal (id ?citationId)
            (name update-evidence)
            (priority ?priority)(isActivated 0)))
    (printout t "stacked update-evidence " ?citationId crlf)
    (bind ?priority (+ ?priority 1))
    (assert (classify-goal (id ?citationId)
            (name activate-evidence)
            (priority ?priority)(isActivated 0)))
    (printout t "stacked activate-evidence " ?citationId crlf)
    (bind ?priority (+ ?priority 1))
    (assert (classify-goal (id ?citationId)
            (name classify-citation)
            (priority ?priority)(isActivated 0)))
    (printout t "stacked classify-citation " ?citationId crlf))

;;
;; This rule activates all the evidence
;;
(defrule dynamic-classify-0 "Activate the evidence"
    (declare (salience 100))
    (goal (name dynamic-classify))
    (classify-goal (id ?citationsId)
        (name activate-evidence)
        (isActivated 1))
    ?evidence <- (ClassificationEvidence
        (id ?id)
        (citationId ?citationId)
        (OBJECT ?evidenceObj)
        (isActivated 0))
    =>
   (printout t "dynamic-classify-0 reactivates evidence " ?id crlf)
    (modify ?evidence (isActivated 1)))

;;
;; This rule gathers evidence for the current citation
;;
(defrule dynamic-classify-1 "Gathers each evidence for current citation"
    (declare (salience 100))
    (goal (name dynamic-classify))
    (classify-goal (id ?citationId) (name build-evidence) (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (OBJECT ?citationObj)
        (isActivated 1))
    ?evidence <- (ClassificationEvidence
        (OBJECT ?evidenceObj)
        (isActivated 1))
    =>
    (printout t "dynamic-classify-1 calls scoreWithCitation" crlf)
    (call ?evidenceObj reset)
    (call ?evidenceObj scoreWithCitation ?citationObj)
    (modify ?evidence  (isActivated 0)))

;;
;; Force an update of the evidence shadow facts.
;;
(defrule dynamic-classify-2 "Force an update of the evidence shadow facts"
    (declare (salience 100))
    (goal (name dynamic-classify))
    (classify-goal (id ?citationId) (name update-evidence) (isActivated 1))
    (ClassificationEvidence
        (id ?id)
        (citationId ?anotherCitationId&:(neq ?citationId ?anotherCitationId))
        (OBJECT ?evidenceObj)
        (isActivated 1))
    =>
    (printout t "dynamic-classify-2 updates evidence with id " ?id crlf)
    (update ?evidenceObj))


;; ===================================================
;;
;; Classification Suite
;;
;; ====================================================

;;
;; BagOfWords - initial classification
;;
(defrule dynamic-classify-3 "First classify with bag of words evidence"
    (declare (salience 100))
    (goal (name dynamic-classify))
    (classify-goal (id ?citationId) (name classify-citation) (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (predictedClassification ?pClass&:(eq ?pClass "NA"))
        (OBJECT ?citationObj))
    ?evidence <- (BagOfWordsEvidence (isActivated 1)
        (citationId ?citationId)
        (polarity ?polarity))
    =>
    (modify ?evidence (isActivated 0))
    (bind ?predictedClass "exclude")
    (if (eq ?polarity "present") then (bind ?predictedClass "include"))
    (printout t "dynamic-classify-3 bag of words evidence sets citation " ?citationId " to " ?predictedClass crlf)
    (modify ?citation (predictedClassification ?predictedClass))
    (call ?citationObj setPredictedClassification ?predictedClass)
    (update ?citationObj)
    (bind ?citationObjAsString (call ?citationObj toString))
    (printout t ?citationObjAsString crlf))

;;
;; Change "include"" to "exclude" if this evidence is absent
;;
(defrule dynamic-classify-4-0 "Consider absent positive evidence to over turn a potential false positive"
    (declare (salience 90))
    (goal (name dynamic-classify))
    (classify-goal (id ?citationId) (name classify-citation) (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (predictedClassification ?pClass&:(eq ?pClass "include"))
        (OBJECT ?citationObj))
    ?evidence <- (MentionEvidence 
        (isActivated 1)
        (id ?id&:(member$ ?id ?*negative-evidence*))
        (citationId ?citationId)
        (polarity ?polarity&:(eq ?polarity "absent"))
        (mention ?mention))
    =>
    (printout t "classify-4-0 no " ?mention " support for include" crlf)
    (modify ?evidence (isActivated 0))
    (modify ?citation (predictedClassification "exclude"))
    (call ?citationObj setPredictedClassification "exclude")
    (update ?citationObj)
    (bind ?citationObjAsString (call ?citationObj toString))
    (printout t ?citationObjAsString crlf))

;;
;; Change "include" to "exclude" if this evidence is present
;;
(defrule dynamic-classify-4-1 "Consider present negative evidence to over turn a potential false positive"
    (declare (salience 90))
    (goal (name dynamic-classify))
    (classify-goal (id ?citationId) (name classify-citation) (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (predictedClassification ?pClass&:(eq ?pClass "include"))
        (OBJECT ?citationObj))
    ?evidence <- (MentionEvidence 
        (isActivated 1)
        (id ?id&:(member$ ?id ?*positive-evidence*))
        (citationId ?citationId)
        (polarity ?polarity&:(eq ?polarity "present"))
        (mention ?mention))
    =>
    (printout t "classify-4-1 " ?mention " refutes include" crlf)
    (modify ?evidence (isActivated 0))
    (modify ?citation (predictedClassification "exclude"))
    (call ?citationObj setPredictedClassification "exclude")
    (update ?citationObj)
    (bind ?citationObjAsString (call ?citationObj toString))
    (printout t ?citationObjAsString crlf))

;;
;; After higher value rules have classified the current Citation
;; this rull fires to tally it in the Experiment statistics
;; and retract the current citation from consideration
;;
(defrule dynamic-classify-5 "Tally the current citation and inactivate"
    (declare (salience 80))
    (goal (name dynamic-classify))
    ?classifySubGoal <- (classify-goal (id ?citationId) (name classify-citation) (isActivated 1))
    ?citation <- (Citation (id ?citationId) (OBJECT ?citationObj) (isActivated 1))
    =>
    (printout t "dynamic-classify-5 fires tallied citation " ?citationId crlf)
    (bind ?experiment (call ?*reader* getExperiment))
    (call ?experiment tallyCitation ?citationObj)
    (modify ?citation (isActivated 0))
    (retract ?classifySubGoal)
    (printout t "dynamic-classify-5 retracts subgoal classify-citation" crlf))

;;
;; This rule transitions the classification sub goals
;;
(defrule dynamic-classify-6 "Transitions the classification sub goals"
    (declare (salience 30))
    (goal (name dynamic-classify))
    ?cg1 <- (classify-goal (id ?citationId)
        (priority ?p1)
        (isActivated 1))
    ?cg2 <- (classify-goal (id ?citationId)
        (priority ?p2&:(eq ?p2 (+ ?p1 1)))
        (isActivated 0))
    =>
    (printout t "dynamic-classify-6 pops classify sub goal stack " crlf)
    (retract ?cg1)
    (modify ?cg2 (isActivated 1)))
;;
;; This rule queues the next available citation
;; by issuing a subgoal with that citation's id
;;
(defrule dynamic-classify-7 "queue the next available test citation"
    (declare (salience 20))
    ?g <- (goal (name dynamic-classify))
    ?model <- (model (test-set ?testSetPartition))
    ?citation <- (Citation (id ?citationId)
        (partition ?testSetPartition)
        (isActivated 1))
    (not (classify-goal (id ?anotherCitationId&:(neq ?citationId ?anotherCitationId))))
    =>
    (printout t "dynamic-classify-7 queueing next citation " ?citationId crlf)
    (stack-classify-subgoals ?citationId))

;;
;; This rule retracts the MentionEvidence.  Currently will be
;; regenerated manually before start of the classification run.
;;
(defrule dynamic-classify-8 "retract MentionEvidence"
    (declare (salience 15))
    (goal (name dynamic-classify))
    ?m <- (MentionEvidence (id ?id))
    =>
    (printout t "dynamic-classify-8 retracting mention evidence" ?id crlf)
    (retract ?m))

;;
;; This rule displays the experimental results and retracts the classification
;; goal
;;
(defrule dynamic-classify-9 "report on the experiment and retract the goal to classify"
    (declare (salience 10))
    ?g <- (goal (name dynamic-classify))
    =>
    (printout t "dynamic-classify-8 fires reports experiment and retracts classify goal" crlf)
    (bind ?experiment (call ?*reader* getExperiment))
    (bind ?resultString (call ?experiment toString))
    (printout t ?resultString crlf)
    (retract ?g))

(provide C:/Users/kjm84/git/edda/edda/rulebase/jess/src/DynamicClassifier)
