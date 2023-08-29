package xyz.mlhmz.mcserverinformation.serverinformationproducer.fetcher;

import xyz.mlhmz.mcserverinformation.serverinformationproducer.Information;

/**
 * Interface to fetch the servers information
 */
public interface InformationFetcher {
    Information fetchInformation();
}
