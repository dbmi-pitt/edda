setwd("C:/Users/kjm84/Desktop/001_PRJS/edda_tm_data/")
getwd()

opbAnalysis <- function() {
  OBP <- read.table(
    file = "edda_tm_opt_20130809143404/obp_combined.csv",
    header = FALSE, sep = ",")
  OBP$DomainSet <- rep("OBP",nrow(OBP)) # make new column 
  OBP$DomainSet <- factor(OBP$DomainSet)
  names(OBP)[names(OBP)=="V2"] <- "NumTopics"
  names(OBP)[names(OBP)=="V3"] <- "Log_Likelihood"
  plot( OBP$Log_Likelihood ~ OBP$NumTopics, xlab = "Number of Topics", 
          ylab = "log P(w|T)",
          main = "OBP Topic Analysis")
}

binominalAnalysis <- function() {
  AMELO <- read.table(
    file = "edda_tm_opt_130118_03/amelo_combined.csv",
    header = TRUE, sep = ",")
  GALACTO <- read.table(
    file = "edda_tm_opt_130118_03/galacto_combined.csv",
    header = TRUE, sep = ",")
  MALARIA <- read.table(
    file = "edda_tm_opt_130118_03/malaria_combined.csv",
    header = TRUE, sep = ",")
  FLU <- read.table(
    file = "edda_tm_opt_130118_03/flu_combined.csv",
    header = TRUE, sep = ",")
  TRANSPLANT <- read.table(
    file = "edda_tm_opt_130118_03/transplant_combined.csv",
    header = TRUE, sep = ",")
  
  AMELO$DomainSet <- rep("AMELO",nrow(AMELO)) # make new column 
  AMELO <- AMELO[,c(3,1,2)] # order columns by indexing 
  GALACTO$DomainSet <- rep("GALACTO",nrow(GALACTO)) # make new column 
  GALACTO <- GALACTO[,c(3,1,2)] # order columns by indexing 
  MALARIA$DomainSet <- rep("MALARIA",nrow(MALARIA)) # make new column 
  MALARIA <- MALARIA[,c(3,1,2)] # order columns by indexing 
  FLU$DomainSet <- rep("FLU",nrow(FLU)) # make new column 
  FLU <- FLU[,c(3,1,2)] # order columns by indexing 
  TRANSPLANT$DomainSet <- rep("TRANSPLANT",nrow(TRANSPLANT)) # make new column 
  TRANSPLANT <- TRANSPLANT[,c(3,1,2)] # order columns by indexing
  
  TMDATA <- rbind(AMELO,GALACTO,MALARIA,FLU,TRANSPLANT)
  TMDATA$DomainSet <- factor(TMDATA$DomainSet)
  
  par(mfrow = c(3, 2), mar = c(6, 6, 4, 2))
  xyplot( AMELO$Log_Likelihood ~ AMELO$NumTopics, xlab = "Number of Topics", 
          ylab = "log P(w|T)",
          main = "AMELO Topic Analysis")
  plot(x = GALACTO$NumTopics, y = GALACTO$Log_Likelihood, xlab = "Number of Topics", 
       ylab = "log P(w|T)",
       main = "GALACTO Topic Analysis")
  plot(x = MALARIA$NumTopics, y = MALARIA$Log_Likelihood, xlab = "Number of Topics", 
       ylab = "log P(w|T)",
       main = "MALARIA Topic Analysis")
  plot(x = FLU$NumTopics, y = FLU$Log_Likelihood, xlab = "Number of Topics", 
       ylab = "log P(w|T)",
       main = "FLU Topic Analysis")
  plot(x = TRANSPLANT$NumTopics, y = TRANSPLANT$Log_Likelihood, xlab = "Number of Topics", 
       ylab = "log P(w|T)",
       main = "TRANSPLANT Topic Analysis")
}




