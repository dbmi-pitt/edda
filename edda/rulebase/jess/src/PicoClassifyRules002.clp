;; ===================================================
;;
;; Classification Suite
;;
;; ====================================================
(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/EddaTemplates)

;;
;;  Necessary and Sufficient include criteria as derived from
;;  reverse engineering the Systematic Review
;;
(defrule pico-classify-precise-include-criteria "Necessary and Sufficient include criteria"
    (declare (salience 100))
    (goal (name pico-classify))
    (classify-goal (id ?citationId)
        (name classify-citation)
        (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (OBJECT ?citationObj)
        (predictedClassification "NA")
        (isActivated 1))
    (PicoEvidence (picoCategory "Intervention / Comparator Category")
        (picoTerm ?mpaTerm&:(or (eq ?mpaTerm "mycophenolic acid")
                (eq ?mpaTerm "mycophenolate mofetil"))))
    (PicoEvidence (picoCategory "Intervention / Comparator Category")
        (picoTerm ?bloodTerm&:(or 
                (eq ?bloodTerm "blood")
                (eq ?bloodTerm "plasma")
                (eq ?bloodTerm "white blood cell count") 
                (eq ?bloodTerm "blood platelet count")
                (eq ?bloodTerm "cell counts")
                (eq ?bloodTerm "thymocyte")
                (eq ?bloodTerm "pharmacokinetics")
                (eq ?bloodTerm "lymphocytes")
                (eq ?bloodTerm "lymphocyte subsets")
                (eq ?bloodTerm "blood specimen collection")
                (eq ?bloodTerm "serum")
                (eq ?bloodTerm "serums"))))
    (not (PicoEvidence (picoCategory "Publication Type")
            (picoTerm ?termPubType&:(or
                    (eq ?termPubType "literature review")
                    (eq ?termPubType "conference proceedings")
                    (eq ?termPubType "comment")
                    (eq ?termPubType "editorial")
                    (eq ?termPubType "letter")
                    (eq ?termPubType "abstract")
                    (eq ?termPubType "review")
                    (eq ?termPubType "opinion paper")))))
    (not (PicoEvidence (picoCategory "Study Design")
            (picoTerm ?termStudyDesign&:(or 
                    (eq ?termStudyDesign "case report")
                    (eq ?termStudyDesign "animal study")))))
    (not (PicoEvidence (picoCategory "Species Category")
            (picoTerm ?speciesTerm&:(and (neq ?speciesTerm "human")
                                         (neq ?speciesTerm "humans")
                                         (neq ?speciesTerm "homo sapiens")
                                         (neq ?speciesTerm "cytomegalovirus")
                                         (neq ?speciesTerm "cytomegaloviruses")))))
    =>
    (printout t "pico-classify-precise-include-criteria: include" crlf)
    (modify ?citation (predictedClassification "include"))
    (update ?citationObj))
(undefrule pico-classify-precise-include-criteria)

;;
;;  Handle citations with Adverse reactions more liberally
;;
(defrule pico-classify-adverse-reactions "Liberally include adverse reactions"
    (declare (salience 95))
    (goal (name pico-classify))
    (classify-goal (id ?citationId)
        (name classify-citation)
        (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (OBJECT ?citationObj)
        (predictedClassification "NA")
        (isActivated 1))
    (PicoEvidence (picoCategory "Intervention / Comparator Category")
        (picoTerm ?mpaTerm&:(or (eq ?mpaTerm "mycophenolic acid")
                (eq ?mpaTerm "mycophenolate mofetil"))))
    (PicoEvidence (picoCategory "Outcome Category")
        (picoTerm ?bloodTerm&:((eq ?bloodTerm "blood"))))
    =>
    (printout t "pico-classify-adverse-reaction: include" crlf)
    (modify ?citation (predictedClassification "include"))
    (update ?citationObj))
(undefrule pico-classify-adverse-reactions)

;;
;; Otherwise exclude it
;;
(defrule pico-classify-exclude-others "Exclude all others"
    (declare (salience 80))
    (goal (name pico-classify))
    (classify-goal (id ?citationId)
        (name classify-citation)
        (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (OBJECT ?citationObj)
        (predictedClassification "NA")
        (isActivated 1))
    =>
    (printout t "pico-classify-exclude-others: exclude" crlf)
    (modify ?citation (predictedClassification "exclude"))
    (update ?citationObj))


(provide C:/Users/kjm84/git/edda/edda/rulebase/jess/src/PicoClassifyRules002)
