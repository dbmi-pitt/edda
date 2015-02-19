(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/EddaTemplates)

;; ==========================================================================
;;
;; model
;;
;; ==========================================================================
(defrule clean-models-0 
    "cleans old models"
    (declare (salience 100))
    ?g <- (goal (name clean-models))
    ?m <- (model)
 =>
    (retract ?m))
    
(defrule clean-models-1 
    "retracts the goal"
    (declare (salience 50))
    ?g <- (goal (name clean-models))
 =>
    (retract ?g))

(deffunction cleanModels () "clean models" 
    (assert (goal (name clean-models)))
    (run))

;; ==========================================================================
;;
;; goal
;;
;; ==========================================================================
(defrule clean-goals-0 
    "cleans old goals"
    (declare (salience 100))
    ?g <- (goal (name clean-goals))
    ?cleanTarget <- (goal (name ?name&:(neq ?name clean-goals)))
 =>
    (printout t "retracting goal " ?name crlf)
    (retract ?cleanTarget))
    
(defrule clean-goals-0-0
    "cleans old prioritized-goals"
    (declare (salience 100))
    ?g <- (goal (name clean-goals))
    ?cleanTarget <- (prioritized-goal (name ?name))
 =>
    (printout t "retracting prioritized-goal " ?name crlf)
    (retract ?cleanTarget))

(defrule clean-goals-1 
    "retracts the goal"
    (declare (salience 50))
    ?g <- (goal (name clean-goals))
 =>
    (retract ?g))

(deffunction cleanGoals () "clean goals" 
    (assert (goal (name clean-goals)))
    (run))

;; =====================================================================
;;
;; Clean classify-goals
;;
;; =====================================================================

(defrule clean-classify-goals-0
    "clean all classify goals in wm"
    (declare (salience 100))
    ?g <- (goal (name clean-classify-goals))
    ?otherGoal <- (classify-goal)
    =>
    (retract ?otherGoal))

(defrule clean-classify-goals-1
    "clean all classify-goals in wm"
    (declare (salience 50))
    ?g <- (goal (name clean-classify-goals))
    =>
    (retract ?g))

(deffunction cleanClassifyGoals () "clean all classify-goals in wm"
    (assert (goal (name clean-classify-goals)))
    (run))

(deffunction cleanAllGoals () "Cleans goals and sub goals"
    (cleanGoals)
    (cleanClassifyGoals))

;; ==========================================================================
;;
;; MentionEvidence
;;
;; ==========================================================================
(defrule clean-mention-evidence-0 
    "cleans mention evidence facts"
    (declare (salience 100))
    (goal (name clean-mention-evidence))
    ?m <- (MentionEvidence)
    =>
    (retract ?m))

(defrule clean-mention-evidence-1 
    "cleans mention evidence facts"
    (declare (salience 50))
    ?g <- (goal (name clean-mention-evidence))
    =>
    (retract ?g))

(deffunction clean-mention-evidence () "cleans mention evidence"
    (assert (goal (name clean-mention-evidence)))
    (run))

;; ==========================================================================
;;
;; Experiment
;;
;; ==========================================================================
(deffunction resetExperiment () "Resets the experiment counters "
    (bind ?experiment (call ?*reader*  getExperiment))
    (call ?experiment setFalsePositives 0)
    (call ?experiment setTruePositives 0)
    (call ?experiment setFalseNegatives 0)
    (call ?experiment setTrueNegatives 0)
    (bind ?experimentDiagnostics (call ?experiment toString))
    (printout t ?experimentDiagnostics crlf))

(provide C:/Users/kjm84/git/edda/edda/rulebase/jess/src/Cleaner)


