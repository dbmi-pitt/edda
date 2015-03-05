(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/EddaTemplates)

;; =====================================================================
;;
;; Cache and Activate the Evidence for the current Citation
;;
;; =====================================================================
(defrule pico-cache-evidence "Cache the evidence for the current citation"
    (declare (salience 100))
    (goal (name pico-classify))
    (classify-goal (id ?citationId)
        (name cache-evidence)
        (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (OBJECT ?citationObj))
    =>
    (call ?citationObj iterateEvidence)
    (bind ?picoEvidence (call ?citationObj nextPicoEvidence))
    (while  (neq ?picoEvidence nil)
         (bind ?cls (call ?picoEvidence getClass))
         (bind ?clsName (call ?cls getName))
;;         (printout t "pico-cache-evidence definstancing a " ?clsName crlf)
         (definstance PicoEvidence ?picoEvidence static)
         (bind ?picoEvidence (call ?citationObj nextPicoEvidence))))

;; =====================================================================
;;
;; Tally Experiment
;;
;; =====================================================================
(defrule pico-tally-experiment "Tally the current citation and inactivate"
    (declare (salience 80))
    (goal (name pico-classify))
    (classify-goal (id ?citationId) (name tally-experiment) (isActivated 1))
    ?citation <- (Citation (id ?citationId) (OBJECT ?citationObj) (isActivated 1))
    =>
;;    (printout t "pico-tally-experiment: " ?citationId crlf)
    (bind ?experiment (call ?*reader* getExperiment))
    (call ?experiment tallyCitation ?citationObj))

;; =====================================================================
;;
;; Retract Citation Evidence
;;
;; =====================================================================
(defrule pico-retract-evidence "retract PicoEvidence"
    (declare (salience 100))
    (goal (name pico-classify))
    (classify-goal (name retract-evidence) (isActivated 1))
    ?evidence <- (PicoEvidence (id ?id))
    =>
    (retract ?evidence))

;; =====================================================================
;;
;; Inactivate Current Citation - also retract final subgoal
;;
;; =====================================================================
(defrule pico-inactivate-citation "inactivates current citation"
    (declare (salience 100))
    (goal (name pico-classify))
    ?cg <- (classify-goal (id ?citationId)
        (name inactivate-citation)
        (isActivated 1))
    ?citation <- (Citation (id ?citationId))
    =>
    (modify ?citation (isActivated 0))
    (retract ?cg))

;; =====================================================================
;;
;; Pop subgoals
;;
;; =====================================================================
(defrule pico-pop-subgoal "Transitions the classification sub goals"
    (declare (salience 30))
    (goal (name pico-classify))
    ?cg1 <- (classify-goal (id ?citationId)
        (name ?name1)
        (priority ?p1)
        (isActivated 1))
    ?cg2 <- (classify-goal (id ?citationId)
        (name ?name2)
        (priority ?p2&:(eq ?p2 (+ ?p1 1)))
        (isActivated 0))
    =>
;;    (printout t "pico-pop-subgoal: <" ?name1 "> ==> <" ?name2 ">" crlf)
    (retract ?cg1)
    (modify ?cg2 (isActivated 1)))

;; =====================================================================
;;
;; Queue Next Citation - Stack subgoals
;;
;; =====================================================================
;;
(defrule pico-queue-next-citation "queue the next available test citation"
    (declare (salience 20))
    ?g <- (goal (name pico-classify))
    ?model <- (model (test-set ?testSetPartition))
    ?citation <- (Citation (id ?citationId)
        (partition ?testSetPartition)
        (isActivated 1))
    (not (classify-goal (id ?anotherCitationId&:(neq ?citationId ?anotherCitationId))))
    =>
    (if (eq (mod ?citationId 1000) 0) then
        (printout t "pico-queue-next-citation: " ?citationId crlf))
    (stack-pico-classify-subgoals ?citationId))

;; =====================================================================
;;
;; Disply Final Results
;;
;; =====================================================================
;;
;; This rule displays the experimental results and retracts the classification
;; goal
;;
(defrule pico-display-results "report on the experiment and retract the goal to classify"
    (declare (salience 10))
    ?g <- (goal (name pico-classify))
    =>
;;    (printout t "pico-display-results: " crlf)
    (bind ?experiment (call ?*reader* getExperiment))
    (bind ?resultString (call ?experiment toString))
    (printout t ?resultString crlf)
    (retract ?g))

;; =====================================================================
;;
;; Subgoal Stacker
;;
;; =====================================================================
(deffunction stack-pico-classify-subgoals (?citationId)
    "Creates prioritized set of subgoals"
    (bind ?priority 0)
    (assert (classify-goal (id ?citationId)
            (name cache-evidence)
            (priority ?priority)
            (isActivated 1)))
    (bind ?priority (+ ?priority 1))
    (assert (classify-goal (id ?citationId)
            (name classify-citation)
            (priority ?priority)(isActivated 0)))
    (bind ?priority (+ ?priority 1))
    (assert (classify-goal (id ?citationId)
            (name tally-experiment)
            (priority ?priority)(isActivated 0)))
    (bind ?priority (+ ?priority 1))
    (assert (classify-goal (id ?citationId)
            (name retract-evidence)
            (priority ?priority)(isActivated 0)))
    (bind ?priority (+ ?priority 1))
    (assert (classify-goal (id ?citationId)
            (name inactivate-citation)
            (priority ?priority)(isActivated 0))))

;; =====================================================================
;;
;; Classification Kickoff
;;
;; =====================================================================
(deffunction pico-classify () "classifies each test deck citation"
    (printout t "pico classifying" crlf)
    (assert (goal (name pico-classify)))
    (run)
    (printout t "Finished pico classifying" crlf))


(provide C:/Users/kjm84/git/edda/edda/rulebase/jess/src/PicoClassifier)
