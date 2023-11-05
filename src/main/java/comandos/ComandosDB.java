package comandos;

import conexao.ConnectionDB;
import entity.Conversation;
import entity.Messager;
import entity.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ComandosDB {
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    Connection conexao;

    public Usuario pegarUser(Long id) {
        Usuario usuario = null;
        conexao = new ConnectionDB().startConnection();
        try {
            PreparedStatement ps = conexao.prepareStatement("Select * from Usuario where id = ?");
            ps.setLong(1, id);
            //guardo no result e pego os dados com o cliente usuario
            ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                // Recupera os valores das colunas do resultado
                Long usuarioId = resultado.getLong("id");
                String nome = resultado.getString("nome");
                String email = resultado.getString("email");
                String senha = resultado.getString("senha");

                //  um objeto de usuário com os valores recuperados
                usuario = new Usuario(usuarioId, nome, email, senha);
            }

            //Fecha o resultado
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                //Encerra a conexão
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return usuario;
    }

    public ArrayList<Usuario> todosUser() {
        conexao = new ConnectionDB().startConnection();
        try {
            PreparedStatement ps = conexao.prepareStatement("Select nome from Usuario");
            // Guardo no result e pego os dados com o cliente usuario
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                // Cria um objeto de usuário com os valores recuperados e adiciona à lista
                usuarios.add(new Usuario(null, nome, null, null));
            }

            // Fecha o resultado
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                // Encerra a conexão
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return usuarios;
    }

    public Conversation getConversaPorId(Long idConversa) {
        conexao = new ConnectionDB().startConnection();
        String sql = "SELECT * FROM Conversas WHERE id = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setLong(1, idConversa);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int id = (int) rs.getLong("id");
                    int idUsuario1 = (rs.getInt("id_usuario"));
                    int id_usuario2 = (rs.getInt("id_usuario_2"));

                    Conversation conversa = new Conversation(id, idUsuario1, id_usuario2);
                    return conversa;
                }
            }
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Retorna null se a conversa não for encontrada
    }

    public Messager pegarMessager() {
        Conversation conversa = null;
        conversa = getConversaPorId(1L);
        if (conversa != null) {
            conexao = new ConnectionDB().startConnection();
            String sql = "SELECT * FROM mensagem WHERE conversa_id = ?";

            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setLong(1, conversa.getIdconversa());

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        int idConversa = (int) conversa.getIdconversa();
                        int idUsuario1 = conversa.getId_usuario();
                        int id_usuario2 = conversa.getId_usuario_2();
                        int id_mensagem = (rs.getInt("id"));
                        String conteudo = (rs.getString("conteudo"));
                        String data = (rs.getString("data_envio"));

                        Messager messager = new Messager(idConversa, idUsuario1, id_usuario2, id_mensagem, conteudo, data);
                        return messager;
                    }

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}