import sys
import string
from random import randint, choice, seed
import random
from datetime import datetime

# Globals
JUNIT_TEMPLATE = r"""package techflix;

import org.junit.*;

import static org.junit.Assert.*;
import static techflix.business.MovieRating.*;
import static techflix.business.ReturnValue.*;
import techflix.business.*;
import static techflix.Solution.*;

import java.util.ArrayList;

public class %(_fileName)s
{
    @BeforeClass
    public static void createTables()
    {
        Solution.dropTables();
        Solution.createTables();
    }

    @AfterClass
    public static void dropTables()
    {
        Solution.dropTables();
    }
    
    %(_testMethods)s
    
    @Test
    public void test()
    {
        %(_testCalls)s
    }
}
"""
TEST_TEMPLATE = r"""

    public void test%(_testIndex)s()
    {
        ReturnValue returnValue;
        Viewer returnedViewer, viewerObj;
        Movie returnedMovie, movieObj;
        int returnedInt;
        ArrayList<Integer> returnedArrayList;
        %(_testContent)s
    }
    
"""

validOperationsAndWeights = [   ('createViewer', 3),
			                    ('getViewer', 1),
			                    ('deleteViewer', 1),
			                    ('updateViewer', 1),
			                    ('addMovie', 3),
			                    ('getMovie', 1),
			                    ('deleteMovie', 1),
			                    ('updateMovie', 1),
			                    ('addView', 3),
			                    ('removeView', 1),
			                    ('getMovieViewCount', 1),
			                    ('addMovieRating', 3),
			                    ('removeMovieRating', 1),
			                    ('getMovieLikesCount', 1),
			                    ('getMovieDislikesCount', 1),
			                    ('getSimilarViewers', 5),
			                    ('mostInfluencingViewers', 5),
			                    ('getMoviesRecommendations', 5),
			                    ('getConditionalRecommendations', 5)
                ]
NEW_ID_PREC = 5
NEGATIVE_ID_PREC = 1

testFile = None
testContent = ''
testMethods = ''
testCalls = ''

# DB simulation
viewerTable = {}
movieTable = {}
viewTable = {}

usedViewerIds = []
usedMovieIds = []

movieRatingEnum = ['LIKE', 'DISLIKE', 'NEUTRAL']

def createViewer(params):
    global testContent

    expected = 'OK'
    if params['id'] in viewerTable:
        expected = 'ALREADY_EXISTS'
    if params['name'] == 'null' or params['id'] <= 0:
        expected = 'BAD_PARAMS'

    if expected == 'OK':
        viewerTable[params['id']] = params
        usedViewerIds.append(params['id'])
    
    testContent += '\n\t\tviewerObj = new Viewer(); viewerObj.setId(' + str(params['id']) + '); viewerObj.setName(' + params['name'] + ');'
    testContent += '\n\t\treturnValue = createViewer(viewerObj);'
    testContent += '\n\t\tassertEquals(' + expected + ', returnValue);\n'

def getViewer(params):
    global testContent
    expected = 'Viewer.badViewer()'
    if params > 0 and params in viewerTable:
        testContent += '\n\t\tviewerObj = new Viewer(); viewerObj.setId(' + str(params) + '); viewerObj.setName(' + viewerTable[params]['name'] + ');'
        expected = 'viewerObj'
    
    testContent += '\n\t\treturnedViewer = getViewer(' + str(params) + ');'
    testContent += '\n\t\tassertEquals(' + expected + ', returnedViewer);\n'		

def deleteViewer(params):
    global testContent
    expected = 'OK'
    if params['id'] not in viewerTable:
        expected = 'NOT_EXISTS'
    else:
        del viewerTable[params['id']]
        usedViewerIds.remove(params['id'])

        toDelete = []
        for _tuple in viewTable:
            if _tuple[0] == params['id']:
                toDelete.append(_tuple)

        for pair in toDelete:
            del viewTable[pair]
        

    testContent += '\n\t\tviewerObj = new Viewer(); viewerObj.setId(' + str(params['id']) + '); viewerObj.setName(' + params['name'] + ');'
    testContent += '\n\t\treturnValue = deleteViewer(viewerObj);'
    testContent += '\n\t\tassertEquals(' + expected + ', returnValue);\n'

