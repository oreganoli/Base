package xyz.oreganoli.base;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class InsertOrder implements Runnable {
    public InsertOrder(PlaceDao dao, Place content, BlockingQueue<List<Place>> queue) {
        this.dao = dao;
        this.content = content;
        this.queue = queue;
    }
    PlaceDao dao;
    Place content;
    BlockingQueue<List<Place>> queue;
    public void run() {
        dao.insert(content);
        try {
            queue.put(dao.get_all());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
