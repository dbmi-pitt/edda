(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/TallyCitations)
(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/ActivateCitations)
(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/AlphabetBuilder)
(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/PicoClassifier)
;(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/DynamicClassifier)
(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/Diagnostics)
(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/RecindPredictions)
(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/Cleaner)

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


(deffunction cleanForClassify () "clear for classify"
    (resetExperiment)
    (cleanGoals)
    (activate-citations))

(pull-sr-and-citations)
(tally-citations)
;;(build-alphabet)
;;(display-words)

(deffunction cleanClassify () "clean up and classify again"
    (activate-citations)
    (recind-predictions)
    (resetExperiment)
    (pico-classify)
    (activate-citations)
    (display-citation-false-negatives))

(cleanClassify)

;;(modify ?testCitations (isActivated 1))


(defquery query-find-false-negatives
    "Find all 'include' citations designated 'exclude' by the algorithm"
    (Citation (predictedClassification "exclude")
        (predictedClassification "true")
        (isActivated 1)))
(deffunction iterate-false-negatives ()
    "Iterate through false negatives"
    (bind ?result (run-query* query-find-false-negatives))
    (if (?result next) then
        (bind ?citationKey (?result getString citationKey))
        (printout t "Got citation key = " ?citationKey crlf)
        else
        (printout t "Query results are empty" crlf)
        ))
   
    
    
