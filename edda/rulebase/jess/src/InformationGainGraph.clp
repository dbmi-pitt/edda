(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/EddaTemplates)

;; =====================================================================
;;
;; Generate a list off Evidence ordered by frequency in include set
;; vs frequency in exclude set.
;;
;; =====================================================================

;; =====================================================================
;;
;; Ruleset
;;
;; =====================================================================;;

;; =======================================================================================
;;
;; Clear PicoEvidence
;; 
;; =======================================================================================
(defrule ig-clear-evidence "Clears any PicoEvidence in working memory"
     (declare (salience 100))
     (prioritized-goal (name "ig-clear-evidence") (isActivated 1))
     ?evidence <- (PicoEvidence)
=>
     (retract ?evidence))

;; =======================================================================================
;;
;; Activate the Citations
;; 
;; =======================================================================================

(defrule ig-activate-citations "Activates the citations"
     (declare (salience 100))
     (prioritized-goal (name ig-activate-citations) (isActivated 1))
     ?citation <- (Citation (isActivated 0))
=>
     (modify ?citation (isActivated 1)))

;; =======================================================================================
;;
;; Cache PicoEvidence
;; 
;; =======================================================================================

(defrule ig-cache-evidence "Caches all evidence across Citations"
     (declare (salience 100))
     (prioritized-goal (name ig-cache-evidence) (isActivated 1))
     ?citation <- (Citation (OBJECT ?citationObj) (isActivated 1))
=>
    (call ?citationObj iterateEvidence)
    (bind ?identifiable (call ?citationObj nextPicoEvidence))
    (while  (neq ?identifiable nil)
        (bind ?picoEvidence (add ?identifiable))
        (modify ?picoEvidence (weight 1))
        (modify ?picoEvidence (isActivated 1))

        (bind ?identifiable (call ?citationObj nextPicoEvidence)))
    (modify ?citation (isActivated 0)))

;; =======================================================================================
;;
;; Merge evidence while summing weights.  The two rules should work together like
;; a classic Merge Sort
;; 
;; =======================================================================================

(defrule ig-merge-evidence-frequency-strict "Caches all evidence across Citations"
     (declare (salience 100))
     (prioritized-goal (name ig-merge-evidence-frequency) (isActivated 1))
     ?citationOne <- (Citation (id ?citationOneId) (actualClassification ?actualClassification))
     ?evidenceOne <- (PicoEvidence (id ?idOne)
                                   (citationId ?citationOneId)
                                   (picoTerm ?picoTerm) 
                                   (weight ?weightOne))
     ?citationTwo <- (Citation (id ?citationTwoId) (actualClassification ?actualClassification))
     ?evidenceTwo <- (PicoEvidence (id ?idTwo&:(neq ?idOne ?idTwo))
                                   (citationId ?citationTwoId)
                                   (picoTerm ?picoTerm)
                                   (weight ?weightTwo&:(eq ?weightOne ?weightTwo)))
=>
    (modify ?evidenceOne (weight (+ ?weightOne ?weightTwo)))
    (retract ?evidenceTwo))

(defrule ig-merge-evidence-frequency-lenient "Merge despite weights"
     (declare (salience 90))
     (prioritized-goal (name ig-merge-evidence-frequency) (isActivated 1))
     ?citationOne <- (Citation (id ?citationOneId) (actualClassification ?actualClassification))
     ?evidenceOne <- (PicoEvidence (id ?idOne)
                                   (citationId ?citationOneId)
                                   (picoTerm ?picoTerm) 
                                   (weight ?weightOne))
     ?citationTwo <- (Citation (id ?citationTwoId) (actualClassification ?actualClassification))
     ?evidenceTwo <- (PicoEvidence (id ?idTwo&:(neq ?idOne ?idTwo))
                                   (citationId ?citationTwoId)
                                   (picoTerm ?picoTerm)
                                   (weight ?weightTwo))
=>
    (modify ?evidenceOne (weight (+ ?weightOne ?weightTwo)))
    (retract ?evidenceTwo))

