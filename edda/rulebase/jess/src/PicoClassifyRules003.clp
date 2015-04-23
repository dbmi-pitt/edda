;; ===================================================
;;
;; Production Classification Suite
;;
;; ===================================================
(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/EddaTemplates)

;;                   
;; EXCLUSION RULES for ORGAN TRANSPLANT SR
;; (T. Bekhuis, 23 February 2105; all terms are preferred terms in the PICO+ terminology)
;;

;;
;; =============================================================================
;;
;;  **********Publication Type
;;  
;;  If Publication Type NOT Null 
;      Exclude if Publication Type EQ 
;;    (Literature review or any of its subclasses) OR
;;    (meta-analysis or its subclass) OR
;;    abstract OR
;;    comment OR
;;    editorial OR
;;    (letter or its subclass) OR
;;    opinion paper 
;;
;; ============================================================================
(defrule pico-classify-exclude-on-pubs "These publication types must be excluded"
    (declare (salience 1000))
    (goal (name pico-classify))
    (classify-goal (id ?citationId)
        (name classify-citation)
        (isActivated 1))
    (rule-goal (name ?ruleName&:(eq ?ruleName "pico-classify-exclude-on-pubs")) (isActivated 1))
    ?citation <- (Citation (id ?citationId)
                           (OBJECT ?citationObj)
                           (predictedClassification "NA")
                           (isActivated 1))
    (PicoEvidence
            (picoCategory ?picoCategory&:(eq ?picoCategory "Publication Type"))
            (picoTerm ?picoTerm&:(or 
                                     (eq ?picoTerm "literature review")
                                     (eq ?picoTerm "meta-analysis")
                                     (eq ?picoTerm "abstract")
                                     (eq ?picoTerm "comment")
                                     (eq ?picoTerm "editorial")
                                     (eq ?picoTerm "letter"))))
    =>
;;    (printout t ?ruleName " fires..." crlf)
    (modify ?citation (predictedClassification "exclude"))
    (modify ?citation (lastRuleApplied ?ruleName))
    (update ?citationObj))

;; ===================================================================================
;;
;; *********Study Design
;;
;; If Study Design NOT Null
;;  Exclude if Study Design EQ
;;    (Literature review or any of its subclasses) OR
;;    (meta-analysis or its subclass) OR
;;    (case study or its subclass)
;;  Exclude if (Study Design EQ animal study) AND (Species Category NOT Homo Sapiens)
;;
;; ==================================================================================

