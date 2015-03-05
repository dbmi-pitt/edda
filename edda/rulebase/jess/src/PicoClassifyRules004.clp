;; ===================================================
;;
;; Classification Suite 004
;;
;; ===================================================
(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/EddaTemplates)

;; =============================================================================
;;  
;;  Exclude if Publication Type or Study Design mentions "literature review" or its
;;  narrower terms
;;
;; ============================================================================
(defrule pico-classify-exclude-on-pubs "These publication types must be excluded"
    (declare (salience 1000))
    (goal (name pico-classify))
    (classify-goal (id ?citationId)
        (name classify-citation)
        (isActivated 1))
    ?citation <- (Citation (id ?citationId)
                           (OBJECT ?citationObj)
                           (predictedClassification "NA")
                           (isActivated 1))
    (PicoEvidence
            (picoCategory ?picoCategory&:(or (eq ?picoCategory "Publication Type")
                                             (eq ?picoCategory "Study Design")))
            (picoTerm ?picoTerm&:(eq ?picoTerm "literature review")))
    =>
;;    (printout t "pico-classify-exclude-on-pubs fires..." crlf)
    (modify ?citation (predictedClassification "exclude"))
    (modify ?citation (lastRuleApplied "bad-pub-type"))
    (update ?citationObj))

;; ===========================================================================
;;  
;;  Exclude if Study Design mentions "case study"
;;  narrower terms
;;
;; ===========================================================================

