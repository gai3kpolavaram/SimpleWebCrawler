package com.crawl.fetcher;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Optional;

import static org.junit.Assert.*;


public class HttpPageFetchTest {

    PageFetcher fetcher = null;

    @Before
    public void setUP() {
        fetcher = new HttpPageFetch();
    }

    @Test (expected = MalformedURLException.class)
    public void testIfBadURLThrowsException() throws MalformedURLException, IOException {
        fetcher.getPage("htt://www.gayathripolavaramtest.com");
    }

    @Test
    public void testNonExistantURLReturnsNull() throws MalformedURLException, IOException{
        Optional<BufferedReader> buff = fetcher.getPage("http://www.gayathripolavaramtest.com");
        assertFalse(buff.isPresent());
    }

    @Test
    public void testGoodURLReturnsContentHttp() throws MalformedURLException, IOException{
        Optional<BufferedReader> buff = fetcher.getPage("http://www.google.com");
        assertTrue(buff.isPresent());
    }

    @Test
    public void testGoodURLReturnsContent() throws MalformedURLException, IOException{
        Optional<BufferedReader> buff = fetcher.getPage("http://wiprodigital.com");
        assertTrue(buff.isPresent());
    }

}