(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/EddaTemplates)

;; ====================================================================
;;
;; rank-word suite of rules calculate the frequencies per partition
;; and overall
;;
;; ====================================================================

(defrule rank-words-0 "Sum frequencies A train set"
    (declare (salience 100))
    ?g <- (goal (name rank-words))
    ?m <- (model (training-set "A")
           (includeWordCount ?iCount)
           (excludeWordCount ?eCount))
    ?w <- (Word (frequencyApartitionExclude ?f1)
        		(frequencyApartitionInclude ?f2)
                (frequency ?f3&:(<> ?f3 (+ ?f1 ?f2))))
    =>
    (modify ?m (includeWordCount (+ ?iCount ?f2))
               (excludeWordCount (+ ?eCount ?f3)))
    (modify ?w (frequency (+ ?f1 ?f2))))

(defrule rank-words-1 "Sum frequencies B train set"
    (declare (salience 100))
    ?g <- (goal (name rank-words))
    ?m <- (model (training-set "B")
           (includeWordCount ?iCount)
           (excludeWordCount ?eCount))
    ?w <- (Word (frequencyBpartitionExclude ?f1)
        		(frequencyBpartitionInclude ?f2)
                (frequency ?f3&:(<> ?f3 (+ ?f1 ?f2))))
    =>
    (modify ?m (includeWordCount (+ ?iCount ?f2))
               (excludeWordCount (+ ?eCount ?f3)))
    (modify ?w (frequency (+ ?f1 ?f2))))

(defrule rank-words-2 "Establish work ranker"
      (declare (salience 75))
    ?g <- (goal (name rank-words))
    ?m <- (model (training-set "A")
                 (includeWordCount ?iCount)
                 (excludeWordCount ?eCount))
    =>
    (printout t "establishing the word ranker and cursor" crlf)
    (assert (word-ranker (rank-iterator 1)))
    (assert (cursor (spos 1) (epos (+ ?iCount ?eCount)) (inc 1))))

(defrule rank-words-3 "if no other word with lower frequency rank and deactivate"
    (declare (salience 50))
    ?g <- (goal (name rank-words))
    ?r <- (word-ranker (rank-iterator ?currentRank))
    ?c <- (cursor (spos ?cval))
    ?m <- (model (id ?modelId))
    ?w <- (Word (isActivated 1)
                (text ?wordText)
                (frequency ?cval))
    =>
    (if (= (mod ?currentRank 1000) 0) then
         (printout t "ranking word #" ?currentRank crlf))
    (modify ?w (rank ?currentRank)
               (isActivated 0))
    (modify ?r (rank-iterator (+ ?currentRank 1))))

(defrule rank-words-4 "if the cursor has reached its limit retract it"
   (declare (salience 35))
    ?g <- (goal (name rank-words))
    ?c <- (cursor (spos ?spos) (epos ?epos&:(= ?spos ?epos)))
    =>
    (retract ?c))

(defrule rank-words-5 "advance the cursor"
   (declare (salience 25))
    ?g <- (goal (name rank-words))
    ?c <- (cursor (spos ?spos) (epos ?epos&:(< ?spos ?epos)) (inc ?inc))
    =>
    (modify ?c (spos (+ ?spos ?inc))))

(defrule rank-words-6 "Retract goal spawn activate low frequencies goal"
    (declare (salience 10))
    ?g <- (goal (name rank-words))
    =>
     (retract ?g)
    )

(deffunction rank-words () "Ranks the words based on corpus frequency"
    (printout t "ranking words" crlf)
    (assert (goal (name rank-words)))
    (run)
    (printout t "finished ranking words" crlf))

(provide C:/Users/kjm84/git/edda/edda/rulebase/jess/src/WordRanker) 
