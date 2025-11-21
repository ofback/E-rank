package com.doback.E_rank.interfaces;

import com.doback.E_rank.infrastructure.models.UsuariosModel;
import java.util.List;
import java.util.Optional;

public interface UsuariosRepository {
    public UsuariosModel searchByCode(int id);

    public List<UsuariosModel> buscar();

    public void addUsuarios(UsuariosModel usuariosModel);

    public void removeUsuarios(int id);

    public void updateUsuarios(int id, UsuariosModel usuariosModel);

    public boolean estaVazio();

    Optional<UsuariosModel> findByEmail(String email);

    List<UsuariosModel> findByNickname(String nickname);
}
