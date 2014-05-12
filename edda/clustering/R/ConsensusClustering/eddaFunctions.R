#
# Load the ConsensusClusterPlus library
#
library(ConsensusClusterPlus)

#
# Function - clusterDomainPartition
#
# Runs ConsensusClusterPlus on a combined training and testing data set
# and then prints out the results
#
clusterDomainPartition <- function(exampleSet,
                                   outputDirectoryPath,
                                   metaFtrNum = 6, isByRow = TRUE) {
  docNum = nrow(exampleSet)
  ftrNum = ncol(exampleSet)
  regFtrNum = ftrNum - metaFtrNum
  fileNames = as.vector(exampleSet$metadata_file)
  ftrNames = colnames(exampleSet)[1:regFtrNum]
  esData = as.matrix(exampleSet[1:docNum,1:regFtrNum],
                     nrow = docNum, 
                     ncol = regFtrNum,
                     isByRow)
  rownames(esData) <- fileNames
  colnames(esData) <- ftrNames
  esData = t(esData)
  print(paste('Built esData'))
  
  maxK_input <- 6
  results = ConsensusClusterPlus(esData,
                                 maxK=maxK_input,
                                 reps=20,
                                 pItem=.75,
                                 pFeature=1,
                                 title=outputDirectoryPath,
                                 clusterAlg="kmdist",
                                 distance="pearson",
                                 seed=1262118388.71279,
                                 plot="pngBMP")
  print(paste('Finished ConsensusClusterPlus'))
  
  analysis <- analyzeCC(results,exampleSet)
  print(paste('Finished analyzeCC'))
  
  return(analysis)
}


#
# Function analyzeCC 
#
# Performs a series of classification studies on a large multiple run
# of the ConsensusClusterPlus function.  
#
# resultCC - Contains dataFrames for runs of each of the preferred cluster k's.
# exampleSet - Contains preprocessed example set data
#
analyzeCC <- function(ccResults,exampleSet) {
  maxK = length(ccResults)
  analysis <- analyzeK(2,ccResults,exampleSet)
  for(i in 3:maxK) {
    analysis <- cbind(analysis,analyzeK(i,ccResults,exampleSet))
  }
  colnames(analysis) <- as.character(2:(ncol(analysis)+1))
  return(analysis)
}

#
# Function analyzeK 
#
# For a given K which is the predefined number of partitioning clusters
# used for a run of ConcensusClusterPlus we choose the cluster that
# has the most training set includes and assume the rest of the
# clusters are exclude clusters.  Our hope is that the relatively few
# include examples will all be segregated to one cluster out of the many
#
analyzeK <- function(k,ccResults,exampleSet) {
  #
  # Analyze K Cluster Model Run
  #
  exampleSet$cluster <- as.vector(ccResults[[k]]$consensusClass)
  #
  # Determine the cluster with the most training includes
  #
  trainInc <- lapply(as.list(1:k), incsPerCluster, "train", "include", exampleSet)
  trainInc <- unlist(trainInc)
  inClusterIdx <- which.max(t(trainInc))
  
  # 
  # True positives are # test includes in includeClusterIdx
  # False positives are # test includes not in includeClusterIdx
  # True negatives are # test excludes not in includeClusterIdx
  # False negatives are # test excludes in includeClusterIdx
  # 
  TPs <-  nrow(exampleSet[(exampleSet$deck == 'test') &
                     (exampleSet$label == 'include') & 
                     (exampleSet$cluster == inClusterIdx),])
  FPs <-  nrow(exampleSet[(exampleSet$deck == 'test') &
                     (exampleSet$label == 'exclude') & 
                     (exampleSet$cluster == inClusterIdx),])
  TNs <-  nrow(exampleSet[(exampleSet$deck == 'test') &
                   (exampleSet$label == 'exclude') & 
                   (exampleSet$cluster != inClusterIdx),])                    
  FNs <-  nrow(exampleSet[(exampleSet$deck == 'test') &
                   (exampleSet$label == 'include') & 
                   (exampleSet$cluster != inClusterIdx),])
  
  precision <- TPs / (TPs + FPs)
  recall <- TPs / (TPs + FNs)
  analysis <- matrix(c(precision, recall))
  rownames(analysis) <- c('precision','recall')
  
  exampleSet$cluster <- NULL
  
  return(analysis)
}


#
# Function incsPerCluster
#
# This function is designed to work with lapply and a list
# of cluster indices.
#
# Inputs:
#      clusterIdx - mapped by lapply
#      es - data frame containing all Edda information
#
incsPerCluster <- function(clusterIdx, deck, label, es) {
  return(nrow(es[(es$deck == deck) &
             (es$label == label) & 
             (es$cluster == clusterIdx),]))
}

#
# Function filterBestMedianAbsoluteDeviation
#
# This function chooses only features with the highest
# numberOfFeatures median absolute deviation
#
# Inputs:
#
#     
#      
#
filterBestMedianAbsoluteDeviation <- function(esData) {
  mads=apply(esData,1,mad)
  esData=esData[rev(order(mads))[1:5000],]
  esData = sweep(esData, 1, apply(esData,1,median,na.rm=T))
  return(esData)
}


changeToDomainDirectory <- function(parentDirectory,domain) {
  workingDirectory <- paste(parentDirectory, domain, sep="")
  workingDirectory <- paste(workingDirectory, '/csv', sep="")
  setwd(workingDirectory)
  print(getwd())
}
#
# Function 
#
# Change to a domain directory
#
buildOutputDirectoryPath <- function(parentDirectory,domain) {
    outputDirectory <- paste(parentDirectory, domain, sep="")
    outputDirectory <- paste(outputDirectory, '/output', sep="")
    return(outputDirectory)
}

