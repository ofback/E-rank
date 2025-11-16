package com.doback.E_rank.application;

import com.doback.E_rank.dto.CreateTeamDTO;
import com.doback.E_rank.dto.MyTeamDTO;
import com.doback.E_rank.entity.Times;
import com.doback.E_rank.exceptions.ResourceNotFoundException;
import com.doback.E_rank.infrastructure.models.RegistroTimesModel;
import com.doback.E_rank.infrastructure.models.TemporadasModel;
import com.doback.E_rank.infrastructure.models.TimesModel;
import com.doback.E_rank.infrastructure.repository.jpa.RegistroTimesJpa;
import com.doback.E_rank.interfaces.RegistroTimesRepository;
import com.doback.E_rank.interfaces.TemporadasRepository;
import com.doback.E_rank.interfaces.TimesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Importe o Transactional

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimesApplication {

    private final TimesRepository timesRepository;
    private final TemporadasRepository temporadasRepository;
    private final RegistroTimesRepository registroTimesRepository;
    private final RegistroTimesJpa registroTimesJpa;

    public TimesApplication(TimesRepository timesRepository, TemporadasRepository temporadasRepository, RegistroTimesRepository registroTimesRepository, RegistroTimesJpa registroTimesJpa) {
        this.timesRepository = timesRepository;
        this.temporadasRepository = temporadasRepository;
        this.registroTimesRepository = registroTimesRepository;
        this.registroTimesJpa = registroTimesJpa;
    }

    // --- MÉTODOS CRUD ADICIONADOS ---
    public List<TimesModel> obterTodosTimes() {
        return timesRepository.buscar();
    }

    public TimesModel obterTimesPorId(int id) {
        return timesRepository.searchByCode(id);
    }

    public void excluirTime(int id) {
        timesRepository.removeTimes(id);
    }

    public void atualizarTimes(int id, TimesModel timesModel) {
        validar(timesModel);
        timesRepository.updateTimes(id, timesModel);
    }
    // --- FIM DOS MÉTODOS ADICIONADOS ---

    @Transactional
    public void criarTime(CreateTeamDTO teamDTO, int creatorId) {
        TemporadasModel temporadaPadrao = temporadasRepository.buscar().stream().findFirst()
                .orElseThrow(() -> new IllegalStateException("Nenhuma temporada encontrada para associar o time."));

        TimesModel timesModel = new TimesModel();
        timesModel.setNome(teamDTO.getNome());
        timesModel.setDescricao(teamDTO.getDescricao());
        timesModel.setIdUsuario(creatorId);
        timesModel.setIdTemporada(temporadaPadrao.getId());
        timesModel.setSts('A');

        validar(timesModel);
        timesRepository.addTimes(timesModel); // Salva o time para obter o ID gerado

        String dataEntrada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        RegistroTimesModel creatorRegistration = new RegistroTimesModel();
        creatorRegistration.setIdTimes(timesModel.getId());
        creatorRegistration.setIdUsuarios(creatorId);
        creatorRegistration.setCargo("Dono");
        creatorRegistration.setStatus("A");
        creatorRegistration.setData_entrada(dataEntrada);
        registroTimesRepository.addRegistroTimes(creatorRegistration);

        if (teamDTO.getMemberIds() != null) {
            for (Integer memberId : teamDTO.getMemberIds()) {
                RegistroTimesModel memberInvitation = new RegistroTimesModel();
                memberInvitation.setIdTimes(timesModel.getId());
                memberInvitation.setIdUsuarios(memberId);
                memberInvitation.setCargo("Membro");
                memberInvitation.setStatus("P");
                memberInvitation.setData_entrada(dataEntrada);
                registroTimesRepository.addRegistroTimes(memberInvitation);
            }
        }
    }


    @Transactional(readOnly = true)
    public List<MyTeamDTO> obterTimesDoUsuario(int userId) {

        System.out.println("--- [DEBUG] INICIANDO obterTimesDoUsuario PARA USUÁRIO: " + userId + " ---");

        List<MyTeamDTO> timesMapeados = registroTimesJpa.findByIdUsuarios(userId).stream()
                .peek(registro -> {
                    // Log 1: O que o banco retornou
                    // CORREÇÃO: Usando .getId() ao invés de .getIdRegistroTime()
                    System.out.println("[DEBUG] Processando registro ID: " + registro.getId());

                    // Log 2: O TimesModel está nulo?
                    if (registro.getTimesModel() == null) {
                        // CORREÇÃO: Usando .getId()
                        System.out.println("[DEBUG] ERRO: registro.getTimesModel() está NULO para o registro ID: " + registro.getId());
                    } else {
                        // Log 3: O Nome do time está nulo?
                        if (registro.getTimesModel().getNome() == null) {
                            System.out.println("[DEBUG] ERRO: registro.getTimesModel().getNome() está NULO para o Time ID: " + registro.getTimesModel().getId());
                        }
                    }
                })
                // Filtro 1: Garante que o time associado não é nulo
                .filter(registro -> registro.getTimesModel() != null)
                // Filtro 2: Garante que o NOME do time também não é nulo
                .filter(registro -> registro.getTimesModel().getNome() != null)
                .map(registro -> {
                    // Log 4: O que estamos mapeando
                    System.out.println("[DEBUG] Mapeando Time: " + registro.getTimesModel().getNome() + " (Cargo: " + registro.getCargo() + ")");
                    return new MyTeamDTO(
                            registro.getIdTimes(),
                            registro.getTimesModel().getNome(), // Isto agora é 100% seguro
                            registro.getCargo(),
                            registro.getStatus()
                    );
                })
                .collect(Collectors.toList());

        System.out.println("--- [DEBUG] FINALIZANDO obterTimesDoUsuario. Times encontrados: " + timesMapeados.size() + " ---");
        return timesMapeados;
    }

    // Adicionado para RF07
    @Transactional
    public void leaveTeam(int teamId, int userId) {
        RegistroTimesModel registration = registroTimesJpa.findByIdTimesAndIdUsuarios(teamId, userId)
                .orElseThrow(() -> new ResourceNotFoundException("Membro com ID " + userId + " não encontrado no time com ID " + teamId));

        if ("Dono".equalsIgnoreCase(registration.getCargo())) {
            throw new IllegalArgumentException("O Dono não pode abandonar o time. Transfira a propriedade ou delete o time.");
        }

        registroTimesJpa.delete(registration);
    }


    private void validar(TimesModel timesModel) {
        Times timesEntidade = new Times(
                timesModel.getNome(),
                timesModel.getDescricao(),
                timesModel.getSts(),
                timesModel.getIdTemporada(),
                timesModel.getIdUsuario()
        );

        if (!timesEntidade.validarTime()) {
            throw new IllegalArgumentException("Validação do time falhou: " + timesEntidade.getErrosValidacao());
        }
    }
}