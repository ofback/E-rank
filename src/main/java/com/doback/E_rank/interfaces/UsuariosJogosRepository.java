package com.doback.E_rank.interfaces;

import com.doback.E_rank.entity.UsuariosJogos;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UsuariosJogosRepository {
    public UsuariosJogos searchByCode(int id);
    public List<UsuariosJogos> buscar();
    public void addUsuariosJogos(UsuariosJogos usuariosJogos);
    public void removeUsuariosJogos(int id);
    public void updateUsuariosJogos(int id, UsuariosJogos usuariosJogos);
    public boolean estaVazio();
}