def updateViewer(params):
    global testContent
    expected = 'OK'
    if params['name'] == 'null':
            expected = 'BAD_PARAMS'
    if params['id'] not in viewerTable:
            expected = 'NOT_EXISTS'

    if expected == 'OK':
        viewerTable[params['id']]['name'] = params['name']

    testContent += '\n\t\tviewerObj = new Viewer(); viewerObj.setId(' + str(params['id']) + '); viewerObj.setName(' + params['name'] + ');'
    testContent += '\n\t\treturnValue = updateViewer(viewerObj);'
    testContent += '\n\t\tassertEquals(' + expected + ', returnValue);\n'

def addMovie(params):
    global testContent
    expected = 'OK'
    if params['id'] in movieTable:
        expected = 'ALREADY_EXISTS'
    if params['name'] == 'null' or params['descr'] == 'null' or params['id'] <= 0:
        expected = 'BAD_PARAMS'

    if expected == 'OK':
        movieTable[params['id']] = params
        usedMovieIds.append(params['id'])
    
    testContent += '\n\t\tmovieObj = new Movie(); movieObj.setId(' + str(params['id']) + '); movieObj.setName(' + params['name'] + '); movieObj.setDescription(' + params['descr'] + ');'
    testContent += '\n\t\treturnValue = createMovie(movieObj);'
    testContent += '\n\t\tassertEquals(' + expected + ', returnValue);\n'

def getMovie(params):
    global testContent
    expected = 'Movie.badMovie()'
    if params > 0 and params in movieTable:
        testContent += '\n\t\tmovieObj = new Movie(); movieObj.setId(' + str(params) + '); movieObj.setName(' + movieTable[params]['name'] + '); movieObj.setDescription(' + movieTable[params]['descr'] + ');'
        expected = 'movieObj'
    
    testContent += '\n\t\treturnedMovie = getMovie(' + str(params) + ');'
    testContent += '\n\t\tassertEquals(' + expected + ', returnedMovie);\n'		

def deleteMovie(params):
    global testContent
    expected = 'OK'
    if params['id'] not in movieTable:
            expected = 'NOT_EXISTS'
    else:
        del movieTable[params['id']]
        usedMovieIds.remove(params['id'])
        toDelete = []
        for _tuple in viewTable:
            if _tuple[1] == params['id']:
                toDelete.append(_tuple)

        for pair in toDelete:
            del viewTable[pair]

    testContent += '\n\t\tmovieObj = new Movie(); movieObj.setId(' + str(params['id']) + '); movieObj.setName(' + params['name'] + '); movieObj.setDescription(' + params['descr'] + ');'
    testContent += '\n\t\treturnValue = deleteMovie(movieObj);'
    testContent += '\n\t\tassertEquals(' + expected + ', returnValue);\n'

def updateMovie(params):
    global testContent
    expected = 'OK'
    if params['descr'] == 'null':
            expected = 'BAD_PARAMS'
    if params['id'] not in movieTable:
            expected = 'NOT_EXISTS'

    if expected == 'OK':
        movieTable[params['id']]['descr'] = params['descr']

    testContent += '\n\t\tmovieObj = new Movie(); movieObj.setId(' + str(params['id']) + '); movieObj.setDescription(' + params['descr'] + ');'
    testContent += '\n\t\treturnValue = updateMovie(movieObj);'
    testContent += '\n\t\tassertEquals(' + expected + ', returnValue);\n'

