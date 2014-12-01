(import edu.pitt.dbmi.edda.rulebase.document.SystematicReview)
(import edu.pitt.dbmi.edda.rulebase.document.Citation)
(import edu.pitt.dbmi.edda.rulebase.pico.DocumentTerm)
(import edu.pitt.dbmi.edda.rulebase.pico.DocumentTerm)
(import edu.pitt.dbmi.edda.rulebase.pico.StudyDesign)
(import edu.pitt.dbmi.edda.rulebase.pico.PublicationType)
(import edu.pitt.dbmi.edda.rulebase.pico.OutcomePopulation)
(import edu.pitt.dbmi.edda.rulebase.pico.InterventionComparator)

;
; Template Identifiable
;
(deftemplate identifiable
  "All Facts have a unique Id for relationships"
  (slot ID))

;
; Template Activatable
;
(deftemplate activatable extends identifiable
  "These facts can be deactivated to avoid unwanted rule reactivation"
  (slot activated (type INTEGER) (default 1)))

;
; Template Goal
;
(deftemplate goal extends identifiable
  "The current goal representation"
  (slot name))
(deffunction newGoal (?name)
    (bind ?theGoal (assert (goal (name ?name))))
    (bind ?theGoalID (call ?theGoal getFactId))
    (modify ?theGoal (ID ?theGoalID)))
(deffunction ppGoal (?theGoal)
    (printout t "goal instance" crlf)
    (printout t  "	ID = " (fact-slot-value ?theGoal ID) crlf)
    (printout t  "	name = " (fact-slot-value ?theGoal name) crlf))
(deffunction unitTestGoal ()
    (bind ?aGoal (newGoal display-words))
    (ppGoal ?aGoal)
    (retract ?aGoal))
(unitTestGoal)

;
; Template systematic-review
;
(deftemplate systematic-review extends identifiable
  "Represents exerpts of the review that would have directed the process"
  (slot domain) ; Ameloblastoma, Flu,  Galactomannan, Maleria, Transplant
  )
(deffunction newSystematicReview (?domain)
    (bind ?theSystematicReview (assert (systematic-review (domain ?domain))))
    (bind ?theSystematicReviewID (call ?theSystematicReview getFactId))
    (modify ?theSystematicReview (ID ?theSystematicReviewID)))
(deffunction ppSystematicReview (?theSystematicReview)
    (printout t "systematic-review instance" crlf)
    (printout t  "	ID = " (fact-slot-value ?theSystematicReview ID) crlf)
    (printout t  "	domain = " (fact-slot-value ?theSystematicReview domain) crlf))
(deffunction unitTestSystematicReview ()
    (bind ?aSystematicReview (newSystematicReview Transplant))
    (ppSystematicReview ?aSystematicReview)
    (retract ?aSystematicReview))
(unitTestSystematicReview)

;
; Template citation
;
(deftemplate citation extends identifiable
  "Represents Title, MESH Terms, and Abstract"
  (slot domain) ; Ameloblastoma, Flu,  Galactomannan, Maleria, Transplant
  (slot partition)   ; A, B
  (slot classification) ; Include, Exclude
  (slot machine-classification (default TBD)) ; Include, Exclude, TBD
  (slot weight (type INTEGER) (default 0))
  )
(deffunction newCitation (?domain ?partition ?classification)
    (bind ?theCitation (assert (citation (domain ?domain)
                                         (partition ?partition)
                                         (classification ?classification))))
    (bind ?theCitationID (call ?theCitation getFactId))
    (modify ?theCitation (ID ?theCitationID)))
(deffunction addCitationWeight (?theCitation ?weightToAdd)
    (bind ?currentWeight (fact-slot-value ?theCitation weight))
    (bind ?currentWeight (+ ?currentWeight ?weightToAdd))
    (modify ?theCitation (weight ?currentWeight)))
(deffunction ppCitation (?theCitation)
    (printout t "citation instance" crlf)
    (printout t  "	ID = " (fact-slot-value ?theCitation ID) crlf)
    (printout t  "	domain = " (fact-slot-value ?theCitation domain) crlf)
    (printout t  "	partition = " (fact-slot-value ?theCitation partition) crlf)
    (printout t  "	classification = " (fact-slot-value ?theCitation classification) crlf)
    (printout t  "	machine-classification = " (fact-slot-value ?theCitation machine-classification) crlf)
    (printout t  "	weight = " (fact-slot-value ?theCitation weight) crlf)
)
(deffunction unitTestCitation ()
    (bind ?aCitation (newCitation Transplant A Exclude))
    (ppCitation ?aCitation)
    (retract ?aCitation)
    (bind ?bCitation (newCitation Transplant B Include))
    (ppCitation ?bCitation)
    (retract ?bCitation))
(unitTestCitation)

