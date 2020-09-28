import json

class PingOutput:
    def __init__(self, success: bool):
        self.success = success

    def toJSON(self):
        return json.dumps(self, default=lambda o: o.__dict__, sort_keys=True, indent=4)