def addView(params):
    global testContent
    expected = 'OK'
    if params[0] not in viewerTable or params[1] not in movieTable:
            expected = 'NOT_EXISTS'
    if params in viewTable:
            expected = 'ALREADY_EXISTS'
    
    if expected == 'OK':
            viewTable.update({params: {'rating': 'NEUTRAL'}})
    
    testContent += '\n\t\treturnValue = addView(' + str(params[0]) + ', ' + str(params[1]) + ');'
    testContent += '\n\t\tassertEquals(' + expected + ', returnValue);\n'

def removeView(params):
    global testContent
    expected = 'OK'
    if params[0] not in viewerTable or params[1] not in movieTable or params not in viewTable:
        expected = 'NOT_EXISTS'
    
    if expected == 'OK':
        del viewTable[params]
    
    testContent += '\n\t\treturnValue = removeView(' + str(params[0]) + ', ' + str(params[1]) + ');'
    testContent += '\n\t\tassertEquals(' + expected + ', returnValue);\n'

def getMovieViewCount(params):
    global testContent
    expected = 0

    for _tuple in viewTable:
        if(_tuple[1] == params):
            expected += 1
    
    testContent += '\n\t\treturnedInt = getMovieViewCount(' + str(params) + ');'
    testContent += '\n\t\tassertEquals(' + str(expected) + ', returnedInt);\n'

def addMovieRating(params):
    global testContent
    expected = "OK"
    if params[0] not in viewerTable or params[1] not in movieTable or (params[0], params[1]) not in viewTable:
        expected = 'NOT_EXISTS'
    
    if expected == 'OK':
        viewTable[(params[0], params[1])]['rating'] = params[2]

    testContent += '\n\t\treturnValue = addMovieRating(' + str(params[0]) + ', ' + str(params[1]) + ', ' + params[2] + ');'
    testContent += '\n\t\tassertEquals(' + expected + ', returnValue);\n'

def removeMovieRating(params):
    global testContent
    expected = "OK"
    if params[0] not in viewerTable or params[1] not in movieTable or params not in viewTable or viewTable[params]['rating'] == 'NEUTRAL':
        expected = 'NOT_EXISTS'
    else:
        viewTable[params]['rating'] = 'NEUTRAL'

    testContent += '\n\t\treturnValue = removeMovieRating(' + str(params[0]) + ', ' + str(params[1]) + ');'
    testContent += '\n\t\tassertEquals(' + expected + ', returnValue);\n'

def getMovieLikesCount(params):
    global testContent
    expected = 0
    for _tuple, viewDetails in viewTable.iteritems():
        if _tuple[1] == params and viewDetails['rating'] == 'LIKE':
            expected += 1
    
    testContent += '\n\t\treturnedInt = getMovieLikesCount(' + str(params) + ');'
    testContent += '\n\t\tassertEquals(' + str(expected) + ', returnedInt);\n'

def getMovieDislikesCount(params):
    global testContent
    expected = 0
    for _tuple, viewDetails in viewTable.iteritems():
        if _tuple[1] == params and viewDetails['rating'] == 'DISLIKE':
            expected += 1
    
    testContent += '\n\t\treturnedInt = getMovieDislikesCount(' + str(params) + ');'
    testContent += '\n\t\tassertEquals(' + str(expected) + ', returnedInt);\n'

def getSimilarViewersList(viewerId):
    similar = {}

    moviesWatched = []
    for _tuple in viewTable:
        if _tuple[0] == viewerId:
            moviesWatched.append(_tuple[1])

    for _tuple in viewTable:
        if _tuple[0] != viewerId and _tuple[1] in moviesWatched:
            if _tuple[0] in similar: similar[_tuple[0]] = similar[_tuple[0]] + 1
            else: similar[_tuple[0]] = 1

    result = []
    for (viewer, count) in similar.iteritems():
        if count >= 0.75 * len(moviesWatched) and len(moviesWatched) != 0:
            result.append(viewer)

    return sorted(result)

