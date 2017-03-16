package com.crawl.extract;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Set;

public interface URLExtractor {

    public Set<String> extractAllLinks(BufferedReader input) throws IOException;
}
