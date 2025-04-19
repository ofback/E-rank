package com.doback.E_rank.interfaces;

import com.doback.E_rank.models.UsuariosJogosModel;

import java.util.List;

public interface UsuariosJogosRepository {
    public UsuariosJogosModel searchByCode(int id);
    public List<UsuariosJogosModel> buscar();
    public void addUsuariosJogos(UsuariosJogosModel usuariosJogosModel);
    public void removeUsuariosJogos(int id);
    public void updateUsuariosJogos(int id, UsuariosJogosModel usuariosJogosModel);
    public boolean estaVazio();
}
