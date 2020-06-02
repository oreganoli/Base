package xyz.oreganoli.base;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class ReadOrder implements Runnable {
    public ReadOrder(PlaceDao dao, BlockingQueue<List<Place>> queue) {
        this.dao = dao;
        this.queue = queue;
    }

    PlaceDao dao;
    BlockingQueue<List<Place>> queue;
    public void run() {
        try {
            queue.put(dao.get_all());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
