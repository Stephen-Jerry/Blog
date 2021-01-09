package dao;

import java.io.*;

public class iodao {
    public void wri(String s,String path){
        FileOutputStream fs = null;
        try {
            fs=new FileOutputStream(path);
            fs.write(s.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(fs!=null){
                try {
                    fs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public String red(String path){
        String contend="";
        try {
            FileInputStream fs=new FileInputStream(path);
            InputStreamReader isr=new InputStreamReader(fs,"GBK");
           BufferedReader br=new BufferedReader(isr);
           String len;
            while((len=br.readLine())!=null){
                contend+=len+"\n";
            }
            if(br!=null){
                br.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contend;
    }

}
