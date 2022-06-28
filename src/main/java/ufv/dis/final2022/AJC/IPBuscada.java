package ufv.dis.final2022.AJC;

public class IPBuscada {
    private String ip;
    private String mensaje;

    public IPBuscada() {
    }

    public IPBuscada(String ip, String mensaje) {
        this.ip = ip;
        this.mensaje = mensaje;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "IPBuscada{" +
                "ip='" + ip + '\'' +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }
}
