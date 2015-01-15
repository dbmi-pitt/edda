(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/EddaTemplates) 

(defrule classify-0 "calls classifyCitation in Java"
    (declare (salience 100))
    ?g <- (goal (name classify))
    ?gId <- (goal (id ?citationId) (name classify-citation))
    ?citation <- (Citation (id ?citationId)
                           (OBJECT ?citationObj)
                           (isActivated 1))
    =>
    (printout t "classify-0 fires calls classifyCitation in java" crlf)
    (modify ?citation (isActivated 0))
    (call ?*reader* classifyCitation ?citationObj))

(defrule classify-1 "Update the evidence objects"
    (declare (salience 90))
    ?g <- (goal (name classify))
    ?gId <- (goal (id ?citationId) (name classify-citation))
    ?evidence <- (ClassificationEvidence 
                    (id ?id) 
                    (citationId ?anotherCitationId&:(neq ?citationId ?anotherCitationId))
                    (OBJECT ?evidenceObj))
    =>
    (printout t "classify-1 fires updates evidence with id " ?id crlf)
    (update ?evidenceObj))

(defrule classify-2 "First classify with bag of words evidence"
    (declare (salience 80))
    ?g <- (goal (name classify))
    ?gId <- (goal (id ?citationId) (name classify-citation))
    ?citation <- (Citation (id ?citationId)
                           (predictedClassification ?pClass&:(eq ?pClass "NA"))
                           (OBJECT ?citationObj))
    ?evidence <- (BagOfWordsEvidence (isActivated 1) (citationId ?citationId) (category ?category))
    =>
    (modify ?evidence (isActivated 0))
    (bind ?predictedClass "exclude")
    (if (eq ?category 1) then (bind ?predictedClass "include"))
    (printout t "classify-2 fires bag of words evidence sets citation " ?citationId " to " ?predictedClass crlf)
    (modify ?citation (predictedClassification ?predictedClass))
    (call ?citationObj setPredictedClassification ?predictedClass)
    (update ?citationObj)
    (bind ?citationObjAsString (call ?citationObj toString))
    (printout t ?citationObjAsString crlf))

;;
;; if we have an include and there is no MPA MentionEvidence then change our mind to exclude
;; hopes of cutting down on false positives with out effecting includes
;;
(defrule classify-3 "Consider MPA evidence to over turn a potential false positive"
    (declare (salience 70))
    ?g <- (goal (name classify))
    ?gId <- (goal (id ?citationId) (name classify-citation))
    ?citation <- (Citation (id ?citationId) 
                           (predictedClassification ?pClass&:(eq ?pClass "include"))
                           (OBJECT ?citationObj))
    ?evidence <- (MentionEvidence (isActivated 1)
                                  (citationId ?citationId) 
                                  (category ?category&:(eq ?category 0))
            					  (mention ?mention&:(eq ?mention "mpa")))
    =>
    (printout t "classify-3 fires when found no mpa support for include" crlf)
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
(defrule classify-4 "Tally the current citation and retract it"
   (declare (salience 60))
    ?gClassify <- (goal (name classify))
    ?gId <- (goal (id ?citationId) (name classify-citation))
    ?citation <- (Citation (id ?citationId)(OBJECT ?citationObj))
    =>
    (printout t "classify-4 fires tallied citation " ?citationId crlf)
    (bind ?experiment (call ?*reader* getExperiment))
    (call ?experiment tallyCitation ?citationObj)
    (retract ?gId))

;;
;; This rule queues the next available citation
;; by issuing a subgoal with that citation's id
;;
(defrule classify-5 "queue the next available test citation"
    (declare (salience 50))
     ?g <- (goal (name classify))
     ?model <- (model (training-set ?trainingSetPartition))
     ?citation <- (Citation (id ?citationId)
        				(partition ?testSetPartition&:(neq ?trainingSetPartition ?testSetPartition)) 
        				(isActivated 1))
    (not (goal (id ?citationId) (name classify-citation)))
    =>
    (printout t "classify-5 fires queueing citation " ?citationId crlf)
    (assert (goal (id ?citationId) (name classify-citation))))

;;
;; This rule displays the experimental results and retracts the classification 
;; goal
;;
(defrule classify-6 "report on the experiment and retract the goal to classify"
    (declare (salience 40))
     ?g <- (goal (name classify))
    =>
    (printout t "classify-6 fires reports experiment and retracts classify goal" crlf)
    (bind ?experiment (call ?*reader* getExperiment))
    (bind ?resultString (call ?experiment toString))
    (printout t ?resultString crlf)
    (retract ?g))

;;
;; This function kicks off the classification process.
;;
(deffunction classify () "builds the alphabet from the training set"
    (printout t "classifying" crlf)
    (assert (goal (name classify)))
    (run)
    (printout t "finished classifying" crlf))

(provide C:/Users/kjm84/git/edda/edda/rulebase/jess/src/Classifier) 
