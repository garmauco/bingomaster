/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Fernando
 */
public class geraCartelas {

    conexao con = new conexao();

    public void geraCartelas(int qc) {
        con.conecta();
        con.executeSQL("SELECT * FROM cartelas");
//        String jogo = "";
        geraSequencia gs = new geraSequencia();
        for (int q = 1; q <= qc; q++) {
            String cartela = "";
            for (int a = 1; a <= 61; a += 15) {
                gs.GeraSequencia(a);
                for (int c = 0; c < gs.sq.length; c++) {
                    cartela += String.format("%02d", gs.sq[c]);
                }
            }

//            System.out.println(q + " " + cartela);
//            jogo += cartela;
            try {
                String sqlInsert = "INSERT INTO cartelas (serie, cartela, situacao) " +
                        "VALUES ('00001000001','" + cartela + "','G')";
                con.statement.executeUpdate(sqlInsert);
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Não foi possivel gravar os dados " + erro);
            }
        }
//        System.out.println(jogo);
        JOptionPane.showMessageDialog(null, "Dados gravados com sucesso");
        con.desconecta();
    }
}
