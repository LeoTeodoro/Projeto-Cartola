package br.inatel.cartola.DAO;

import br.inatel.cartola.model.Jogador;

import java.sql.SQLException;
import java.util.ArrayList;

public class JogadorDAO extends ConnectionDAO {
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertJogador(Jogador jogador) {

        connectToDB();

        String sql = "INSERT INTO Jogador (idJogador,Nome,Pontuacao,Preco,Posicao,Time) values(?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,jogador.id);
            pst.setString(2, jogador.nome);
            pst.setFloat(3, jogador.pontuacao);
            pst.setFloat(4, jogador.preco);
            pst.setString(5, jogador.posicao);
            pst.setString(6, jogador.time);
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
    public boolean updateJogador(int id, Jogador jogador) {
        connectToDB();
        String sql = "UPDATE Jogador SET Nome=?, Pontuacao=?, Preco=?, Posicao=?, Time=? where idJogador=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, jogador.nome);
            pst.setFloat(2, jogador.pontuacao);
            pst.setFloat(3, jogador.preco);
            pst.setString(4, jogador.posicao);
            pst.setString(5, jogador.time);
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
    public boolean deleteJogador(Jogador jogador) {
        connectToDB();
        String sql = "DELETE FROM Jogador where idJogador=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, jogador.id );
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

    public ArrayList<Jogador> selectJogadores() {
        ArrayList<Jogador> jogadores = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Jogador";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de jogadores: ");

            while (rs.next()) {

                Jogador jogadorAux = new Jogador(rs.getString("time"),rs.getFloat("preco"),rs.getString("nome"),
                        rs.getFloat("pontuacao"), rs.getString("posicao"), rs.getInt("idJogador"));

                System.out.println("nome = " + jogadorAux.nome);
                System.out.println("posicao = " + jogadorAux.posicao);
                System.out.println("preco = " + jogadorAux.preco);
                System.out.println("pontuacao = " + jogadorAux.pontuacao);
                System.out.println("time = " + jogadorAux.time);
                System.out.println("id = " + jogadorAux.id);
                System.out.println("--------------------------------");

                jogadores.add(jogadorAux);
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
        return jogadores;
    }
}