(defrule pico-classify-exclude-bad-study-lit "Exclude based on Study Design, Lit Review, Meta Analysis, Case"
    (declare (salience 990))
    (goal (name pico-classify))
    (classify-goal (id ?citationId)
        (name classify-citation)
        (isActivated 1))
    (rule-goal (name ?ruleName&:(eq ?ruleName "pico-classify-exclude-bad-study-lit")) (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (OBJECT ?citationObj)
        (predictedClassification "NA")
        (isActivated 1))
    (PicoEvidence (picoCategory ?picoCategory&:(eq ?picoCategory "Study Design"))
                  (picoTerm ?picoTerm&:(or
                                (eq ?picoTerm "literature review")
                                (eq ?picoTerm "meta-analysis")
                                (eq ?picoTerm "case study"))))
    =>
;;    (printout t ?ruleName " fires..." crlf)
    (modify ?citation (predictedClassification "exclude"))
    (modify ?citation (lastRuleApplied ?ruleName))
    (update ?citationObj))

(defrule pico-classify-exclude-bad-study-animals "Exclude based on Study Design Animal Study"
    (declare (salience 980))
    (goal (name pico-classify))
    (classify-goal (id ?citationId)
        (name classify-citation)
        (isActivated 1))
    (rule-goal (name ?ruleName&:(eq ?ruleName "pico-classify-exclude-bad-study-animals")) (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (OBJECT ?citationObj)
        (predictedClassification "NA")
        (isActivated 1))
    (PicoEvidence (picoCategory ?picoCategory&:(eq ?picoCategory "Study Design"))
                  (picoTerm ?picoTerm&:(eq ?picoTerm "animal study")))
    (not (PicoEvidence (picoCategory "Species Category")
                       (picoTerm ?anotherPicoTerm&:(eq ?anotherPicoTerm "homo sapiens"))))
    =>
;;    (printout t ?ruleName " fires..." crlf)
    (modify ?citation (lastRuleApplied ?ruleName))
    (modify ?citation (predictedClassification "exclude"))
    (update ?citationObj))

;; =============================================================================
;;
;;   **********Species Category
;;
;;  If Species Category NOT Null
;;  Exclude if NOT Homo sapiens
;;
;; ============================================================================

(defrule pico-classify-exclude-bad-species "Exclude not humans"
    (declare (salience 970))
    (goal (name pico-classify))
    (classify-goal (id ?citationId)
        (name classify-citation)
        (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (OBJECT ?citationObj)
        (predictedClassification "NA")
        (isActivated 1))
    (rule-goal (name ?ruleName&:(eq ?ruleName "pico-classify-exclude-bad-species")) (isActivated 1))
    (PicoEvidence (picoCategory ?speciesCategory&:(eq ?speciesCategory "Species Category"))
                  (picoTerm ?picoTerm&:(neq ?picoTerm "homo sapiens")))
    (not (PicoEvidence (picoCategory ?speciesCategory)
                       (picoTerm ?picoTermTwo&:(eq ?picoTermTwo "homo sapiens"))))
    =>
;;    (printout t ?ruleName " fires..." crlf)
    (modify ?citation (lastRuleApplied ?ruleName))
    (modify ?citation (predictedClassification "exclude"))
    (update ?citationObj))

;; ============================================================================
;;  
;; *************Population Category
;;
;; If Population Type Category NOT Null
;;  Exclude if NOT Organ Transplantations 
;;
;;  *********Note the goal is to keep solid transplant patients 
;;  *********who received kidney, liver, heart, lung, pancreas, 
;;  *********or intestine transplants. 
;;  
;;  *********If previous rule fails, try stricter rule as follows:
;;  
;;  If Population Type Category NOT Null
;;  Exclude if solely Cell Transplantation 
;;
;; ============================================================================
(defrule pico-classify-exclude-not-organ-transplant "Must be solid organ transplant"
    (declare (salience 960))
    (goal (name pico-classify))
    (classify-goal (id ?citationId)
        (name classify-citation)
        (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (OBJECT ?citationObj)
        (predictedClassification "NA")
        (isActivated 1))
    (rule-goal (name ?ruleName&:(eq ?ruleName "pico-classify-exclude-not-organ-transplant")) (isActivated 1))
    (PicoEvidence (picoCategory ?populationTypeCategory&:(eq ?populationTypeCategory "Population Type Category"))
                  (picoTerm ?transplantTerm&:(eq ?transplantTerm "transplantation"))
                  (ancestryDepth 1))
    (not (PicoEvidence (picoCategory ?populationTypeCategory)
                       (picoTerm ?organTransplantTerm&:(eq ?organTransplantTerm "organ transplantations"))))
    =>
;;    (printout t ?ruleName " fires..." crlf)
    (modify ?citation (lastRuleApplied ?ruleName))
    (modify ?citation (predictedClassification "exclude"))
    (update ?citationObj))

(defrule pico-classify-exclude-soley-cell-transplant "Exclude if solely cell transplantion"
    (declare (salience 950))
    (goal (name pico-classify))
    (classify-goal (id ?citationId)
        (name classify-citation)
        (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (OBJECT ?citationObj)
        (predictedClassification "NA")
        (isActivated 1))
    (rule-goal (name ?ruleName&:(eq ?ruleName "pico-classify-exclude-soley-cell-transplant")) (isActivated 1))
    (PicoEvidence (picoCategory ?populationCategory&:(eq ?populationCategory "Population Type Category"))
                  (picoTerm ?picoTermOne&:(eq ?picoTermOne "cell transplantation"))
                  (ancestryDepth ?ancestryDepth))
    (not (PicoEvidence (picoCategory ?populationCategory)
                       (picoTerm ?picoTermTwo&:(or
                               (eq ?picoTermTwo "cold ischemia")
                               (eq ?picoTermTwo "heterograft")
                               (eq ?picoTermTwo "homologous transplantation")
                               (eq ?picoTermTwo "homologous transplantation")
                               (eq ?picoTermTwo "organ transplantations")
                               (eq ?picoTermTwo "reimplantations")
                               (eq ?picoTermTwo "tissue and organ harvesting")
                               (eq ?picoTermTwo "tissue transplantation")
                               (eq ?picoTermTwo "transplantation, heterotopic")
                               (eq ?picoTermTwo "transplantation, autologous")
                               (eq ?picoTermTwo "warm ischemia")))))
    =>
;;    (printout t ?ruleName " fires..." crlf)
    (modify ?citation (lastRuleApplied ?ruleName))
    (modify ?citation (predictedClassification "exclude"))
    (update ?citationObj))
(undefrule pico-classify-exclude-soley-cell-transplant)

;; ============================================================================
;;  
;; **************Intervention / Comparator Category
;; 
;; Exclude if NOT Mycophenolic Acid 
;;
;; Exclude if NOT Blood
;;
;; Exclude if NOT Physiological Monitoring
;;
;; ============================================================================

(defrule pico-classify-exclude-not-mpa "Exclude if NOT Mycophenolic Acid"
    (declare (salience 940))
    (goal (name pico-classify))
    (classify-goal (id ?citationId)
        (name classify-citation)
        (isActivated 1))
    (rule-goal (name ?ruleName&:(eq ?ruleName "pico-classify-exclude-not-mpa")) (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (OBJECT ?citationObj)
        (predictedClassification "NA")
        (isActivated 1))
    (not (PicoEvidence (picoCategory "Intervention / Comparator Category")
                      (picoTerm ?mpaTerm&:(eq ?mpaTerm "mycophenolic acid"))))
    =>
;;    (printout t ?ruleName " fires..." crlf)
    (modify ?citation (lastRuleApplied ?ruleName))
    (modify ?citation (predictedClassification "exclude"))
    (update ?citationObj))

(defrule pico-classify-exclude-not-blood "Exclude if NOT blood"
    (declare (salience 930))
    (goal (name pico-classify))
    (classify-goal (id ?citationId)
        (name classify-citation)
        (isActivated 1))
    (rule-goal (name ?ruleName&:(eq ?ruleName "pico-classify-exclude-not-blood")) (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (OBJECT ?citationObj)
        (predictedClassification "NA")
        (isActivated 1))
    (not (PicoEvidence (picoCategory "Intervention / Comparator Category")
                      (picoTerm ?mpaTerm&:(eq ?mpaTerm "blood"))))
    =>
;;    (printout t ?ruleName " fires..." crlf)
    (modify ?citation (lastRuleApplied ?ruleName))
    (modify ?citation (predictedClassification "exclude"))
    (update ?citationObj))

(defrule pico-classify-exclude-not-physiological-monitoring "Exclude if NOT physiological monitoring"
    (declare (salience 920))
    (goal (name pico-classify))
    (classify-goal (id ?citationId)
        (name classify-citation)
        (isActivated 1))
    (rule-goal (name ?ruleName&:(eq ?ruleName "pico-classify-exclude-not-physiological-monitoring")) (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (OBJECT ?citationObj)
        (predictedClassification "NA")
        (isActivated 1))
    (not (PicoEvidence (picoCategory "Intervention / Comparator Category")
                      (picoTerm ?mpaTerm&:(eq ?mpaTerm "physiologic monitoring"))))
    =>
;;    (printout t ?ruleName " fires..." crlf)
    (modify ?citation (lastRuleApplied ?ruleName))
    (modify ?citation (predictedClassification "exclude"))
    (update ?citationObj))

;; =============================================================================================================
;;
;; pico-classify-exclude-missing-outcome
;;
;; Hi, Kevin, could you run an OUTCOME rule by itself before the meeting?
;; I know you don’t have time to run the entire rule set with this addition, but I’d like to see how it performs.
;; Please use the TRAINING dset.
;;
;; Try this rule: 
;;
;; Exclude if the outcome category is null. 
;;
;; =============================================================================================================
(defrule pico-classify-exclude-missing-outcome "Exclude if there is no Outcome Category"
    (declare (salience 910))
    (goal (name pico-classify))
    (classify-goal (id ?citationId)
        (name classify-citation)
        (isActivated 1))
    (rule-goal (name ?ruleName&:(eq ?ruleName "pico-classify-exclude-missing-outcome")) (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (OBJECT ?citationObj)
        (predictedClassification "NA")
        (isActivated 1))
    (not (PicoEvidence (picoCategory "Outcome Category")))
    =>
;;    (printout t ?ruleName " fires..." crlf)
    (modify ?citation (lastRuleApplied ?ruleName))
    (modify ?citation (predictedClassification "exclude"))
    (update ?citationObj))

;; ============================================================================
;;  
;;  Include all others
;;
;; ============================================================================

(defrule pico-classify-include-others "Include all others"
    (declare (salience 900))
    (goal (name pico-classify))
    (classify-goal (id ?citationId)
        (name classify-citation)
        (isActivated 1))
    (rule-goal (name ?ruleName&:(eq ?ruleName "pico-classify-include-others")) (isActivated 1))
    ?citation <- (Citation (id ?citationId)
        (OBJECT ?citationObj)
        (predictedClassification "NA")
        (isActivated 1))
    =>
;;    (printout t ?ruleName " fires..." crlf)
    (modify ?citation (lastRuleApplied ?ruleName))
    (modify ?citation (predictedClassification "include"))
    (update ?citationObj))

(provide C:/Users/kjm84/git/edda/edda/rulebase/jess/src/PicoClassifyRules003)
