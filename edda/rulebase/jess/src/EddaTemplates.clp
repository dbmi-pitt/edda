(import edu.pitt.dbmi.edda.rulebase.SystematicReviewReader)
(import edu.pitt.dbmi.edda.rulebase.Experiment)
(import edu.pitt.dbmi.edda.rulebase.Identifiable)
(import edu.pitt.dbmi.edda.rulebase.ClassificationEvidence)
(import edu.pitt.dbmi.edda.rulebase.pico.PicoEvidence)
(import edu.pitt.dbmi.edda.rulebase.MentionEvidence)
(import edu.pitt.dbmi.edda.rulebase.section.TitleEvidence)
(import edu.pitt.dbmi.edda.rulebase.section.AbstractEvidence)
(import edu.pitt.dbmi.edda.rulebase.bagawords.BagOfWordsEvidence)
(import edu.pitt.dbmi.edda.rulebase.bagawords.Alphabet)
(import edu.pitt.dbmi.edda.rulebase.document.SystematicReview)
(import edu.pitt.dbmi.edda.rulebase.document.Citation)
(import edu.pitt.dbmi.edda.rulebase.document.Word)

(deftemplate Identifiable
    (declare (from-class Identifiable)
             (include-variables TRUE)))

(deftemplate ClassificationEvidence extends Identifiable
    (declare (from-class ClassificationEvidence)
             (include-variables TRUE)))

(deftemplate MentionEvidence extends ClassificationEvidence
    (declare (from-class MentionEvidence)
             (include-variables TRUE)))

(deftemplate TitleEvidence extends MentionEvidence
    (declare (from-class TitleEvidence)
             (include-variables TRUE)))

(deftemplate AbstractEvidence extends MentionEvidence
    (declare (from-class AbstractEvidence)
             (include-variables TRUE)))

(deftemplate BagOfWordsEvidence extends ClassificationEvidence
    (declare (from-class BagOfWordsEvidence)
             (include-variables TRUE)))

(deftemplate Experiment extends Identifiable
    (declare (from-class Experiment)
             (include-variables TRUE)))

(deftemplate SystematicReview extends Identifiable
    (declare (from-class SystematicReview)
             (include-variables TRUE)))

(deftemplate Citation extends Identifiable
    (declare (from-class Citation)
             (include-variables TRUE)))

(deftemplate Word extends Identifiable
    (declare (from-class Word)
             (include-variables TRUE)))

(deftemplate PicoEvidence extends ClassificationEvidence
    (declare (from-class PicoEvidence)
             (include-variables TRUE)))

(deftemplate goal extends Identifiable "goal system"  
    (slot name))

(deftemplate prioritized-goal extends goal "prioritized goal"  
    (slot priority (type INTEGER) (default 0)))

(deftemplate classify-goal extends Identifiable "classification subgoal system"  
    (slot name)
    (slot priority (type INTEGER) (default 0)))

(deftemplate citation-counter "counts citations in various partitions"
    (slot domain (default Transplant))
    (slot partition)
    (slot actual-classification)
    (slot frequency (type INTEGER) (default 0)))

(deftemplate model extends Identifiable "defines parameters of a model"
    (slot training-set (default "train"))
    (slot test-set (default "test"))
    (slot excludeWordCount (type FLOAT)(default 0.0))
    (slot includeWordCount (type FLOAT)(default 0.0))
    )

(deftemplate word-ranker "ranks the word"
    (slot rank-iterator (type INTEGER) (default 0)))

(deftemplate cursor "used to simulate iteration"
    (slot spos (type INTEGER) (default 1))
    (slot epos (type INTEGER) (default 10))
    (slot inc (type INTEGER) (default 1)))

(defglobal ?*reader* = (new SystematicReviewReader))

(provide C:/Users/kjm84/git/edda/edda/rulebase/jess/src/EddaTemplates)    
        