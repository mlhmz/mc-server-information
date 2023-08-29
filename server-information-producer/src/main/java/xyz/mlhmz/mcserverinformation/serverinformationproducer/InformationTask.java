package xyz.mlhmz.mcserverinformation.serverinformationproducer;

import xyz.mlhmz.mcserverinformation.serverinformationproducer.fetcher.InformationFetcher;
import xyz.mlhmz.mcserverinformation.serverinformationproducer.publisher.InformationPublisher;

public class InformationTask {
    private final InformationFetcher fetcher;
    private final InformationPublisher publisher;

    public InformationTask(InformationFetcher fetcher, InformationPublisher publisher) {
        this.fetcher = fetcher;
        this.publisher = publisher;
    }

    public void execute() {
        publisher.publish(fetcher.fetch());
    }
}