def getSimilarViewers(params):
    global testContent
    similarViewers = getSimilarViewersList(params)

    testContent += '\n\t\treturnedArrayList = getSimilarViewers(' + str(params) + ');'
    testContent += '\n\t\tassertEquals(' + str(len(similarViewers)) + ', returnedArrayList.size());'
    for i in range(0, len(similarViewers)):
        testContent += '\n\t\tassertEquals(Integer.valueOf(' + str(similarViewers[i]) + '), returnedArrayList.get(' + str(i) + '));'
    testContent += '\n'

def getMostInfluencingViewersList():
    influencingViewers = {}
    for _tuple in viewTable:
        viewer = _tuple[0]
        rating = viewTable[_tuple]['rating']
        if viewer in influencingViewers:
            influencingViewers[viewer]['views'] += 1
            if rating != 'NEUTRAL': influencingViewers[viewer]['ratings'] += 1
        else:
            influencingViewers[viewer] = { 'views': 1, 'ratings': 0 }
            if rating != 'NEUTRAL': influencingViewers[viewer]['ratings'] = 1

    byIdAsc = sorted(influencingViewers.items(), key=lambda entry: entry[0])
    byRatingDesc = sorted(byIdAsc, key=lambda entry: entry[1]['ratings'], reverse=True)
    byViewsDesc = sorted(byRatingDesc, key=lambda entry: entry[1]['views'], reverse=True)

    return byViewsDesc[:10]

def mostInfluencingViewers(params):
    global testContent

    influencingViewers = getMostInfluencingViewersList()
    testContent += '\n\t\treturnedArrayList = mostInfluencingViewers();'
    testContent += '\n\t\tassertEquals(' + str(len(influencingViewers)) + ', returnedArrayList.size());'

    for i in range(0, len(influencingViewers)):
        testContent += '\n\t\tassertEquals(Integer.valueOf(' + str(influencingViewers[i][0]) + '), returnedArrayList.get(' + str(i) + '));'
    testContent += '\n'

def getMoviesRecommendationsList(viewerId):
    similarViewers = getSimilarViewersList(viewerId)

    moviesWatchedByViewer = []
    for (vid, mid) in viewTable:
        if vid == viewerId: moviesWatchedByViewer.append(mid)

    moviesLikedBySimilar = {}
    for vid in similarViewers:
        for (viewer, mid) in viewTable:
            if viewer == vid and mid not in moviesWatchedByViewer and viewTable[(viewer, mid)]['rating'] == 'LIKE':
                if mid in moviesLikedBySimilar:
                    moviesLikedBySimilar[mid] += 1
                else: moviesLikedBySimilar[mid] = 1

    moviesWatchedBySimilar = {}
    for vid in similarViewers:
        for (viewer, mid) in viewTable:
            if viewer == vid and mid not in moviesWatchedByViewer and viewTable[(viewer, mid)]['rating'] != 'LIKE' and mid not in moviesLikedBySimilar:
                if mid in moviesWatchedBySimilar:
                    moviesWatchedBySimilar[mid] += 1
                else: moviesWatchedBySimilar[mid] = 1

    result1 = moviesLikedBySimilar.items()
    result1 = sorted(result1, key=lambda pair: pair[0])
    result1 = sorted(result1, key=lambda pair: pair[1], reverse=True)

    result2 = moviesWatchedBySimilar.items()
    result2 = sorted(result2, key=lambda pair: pair[0])

    result = result1 + result2
    return result[:10]

def getMoviesRecommendations(params):
    global testContent
    moviesRecommendations = getMoviesRecommendationsList(params)

    testContent += '\n\t\treturnedArrayList = getMoviesRecommendations(' + str(params) + ');'
    testContent += '\n\t\tassertEquals(' + str(len(moviesRecommendations)) + ', returnedArrayList.size());'

    for i in range(0, len(moviesRecommendations)):
        testContent += '\n\t\tassertEquals(Integer.valueOf(' + str(moviesRecommendations[i][0]) + '), returnedArrayList.get(' + str(i) + '));'
    testContent += '\n'

