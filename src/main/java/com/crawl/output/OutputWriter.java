package com.crawl.output;


import java.io.IOException;

public interface OutputWriter {
    void write(String url) throws IOException;

}
