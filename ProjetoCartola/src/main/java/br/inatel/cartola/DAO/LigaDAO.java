package br.inatel.cartola.DAO;

import br.inatel.cartola.model.Liga;

import java.sql.SQLException;
import java.util.ArrayList;

public class LigaDAO extends ConnectionDAO {
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertLiga(Liga liga) {

        connectToDB();

        String sql = "INSERT INTO Liga (idLiga,Nome,Times) values(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, liga.id);
            pst.setString(2, liga.nome);
            pst.setString(3, String.valueOf(liga.times));
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    //UPDATE
    public boolean updateLiga(Liga liga) {
        connectToDB();
        String sql = "UPDATE Liga SET Nome=?, Times=? where idLiga=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, liga.nome);
            pst.setString(2, String.valueOf(liga.times));
            pst.setInt(3,liga.id);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    //DELETE
    public boolean deleteLiga(Liga liga) {
        connectToDB();
        String sql = "DELETE FROM Liga where idLiga=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, liga.id );
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    public ArrayList<Liga> selectLigas() {
        ArrayList<Liga> ligas = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Ligas";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de ligas: ");

            while (rs.next()) {

                Liga ligaAux = new Liga(rs.getString("nome"),rs.getInt("idLiga"));

                System.out.println("nome = " + ligaAux.nome);
                System.out.println("id = " + ligaAux.id);
                System.out.println("--------------------------------");

                ligas.add(ligaAux);
            }
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return ligas;

    }
}
