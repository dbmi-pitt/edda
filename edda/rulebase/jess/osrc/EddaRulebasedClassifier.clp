(clear)

(require identifiable c:/Users/kjm84/git/edda/edda/rulebase/jess/src/EddaTemplates.clp)
(require EddaTestData c:/Users/kjm84/git/edda/edda/rulebase/jess/src/EddaTestData.clp)

(buildTestData)

(require EddaRules c:/Users/kjm84/git/edda/edda/rulebase/jess/src/EddaRules.clp)

(newGoal weight-words)
(run)

(newGoal activate-activatables)
(run)

(newGoal display-words)
(run)

(newGoal score-citations)
(run)

(newGoal classify-citations)
(run)

(newGoal display-citations)
(run)









