library(ConsensusClusterPlus)

if(!exists("buildEsData", mode = "function") ||
     !exists("readExampleSet", mode = "function")) {
  setwd("C:/EDDA/workspace/edda/rsrc/ConsensusClustering")
  source("eddaObpFunctions.R")
  source("eddaObpIoUtils.R")
  source("eddaObpHtml.R")
}

es <- readExampleSet('obp','tfIdf')
webContext <- createDirectory("C:/Software/tomcat8/webapps/edda/analysis008")
webContextImgOutput <- "C:/Software/tomcat8/webapps/edda/analysis008/images"
esData <- buildEsData(es, webContextImgOutput, metaFtrNum = 6)
sortingIndices <- rev(order(colSums(esData)))
sortingIndices <- rev(order(apply(esData, 2, var)))
esData500 <- esData[, rev(order(colSums(esData)))[0:500]]
esData500 <- t(esData500)
ccResults <- clusterDomainPartition(esData = esData500, 
                                    outputDirectoryPath = webContextImgOutput,
                                    maxK_input = 15)

outputHtml(ccResults, webContext, webContextImgOutput)


es <- readExampleSet('obpbio','tfIdf')
webContext <- createDirectory("C:/Software/tomcat8/webapps/edda/analysis009")
webContextImgOutput <- "C:/Software/tomcat8/webapps/edda/analysis009/images"
esData <- buildEsData(es, webContextImgOutput, metaFtrNum = 6)
sortingIndices <- rev(order(colSums(esData)))
sortingIndices <- rev(order(apply(esData, 2, var)))
esData500 <- esData[, rev(order(colSums(esData)))[0:500]]
esData500 <- t(esData500)
ccResults <- clusterDomainPartition(esData = esData500, 
                                    outputDirectoryPath = webContextImgOutput,
                                    maxK_input = 15)
outputHtml(ccResults, webContext, webContextImgOutput)