
package com.journaldev.files;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class image {

    public static void main(String[] args) {
        String url = "https://discuss.codingblocks.com/uploads/default/original/2X/8/891ee9a180d14aa4cb2f71100d7b3a987215d384.jpg";
        
        try {
            downloadUsingNIO(url, "C:/Dev/Eclipse_Workspace/Snake/891ee9a180d14aa4cb2f71100d7b3a987215d384.jpg");
            
            downloadUsingStream(url, "C:/Dev/Eclipse_Workspace/Snake/891ee9a180d14aa4cb2f71100d7b3a987215d384.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void downloadUsingStream(String urlStr, String file) throws IOException{
        URL url = new URL(urlStr);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[25000];
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
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(file);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();
    }

}
