(import edu.pitt.dbmi.edda.rulebase.SystematicReviewReader)
(import edu.pitt.dbmi.edda.rulebase.Identifiable)
(import edu.pitt.dbmi.edda.rulebase.document.SystematicReview)
(import edu.pitt.dbmi.edda.rulebase.document.Citation)
(import edu.pitt.dbmi.edda.rulebase.document.Word)
(import edu.pitt.dbmi.edda.rulebase.document.WordOccurence)
(import edu.pitt.dbmi.edda.rulebase.pico.DocumentTerm)
(import edu.pitt.dbmi.edda.rulebase.pico.DocumentTerm)
(import edu.pitt.dbmi.edda.rulebase.pico.StudyDesign)
(import edu.pitt.dbmi.edda.rulebase.pico.PublicationType)
(import edu.pitt.dbmi.edda.rulebase.pico.OutcomePopulation)
(import edu.pitt.dbmi.edda.rulebase.pico.InterventionComparator)

(deftemplate Identifiable
    (declare (from-class Identifiable)
             (include-variables TRUE)))

(deftemplate Word extends Identifiable
    (declare (from-class Word)
             (include-variables TRUE)))

(deftemplate Citation extends Identifiable
    (declare (from-class Citation)
             (include-variables TRUE)))

(deftemplate SystematicReview extends Identifiable
    (declare (from-class SystematicReview)
             (include-variables TRUE)))

(deftemplate DocumentTerm extends Identifiable
    (declare (from-class DocumentTerm)
             (include-variables TRUE)))

(deftemplate PublicationType extends DocumentTerm
    (declare (from-class PublicationType)
             (include-variables TRUE)))

(deftemplate OutcomePopulation extends DocumentTerm
    (declare (from-class OutcomePopulation)
             (include-variables TRUE)))

(deftemplate InterventionComparator extends DocumentTerm
    (declare (from-class InterventionComparator)
             (include-variables TRUE)))

(deftemplate StudyDesign extends DocumentTerm
    (declare (from-class StudyDesign)
             (include-variables TRUE)))

(deffunction pullData () "pulls sr data from the file system"
    (bind ?reader (new SystematicReviewReader))
    (call ?reader execute)
    (bind ?identifiable (call ?reader nextIdentifiable))
    (while  (neq ?identifiable nil)
        (add ?identifiable)
        (bind ?identifiable (call ?reader nextIdentifiable))))
   

    

        
        