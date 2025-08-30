package com.doback.E_rank.application;

import com.doback.E_rank.entity.RegistroTimes;
import com.doback.E_rank.infrastructure.models.RegistroTimesModel;
import com.doback.E_rank.infrastructure.models.TimesModel;
import com.doback.E_rank.infrastructure.models.UsuariosModel;
import com.doback.E_rank.interfaces.RegistroTimesRepository;
import com.doback.E_rank.interfaces.TimesRepository;
import com.doback.E_rank.interfaces.UsuariosRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroTimesApplication {

    private final RegistroTimesRepository registroTimesRepository;
    private final TimesRepository timesRepository;
    private final UsuariosRepository usuariosRepository;

    public RegistroTimesApplication(RegistroTimesRepository registroTimesRepository, TimesRepository timesRepository, UsuariosRepository usuariosRepository) {
        this.registroTimesRepository = registroTimesRepository;
        this.timesRepository = timesRepository;
        this.usuariosRepository = usuariosRepository;
    }

    public List<RegistroTimesModel> obterTodosRegistrosTime() {
        return registroTimesRepository.buscar();
    }

    public RegistroTimesModel obterRegistrosTime(int id) {
        return registroTimesRepository.searchByCode(id);
    }

    public void criarRegistrosTime(RegistroTimesModel registroTimesModel) {
        validar(registroTimesModel);
        registroTimesRepository.addRegistroTimes(registroTimesModel);
    }

    public void excluirRegistroTime(int id) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userEmail;
        if (principal instanceof UserDetails) {
            userEmail = ((UserDetails) principal).getUsername();
        } else {
            userEmail = principal.toString();
        }


        UsuariosModel currentUser = usuariosRepository.findByEmail(userEmail)
                .orElseThrow(() -> new IllegalStateException("Usuário autenticado não encontrado."));


        RegistroTimesModel registro = registroTimesRepository.searchByCode(id);
        if (registro == null) {
            throw new IllegalArgumentException("Registro de time não encontrado com o ID: " + id);
        }


        TimesModel time = timesRepository.searchByCode(registro.getIdTimes());
        if (time == null) {
            throw new IllegalStateException("Time associado ao registro não foi encontrado.");
        }


        if (time.getIdUsuario() != currentUser.getId()) {

            throw new IllegalStateException("Apenas o criador do time pode remover membros.");
        }


        registroTimesRepository.removeRegistroTimes(id);
    }

    public void atualizarRegistrosTime(int id, RegistroTimesModel registroTimesModel) {
        validar(registroTimesModel);
        registroTimesRepository.updateRegistroTimes(id, registroTimesModel);
    }

    private RegistroTimes validar (RegistroTimesModel registroTimesModel){
        RegistroTimes registroTimesEntidade = new RegistroTimes(
                registroTimesModel.getCargo(),
                registroTimesModel.getData_entrada(),
                registroTimesModel.getIdTimes(),
                registroTimesModel.getIdUsuarios()
        );
        if (!registroTimesEntidade.validarRegistroTimes()) {
            throw new IllegalArgumentException("Validação do registroTimes falhou: " + registroTimesEntidade.getErrosValidacao());
        }

        return registroTimesEntidade;
    }
}

