package com.ccziwe.tool;

public class VmessBaen {
    public String SourceVmess;
    public String vmessBase64;
    public String Vmess;

    public VmessBaen(String sourceVmess, String vmessBase64, String vmess) {
        SourceVmess = sourceVmess;
        this.vmessBase64 = vmessBase64;
        Vmess = vmess;
    }

    public VmessBaen() {
    }


    public String getSourceVmess() {
        return SourceVmess;
    }

    public void setSourceVmess(String sourceVmess) {
        SourceVmess = sourceVmess;
    }

    public String getVmessBase64() {
        return vmessBase64;
    }

    public void setVmessBase64(String vmessBase64) {
        this.vmessBase64 = vmessBase64;
    }

    public String getVmess() {
        return Vmess;
    }

    public void setVmess(String vmess) {
        Vmess = vmess;
    }

    @Override
    public String toString() {
        return "VmessBaen{" +
                "SourceVmess='" + SourceVmess + '\'' +
                ", vmessBase64='" + vmessBase64 + '\'' +
                ", Vmess='" + Vmess + '\'' +
                '}';
    }
}
