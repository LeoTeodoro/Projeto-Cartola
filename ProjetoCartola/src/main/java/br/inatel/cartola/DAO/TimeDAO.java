package br.inatel.cartola.DAO;

import br.inatel.cartola.model.Jogador;
import br.inatel.cartola.model.Time;

import java.sql.SQLException;
import java.util.ArrayList;

public class TimeDAO extends ConnectionDAO {
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertTime(Time time) {

        connectToDB();

        String sql = "INSERT INTO Time (idTime, Jogadores,Pontuacao,Nome,Dinheiro) values(?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,time.id);
            pst.setString(2, String.valueOf(time.jogadores));
            pst.setFloat(3, time.pontuacaoTime );
            pst.setString(4, time.nome);
            pst.setFloat(5, time.getDinheiro());
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
    public boolean updateTime(int id, Time time) {
        connectToDB();
        String sql = "UPDATE Time SET Jogadores=?, Pontuacao=?, Nome=?, Dinheiro=?, Liga_idLiga=? where idTime=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, String.valueOf(time.jogadores));
            pst.setFloat(2, time.pontuacaoTime);
            pst.setString(3, time.nome);
            pst.setFloat(4, time.getDinheiro());
            pst.setString(5, time.Liga_idLiga);
            pst.setInt(6,id);
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
    public boolean deleteTime(Time time) {
        connectToDB();
        String sql = "DELETE FROM Time where idTime=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, time.id );
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

    public ArrayList<Time> selectTimes() {
        ArrayList<Time> times = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Time";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de times: ");

            while (rs.next()) {

                Time timeAux = new Time(rs.getInt("idTime"),rs.getString("nome"),rs.getFloat("dinheiro"),rs.getFloat("pontuacao"),
                        rs.getString("Liga_idLiga"));

                System.out.println("nome = " + timeAux.nome);
                System.out.println("preco = " + timeAux.getDinheiro());
                System.out.println("pontuacao = " + timeAux.pontuacaoTime);
                System.out.println("id = " + timeAux.id);
                System.out.println("--------------------------------");

                times.add(timeAux);
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
        return times;
    }
}