;; =======================================================================================
;;
;; Include evidence with no include evidence
;; 
;; =======================================================================================

(defrule ig-report-deactivate-includes-only "Toggle isActivated for solo include evidence"
     (declare (salience 100))
     (prioritized-goal (name ig-report-divergences) (isActivated 1))
     ?citation <- (Citation (id ?citationOneId) (actualClassification "include"))
     ?evidence <- (PicoEvidence
                                (citationId ?citationOneId)
                                (isActivated 1)
                                (picoTerm ?picoTerm)
                                (weight ?weightOne))
     (not (and (Citation (id ?citationTwoId) (actualClassification "exclude"))
               (PicoEvidence (citationId ?citationTwoId) (picoTerm ?picoTerm))))
=>
    (modify ?evidence (isActivated 0)))

(defrule ig-report-divergences-include-only "Report solo includes sorted by weight"
     (declare (salience 95))
     (prioritized-goal (name ig-report-divergences) (isActivated 1))
     ?citation <- (Citation (id ?citationOneId) (actualClassification "include"))
     ?evidence <- (PicoEvidence (citationId ?citationOneId)
                                (isActivated 0)
                                (picoTerm ?picoTerm)
                                (weight ?weightOne))
     (not (and (Citation (id ?citationTwoId) (actualClassification "include"))
               (PicoEvidence (citationId ?citationTwoId)
                             (isActivated 0)
                             (picoTerm ?anotherPicoTerm)
			     (weight ?weightTwo&:(< ?weightOne ?weightTwo)))))
=>
    (printout t "include only evidence => <" ?picoTerm ", " ?weightOne ">" crlf)
    (retract ?evidence))

;; =======================================================================================
;;
;; Include evidence with no exclude evidence
;; 
;; =======================================================================================

(defrule ig-report-deactivate-excludes-only "Toggle isActivated for solo exclude evidence"
     (declare (salience 90))
     (prioritized-goal (name ig-report-divergences) (isActivated 1))
     ?citation <- (Citation (id ?citationOneId) (actualClassification "exclude"))
     ?evidence <- (PicoEvidence (citationId ?citationOneId)
                                (isActivated 1)
                                (picoTerm ?picoTerm)
                                (weight ?weightOne))
     (not (and (Citation (id ?citationTwoId) (actualClassification "include"))
               (PicoEvidence (citationId ?citationTwoId) (picoTerm ?picoTerm))))
=>
    (modify ?evidence (isActivated 0)))

(defrule ig-report-divergences-exclude-only "Report solo excludes sorted by weight"
     (declare (salience 85))
     (prioritized-goal (name ig-report-divergences) (isActivated 1))
     ?citation <- (Citation (id ?citationOneId) (actualClassification "exclude"))
     ?evidence <- (PicoEvidence (citationId ?citationOneId)
                                (isActivated 0)
                                (picoTerm ?picoTerm)
                                (weight ?weightOne))
     (not (and (Citation (id ?citationTwoId) (actualClassification "exclude"))
               (PicoEvidence (citationId ?citationTwoId)
                             (isActivated 0)
                             (picoTerm ?anotherPicoTerm)
			     (weight ?weightTwo&:(< ?weightOne ?weightTwo)))))
=>
    (printout t "exclude only evidence => <" ?picoTerm ", " ?weightOne ">" crlf)
    (retract ?evidence))

