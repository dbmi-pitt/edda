(defrule eTester "Can we grab a PicoEvidence?" 
   (declare (salience 4000))
   ?myEvidence <- (PicoEvidence)
=> 
   (bind ?pCategory (fact-slot-value ?myEvidence picoCategory))
   (bind ?pTerm (fact-slot-value ?myEvidence picoTerm))
   (printout t "category: " ?pCategory crlf " term: " ?pTerm crlf))

(deffunction eTest () "Try to fire a rule"
   (bind ?myEvidence (assert (PicoEvidence (picoCategory "Publication Type")
                                           (picoTerm "conference paper"))))
   (run)
   (retract ?myEvidence))

(deffunction eTest2 () "Try to fire a rule"
   (bind ?myObj (new PicoEvidence))
   (call ?myObj setPicoCategory "Publication Type")
   (call ?myObj setPicoTerm "conference paper")
   (bind ?myEvidence (definstance PicoEvidence ?myObj static))
   (run)
   (retract ?myEvidence))

(undefrule eTester)
