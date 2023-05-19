package model;
public class Nota {
    private Long id;
    private String titulo;
    private String texto;

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getTitulo(){
        return titulo;
    }

    public void setTexto(String texto){
        this.texto = texto;
    }
    public String getTexto(){
        return texto;
    }
}
