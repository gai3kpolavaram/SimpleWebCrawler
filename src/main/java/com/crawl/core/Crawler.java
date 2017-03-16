package com.crawl.core;
import com.crawl.extract.URLExtractor;
import com.crawl.extract.URLExtractorImpl;
import com.crawl.fetcher.HttpPageFetch;
import com.crawl.fetcher.PageFetcher;
import com.crawl.output.TextFileWriter;
import com.crawl.util.DomainUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class Crawler {

    private DomainUtil domainUtil;
    private PageFetcher fetcher;
    private URLExtractor extractor;
    private TextFileWriter writer;
    private static int MAX_LIMIT = 100;
    private HashSet<String> urlSet = new HashSet<String>();
    private LinkedList<String> urlList = new LinkedList<String>();

    public Crawler() {
        fetcher = new HttpPageFetch();
        extractor = new URLExtractorImpl();
        domainUtil = new DomainUtil();
        writer = new TextFileWriter();
    }

    public static void main(String args[]) {

        if (args.length < 2 ) {
            System.out.println("Please Enter URL and max number of links to crawl as a command line argument");
        } else {

            int limit;
            try {
               limit = Integer.getInteger(args[1]).intValue();
            } catch (Exception e) {
                limit = MAX_LIMIT;
            }
            Crawler crawler = new Crawler();
            crawler.process(args[0], limit);
        }
    }

    public void process(String url, int maxLimit) {

        boolean isValid = true;
        String rootDomain = "";
        int count = 1;

        Optional<String> rootDomainOp = domainUtil.extractDomain(url);


        if (rootDomainOp.isPresent()) {
            rootDomain = rootDomainOp.get();
        }
        System.out.println(rootDomain);

        urlSet.add(url);
        urlList.add(url);
        while(count < maxLimit ) {
            if (urlList.size()>0) {
                try {
                    String currentURL = urlList.getFirst();

                    Optional<BufferedReader> buff = fetcher.getPage(currentURL);
                    writer.write(currentURL);
                    System.out.println(currentURL);
                    if (buff.isPresent()) {

                        for (String childUrl : extractor.extractAllLinks(buff.get())) {
                            if (!urlSet.contains(childUrl)) {
                                urlSet.add(childUrl);

                                if (domainUtil.isInRootDomain(rootDomain, childUrl)) {
                                    urlList.add(childUrl);
                                } else {
                                    writer.write(childUrl);
                                    System.out.println("Will not follow through: " + childUrl);
                                }

                            }
                        }
                    }

                    urlList.removeFirst();

                } catch (IOException e) {

                }
                count++;
            }
        }

    }

}
