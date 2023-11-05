package entity;

public class Conversation{
    private long Idconversa;
    private int id_usuario;
    private int id_usuario_2;

    public Conversation() {
    }

    public Conversation(int idconversa, int id_usuario, int id_usuario_2) {
        Idconversa = idconversa;
        this.id_usuario = id_usuario;
        this.id_usuario_2 = id_usuario_2;
    }

    public long getIdconversa() {
        return Idconversa;
    }

    public void setIdconversa(long idconversa) {
        Idconversa = idconversa;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_usuario_2() {
        return id_usuario_2;
    }

    public void setId_usuario_2(int id_usuario_2) {
        this.id_usuario_2 = id_usuario_2;
    }
}
