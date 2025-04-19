package com.doback.E_rank.interfaces;

import com.doback.E_rank.models.UsuariosModel;
import java.util.List;

public interface UsuariosRepository {
    public UsuariosModel searchByCode(Long id);  // Mudado para Long

    public List<UsuariosModel> buscar();

    public void addUsuarios(UsuariosModel usuariosModel);

    public void removeUsuarios(Long id);  // Mudado para Long

    public void updateUsuarios(Long id, UsuariosModel usuariosModel);  // Mudado para Long

    public boolean estaVazio();
}