;; =======================================================================================
;;
;; Include and Exclude evidence with varying weights
;;         report in descreasing order of weight divergence
;; 
;; =======================================================================================
(defrule ig-report-divergences-both "Compare evidence weights"
     (declare (salience 80))
     (prioritized-goal (name ig-report-divergences) (isActivated 1))
     ?citationOne <- (Citation (id ?citationOneId)
                               (actualClassification "include"))
     ?evidenceOne <- (PicoEvidence (citationId ?citationOneId)
                                   (isActivated 1)
                                   (picoTerm ?picoTerm)
                                   (weight ?weightOne))
     ?citationTwo <- (Citation (id ?citationTwoId)
                               (actualClassification "exclude"))
     ?evidenceTwo <- (PicoEvidence (citationId ?citationTwoId)
                                   (isActivated 1)
                                   (picoTerm ?picoTerm)
                                   (weight ?weightTwo))
     (not (and (Citation (id ?citationThreeId) 
                    (actualClassification "include"))
               (PicoEvidence
                    (citationId ?citationThreeId)
                    (isActivated 1)
                    (picoTerm ?anotherPicoTerm) 
                   (weight ?weightThree))
               (Citation (id ?citationFourId) 
                    (actualClassification "exclude"))
               (PicoEvidence (id ?evidenceFourId)
                             (citationId ?citationFourId)
                             (isActivated 1)
                             (picoTerm ?anotherPicoTerm)
                             (weight ?weightFour&:(< (abs (- ?weightOne ?weightTwo))
                                                     (abs (- ?weightThree ?weightFour)))))))
=>
    (printout t " both evidence =>" crlf
                                 "         <" ?picoTerm ", exc, " ?weightTwo "> " crlf
                                 "         <" ?picoTerm ", inc, " ?weightOne "> " crlf)
    (retract ?evidenceOne)
    (retract ?evidenceTwo))

;; =====================================================================
;;
;; Subgoal popper
;;
;; =====================================================================
(defrule ig-pop-subgoal "Transitions the IG subgoals"
    (declare (salience 30))
    ?cg1 <- (prioritized-goal
        (name ?name1)
        (priority ?p1)
        (isActivated 1))
    ?cg2 <- (prioritized-goal
        (name ?name2)
        (priority ?p2&:(eq ?p2 (+ ?p1 1)))
        (isActivated 0))
    =>
    (printout t "ig-pop-subgoal: <" ?name1 "> ==> <" ?name2 ">" crlf)
    (retract ?cg1)
    (modify ?cg2 (isActivated 1)))

;; =====================================================================
;;
;; Subgoal Stacker
;;
;; =====================================================================
(deffunction ig-stack-goals ()
    "Creates prioritized set of subgoals"
    (bind ?priority 0)
    (assert (prioritized-goal
            (name ig-clear-evidence)
            (priority ?priority)
            (isActivated 1)))
    (printout t "Stacked: <ig-clear-evidence> " crlf)
    (bind ?priority (+ ?priority 1))
    (assert (prioritized-goal
            (name ig-activate-citations)
            (priority ?priority)
            (isActivated 0)))
    (printout t "Stacked: <ig-activate-citations> " crlf)
    (bind ?priority (+ ?priority 1))
    (assert (prioritized-goal
            (name ig-cache-evidence)
            (priority ?priority)
            (isActivated 0)))
    (printout t "Stacked: <ig-cache-evidence> " crlf)
    (bind ?priority (+ ?priority 1))
    (assert (prioritized-goal
            (name ig-merge-evidence-frequency)
            (priority ?priority)
            (isActivated 0)))
    (printout t "Stacked: <ig-merge-evidence-frequency> " crlf)
    (bind ?priority (+ ?priority 1))
    (assert (prioritized-goal
            (name ig-report-divergences)
            (priority ?priority)
            (isActivated 0)))
    (printout t "Stacked: <ig-report-divergences> " crlf)
    (bind ?priority (+ ?priority 1))
    (assert (prioritized-goal
            (name ig-activate-citations)
            (priority ?priority)
            (isActivated 0)))
    (printout t "Stacked: <activate-citations> " crlf))

;; =====================================================================
;;
;; Information Gain Kickoff
;;
;; =====================================================================
(deffunction ig-calculate () "classifies each test deck citation"
    (printout t "Starting information gain calculator" crlf)
    (ig-stack-goals)
    (run)
    (cleanGoals) 
    (printout t "Finished information gain calculations" crlf))


(provide C:/Users/kjm84/git/edda/edda/rulebase/jess/src/InformationGainGraph)