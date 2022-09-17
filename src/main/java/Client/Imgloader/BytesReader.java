package Client.Imgloader;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BytesReader {

    public static void byteReader(InputStream is, OutputStream os) throws IOException {

        int byteRead = -1;

        byte[] bytes = new byte[1024];

        while ((byteRead = is.read(bytes)) != -1){

            os.write(bytes, 0, byteRead);

        }

    }

}
