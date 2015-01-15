#
# createDirectory
#
createDirectory <- function(directoryPath) {
  if (!file.exists(directoryPath)) { dir.create(directoryPath) }
  return(directoryPath)
}
#
# readExampleSet
#
# Reads in a comma separated value (csv) 
# generated from a RapidMiner example set
# 
readExampleSet <- function(domain = 'obp', metric = 'tfIdf') {
  saveFileName <- globRdaFileName(domain, metric)
  if (!file.exists(saveFileName)){
    csvFile <- globCsvFileName(domain, metric)
    print(paste("Reading ", csvFile))
    es <- read.table(file = csvFile, header = TRUE, sep=",")
    print(paste("Saving",saveFileName))
    save(es, file=saveFileName)
  }
  load(saveFileName)
  return(es)
}

#
# globCsvFileName
#
# generate a file name for csv input
# 
globCsvFileName <- function(domain = 'obp', metric = 'tfIdf') {
  csvFile <- 'T:/EDDA/WORKSPACE/KEVIN/clustering/data/'
  csvFile <- paste(csvFile,domain,sep="")
  csvFile <- paste(csvFile,"/csv/",sep="");
  csvFile <- paste(csvFile,domain,sep="");
  csvFile <- paste(csvFile,"_",sep="");
  csvFile <- paste(csvFile,metric,sep="")
  csvFile <- paste(csvFile,'.csv',sep="")
  return(csvFile)
}

#
# globRdaFileName
#
# geneate a file name for random access binary files
# 
globRdaFileName <- function(domain = 'obp', metric = 'tfIdf') {
  saveFileName <- "C:/edda/clustering/";
  saveFileName <- paste(saveFileName, domain, sep="")
  saveFileName <- paste(saveFileName, "_rdas/", sep="")
  saveFileName <- paste(saveFileName, domain, sep="")
  saveFileName <- paste(saveFileName, "_", sep="")
  saveFileName <- paste(saveFileName, metric, sep="")
  saveFileName <- paste(saveFileName, '.rda', sep="")
  return(saveFileName)
}

#
# testGlobbers
#
# check that file generation is correct
# 
testGlobbers <- function() {
  print(globCsvFileName('obpbio','tfIdf'))
  print(globCsvFileName('obpbio','termOccurance'))
  print(globRdaFileName('obpbio','tfIdf'))
  print(globRdaFileName('obpbio','termOccurance'))
  print(globCsvFileName('obp','tfIdf'))
  print(globCsvFileName('obp','termOccurance'))
  print(globRdaFileName('obp','tfIdf'))
  print(globRdaFileName('obp','termOccurance'))
}