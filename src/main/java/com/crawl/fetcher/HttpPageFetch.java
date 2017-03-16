package com.crawl.fetcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HttpPageFetch implements PageFetcher {

    private static Logger logger = Logger.getLogger(PageFetcher.class.getName());


   public Optional<BufferedReader> getPage(String url) throws MalformedURLException, IOException {

       logger.info("URL to fetch: " + url);
       InputStream iStream = null;
       BufferedReader bufReader = null;
       try {

           URL urlLink = new URL(url);
           iStream = urlLink.openStream();

           bufReader = new BufferedReader(new InputStreamReader(iStream));
       } catch (UnknownHostException e) {
            logger.log(Level.INFO, "Domain does not exist");
       }

       if (bufReader!=null)
           return Optional.of(bufReader);
       else
           return Optional.empty();
   }
}
