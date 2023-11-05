package testaClasses;

import comandos.ComandosDB;
import entity.Conversation;
import entity.Messager;
import entity.Usuario;

import java.util.ArrayList;

public class TestaConexao {
    public static void main(String[] args) {

        ComandosDB teste = new ComandosDB();
        Messager messager = teste.pegarMessager();
        System.out.println(messager.getId_usuario());
        ArrayList<Usuario> usuarios = teste.todosUser();
        for (Usuario usuario : usuarios){
            System.out.println(usuario.getNome());
        }

    }
}
