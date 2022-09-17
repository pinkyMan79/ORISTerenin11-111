package Client.Imgloader;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class Loader {

    private final String location;

    private final String fileName;

    private HttpURLConnection connection;

    public Loader(String location, String fileName, String format){

        this.location = location;

        this.fileName = fileName + format;

    }

    public void loadFromUrl(){

        try {

            URL url = new URL(location);

            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true); //with post request

            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){

                loadImg(fileName);

            }

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

    private void loadImg(String fileName) throws IOException {

        InputStream inputStream = null;

        OutputStream outputStream = null;

        try {

            inputStream = connection.getInputStream();

            File image = new File(fileName);

            if (!image.isFile()){

                image.createNewFile();

                outputStream = new FileOutputStream(image);

                BytesReader.byteReader(inputStream, outputStream);

            }else {

                image.delete();

                image.createNewFile();

                outputStream = new FileOutputStream(image);

                BytesReader.byteReader(inputStream, outputStream);

            }

        } catch (IOException e) {

            throw new RuntimeException(e);

        }finally {

            inputStream.close();
            outputStream.close();

        }

    }

    public String getFileName() {
        return fileName;
    }

    public String getLocation() {
        return location;
    }
}
