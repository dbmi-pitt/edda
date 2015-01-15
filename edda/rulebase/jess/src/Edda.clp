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
    (while  (neq ?identifiableObj nil)   
        (bind ?identifiable (add ?identifiableObj))
        (bind ?idValue (fact-slot-value ?identifiable id))
        (printout t "Adding identifiable #" ?idValue crlf)
        (bind ?identifiableObj (call ?*reader* nextIdentifiable)))
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