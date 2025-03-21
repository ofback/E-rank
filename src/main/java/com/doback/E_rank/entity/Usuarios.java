package com.doback.E_rank.entity;

public class Usuario {
    private Long id_usuario;
    private char sts;
    private String biografia;
    private String nickname;    
    private String email;
    
    public Usuario(Long id_usuario, char sts, String biografia, String nickname, String email) {
        id_usuario = id_usuario;
        sts = sts;
        biografia = biografia;
        nickname = nickname
        email = email;
    }


    public Long getid_usuario() {
        return id_usuario;
    }

    public void setIdUsuario(Long id_usuario) {
        id_usuario = id_usuario;
    }


    public char getsts() {
        return sts;
    }

    public void setsts(char sts) {
        sts = sts;
    }


    public String getbiografia(){
        return biografia;
    }
    public void setbiografia(String biografia){
        biografia = biografia;
    }

    
    public String getnickname(){
        return nickname;
}
    public void setnickname(String nickname){
        nickname = nickname;
    }
    
    public getemail(){
        return email;
    }

    public void setemail(String email){
        email = email;
    }
}