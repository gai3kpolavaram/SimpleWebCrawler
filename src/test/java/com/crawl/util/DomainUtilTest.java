package com.crawl.util;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class DomainUtilTest {

    private DomainUtil domainUtil;

    @Before
    public void setUp() {
        domainUtil = new DomainUtil();
    }

    @Test
    public void nullURL() {

        assertFalse(domainUtil.extractDomain(null).isPresent());
    }

    @Test
    public void emptyURL() {

        assertFalse(domainUtil.extractDomain("").isPresent());
    }

    @Test
    public void domainWithHttp() {
        Optional<String> domain =  domainUtil.extractDomain("http://wiprodigital.com");
        if (domain.isPresent())
        assertEquals("wiprodigital.com", domain.get());
    }

    @Test
    public void domainWithHttps() {
        Optional<String> domain =  domainUtil.extractDomain("https://wiprodigital.com");
        if (domain.isPresent())
            assertEquals("wiprodigital.com", domain.get());
    }

    @Test
    public void domainWithWWW() {
        Optional<String> domain =  domainUtil.extractDomain("http://www.wiprodigital.com");
        if (domain.isPresent())
            assertEquals("wiprodigital.com", domain.get());
    }

}