(defrule pico-classify-exclude-case-study "Exclude Study Design Case Study"
    (declare (salience 900))
    (goal (name pico-classify))
    (classify-goal (id ?citationId)
        (name classify-citation)
        (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (OBJECT ?citationObj)
        (predictedClassification "NA")
        (isActivated 1))
    (PicoEvidence (picoCategory ?picoCategory&:(eq ?picoCategory "Study Design"))
                  (picoTerm ?picoTerm&:(eq ?picoTerm "case study")))
    =>
;;    (printout t "pico-classify-exclude-case-study..." crlf)
    (modify ?citation (predictedClassification "exclude"))
    (modify ?citation (lastRuleApplied "no-case-studies"))
    (update ?citationObj))

;; ============================================================================
;;  
;;  Exclude if Age Category is infant and nothing else
;;
;; ============================================================================

(defrule pico-classify-exclude-only-infants "Exclude Age Category Infants"
    (declare (salience 800))
    (goal (name pico-classify))
    (classify-goal (id ?citationId)
        (name classify-citation)
        (isActivated 1))
    ?citation <- (Citation (id ?citationId)
                           (OBJECT ?citationObj)
                           (predictedClassification "NA")
                           (isActivated 1))
    (PicoEvidence (picoCategory "Age Category")
                  (ancestryDepth 0)
                  (picoTerm ?picoTerm&:(or
                               (eq ?picoTerm "infants")
                               (eq ?picoTerm "infants, newborn"))))
    (not (PicoEvidence (picoCategory "Age Category")
                  (ancestryDepth 0)
                  (picoTerm ?anotherPicoTerm&:(and
                               (neq ?anotherPicoTerm "infants")
                               (neq ?anotherPicoTerm "infants, newborn")))))
    =>
;;    (printout t "pico-classify-exclude-only-infants..." crlf)
    (modify ?citation (predictedClassification "exclude"))
    (modify ?citation (lastRuleApplied "only-infants"))
    (update ?citationObj))

;; =============================================================================
;;  
;;  Exclude when Species Category is only non human
;;
;; ============================================================================

(defrule pico-classify-exclude-only-nonhumans "Exclude Age Category Infants"
    (declare (salience 700))
    (goal (name pico-classify))
    (classify-goal (id ?citationId)
        (name classify-citation)
        (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (OBJECT ?citationObj)
        (predictedClassification "NA")
        (isActivated 1))
    (PicoEvidence (picoCategory ?picoCategory&:(eq ?picoCategory "Species Category"))
                  (ancestryDepth 0)
                  (picoTerm ?picoTerm&:(and
                               (neq ?picoTerm "homo sapiens")
                               (neq ?picoTerm "human study"))))
    (not (PicoEvidence (picoCategory "Species Category")
                       (ancestryDepth 0)
                       (picoTerm ?anotherPicoTerm&:(or
                               (eq ?anotherPicoTerm "homo sapiens")
                               (eq ?anotherPicoTerm "human study")))))
    =>
;;    (printout t "pico-classify-exclude-only-nonhumans..." crlf)
    (modify ?citation (predictedClassification "exclude"))
    (modify ?citation (lastRuleApplied "only-nonhumans"))
    (update ?citationObj))

;; =============================================================================
;;  
;;  Exclude missing abstracts
;;
;; ============================================================================
(defrule pico-classify-exclude-missing-abstract ""
    (declare (salience 690))
    (goal (name pico-classify))
    (classify-goal (id ?citationId)
        (name classify-citation)
        (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (OBJECT ?citationObj)
        (predictedClassification "NA")
        (isActivated 1))
    (PicoEvidence (picoCategory ?picoCategory&:(eq ?picoCategory "Abstract Category"))
                  (picoTerm "missing"))
    =>
;;    (printout t "pico-classify-exclude-missing-abstract..." crlf)
    (modify ?citation (predictedClassification "exclude"))
    (modify ?citation (lastRuleApplied "missing-abstract"))
    (update ?citationObj))

;; ============================================================================
;;  
;;  Deflate any Intervention/Category term containing "blood" into "blood"
;;
;; ============================================================================
(defrule pico-classify-deflate-to-blood "any term with blood is changed to only blood"
    (declare (salience 680))
    (goal (name pico-classify))
    (classify-goal (id ?citationId)
        (name classify-citation)
        (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (OBJECT ?citationObj)
        (predictedClassification "NA")
        (isActivated 1))
    ?bloodSynonym <- 
        (PicoEvidence (picoCategory ?icCategory&:(eq ?icCategory "Intervention / Comparator Category"))
                  (picoTerm ?bloodContainingTerm&/.*blood.*/)
                  (OBJECT ?bloodSynonymObj))
    (not (PicoEvidence (picoCategory ?icCategory)
                       (picoTerm ?exactBloodTerm&:(or (eq ?exactBloodTerm "blood") 
                                                      (eq ?exactBloodTerm "creatinine blood level")))))
    =>
    (printout t "pico-classify-deflate-to-blood..." crlf)
    (printout t "   " ?bloodContainingTerm " ==> blood" crlf)
    (modify ?bloodSynonym (picoTerm "blood"))
    (update ?bloodSynonymObj))

(defrule pico-classify-deflate-to-mpa "mmf to mpa"
    (declare (salience 670))
    (goal (name pico-classify))
    (classify-goal (id ?citationId)
        (name classify-citation)
        (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (OBJECT ?citationObj)
        (predictedClassification "NA")
        (isActivated 1))
    ?mpaSynonym <- 
        (PicoEvidence (picoCategory ?icCategory&:(eq ?icCategory "Intervention / Comparator Category"))
                  (picoTerm ?mpaContainingTerm&/mycophenolate mofetil/)
                  (OBJECT ?mpaSynonymObj))
    (not (PicoEvidence (picoCategory ?icCategory)
                       (picoTerm "mycophenolic acid")))
    =>
    (printout t "pico-classify-deflate-to-mpa..." crlf)
    (printout t "   " ?mpaContainingTerm " ==> mycophenolic acid" crlf)
    (modify ?mpaSynonym (picoTerm "mycophenolic acid") (ancestryDepth 1))
    (update ?mpaSynonymObj))

;;matched multivariate analysis
(defrule pico-classify-infer-measurements "infer measurements"
   (declare (salience 660))
    (goal (name pico-classify))
    (classify-goal (id ?citationId)
        (name classify-citation)
        (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (OBJECT ?citationObj)
        (predictedClassification "NA")
        (content ?citationContent&/.*matched multivariate analysis.*/)
        (isActivated 1))
    (not (PicoEvidence (picoCategory ?icCategory&:(eq ?icCategory "Intervention / Comparator Category"))
                  (picoTerm "physiologic monitoring")))
    =>
    (printout t "pico-classify-infer-measurements..." crlf)
    (bind ?e (new PicoEvidence))
    (call ?e setPicoCategory ?icCategory)
    (call ?e setPicoTerm "physiologic monitoring")
    (call ?e setAncestryDepth 0)
    (call ?e setCitationId ?citationId)
    (add ?e))
(undefrule pico-classify-infer-measurements)

;; ============================================================================
;;  
;;  If Embase Keywords contains mycophenolic acid 2 morpholinoethyl ester
;;  and there is no direct mycophenolic acid term but there is a ancestor
;;
;; ============================================================================
(defrule pico-classify-screen-embase-mmf "Embases MMF in keywords only should not indicate MPA measurement"
    (declare (salience 640))
    (goal (name pico-classify))
    (classify-goal (id ?citationId)
        (name classify-citation)
        (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (OBJECT ?citationObj)
        (predictedClassification "NA")
        (isActivated 1))
    ?mpa <- 
        (PicoEvidence (picoCategory ?icCategory&:(eq ?icCategory "Intervention / Comparator Category"))
                  (picoTerm ?mpaContainingTerm&/mycophenolic acid/))
    (PicoEvidence (picoCategory "Embase Keywords Category")
                       (picoTerm "mmf"))
    (not (PicoEvidence (picoCategory "General Mention Category")
                       (picoTerm "mmf")))
    =>
    (printout t "pico-classify-screen-embase-mmf..." crlf)
    (retract ?mpa))

;; ============================================================================
;;  
;;  Include if mycophenolic acid, physiologic monitoring, and blood
;;
;; ============================================================================

(defrule pico-classify-measured-mpa "include if mpa is measured"
    (declare (salience 500))
    (goal (name pico-classify))
    (classify-goal (id ?citationId)
        (name classify-citation)
        (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (OBJECT ?citationObj)
        (predictedClassification "NA")
        (isActivated 1))
    (PicoEvidence (picoCategory ?icCategory&:(eq ?icCategory "Intervention / Comparator Category"))
                  (picoTerm "mycophenolic acid"))
    (PicoEvidence (picoCategory ?icCategory)
                  (picoTerm "physiologic monitoring"))
    (PicoEvidence (picoCategory ?icCategory)
                  (picoTerm "blood"))
    =>
    (modify ?citation (predictedClassification "include"))
    (modify ?citation (lastRuleApplied "pico-classify-measured-mpa"))
    (update ?citationObj))

;; ============================================================================
;;  
;;  Exclude all others
;;
;; ============================================================================

(defrule pico-classify-exclude-others "Exclude all others"
    (declare (salience 100))
    (goal (name pico-classify))
    (classify-goal (id ?citationId)
        (name classify-citation)
        (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (OBJECT ?citationObj)
        (predictedClassification "NA")
        (isActivated 1))
    =>
;;    (printout t "pico-classify-exclude-others: exclude" crlf)
    (modify ?citation (predictedClassification "exclude"))
    (modify ?citation (lastRuleApplied "exclude-all-others"))
    (update ?citationObj))

(provide C:/Users/kjm84/git/edda/edda/rulebase/jess/src/PicoClassifyRules004)
