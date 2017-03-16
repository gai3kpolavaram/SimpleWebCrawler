package com.crawl.util;

import jdk.nashorn.internal.runtime.OptimisticReturnFilters;

import java.util.Optional;

public class DomainUtil {

    public Optional<String> extractDomain(String url) {
        if (url!=null && url.length()>0 ){

            url = url.replace("http://", "");
            url = url.replace("https://", "");
            url = url.replace("www.", "");
            int loc = url.indexOf("/");
            if (loc < 0) {
                loc = url.length();
            }
            url = url.substring(0, loc);
            loc = url.indexOf(":");
            if (loc > 0)
                url = url.substring(0, loc);
        }
        if (url!=null && url.trim().length() > 0) {
            return Optional.of(url);
        } else
            return Optional.empty();

    }
}
