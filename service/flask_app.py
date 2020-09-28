from flask import Flask
from flask import request
from flask import Response

from resources import resourcePing, resourceUpscale
from message_protocol.upscale_input import parseUpscaleInput

app = Flask(__name__)

#-----------------------------------------------------------------------------------------------------------------------
@app.route('/ping', methods=['GET'])
def ping():
    output = resourcePing.main()
    json = output.toJSON()
    return Response(json, mimetype='application/json')

@app.route('/upscale', methods=['POST'])
def upscale():
    input = parseUpscaleInput(request.json)
    output = resourceUpscale.main(input)
    json = output.toJSON()
    return Response(json, mimetype='application/json')