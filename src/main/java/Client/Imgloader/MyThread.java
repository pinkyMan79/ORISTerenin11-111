package Client.Imgloader;

public class MyThread extends Thread{

    private String name;
    private String path;

    public MyThread(String name, String path){

        this.path = path;
        this.name = name;

    }


    @Override
    public void run() {

    }

    @Override
    public synchronized void start() {

        Loader loader = new Loader(path, name,"");
        loader.loadFromUrl();

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
