import base64

from message_protocol.upscale_input import UpscaleInput
from message_protocol.upscale_output import UpscaleOutput


class ResourceUpscale:
    def main(self, upscaleInput: UpscaleInput) -> UpscaleOutput:
        imageBytesArray = base64.b64decode(upscaleInput.imageBase64)

        return UpscaleOutput(upscaleInput.imageBase64)
