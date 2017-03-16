package com.crawl.fetcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Optional;

public interface PageFetcher {

    Optional<BufferedReader> getPage(String url) throws MalformedURLException,IOException;
}
