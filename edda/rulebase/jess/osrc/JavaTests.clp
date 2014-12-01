(batch c:/Users/kjm84/git/edda/edda/rulebase/jess/src/EddaTemplates.clp)
(import edu.pitt.dbmi.edda.rulebase.DocumentTerm)
(import edu.pitt.dbmi.edda.rulebase.StudyDesign)
(import edu.pitt.dbmi.edda.rulebase.PublicationType)
(import edu.pitt.dbmi.edda.rulebase.OutcomePopulation)
(import edu.pitt.dbmi.edda.rulebase.InterventionComparator)
(deftemplate document-term
    (declare (from-class DocumentTerm)
             (include-variables TRUE)))
(deftemplate study-design
    (declare (from-class StudyDesign)
             (include-variables TRUE)))
(deftemplate publication-type
    (declare (from-class PublicationType)
             (include-variables TRUE)))
(deftemplate outcome-population
    (declare (from-class OutcomePopulation)
             (include-variables TRUE)))
(deftemplate intervention-comparator
    (declare (from-class InterventionComparator)
             (include-variables TRUE)))

(bind ?x (new DocumentTerm))
(bind ?a (new StudyDesign))
(bind ?b (new PublicationType))
(bind ?c (new OutcomePopulation))
(bind ?d (new InterventionComparator))
(add ?x)
(add ?a)
(add ?b)
(add ?c)
(add ?d)

(printout t (?a getTerm) crlf)
(printout t (?a getDocumentId) crlf)
(printout t (?b getTerm) crlf)
(printout t (?b getDocumentId) crlf)
(printout t (?c getTerm) crlf)
(printout t (?c getDocumentId) crlf)
(printout t (?x getTerm) crlf)
(printout t (?x getDocumentId) crlf)

(modify 16 (term mpa))
(modify 17 (term randomized))
(modify 18 (term organ))
(modify 19 (term transplant))

(printout t (?a getTerm) crlf)
(printout t (?b getTerm) crlf)
(printout t (?c getTerm) crlf)
(printout t (?x getTerm) crlf)

(defrule display-document-terms
    "Test polymorphism of shadow facts"
    (declare (salience 100))
    ?goal <- (goal (name display-document-terms))
    ?documentTerm <- (document-term)
=>
    (printout t "Found document term " crlf))

(defrule display-study-designs
    "Test polymorphism of shadow facts"
    (declare (salience 100))
    ?goal <- (goal (name display-document-terms))
    ?studyDesignTerm <- (study-design)
=>
    (printout t "Found study design " crlf))

(defrule display-document-terms-transition
    "Retract goal to display document terms"
    (declare (salience 50))
    ?goal <- (goal (name display-document-terms))
=>
    (printout t "Retracting Goal to display-document-terms" crlf)
    (retract ?goal))

(assert (goal (name display-document-terms)))
(run)

(bind ?b (assert (study-design (documentId "5555") (term "random control trial"))))
;;(defclass StudyDesign StudyDesign)

?a <- (definstance StudyDesign auto)

