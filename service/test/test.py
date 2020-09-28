import numpy as np
from PIL import Image
from ISR.models import RDN

testImage1 = '../../sample-images/t1.jpg'
testImage2 = '../../sample-images/t2.jpg'
testImage3 = '../../sample-images/t3.jpg'
testImage4 = '../../sample-images/t4.jpg'
testImage5 = '../../sample-images/t5.jpg'
testImage6 = '../../sample-images/t6.jpg'
testImage7 = '../../sample-images/t7.jpg'
testImage8 = '../../sample-images/t8.jpg'

testImages = [testImage1, testImage2, testImage3, testImage4, testImage5, testImage6, testImage7, testImage8]

for testImage in testImages:
    print('Testing on image [' + str(testImage) + ']')
    inputPath = testImage
    outputPath = testImage.replace('.jpg', '') + '_up' + '.jpg'
    imagePil = Image.open(inputPath)
    imageNumpy = np.array(imagePil)
    model = RDN(weights='noise-cancel')
    scaledNumpy = model.predict(imageNumpy)
    scaledPil = Image.fromarray(scaledNumpy)
    scaledPil.save(outputPath)