;
; Template word
;
(deftemplate word extends identifiable
  "Represents a word"
  (slot text) ; Ameloblastoma, Flu,  Galactomannan, Maleria, Transplant
  (slot weight (type INTEGER) (default 0)))
(deffunction newWord (?text)
    (bind ?theWord (assert (word (text ?text))))
    (bind ?theWordID (call ?theWord getFactId))
    (modify ?theWord (ID ?theWordID)))
(deffunction addWeight (?theWord ?weightToAdd)
    (bind ?currentWeight (fact-slot-value ?theWord weight))
    (bind ?currentWeight (+ ?currentWeight ?weightToAdd))
    (modify ?theWord (weight ?currentWeight)))
(deffunction ppWord (?theWord)
    (printout t "word instance" crlf)
    (printout t  "	ID = " (fact-slot-value ?theWord ID) crlf)
    (printout t  "	text = " (fact-slot-value ?theWord text) crlf)
    (printout t  "	weight = " (fact-slot-value ?theWord weight) crlf))
(deffunction unitTestWord ()
    (bind ?aWord (newWord transplant))
    (ppWord ?aWord)
    (retract ?aWord)
    (bind ?aWord (newWord mpa))
    (ppWord ?aWord)
    (retract ?aWord)
    (bind ?aWord (newWord ischemia))
    (ppWord ?aWord)
    (retract ?aWord))
(unitTestWord)

;
; Template word-occurence
;
(deftemplate word-occurence extends activatable
  "Represents a word-occurence"
  (slot container) ; systematic-review, citation, partition
  (slot word)
  (slot frequency (type INTEGER) (default 0)))
(deffunction newWordOccurence (?container ?word ?frequency)
    (bind ?theWordOccurence (assert (word-occurence (container ?container)
                                                    (word ?word) 
                                                    (frequency ?frequency))))
    (bind ?theWordOccurenceID (call ?theWordOccurence getFactId))
    (modify ?theWordOccurence (ID ?theWordOccurenceID)))
(deffunction deactivate (?theActivatable)
    (modify ?theActivatable (activated 0)))
(deffunction activate (?theActivatable)
    (modify ?theActivatable (activated 1)))
(deffunction ppWordOccurence (?theWordOccurence)
    (bind ?theContainer (fact-slot-value ?theWordOccurence container))
    (bind ?theWord (fact-slot-value ?theWordOccurence word))
    (bind ?theFrequency (fact-slot-value ?theWordOccurence frequency))
    (printout t "word-occurence instance" crlf)
    (printout t  "	ID = " (fact-slot-value ?theWordOccurence ID) crlf)
    (printout t  "	Container domain = " (fact-slot-value ?theContainer domain) crlf)
    (printout t  "	Word text = " (fact-slot-value ?theWord text) crlf)
    (printout t  "	Frequency = " ?theFrequency crlf)
    (printout t  "	activated = " (fact-slot-value ?theWordOccurence activated) crlf)
    )
(deffunction unitTestWordOccurence ()
    (bind ?citationA (newCitation Transplant A Exclude))
    (bind ?wordA (newWord random))
    (bind ?aWordOccurence
        (newWordOccurence
            ?citationA
            ?wordA
            7))
    (ppWordOccurence ?aWordOccurence)
    (bind ?citationB (newCitation Transplant B Include))
    (bind ?wordB (newWord study))
    (bind ?bWordOccurence 
        (newWordOccurence 
            ?citationB            
            ?wordB
            3))
    (ppWordOccurence ?bWordOccurence)
    (deactivate ?aWordOccurence)
    (ppWordOccurence ?aWordOccurence)
    (activate ?aWordOccurence)
    (ppWordOccurence ?aWordOccurence)
    (retract ?aWordOccurence)
    (retract ?bWordOccurence)
    (retract ?citationA)
    (retract ?wordA)
    (retract ?citationB)
    (retract ?wordB))
(unitTestWordOccurence)

;
; Template used
;
(deftemplate used extends identifiable
  "Marks evidence as used thereby restricting further firing"
  (slot goal)
  (slot evidence))
(deffunction newUsed (?goal ?evidence)
    (bind ?theUsed (assert (used (goal ?goal) (evidence ?evidence))))
    (bind ?theUsedID (call ?theUsed getFactId))
    (modify ?theUsed (ID ?theUsedID)))
(deffunction ppUsed (?theUsed)
    (bind ?evidence (fact-slot-value ?theUsed evidence))
    (printout t "used instance" crlf)
    (printout t  "	ID = " (fact-slot-value ?theUsed ID) crlf)
    (printout t  "	Evidence = " (fact-slot-value ?evidence ID) crlf))
(deffunction unitTestUsed ()
    (bind ?g (newGoal print-them))
    (bind ?w (newWord mpa))
    (bind ?u (newUsed ?g ?w))
    (ppUsed ?u)
    (retract ?g)
    (retract ?w)
    (retract ?u)
)
(unitTestUsed)
