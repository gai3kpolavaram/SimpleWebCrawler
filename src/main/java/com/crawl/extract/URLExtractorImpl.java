package com.crawl.extract;

import javax.swing.text.html.parser.ParserDelegator;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.Set;

public class URLExtractorImpl implements URLExtractor{

    public Set<String> extractAllLinks(BufferedReader input) throws IOException{

        Set<String> urlList = null;

        ParserDelegator parserDelegator = new ParserDelegator();
        HtmlEditorKitImpl parserCallback = new HtmlEditorKitImpl();
        parserDelegator.parse(input, parserCallback, true);

        urlList = parserCallback.getUrlList();
        return urlList;

    }
}
