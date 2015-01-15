(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/EddaTemplates)

;; ====================================================================
;;
;; Calculate word differential
;;
;; ====================================================================

(defrule calculate-word-differential-0 "Find discriminatory potential for each word using train A"
    (declare (salience 100))
    ?g <- (goal (name calculate-word-differential))
    ?m <- (model (training-set "A") (includeWordCount ?iCount) (excludeWordCount ?eCount))
	?r <- (word-ranker (rank-iterator ?maxDifferential))
    ?w <- (Word (isActivated 1) 
                (frequencyApartitionInclude ?wOneIncs) 
                (frequencyApartitionExclude ?wOneExcs))
    =>
    (printout t "calculate-word-differential-0:" crlf)
    (printout t "model iCount = " ?iCount " eCount = " ?eCount crlf)
    (bind ?scaledExcs (round (* ?wOneExcs (/ ?iCount ?eCount))))
    (bind ?currentDifferential (abs (- ?wOneIncs ?scaledExcs)))
    (modify ?r (rank-iterator (max ?maxDifferential ?currentDifferential)))
    (modify ?w (rank ?currentDifferential) (isActivated 0)))

(defrule calculate-word-differential-1 "Transition to rank-discriminators"
    (declare (salience 75))
    ?g <- (goal (name calculate-word-differential))
    ?r <- (word-ranker (rank-iterator ?maxDifferential))
    =>
    (printout t "retracting goal to calculate-word-differential" crlf)
    (printout t "maxRank is " ?maxDifferential crlf)
    (retract ?g)
    (assert (goal (name rank-discriminators))))

(deffunction calculate-word-differential () "word differential"
    (printout t "calculating the word differential" crlf)
    (assert (goal (name calculate-word-differential)))
    (run)
    (printout t "finished calculating the word differential" crlf))

;; ====================================================================
;;
;; Rank discriminators
;;
;; ====================================================================
(defrule rank-discriminators-1 "Start a cursor fact"
    (declare (salience 90))
    ?g <- (goal (name rank-discriminators))
	?r <- (word-ranker (rank-iterator ?maxDifferential))
    =>
    (printout t "building cursor spos = " ?maxDifferential crlf)
    (assert (cursor (spos ?maxDifferential) (epos 1) (inc -1)))
    (retract ?r)
    (assert (word-ranker)))

(defrule rank-discriminators-2 "if cursor end state is reached then retract cursor"
    (declare (salience 80))
    ?g <- (goal (name rank-discriminators))
    ?c <- (cursor (spos ?spos) (epos ?epos&:(= ?spos ?epos)))
    ?r <- (word-ranker)
    =>
    (retract ?c)
    (retract ?r))

(defrule rank-discriminators-3 "if ranker exceeds twenty stop the process"
    (declare (salience 80))
    ?g <- (goal (name rank-discriminators))
    ?c <- (cursor)
    ?r <- (word-ranker (rank-iterator ?currentRank&:(> ?currentRank 20)))
    =>
    (retract ?c)
    (retract ?r))

(defrule rank-discriminators-4 "As the cursor passes over a differential rank the word"
    (declare (salience 70))
    ?g <- (goal (name rank-discriminators))
	?r <- (word-ranker (rank-iterator ?currentRank))
    ?c <- (cursor (spos ?spos))
    ?w <- (Word (isActivated 1)
        		(rank ?wordDifferential&:(= ?wordDifferential ?spos)))
    =>
    (modify ?w (isActivated 0)(rank ?currentRank))
    (modify ?r (rank-iterator (+ ?currentRank 1))))

(defrule rank-discriminators-5 "cursor incrementation (actually decrements here)"
    (declare (salience 50))
    ?g <- (goal (name rank-discriminators))
    ?c <- (cursor (spos ?spos) (epos ?epos&:(<> ?spos ?epos)) (inc ?inc))
    =>
     (if (= (mod ?spos 1000) 0) then
         (printout t "descriminating cursor at " ?spos crlf))
     (modify ?c (spos (+ ?spos ?inc))))

(defrule rank-discriminators-6 "Retract goal rank discriminators spawn goal to prune lows"
    (declare (salience 40))
    ?g <- (goal (name rank-discriminators))
    =>
     (retract ?g)
     (assert (goal (name prune-to-low-discriminators)))
     (printout t "rank-discriminators ==> prune-to-low-discriminators" crlf)
    )

;; ====================================================================
;;
;; Any active Words are no longer considered here
;;
;; ====================================================================

(defrule prune-to-low-descriminators-0 "All remaining actives are retracted"
    (declare (salience 100))
    ?g <- (goal (name prune-to-low-discriminators))
    ?w <- (Word (isActivated 1))
    =>
    (retract ?w))

(defrule prune-to-low-descriminators-1 "Transition goal to activate and display"
    (declare (salience 25))
    ?g <- (goal (name prune-to-low-discriminators))
    =>
    (retract ?g)
    (assert (goal (name activate-and-display-remaining-words)))
    (printout t "prune-to-low-discriminators ==> activate-and-display-remaining-words" crlf))

;; ====================================================================
;;
;; 
;;
;; ====================================================================

(defrule activate-and-display-remaining-words-0 
    "activates and displays all remaining words"
    (declare (salience 100))
    ?g <- (goal (name activate-and-display-remaining-words))
    ?w <- (Word (isActivated 0))
 =>
    (printout t (fact-slot-value ?w text) " => " (fact-slot-value ?w frequency) crlf)
    (modify ?w (isActivated 1)))
    
(defrule activate-and-display-remaining-words-1 
    "retracts the goal"
    (declare (salience 50))
    ?g <- (goal (name activate-and-display-remaining-words))
 =>
    (retract ?g))

;; ====================================================================
;;
;; 
;;
;; ====================================================================

(deffunction build-model () "build the model"
     (printout t "building model" crlf)
     (assert (goal (name activate-low-frequencies)))
     (run)
     (printout t "finished building model" crlf))

(provide C:/Users/kjm84/git/edda/edda/rulebase/jess/src/ModelBuilder)