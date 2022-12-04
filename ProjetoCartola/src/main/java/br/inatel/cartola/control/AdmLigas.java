package br.inatel.cartola.control;

import br.inatel.cartola.DAO.JogadorDAO;
import br.inatel.cartola.DAO.TimeDAO;
import br.inatel.cartola.DAO.LigaDAO;
import br.inatel.cartola.model.Liga;
import br.inatel.cartola.model.Time;

public class AdmLigas {
    LigaDAO ligaDAO = new LigaDAO();

    public void insereLigas(Liga liga){
        ligaDAO.insertLiga(liga);
    }

    public void mostraLigas(){
        ligaDAO.selectLigas();
    }

    public void mostraTimes(Liga liga){
        System.out.println(liga.times);
    }

    public void deletaLigas(Liga liga){
        ligaDAO.deleteLiga(liga);
    }

    public void insereTime(Liga liga, Time time){
        liga.times.add(time.nome);
        ligaDAO.updateLiga(liga);
    }
}
