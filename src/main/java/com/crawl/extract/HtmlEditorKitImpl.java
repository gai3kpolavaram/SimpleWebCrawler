package com.crawl.extract;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import java.util.HashSet;
import java.util.Set;

public class HtmlEditorKitImpl extends HTMLEditorKit.ParserCallback {

    public Set<String> getUrlList() {
        return urlList;
    }

    private Set<String> urlList = new HashSet<String>();

    public void handleText(final char[] data, final int pos) { }
    public void handleStartTag(HTML.Tag tag, MutableAttributeSet attribute, int pos) {

        if (tag == HTML.Tag.A) {
            String address = (String)attribute.getAttribute(HTML.Attribute.HREF);
            urlList.add(address);
        }
    }

    public void handleEndTag(HTML.Tag t, final int pos) {  }
    public void handleSimpleTag(HTML.Tag t, MutableAttributeSet a, final int pos) { }
    public void handleComment(final char[] data, final int pos) { }
    public void handleError(final java.lang.String errMsg, final int pos) { }

}
