;; ============================================================================
;;  
;;  Exclude if Age Category is infant and nothing else
;;
;;   If Age Category NOT Null
;;   Exclude if solely (Infants or any of its subclasses) 
;;
;; ============================================================================

(defrule pico-classify-exclude-only-infants "Exclude Age Category Infants"
    (declare (salience 80))
    (goal (name pico-classify))
    (classify-goal (id ?citationId)
        (name classify-citation)
        (isActivated 1))
    ?citation <- (Citation (id ?citationId)
                           (OBJECT ?citationObj)
                           (predictedClassification "NA")
                           (isActivated 1))
    (PicoEvidence (picoCategory "Age Category")
                  (picoTerm ?picoTerm&:(or
                               (eq ?picoTerm "infants")
                               (eq ?picoTerm "infants, newborn"))))
    (not (PicoEvidence (picoCategory "Age Category")
                  (picoTerm ?anotherPicoTerm&:(and
                               (neq ?anotherPicoTerm "infants")
                               (neq ?anotherPicoTerm "infants, newborn")))))
    =>
;;    (printout t "pico-classify-exclude-only-infants..." crlf)
    (modify ?citation (predictedClassification "exclude"))
    (modify ?citation (lastRuleApplied "pico-classify-exclude-only-infants"))
    (update ?citationObj))

;; =============================================================================
;;
;;   **********Species Category
;;  
;;  Exclude when Species Category is only non human
;;
;;  If Species Category NOT Null
;;  Exclude if NOT Homo sapiens
;;
;; ============================================================================

(defrule pico-classify-exclude-only-nonhumans "Exclude only nonhumans"
    (declare (salience 70))
    (goal (name pico-classify))
    (classify-goal (id ?citationId)
        (name classify-citation)
        (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (OBJECT ?citationObj)
        (predictedClassification "NA")
        (isActivated 1))
    (PicoEvidence (picoCategory ?picoCategory&:(eq ?picoCategory "Species Category"))
                  (picoTerm ?picoTerm&:(and
                               (neq ?picoTerm "homo sapiens")
                               (neq ?picoTerm "human study"))))
    (not (PicoEvidence (picoCategory "Species Category")
                       (picoTerm ?anotherPicoTerm&:(or
                               (eq ?anotherPicoTerm "homo sapiens")
                               (eq ?anotherPicoTerm "human study")))))
    =>
;;    (printout t "pico-classify-exclude-only-nonhumans..." crlf)
    (modify ?citation (predictedClassification "exclude"))
    (modify ?citation (lastRuleApplied "pico-classify-exclude-only-nonhumans"))
    (update ?citationObj))

;; ============================================================================
;;  
;;  Exclude when CIs exist but "mpa" and "blood" do not exist.
;;
;; ============================================================================

(defrule pico-classify-exclude-faulty-comparators "If both mpa & blood do not exist yet other comparators do"
    (declare (salience 60))
    (goal (name pico-classify))
    (classify-goal (id ?citationId)
        (name classify-citation)
        (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (OBJECT ?citationObj)
        (predictedClassification "NA")
        (isActivated 1))
    (PicoEvidence (picoCategory ?icCategory&:(eq ?icCategory "Intervention / Comparator Category"))
                  (picoTerm ?nonMpaTerm&:(and
                               (neq ?nonMpaTerm "mycophenolic acid")
                               (neq ?nonMpaTerm "blood"))))
    (not (and (PicoEvidence (picoCategory ?icCategory)
                            (picoTerm ?mpaTerm&:(eq ?mpaTerm "mycophenolic acid")))
              (PicoEvidence (picoCategory ?icCategory)
                            (picoTerm ?bloodTerm&:(eq ?bloodTerm "blood")))))
    =>
;;    (printout t "pico-classify-exclude-faulty-comparators..." crlf)
    (modify ?citation (predictedClassification "exclude"))
    (modify ?citation (lastRuleApplied "pico-classify-exclude-faulty-comparators"))
    (update ?citationObj))
