package com.doback.E_rank.interfaces;

import com.doback.E_rank.models.Usuarios;
import java.util.List;

public interface UsuariosRepository {
    public Usuarios searchByCode(Long id);  // Mudado para Long

    public List<Usuarios> buscar();

    public void addUsuarios(Usuarios usuarios);

    public void removeUsuarios(Long id);  // Mudado para Long

    public void updateUsuarios(Long id, Usuarios usuarios);  // Mudado para Long

    public boolean estaVazio();
}
