package com.crawl.extract;

import com.crawl.fetcher.HttpPageFetch;
import com.crawl.fetcher.PageFetcher;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.fail;

public class URLExtractorImplTest {

    URLExtractor urlExtractor;
    PageFetcher pageFetcher;

    @Before
    public void setUp() {
        urlExtractor = new URLExtractorImpl();
        pageFetcher = new HttpPageFetch();
    }

    @Test
    public void testExtractorReturnsList() {
        BufferedReader buff = null;
        try {
            buff = pageFetcher.getPage("http://wiprodigital.com").get();
            assertFalse(urlExtractor.extractAllLinks(buff).isEmpty());
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

}