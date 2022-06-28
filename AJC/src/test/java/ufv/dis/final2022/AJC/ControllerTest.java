package ufv.dis.final2022.AJC;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void buscarIP() {
        IPBuscada ipbuscada = new IPBuscada();
        assertNull(ipbuscada.getIp());

    }

    void IPMenor(){
        IPBuscada iptest = new IPBuscada("0.-1.20.20",null);

        Funciones aux = new Funciones();
        Gson gson = new Gson();

        String ippuntos = String.valueOf(iptest.getIp());
        long iptrans = aux.Dot2LongIP(ippuntos);

        boolean menor = false;

        if(iptrans < 0){
            menor = true;
        }

        assertTrue(menor);
    }
}