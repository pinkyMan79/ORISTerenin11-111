package Client;

import Client.Imgloader.ImageFounder;
import Client.Imgloader.Loader;
import Client.Imgloader.MyThread;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // at first, we need to download page with images
        Loader loader = new Loader("https://en.wikipedia.org/wiki/HTTP_cookie", "/home/terenin/Documents/Agona/HTTPCLIENTPROJECT/src/main/java/Client/Imgloader/saturn", ".html");
        loader.loadFromUrl();

        ImageFounder imageFounder = new ImageFounder();

        List<String> images = imageFounder.getImages("/home/terenin/Documents/Agona/HTTPCLIENTPROJECT/src/main/java/Client/Imgloader/saturn.html");

        List<MyThread> downloadChannels = new ArrayList<>();

        for (int i = 2; i < images.size() - 1; i++) {

            System.out.println(images.get(i));

            /*Loader loader1 = new Loader("https://" + images.get(i) + "png", "/home/terenin/Documents/Agona/HTTPCLIENTPROJECT/src/main/java/Client/Imgloader/images/" + i +"name", ".png");
            loader1.loadFromUrl();*/

            downloadChannels.add(new MyThread("/home/terenin/Documents/Agona/HTTPCLIENTPROJECT/src/main/java/Client/Imgloader/images/" + i +"name" + ".png", "https://" + images.get(i) + "png"));

        }

        for (int i = 0; i < downloadChannels.size(); i++) {

            downloadChannels.get(i).start();

        }

    }

}
