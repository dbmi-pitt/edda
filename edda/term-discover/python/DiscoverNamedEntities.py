#!/usr/bin/python
# author: Eugene Tseytlin (University of Pittsburgh)
# detect Named Entities s.a. geographic locations in set of sentences
import sys
import nltk

# find named entities in a parsed tree
# ORGANIZATION     Georgia-Pacific Corp., WHO
# PERSON     Eddy Bonte, President Obama
# LOCATION     Murray River, Mount Everest
# DATE     June, 2008-06-29
# TIME     two fifty a m, 1:30 p.m.
# MONEY     175 million Canadian Dollars, GBP 10.40
# PERCENT     twenty pct, 18.75 %
# FACILITY     Washington Monument, Stonehenge
# GPE     South East Asia, Midlothian

def find_NE(entities):
    for x in entities:
        if type(x) is nltk.tree.Tree:
            if x.node in ["ORGANIZATION","PERSON","LOCATION","FACILITY","GPE"]:
                return True
    return False

# main method
if __name__ == "__main__":

    fname=sys.argv[1]
    with open(fname) as f:
        content = f.readlines()
        
    # iterate over sentences in an input file
    for sentence in content:
        # parse each sentence into tokens with POS
        tokens = nltk.word_tokenize(sentence)
        tagged = nltk.pos_tag(tokens)
        # run named entity chunker
        entities = nltk.ne_chunk(tagged)
        
        if find_NE(entities):
            print sentence.strip()
