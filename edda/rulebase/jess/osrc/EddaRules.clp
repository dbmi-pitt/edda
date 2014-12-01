(require EddaTemplates.clp)
(defrule weight-words-by-sr
    "postively weight words appearing in SR"
    (declare (salience 100))
    ?goal <- (goal (name weight-words))
    ?sr <- (systematic-review)
    ?wOccurence <- (word-occurence (container ?sr) (word ?w) (activated 1))
=>
    (addWeight ?w 2)
    (printout t "sr adds to weight of " (fact-slot-value ?w text) crlf)
    (deactivate ?wOccurence))

(defrule weight-words-by-includes
    "postively weight words appearing in includes"
    (declare (salience 100))
    ?goal <- (goal (name weight-words))
    ?citation <- (citation (partition A) (classification Include))
    ?wOccurence <- (word-occurence (container ?citation)
                                   (word ?w)
                                   (activated 1))
=>
    (addWeight ?w 1)
    (printout t "include adds to weight of " (fact-slot-value ?w text) crlf)
    (deactivate ?wOccurence))

(defrule weight-words-by-excludes
    "negatively weight words appearing in excludes"
    (declare (salience 100))
    ?goal <- (goal (name weight-words))
    ?citation <- (citation (partition A) (classification Exclude))
    ?wOccurence <- (word-occurence (container ?citation)
                                  (word ?w)
                                  (activated 1))
=>
    (addWeight ?w -1)
    (printout t "exclude subtracts from weight of " (fact-slot-value ?w text) crlf)
    (deactivate ?wOccurence))

(defrule weight-words-transition
    "Retract goal to weight words"
    (declare (salience 50))
    ?goal <- (goal (name weight-words))
=>
    (retract ?goal))

;;
;; activate activatables
;;
(defrule activate-activatables
    "activate all deactivated activatables"
    (declare (salience 100))
    ?goal <- (goal (name activate-activatables))
    ?aDeActivated <- (activatable (activated 0))
=>
    (printout t activating crlf)
    (activate ?aDeActivated))

(defrule activate-activatables-transition
    "Retract goal to activate activatables"
    (declare (salience 50))
    ?goal <- (goal (name activate-activatables))
=>
    (retract ?goal))

;;
;;
;; Display the Words
;;
(defrule display-words
    "print the words to the screen"
    (declare (salience 100))
    ?goal <- (goal (name display-words))
    ?w <- (word)
=>
    (ppWord ?w))

(defrule display-words-transition
    "Retract goal to display words"
    (declare (salience 50))
    ?goal <- (goal (name display-words))
=>
    (retract ?goal))

;;
;; Score citations
;;
(defrule score-citation-by-word
    "tally word contributions to citations"
    (declare (salience 100))
    ?goal <- (goal (name score-citations))
    ?citation <- (citation (partition B))
    ?w <- (word {weight > 0})
    ?wOccurence <- (word-occurence (container ?citation) (word ?w) (activated 1))
=>
    (addCitationWeight ?citation (fact-slot-value ?w weight))
    (printout t (fact-slot-value ?w text) " adds positive weight to citation." crlf)
    (deactivate ?wOccurence))

(defrule score-citations-transition
    "Retract goal to score citations"
    (declare (salience 50))
    ?goal <- (goal (name score-citations))
=>
    (retract ?goal))

;;
;; Classify Citations
;;
(defrule classify-includes
    "Include those citations with score higher than zero"
    (declare (salience 100))
    ?goal <- (goal (name classify-citations))
    ?citation <- (citation (partition B) {weight > 0} (machine-classification TBD))
=>
    (modify ?citation (machine-classification Include)))

(defrule classify-excludes
    "Exclude those citations with score zero or lower"
    (declare (salience 100))
    ?goal <- (goal (name classify-citations))
    ?citation <- (citation (partition B) {weight <= 0} (machine-classification TBD))
=>
    (modify ?citation (machine-classification Exclude)))

(defrule classify-citations-transition
    "Retract goal to classify citations"
    (declare (salience 50))
    ?goal <- (goal (name classify-citations))
=>
    (retract ?goal))

;;
;; Display citations
;;
(defrule diplay-citation
    "Display the citation"
    (declare (salience 100))
    ?goal <- (goal (name display-citations))
    ?citation <- (citation (partition B))
=>
    (ppCitation ?citation))

(defrule display-citation-transition
    "Retract goal to display citations"
    (declare (salience 50))
    ?goal <- (goal (name display-citations))
=>
    (retract ?goal))
