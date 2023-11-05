package entity;

public class Messager extends Conversation{
    private int id_Mensagem;
    private String conteudo;
    private String data_Envio;

    public Messager(int idconversa, int id_usuario, int id_usuario_2, int id_Mensagem, String conteudo, String data_Envio) {
        super(idconversa, id_usuario, id_usuario_2);
        this.id_Mensagem = id_Mensagem;
        this.conteudo = conteudo;
        this.data_Envio = data_Envio;
    }

    public int getId_Mensagem() {
        return id_Mensagem;
    }

    public void setId_Mensagem(int id_Mensagem) {
        this.id_Mensagem = id_Mensagem;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getData_Envio() {
        return data_Envio;
    }

    public void setData_Envio(String data_Envio) {
        this.data_Envio = data_Envio;
    }
}
