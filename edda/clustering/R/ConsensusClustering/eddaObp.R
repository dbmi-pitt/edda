if(!exists("buildEsData", mode = "function") ||
  !exists("readExampleSet", mode = "function")) {
  setwd("C:/EDDA/workspace/edda/rsrc/ConsensusClustering")
  source("eddaObpFunctions.R")
  source("eddaObpIoUtils.R")
  source("eddaObpHtml.R")
}

es <- readExampleSet('obp','tfIdf')
webContext <- createDirectory("C:/Software/tomcat8/webapps/edda/analysis004")
webContextImgOutput <- "C:/Software/tomcat8/webapps/edda/analysis004/images"
esData <- buildEsData(es, webContextImgOutput, metaFtrNum = 6)
sortingIndices <- rev(order(colSums(esData)))
sortingIndices <- rev(order(apply(esData, 2, var)))
esData500 <- esData[, rev(order(colSums(esData)))[0:500]]
ccResults <- clusterDomainPartition(esData = esData500, 
                                   outputDirectoryPath = webContextImgOutput,
                                   maxK_input = 15)

outputHtml(ccResults, webContext, webContextImgOutput)





es <- readExampleSet('obp','tfIdf')
webContext <- createDirectory("C:/Software/tomcat8/webapps/edda/analysis004")
webContextImgOutput <- "C:/Software/tomcat8/webapps/edda/analysis004/images"
esData <- buildEsData(es, webContextImgOutput, metaFtrNum = 6)
sortingIndices <- rev(order(apply(esData, 2, var)))
esData500 <- esData[, rev(order(colSums(esData)))[0:500]]
ccResults = ConsensusClusterPlus(esData500,
                                 maxK=15,
                                 reps=50,
                                 pItem=0.75,
                                 pFeature=1,
                                 title=webContextImgOutput,
                                 clusterAlg="hc",
                                 distance="pearson",
                                 seed=1262118388.71279,
                                 plot="png")
#consensusTree - hclust object
consensusTree <- ccResults[[10]]["consensusTree"]
icl <- calcICL(ccResults,title=webContextImgOutput,plot="png")
clusterConsensus <- icl[["clusterConsensus"]]
itemConsensus <- icl[["itemConsensus"]]

outputHtml(ccResults, webContext, webContextImgOutput)


es <- readExampleSet('obp','termOccurance')
webContext <- createDirectory("C:/Software/tomcat8/webapps/edda/analysis007")
webContextImgOutput <- "C:/Software/tomcat8/webapps/edda/analysis007/images"
esData <- buildEsData(es, webContextImgOutput, metaFtrNum = 6)
sortingIndices <- rev(order(colSums(esData)))
esData500 <- esData[, rev(order(colSums(esData)))[0:1500]]
ccResults = ConsensusClusterPlus(esData500,
                               maxK=20,
                               reps=500,
                               pItem=0.75,
                               pFeature=1,
                               title=webContextImgOutput,
                               clusterAlg="hc",
                               distance="pearson",
                               seed=1262118388.71279,
                               plot="png")
#consensusTree - hclust object
consensusTree <- ccResults[[10]]["consensusTree"]
icl <- calcICL(ccResults,title=webContextImgOutput,plot="png")
clusterConsensus <- icl[["clusterConsensus"]]
itemConsensus <- icl[["itemConsensus"]]

outputHtml(ccResults, webContext, webContextImgOutput)
