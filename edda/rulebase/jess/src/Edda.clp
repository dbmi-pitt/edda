(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/TallyCitations)
(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/ActivateCitations)
(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/AlphabetBuilder)
(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/PicoClassifier)
(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/PicoClassifyRules003)
(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/Diagnostics)
(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/DiagnosticsForCitations)
(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/RecindPredictions)
(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/InformationGainGraph)
(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/Cleaner)
(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/Explain)


(deffunction pull-sr-and-citations () "pulls sr spec and citations from file system"
    (printout t "pulling sr and citations" crlf)
    (call ?*reader* pullSrAndCitations)
    (bind ?identifiableObj (call ?*reader* nextIdentifiable))
    (bind ?numberIdentifiablesLoaded 0)
    (while  (neq ?identifiableObj nil)
        (bind ?identifiable (add ?identifiableObj))
        (bind ?idValue (fact-slot-value ?identifiable id))
        (bind ?numberIdentifiablesLoaded (+ ?numberIdentifiablesLoaded 1))
        (if (eq (mod ?numberIdentifiablesLoaded 100) 0) then
            (printout t "Added " ?numberIdentifiablesLoaded " identifiables." crlf))
        (bind ?identifiableObj (call ?*reader* nextIdentifiable)))
    (assert (model (id 1) (isActivated 1) (training-set "train") (test-set "test")))
    (printout t "finished pulling sr and citations" crlf))

(pull-sr-and-citations)
(tally-citations)

(defglobal ?*rules-list* = (create$
    "pico-classify-exclude-on-pubs"
    "pico-classify-exclude-bad-study-lit"
    "pico-classify-exclude-bad-study-animals"
    "pico-classify-exclude-bad-species"
    "pico-classify-exclude-not-organ-transplant"
    "pico-classify-exclude-soley-cell-transplant"
    "pico-classify-exclude-not-mpa"
    "pico-classify-exclude-not-blood"
    "pico-classify-exclude-not-physiological-monitoring"))

(defglobal ?*inc-all-rule* = "pico-classify-include-others")

(deffunction assert-rules (?activation) "generates a set of active rules"
    (bind ?rules (create$))
    (bind ?priority 1)
    (foreach ?rule ?*rules-list*
           (bind ?rules (insert$ ?rules (+ (length$ ?rules) 1)
                                 (assert (rule-goal (name ?rule)
                                                    (priority ?priority)
                                                    (isActivated ?activation)))))
           (bind ?priority (+ ?priority 1)))
    (return ?rules))


(deffunction retract-rules (?rules) "retracts each rule in the list"
    (foreach ?rule ?rules (retract ?rule)))

(deffunction cleanClassify () "clean up and classify again"
    (activate-citations)
    (recind-predictions)
    (resetExperiment)
    (pico-classify)
    (activate-citations))

(deffunction run-each-rule () "run each rule independently"
   (bind ?deActivatedRules (assert-rules 0))
   (bind ?incOthers (assert (rule-goal (name ?*inc-all-rule*) (isActivated 1))))
   (foreach ?rule ?deActivatedRules
       (printout t crlf crlf "Running with only " (fact-slot-value ?rule name) crlf)
       (modify ?rule (isActivated 1))
       (cleanClassify)
       (modify ?incOthers (isActivated 0))
       (explain)
       (modify ?rule (isActivated 0))
       (modify ?incOthers (isActivated 1)))
    (retract-rules ?deActivatedRules)
    (retract ?incOthers))

(deffunction assert-progressive-rules (?count) "activate up to count rules"
    (bind ?rules (create$))
    (bind ?priority 1)
    (foreach ?rule ?*rules-list*
           (if (<= ?priority ?count) then
               (bind ?rules (insert$ ?rules (+ (length$ ?rules) 1)
                                     (assert (rule-goal (name ?rule)
                                                   (priority ?priority)
                                                   (isActivated 1))))))
           (bind ?priority (+ ?priority 1)))
    (return ?rules))

(deffunction run-progressively () "run each rule sets progressively"
   (for (bind ?count 1) (<= ?count (length$ ?*rules-list*)) (++ ?count)
        (bind ?activeRules (assert-progressive-rules ?count))
        (bind ?incOthers (assert (rule-goal (name ?*inc-all-rule*) (isActivated 1))))
        (printout t crlf crlf "Running with first " ?count " excluders." crlf)
        (cleanClassify)
        (modify ?incOthers (isActivated 0))
        (explain)
        (retract-rules ?activeRules)
        (retract ?incOthers)))

(deffunction run-rules-together () "run rules together"
   (bind ?deActivatedRules (assert-rules 1))
   (bind ?incOthers (assert (rule-goal (name ?*inc-all-rule*) (isActivated 1))))
   (cleanClassify)
   (modify ?incOthers (isActivated 0))
   (explain)
   (retract-rules ?deActivatedRules)
   (retract ?incOthers))

(deffunction assert-named-rule (?ruleName) "activates only the named rule"
    (bind ?rules (create$))
    (foreach ?rule ?*rules-list*
           (if (eq ?rule ?ruleName) then
               (bind ?rules (insert$ ?rules (+ (length$ ?rules) 1)
                                     (assert (rule-goal (name ?rule)
                                                   (priority 1)
                                                   (isActivated 1)))))))
    (return ?rules))


(deffunction run-rule-by-name (?ruleName) "runs only one rule"
   (bind ?deActivatedRules (assert-named-rule ?ruleName))
   (bind ?incOthers (assert (rule-goal (name ?*inc-all-rule*) (isActivated 1))))
   (foreach ?rule ?deActivatedRules
       (printout t crlf crlf "Running with only " (fact-slot-value ?rule name) crlf)
       (modify ?rule (isActivated 1))
       (cleanClassify)
       (modify ?incOthers (isActivated 0))
       (explain)
       (modify ?rule (isActivated 0))
       (modify ?incOthers (isActivated 1)))
    (retract-rules ?deActivatedRules)
    (retract ?incOthers))

;;(run-rule-by-name "pico-classify-exclude-bad-species")

;;(run-each-rule)

    
    
