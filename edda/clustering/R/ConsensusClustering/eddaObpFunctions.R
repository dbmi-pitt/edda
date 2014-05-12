#
# Build examples matrix from DataSet
#
#
# Function - clusterDomainPartition
#
# Runs ConsensusClusterPlus on a combined training and testing data set
# and then prints out the results
#
buildEsData <- function(exampleSet,
                        outputDirectoryPath,
                        metaFtrNum = 6) {
  docNum = nrow(exampleSet)
  ftrNum = ncol(exampleSet)
  regFtrNum = ftrNum - metaFtrNum
  fileNames = as.vector(exampleSet$metadata_file)
  ftrNames = colnames(exampleSet)[1:regFtrNum]
  esData = as.matrix(exampleSet[1:docNum,1:regFtrNum],
                     nrow = docNum, 
                     ncol = regFtrNum,
                     byRow="TRUE")
  rownames(esData) <- fileNames
  colnames(esData) <- ftrNames
  print(paste('Built esData'))
  return(esData)
}

#
# Function - clusterDomainPartition
#
# Runs ConsensusClusterPlus on a combined training and testing data set
# and then prints out the results
#
clusterDomainPartition <- function(esData,
                                   outputDirectoryPath,
                                   maxK_input = 6) {
  results = ConsensusClusterPlus(esData,
                                 maxK=maxK_input,
                                 reps=20,
                                 pItem=0.75,
                                 pFeature=1,
                                 title=outputDirectoryPath,
                                 clusterAlg="hc",
                                 distance="pearson",
                                 seed=1262118388.71279,
                                 plot="pngBMP")
  print(paste('Finished ConsensusClusterPlus'))
  return(results)
}

#
# Function - createXhtmlPrefix
# 
# Creates html header information in a N:1 char vector
#
createXhtmlPrefix <- function() {
  return(c("<?xml version=\"1.0\" encoding=\"UTF-8\"?>",
           "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"",
           "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">",
           "<html xmlns=\"http://www.w3.org/1999/xhtml\">",
           "<head>",
           "<title>Obp Clustering Analysis</title>",
           "<link href=\"../obp.css\" rel=\"stylesheet\" type=\"text/css\">",
           "</link>",
           "</head>",
           "<body>"))
}
#
# Function - createXhtmlSuffix
# 
# Creates html header information in a N:1 char vector
#
createXhtmlSuffix <- function() {
  return(c("</body>",
    "</html>"))
}
#
# Function - newTextBlock
# 
# Creates a place to append text
#
newTextBlock <- function(firstValue) {
  return(c(firstValue))
}
#
# Function - appendText
# 
# Appends text
#
appendText <- function(textBlock, textLine) {
  for (textChunk in textLine) {
    textBlock[length(textBlock)+1] = textChunk
  }
  return(textBlock)
}
#
# Function - writeTextBlockToFile
#
writeTextBlockToFile <- function(fileName, textBlock) {
  if (file.exists(fileName)) {
    file.remove(fileName)
  }
  sink(fileName)
  for (textLine in textBlock) {
    cat(textLine)
  }
  sink()
}
#
# Function - buildAnalysisFileName
#
# Takes the analysis number and bulids a name for the html file
#
buildAnalysisFileName <- function(directoryPath = "", analysisNumber) {
  accumulator <- directoryPath
  accumulator <- paste(accumulator,"analysis_",sep="/")
  accumulator <- paste(accumulator,analysisNumber,sep="")
  accumulator <- paste(accumulator,".html",sep="")
  return(accumulator)
}
#
# Function - buildAnalysisListItem
#
# Takes the analysis number and bulids a hyper link to the
# the analysis html
#
buildAnalysisListItem <- function(analysisNumber) {
  accumulator <- paste("<li><a href='analysis_",analysisNumber,sep="")
  accumulator <- paste(accumulator,".html",sep="")
  accumulator <- paste(accumulator,"'>Analysis using ",sep="")
  accumulator <- paste(accumulator,analysisNumber,sep="")
  accumulator <- paste(accumulator," clusters</a></li>",sep="")
  return(accumulator)
}
#
# Function - buildAnalysisHeader
#
# Takes the analysis number and bulids a h1 header
#
buildAnalysisHeader <- function(analysisNumber) {
  accumulator <- "<h1>Analysis using "
  accumulator <- paste(accumulator,analysisNumber,sep="")
  accumulator <- paste(accumulator," clusters</h1>",sep="")
  return(accumulator)
}
#
# Function - buildClusterHeader
#
# Takes the analysis number and bulids a h1 header
#
buildClusterHeader <- function(clusterNumber) {
  accumulator <- "<h2>Cluster "
  accumulator <- paste(accumulator,clusterNumber,sep="")
  accumulator <- paste(accumulator,"</h2>",sep="")
  return(accumulator)
}
#
# Function - buildImageLinks
#
# Builds links to the images produced by CCPlus
#
buildImageLinks <- function(oDirectoryName) {
  print(oDirectoryName)
  imgFiles <- list.files(oDirectoryName, pattern = "*.png", full.names = FALSE)
  accumulator <- "<ul id='images'>"
  for (imgFile in imgFiles) {
    print(imgFile)
    accumulator <- appendText(accumulator,"<li><a href='images/")
    accumulator <- appendText(accumulator,imgFile)
    accumulator <- appendText(accumulator,"' target='_blank'>")
    accumulator <- appendText(accumulator,imgFile)
    accumulator <- appendText(accumulator,"</a></li>")
  }
  accumulator <- appendText(accumulator,"</ul>")
  return(accumulator)
}
#
# findWordRank
#
# 
findWordRank <- function(esDataColumns,sortingVector) {
  result <- -1
  for (idx in sortingVector) {
    wordAtIdx <- esDataColumns[idx]
    if (wordAtIdx == "squamous") {
      result <- idx
    }
  } 
  return(result)
}