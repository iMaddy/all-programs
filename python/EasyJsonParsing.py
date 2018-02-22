# pip install if this module is not installed
# pip install flatten_json
from flatten_json import flatten
import json

def searchDictionaryKey(dict,key):
    flattenDict = flatten(dict,'#')
    for k in dict:
            if key in k:
                    print k

def getJsonKey(flatten_key):
    keys = flatten_key.split('#')
    fullKey = ''
    for key in keys:
            fullKey += '[\'' + key +'\']'
    #print fullKey
    return fullKey