def getSimilarRankersList(viewerId, movieId):
    similarViewers = getSimilarViewersList(viewerId)

    result = []
    for viewer in similarViewers:
        if (viewer, movieId) in viewTable and (viewerId, movieId) in viewTable:
            if viewTable[(viewer, movieId)] == viewTable[(viewerId, movieId)] and viewTable[(viewerId, movieId)]['rating'] != 'NEUTRAL':
                result.append(viewer)

    return result

def getConditionalRecommendationsList(viewerId, movieId):
    similarRankers = getSimilarRankersList(viewerId, movieId)

    moviesWatchedByViewer = []
    for (vid, mid) in viewTable:
        if vid == viewerId: moviesWatchedByViewer.append(mid)

    moviesLikedBySimilar = {}
    for vid in similarRankers:
        for (viewer, mid) in viewTable:
            if viewer == vid and mid not in moviesWatchedByViewer and viewTable[(viewer, mid)]['rating'] == 'LIKE':
                if mid in moviesLikedBySimilar:
                    moviesLikedBySimilar[mid] += 1
                else:
                    moviesLikedBySimilar[mid] = 1

    moviesWatchedBySimilar = {}
    for vid in similarRankers:
        for (viewer, mid) in viewTable:
            if viewer == vid and mid not in moviesWatchedByViewer and viewTable[(viewer, mid)]['rating'] != 'LIKE' and mid not in moviesLikedBySimilar:
                if mid in moviesWatchedBySimilar:
                    moviesWatchedBySimilar[mid] += 1
                else:
                    moviesWatchedBySimilar[mid] = 1

    result1 = moviesLikedBySimilar.items()
    result1 = sorted(result1, key=lambda pair: pair[0])
    result1 = sorted(result1, key=lambda pair: pair[1], reverse=True)

    result2 = moviesWatchedBySimilar.items()
    result2 = sorted(result2, key=lambda pair: pair[0])

    result = result1 + result2
    return result[:10]

def getConditionalRecommendations(params):
    global testContent
    conditionalRecommendations = getConditionalRecommendationsList(params[0], params[1])

    testContent += '\n\t\treturnedArrayList = getConditionalRecommendations(' + str(params[0]) + ', ' + str(params[1]) + ');'
    testContent += '\n\t\tassertEquals(' + str(len(conditionalRecommendations)) + ', returnedArrayList.size());'

    for i in range(0, len(conditionalRecommendations)):
        testContent += '\n\t\tassertEquals(Integer.valueOf(' + str(
            conditionalRecommendations[i][0]) + '), returnedArrayList.get(' + str(i) + '));'
    testContent += '\n'

def weightedChoice(choices):
   total = sum(w for c, w in choices)
   r = random.uniform(0, total)
   upto = 0
   for c, w in choices:
      if upto + w >= r:
         return c
      upto += w
   assert False, "Shouldn't get here"

def pickRandomOperation():
    return weightedChoice(validOperationsAndWeights)

def randstr():
    # all names are 20 characters long or null
    return '"' + ''.join(choice(string.ascii_uppercase + string.digits) for _ in range(20)) + '"' if randint(0, 20) != 0 else 'null'

def randid(fromViewer):
    if randint(0, 100) < NEW_ID_PREC:
        id = randint(1, 100000000)
        if randint(0, 100) < NEGATIVE_ID_PREC:
            id = -id
    else:
        if fromViewer:
            if len(usedViewerIds) == 0: id = randint(1, 100000000)
            else: id = usedViewerIds[randint(0, len(usedViewerIds) - 1)]
        else:
            if len(usedMovieIds) == 0: id = randint(1, 100000000)
            else: id = usedMovieIds[randint(0, len(usedMovieIds) - 1)]

    return id

