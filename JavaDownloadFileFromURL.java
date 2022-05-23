package com.journaldev.files;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class JavaDownloadFileFromURL {

    public static void main(String[] args) {
        String url = "https://www.journaldev.com/sitemap.xml";
        
        try {
            downloadUsingNIO(url, "/Users/pankaj/sitemap.xml");
            
            downloadUsingStream(url, "/Users/pankaj/sitemap_stream.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void downloadUsingStream(String urlStr, String file) throws IOException{
        URL url = new URL(urlStr);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count=0;
        while((count = bis.read(buffer,0,1024)) != -1)
        {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }

    private static void downloadUsingNIO(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import java.net.*;
import java.io.*;

public class MainClass {
public static void main(String[] args) throws IOException {
String strData = “javascript:playMp3(‘https://www.englishspeak.com/instantspeak/English/phrases/mp3/aFew.mp3’)”;
String strFind = “https://www.englishspeak.com/instantspeak/English/phrases/mp3/”;

File file = new File(“D:\\htmlformp3.txt”);
FileReader fr = new FileReader(file);
BufferedReader br = new BufferedReader(fr);
String line;
while ((line = br.readLine()) != null) {
String result = getSubString(line, strFind);
if(result != null){
System.out.println(result);
}
}
br.close();
fr.close();
}

public static String getSubString(String strParent, String strSub){
int index = strParent.indexOf(strSub);
if(index >= 0){
int subIndex = index + strSub.length();

for(int i = subIndex; i < strParent.length(); i++){
if ('.' == strParent.charAt(i)){
break;
} else {
strSub += strParent.charAt(i);
}
}
return strSub + ".mp3";
}
return null;
}
}
