package br.com.ifsc.blocodenotas.model;
public class Nota {
    private Long id;
    private String titulo;
    private String texto;

    public Nota(String titulo, String texto) {
        this.titulo = titulo;
        this.texto = texto;
    }

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