def getParamsForOp(op):
    # return Viewer object
    if op == 'createViewer' or op == 'deleteViewer' or op == 'updateViewer':
        return {'id': randid(True), 'name': randstr()}
    
    # return Movie object
    if op == 'addMovie' or op == 'deleteMovie' or op == 'updateMovie':
        return {'id': randid(False), 'name': randstr(), 'descr': randstr()}

    # return random int for viewer
    if op == 'getViewer' or op == 'getSimilarViewers' or op == 'getMoviesRecommendations':
        return randid(True)

    # return random int for movie
    if op ==  'getMovie' or op == 'getMovieViewCount' or op == 'getMovieLikesCount' or op == 'getMovieDislikesCount':
        return randid(False)

    # return a tuple of ints
    if op == 'addView' or op == 'removeView' or op == 'removeMovieRating' or op == 'getConditionalRecommendations':
        return  (randid(True), randid(False))

    # return movie rating params
    if op == 'addMovieRating':
        return (randid(True), randid(False), movieRatingEnum[randint(0,1)])
        
def generateOperation(opcode, params):
        if opcode == 'createViewer':
                createViewer(params)
        if opcode == 'getViewer':
                getViewer(params)
        if opcode == 'deleteViewer':
                deleteViewer(params)
        if opcode == 'updateViewer':
                updateViewer(params)
        if opcode == 'addMovie':
                addMovie(params)
        if opcode == 'getMovie':
                getMovie(params)
        if opcode == 'deleteMovie':
                deleteMovie(params)
        if opcode == 'updateMovie':
                updateMovie(params)
        if opcode == 'addView':
                addView(params)
        if opcode == 'removeView':
                removeView(params)
        if opcode == 'getMovieViewCount':
                getMovieViewCount(params)
        if opcode == 'addMovieRating':
                addMovieRating(params)
        if opcode == 'removeMovieRating':
                removeMovieRating(params)
        if opcode == 'getMovieLikesCount':
                getMovieLikesCount(params)
        if opcode == 'getMovieDislikesCount':
                getMovieDislikesCount(params)
        if opcode == 'getSimilarViewers':
                getSimilarViewers(params)
        if opcode == 'mostInfluencingViewers':
                mostInfluencingViewers(params)
        if opcode == 'getMoviesRecommendations':
                getMoviesRecommendations(params)
        if opcode == 'getConditionalRecommendations':
                getConditionalRecommendations(params)

def generateTest(testSize):
    global testMethods
    global testContent
    global testCalls

    methodMaxSize = 1000
    currentMethodSize = 0
    testIndex = 1
    for _ in range(testSize):
        currentMethodSize += 1

        op = pickRandomOperation()
        params = getParamsForOp(op)

        generateOperation(op, params)

        if currentMethodSize >= methodMaxSize:
            testMethods += TEST_TEMPLATE % dict(_testIndex = testIndex, _testContent = testContent)
            testContent = ''
            currentMethodSize = 0
            testCalls += '\n\t\ttest' + str(testIndex) + '();'
            testIndex += 1

    if currentMethodSize != 0:
        testMethods += TEST_TEMPLATE % dict(_testIndex = testIndex, _testContent = testContent)
        testContent = ''
        currentMethodSize = 0
        testCalls += '\n\t\ttest' + str(testIndex) + '();'
        testIndex += 1

def main():
    seed(datetime.now())
    
    if len(sys.argv) is not 2:
        print 'Usage: python ' + sys.argv[0] + ' <number of operations>'
        sys.exit(1)

    testSize = int(sys.argv[1])
    testName = 'DBRandomTest_' + str(testSize) + 'Operations'
    testFile = open(testName + '.java', 'w')

    generateTest(testSize)
    testFile.write(JUNIT_TEMPLATE % dict(_fileName = testName, _testMethods = testMethods, _testCalls = testCalls))

    testFile.close()

if __name__ == '__main__':
    main()