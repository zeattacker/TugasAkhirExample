package com.dimas.gastrointenistal.helpers;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by rama on 11/9/16.
 */

public class XMLParser {
    private static XMLParser xmp;
    private HashMap<String, ArrayList<String>> data = new HashMap<>();

    public static XMLParser getInstance(){
        if(xmp == null){
            xmp = new XMLParser();
        }

        return xmp;
    }

    public HashMap<String,ArrayList<String>> getData(){

        try {
            URL url = new URL("http://doktersehat.com/feed/");

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(false);
            XmlPullParser xpp = factory.newPullParser();

            // We will get the XML from an input stream
            xpp.setInput(getInputStream(url), "UTF_8");

            /* We will parse the XML content looking for the "<title>" tag which appears inside the "<item>" tag.
             * However, we should take in consideration that the rss feed name also is enclosed in a "<title>" tag.
             * As we know, every feed begins with these lines: "<channel><title>Feed_Name</title>...."
             * so we should skip the "<title>" tag which is a child of "<channel>" tag,
             * and take in consideration only "<title>" tag which is a child of "<item>"
             *
             * In order to achieve this, we will make use of a boolean variable.
             */
            boolean insideItem = false;

            // Returns the type of current event: START_TAG, END_TAG, etc..
            int eventType = xpp.getEventType();
            String title = "";
            String desc = "";
            String link = "";
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG) {

                    if (xpp.getName().equalsIgnoreCase("item")) {
                        insideItem = true;
                    } else if (xpp.getName().equalsIgnoreCase("title")) {
                        if (insideItem)
                            title = xpp.nextText();
                            if(!data.containsKey(title)){;
                                data.put(title, new ArrayList<String>());
                            }
                    } else if (xpp.getName().equalsIgnoreCase("link")) {
                        if (insideItem)
                            link = xpp.nextText();
                            data.get(title).add(title);
                            data.get(title).add(link);
                    } else if(xpp.getName().equalsIgnoreCase("description")){
                        if(insideItem)
                            desc = xpp.nextText();
                            data.get(title).add(desc);
                    }
                }else if(eventType== XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase("item")){
                    insideItem=false;
                }

                eventType = xpp.next(); //move to next element
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
    public InputStream getInputStream(URL url) {
        try {
            return url.openConnection().getInputStream();
        } catch (IOException e) {
            return null;
        }
    }
}
