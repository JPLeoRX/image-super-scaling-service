import json


class UpscaleOutput:
    def __init__(self, imageBase64: str):
        self.imageBase64 = imageBase64

    def toJSON(self):
        return json.dumps(self, default=lambda o: o.__dict__, sort_keys=False, indent=4)

def parseUpscaleOutput(dictionary) -> UpscaleOutput:
    imageBase64 = dictionary['imageBase64']
    return UpscaleOutput(imageBase64)