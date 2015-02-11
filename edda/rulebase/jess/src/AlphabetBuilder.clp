(require C:/Users/kjm84/git/edda/edda/rulebase/jess/src/EddaTemplates) 

;;
;; Actual BagOfWords ranking is done in the Java code
;; but the discriminating Word objects are shadowed in Jess
;; for diagnostic purposes
;;

;;
;; Function to start rule firing
;;
(deffunction build-alphabet () "builds the alphabet from the training set"
    (printout t "building alphabet" crlf)
    (assert (model (id 1) (isActivated 1) (training-set "train") (test-set "test")))
    (assert (goal (name build-alphabet)))
    (run)
    (printout t "finished building alphabet" crlf))

;;
;;
;; Function to pull in the key alphabet terms
;;
(deffunction pullAlphabetTerms (?bagOfWordsEvidence) "pull in the key discriminating terms"
    (bind ?alphabet (call ?bagOfWordsEvidence getAlphabet))
    (bind ?alphabetWord (call ?alphabet nextAlphabetWord))
    (while  (neq ?alphabetWord nil)
        (add ?alphabetWord)
        (bind ?alphabetWord (call ?alphabet nextAlphabetWord))))

;;
;; First two rules pull a cached serialized alphabet
;;
(defrule build-alphabet-0 "If we have words in memory we have an alphabet"
  (declare (salience 125))
    ?g <- (goal (name build-alphabet))
    (exists (Word))
    =>
     (retract ?g))

(defrule build-alphabet-1 "pull alphabet to working memory"
    (declare (salience 115))
    ?g <- (goal (name build-alphabet))
    (BagOfWordsEvidence (OBJECT ?bagOfWordsEvidence))
    (not (exists (Word)))
    =>
    (pullAlphabetTerms ?bagOfWordsEvidence))

;;
;; Remaining rules fire to rebuild alphabet from scratch
;;

(defrule build-alphabet-2 "builds alphabet from training set"
    (declare (salience 100))
    ?g <- (goal (name build-alphabet))
    ?model <- (model (id ?modelId) (training-set ?p) (isActivated 1))
    ?citation <- (Citation (partition ?p) (OBJECT ?citationObj) (isActivated 1))
    (BagOfWordsEvidence (OBJECT ?bagOfWordsEvidence))
    (not (exists (Word)))
    =>
    (bind ?alphabet (call ?bagOfWordsEvidence getAlphabet))
    (call ?alphabet contributeToWordFrequencies ?citationObj)
    (modify ?citation (isActivated 0)))

(defrule build-alphabet-3 "Do some statistics on the alphabet and find best discriminators"
    (declare (salience 75))
    ?g <- (goal (name build-alphabet))
    (BagOfWordsEvidence (OBJECT ?bagOfWordsEvidence))
    (not (exists (Word)))
    =>
    (bind ?alphabet (call ?bagOfWordsEvidence getAlphabet))
    (call ?alphabet findBestDiscriminators))

(defrule build-alphabet-4 "pull alphabet to working memory"
    (declare (salience 50))
    ?g <- (goal (name build-alphabet))
    (BagOfWordsEvidence (OBJECT ?bagOfWordsEvidence))
    (not (exists (Word)))
    =>
    (pullAlphabetTerms ?bagOfWordsEvidence)
    (bind ?alphabet (call ?bagOfWordsEvidence getAlphabet))
    (call ?alphabet persistAlphabet)
    (retract ?g))

(provide C:/Users/kjm84/git/edda/edda/rulebase/jess/src/AlphabetBuilder) 
