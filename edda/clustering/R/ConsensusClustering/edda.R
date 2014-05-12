
if(!exists("analyzeCC", mode = "function") 
   || !exists("analyzeK", mode = "function")
   || !exists("incsPerCluster", mode = "function")
   || !exists("filterBestMedianAbsoluteDeviation")
   || !exists("changeToDomainDirectory", mode = "function")
   || !exists("buildOutputDirectoryPath", mode = "function")
   || !exists("clusterDomainPartition", mode = "function")) {
  setwd("C:/EDDA/workspace/edda/rsrc/ConsensusClustering")
  source("eddaFunctions.R")
}

parentDirectory <- "T:/EDDA/WORKSPACE/KEVIN/clustering/data/"

domains = c('amelo','flu','galacto','malaria','transplant')
domains = c('amelo', 'galacto', 'malaria')
domains = c('malaria')

parentDirectory <- "T:/EDDA/WORKSPACE/KEVIN/clustering/data"
setwd(parentDirectory)

for (domain in domains) {
  trainingCsvFile <- paste(domain,"/csv/A.csv",sep="")
  testingCsvFile <- paste(domain,"/csv/B_by_A.csv",sep="")
  print(paste("Reading ",trainingCsvFile))
  esTrain <- read.table(file = trainingCsvFile, header = TRUE, sep=",")
  print(paste("Reading ",testingCsvFile))
  esTest <- read.table(file = testingCsvFile, header = TRUE, sep=",")
  esTrainDocNum = nrow(esTrain)
  esTestDocNum = nrow(esTest)
  esTrain$deck = rep("train", esTrainDocNum)
  esTest$deck = rep("test", esTestDocNum)
  es = rbind(esTrain, esTest)
  saveFileName <- paste("C:/edda/clustering/", paste(domain, "_train_A_test_B.rda", sep=""), sep="")
  print(paste("Saving",saveFileName))
  save(es, file=saveFileName)
  
  trainingCsvFile <- paste(domain,"/csv/B.csv",sep="")
  testingCsvFile <- paste(domain,"/csv/A_by_B.csv",sep="")
  print(paste("Reading",trainingCsvFile))
  esTrain <- read.table(file = trainingCsvFile, header = TRUE, sep=",")
  print(paste("Reading",testingCsvFile))
  esTest <- read.table(file = testingCsvFile, header = TRUE, sep=",")
  esTrainDocNum = nrow(esTrain)
  esTestDocNum = nrow(esTest)
  esTrain$deck = rep("train", esTrainDocNum)
  esTest$deck = rep("test", esTestDocNum)
  es = rbind(esTrain, esTest)
  saveFileName <- paste("C:/edda/clustering/", paste(domain, "_train_B_test_A.rda", sep=""), sep="")
  print(paste("Saving",saveFileName))
  save(es, file=saveFileName)
}

for (domain in domains) {
  esFileName <- paste("C:/edda/clustering/", paste(domain, "_train_A_test_B.rda", sep=""),  sep="")
  oDirectoryName <- paste("C:/edda/clustering/", paste(domain, "_train_A_test_B_output",  sep=""),  sep="")
  if (!file.exists(oDirectoryName)) { dir.create(oDirectoryName) }
  print(paste("Loading",esFileName))
  load(file=esFileName)
  print(paste("Analyzing",esFileName))
  analysis <- clusterDomainPartition(exampleSet = es, 
                                     outputDirectoryPath = oDirectoryName)
  print(analysis)
  
  esFileName <- paste("C:/edda/clustering/", paste(domain, "_train_B_test_A.rda",  sep=""),  sep="")
  oDirectoryName <- paste("C:/edda/clustering/", paste(domain, "_train_B_test_A_output",  sep=""),  sep="")
  if (!file.exists(oDirectoryName)) { dir.create(oDirectoryName) }
  print(paste("Loading",esFileName))
  load(file=esFileName)
  print(paste("Analyzing",esFileName))
  analysis <- clusterDomainPartition(exampleSet = es, 
                                     outputDirectoryPath = oDirectoryName)
  print(analysis)
}




