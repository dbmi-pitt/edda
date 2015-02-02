(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/EddaTemplates)

;; ====================================================================
;;
;; Low frequency words now have ranks that are low.  We want to prune
;; the high frequency words.  Here we can just retract Words along with
;; additional bookkeeping.
;;
;; ====================================================================

(defrule prune-frequent-words-0 "if the word rank is in the lower half reactivate"
    (declare (salience 100))
    ?g <- (goal (name prune-frequent-words))
    ?r <- (word-ranker (rank-iterator ?highRank))
    ?w <- (Word (isActivated 0) (rank ?wordRank&:(< ?wordRank (/ ?highRank 2))))
    =>
    (modify ?w (isActivated 1)))

(defrule prune-frequent-words-1 "if the word rank is in the upper half retract"
    (declare (salience 100))
    ?g <- (goal (name prune-frequent-words))
    ?r <- (word-ranker (rank-iterator ?highRank))
    ?w <- (Word (isActivated 0) 
        		(text ?text) 
        		(frequency ?frequency)
        		(rank ?wordRank&:(>= ?wordRank (/ ?highRank 2))))
    =>
    (printout t "retracting " ?text " freq = " ?frequency " rank = " ?wordRank crlf)
    (retract ?w))

(defrule prune-frequent-words-2 "retract goal and refresh the ranker fact"
    (declare (salience 25))
    ?g <- (goal (name prune-frequent-words))
    ?r <- (word-ranker (rank-iterator ?currentRank))
    =>
     (retract ?r)
     (retract ?g)
     (assert (word-ranker (rank-iterator 1))))

(deffunction prune-frequent-words () "prune freq" 
    (printout t "pruning frequent words" crlf)
    (assert (goal (name prune-frequent-words)))
    (run)
    (printout t "finished pruning frequent words" crlf))

(provide C:/Users/kjm84/git/edda/edda/rulebase/jess/src/PruneFrequentWords)
