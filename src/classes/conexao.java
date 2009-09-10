/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Fernando
 */
public class conexao {

    final private String driver = "org.gjt.mm.mysql.Driver";
    final private String url = "jdbc:mysql://localhost/bingomaster";
    final private String usuario = "root";
    final private String senha = "";
    private Connection conexao;
    public Statement statement;
    public ResultSet resultset;

    public boolean conecta() {
        boolean result = true;
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
//            JOptionPane.showMessageDialog(null, "conectou");
        } catch (ClassNotFoundException Driver) {
            JOptionPane.showMessageDialog(null, "Driver não localizado: " + Driver);
            result = false;
        } catch (SQLException Fonte) {
            JOptionPane.showMessageDialog(null, "Deu erro na conexão com a fonte de dados: " + Fonte);
            result = false;
        }
        return result;
    }

    public void desconecta() {
        boolean result = true;
        try {
            conexao.close();
//            JOptionPane.showMessageDialog(null, "Banco desconectado");
        } catch (SQLException fecha) {
            JOptionPane.showMessageDialog(null, "Não foi  possivel fechar o banco de dados: " + fecha);
            result = false;
        }
    }

    public void executeSQL(String sql) {
        try {
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(sql);
        } catch (SQLException squlex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel executar o comando sql, " + squlex + ", o sql passado foi: " + sql);
        }
    }
}
