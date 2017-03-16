package com.crawl.util;

import jdk.nashorn.internal.runtime.OptimisticReturnFilters;

import java.util.Optional;
import java.util.Set;

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

    private String getAbsolutePath(String url, String rootDomain) {
        if (url!=null) {
            if (url.startsWith("/"))
                url = "www." + rootDomain + url;
        }
        return url;

    }

    public boolean isInRootDomain (String rootDomain, String url) {
        Optional<String> domain = extractDomain(getAbsolutePath(url, rootDomain));
        if (domain.isPresent()){

            if (domain.get().contains(rootDomain)) {
                return true;
            }

        }
         else
            return false;

        return false;
    }
}
