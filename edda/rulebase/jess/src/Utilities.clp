(deffunction check-mod (?currentRank) "tests mod"
    (if (= (mod ?currentRank 100) 0) then
         (printout t ?currentRank " has zero modulus." crlf)
        else
         (printout t ?currentRank " has nonzero modulus" crlf)))
