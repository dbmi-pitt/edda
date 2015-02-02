;; ===================================================
;;
;; Classification Suite
;;
;; ====================================================
(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/EddaTemplates)

;;
;; Publication Type Necessary and Sufficient
;;
(defrule pico-classify-publication-type "Publication Type Necessary and Sufficient"
    (declare (salience 100))
    (goal (name pico-classify))
    (classify-goal (id ?citationId)
        (name classify-citation)
        (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (OBJECT ?citationObj)
        (predictedClassification "NA")
        (isActivated 1))
    (PicoEvidence (picoCategory "Publication Type")
        (picoTerm ?term&:(or
                (eq ?term "literature review")
                (eq ?term "conference proceedings")
                (eq ?term "conference paper")
                (eq ?term "comment")
                (eq ?term "editorial")
                (eq ?term "letter")
                (eq ?term "abstract")
                (eq ?term "review")
                (eq ?term "opinion paper"))))
    =>
    (printout t "pico-classify-publication-type: exclude" crlf)
    (modify ?citation (predictedClassification "exclude"))
    (update ?citationObj))

;;
;; Study Design Necessary and Sufficient
;;
(defrule pico-classify-study-design "Study Design Necessary and Sufficient"
    (declare (salience 95))
    (goal (name pico-classify))
    ?cg <- (classify-goal
        (id ?citationId)
        (name classify-citation)
        (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (OBJECT ?citationObj)
        (predictedClassification "NA")
        (isActivated 1))
    (PicoEvidence (picoCategory "Study Design")
        (picoTerm ?term&:(or (eq ?term "case report")
                			 (eq ?term "case study")
                             (eq ?term "animal study"))))
    =>
    (printout t "pico-classify-study-design: exclude" crlf)
    (modify ?citation (predictedClassification "exclude"))
    (update ?citationObj))

;;
;; Species Category
;;
;; if another species is mentioned but there is no mention of human(s)
;; exclude
;;
(defrule pico-classify-species "Species Category Necessary and Sufficient"
    (declare (salience 90))
    (goal (name pico-classify))
    (classify-goal (id ?citationId)
        (name classify-citation) (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (OBJECT ?citationObj)
        (predictedClassification "NA")
        (isActivated 1))
    (PicoEvidence (picoCategory "Species Category")
        (picoTerm ?term&:(and (neq ?term "human") (neq ?term "humans"))))
    (not (PicoEvidence (picoCategory "Species Category")
            (picoTerm ?humanTerm&:(and (eq ?humanTerm "human") (eq ?humanTerm "humans")))))
    =>
    (printout t "pico-classify-human-species: exclude" crlf)
    (modify ?citation (predictedClassification "exclude"))
    (update ?citationObj))

;;
;; Exclude if INTERVENTION / COMPARATOR CATEGORY NOT MPA or MMF
;;
(defrule pico-classify-intervention-mpa "Either MPA or MMF must be an intervention otherwise Exclude"
    (declare (salience 85))
    (goal (name pico-classify))
    (classify-goal (id ?citationId)
        (name classify-citation) (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (OBJECT ?citationObj)
        (predictedClassification "NA")
        (isActivated 1))
    (not (PicoEvidence (picoCategory "Intervention / Comparator Category")
            (picoTerm ?term&:(or (eq ?term "mycophenolic acid")
                    			 (eq ?term "mycophenolate mofetil")))))
    =>
    (printout t "pico-classify-intervention-comparator: exclude" crlf)
    (modify ?citation (predictedClassification "exclude"))
    (update ?citationObj))

;;
;; Otherwise include it
;;
(defrule pico-classify-include-others "Include all others"
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
    (printout t "pico-classify-include-others: include" crlf)
    (modify ?citation (predictedClassification "include"))
    (update ?citationObj))


(provide C:/Users/kjm84/git/edda/edda/rulebase/jess/src/PicoClassifyRules001)
