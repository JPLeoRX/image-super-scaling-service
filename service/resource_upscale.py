import io
import base64
import numpy as np
from PIL import Image
from ISR.models import RDN
from message_protocol.upscale_input import UpscaleInput
from message_protocol.upscale_output import UpscaleOutput


MODEL = RDN(weights='noise-cancel')

class ResourceUpscale:
    def main(self, upscaleInput: UpscaleInput) -> UpscaleOutput:
        # Parse base64 string into bytes array
        inputImageBytesArray = base64.b64decode(upscaleInput.imageBase64)

        # Open the image
        imagePil = Image.open(io.BytesIO(inputImageBytesArray))
        imageNumpy = np.array(imagePil)

        # Scale the image
        scaledNumpy = MODEL.predict(imageNumpy)
        scaledPil = Image.fromarray(scaledNumpy)

        # Write scaled image as bytes array
        outputImageBytesArrayIO = io.BytesIO()
        scaledPil.save(outputImageBytesArrayIO, format=imagePil.format, quality=100)
        outputImageBytesArray = outputImageBytesArrayIO.getvalue()

        # Convert back to base64 string
        outputImageBase64 = base64.b64encode(outputImageBytesArray).decode('utf-8')
        return UpscaleOutput(outputImageBase64)
