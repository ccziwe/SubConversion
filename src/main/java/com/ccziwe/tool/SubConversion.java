package com.ccziwe.tool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;

public class SubConversion {
    public static void main(String[] args) throws IOException {
        ArrayList<VmessBaen> list = new ArrayList();
        list = parsingVmess("https://biteb.club/link/nj44BiX0eRLcqQYD?sub=3&extend=1");
    }

    public static ArrayList<VmessBaen> parsingVmess(String url) throws IOException {
        // String url = "https://biteb.club/link/nj44BiX0eRLcqQYD?sub=3&extend=1";
        String s = HttpRequest.downLoadFromUrl(url);
        String restr = new String(Base64.getDecoder().decode(s), "UTF-8");
        String[] arr1 = restr.split("vmess://");
        ArrayList<VmessBaen> list = new ArrayList();
        for (int i = 1; i < arr1.length; i++) {
            String value = new String(Base64.getDecoder().decode(arr1[i].replaceAll("\n", "")), "UTF-8");
            int result1 = value.indexOf("网");
            int result2 = value.indexOf("群");
            int result3 = value.indexOf("更新");
            int result4 = value.indexOf("剩余");
            int result5 = value.indexOf("时间");
            if (result1 != -1
                    || result2 != -1
                    || result3 != -1
                    || result4 != -1
                    || result5 != -1
            ) {
            } else {
                VmessBaen vmessBaen = new VmessBaen();
                vmessBaen.setSourceVmess("vmess://" + arr1[i]);
                vmessBaen.setVmessBase64(value);
                list.add(vmessBaen);
            }
        }


        for (VmessBaen tmp : list) {
            // System.out.println(tmp.getSourceVmess());
        }
        // System.out.println(list.size());
        return list;
    }
}
