package com.doback.E_rank.application;

import com.doback.E_rank.dto.FriendDTO;
import com.doback.E_rank.dto.PendingRequestDTO;
import com.doback.E_rank.entity.Amizades;
import com.doback.E_rank.infrastructure.models.AmizadesModel;
import com.doback.E_rank.infrastructure.models.UsuariosModel;
import com.doback.E_rank.infrastructure.repository.jpa.AmizadesJpa;
import com.doback.E_rank.interfaces.AmizadesRepository;
import com.doback.E_rank.interfaces.UsuariosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AmizadesApplication {

    private final AmizadesRepository amizadeRepository;
    private final NotificacaoApplication notificacaoApplication;
    private final AmizadesJpa amizadesJpa;
    private final UsuariosRepository usuariosRepository;

    public AmizadesApplication(AmizadesRepository amizadeRepository,
                               NotificacaoApplication notificacaoApplication,
                               AmizadesJpa amizadesJpa,
                               UsuariosRepository usuariosRepository) {
        this.amizadeRepository = amizadeRepository;
        this.notificacaoApplication = notificacaoApplication;
        this.amizadesJpa = amizadesJpa;
        this.usuariosRepository = usuariosRepository;
    }

    public List<AmizadesModel> obterTodasAmizades() {
        return amizadeRepository.buscar();
    }

    public AmizadesModel obterAmizadePorId(int id) {
        return amizadeRepository.searchByCode(id);
    }

    public void criarAmizade(int idRemetente, int idDestinatario) {
        AmizadesModel amizadesModel = new AmizadesModel();
        amizadesModel.setIdUsuario1(idRemetente);
        amizadesModel.setIdUsuario2(idDestinatario);
        amizadesModel.setStatus('P'); // 'P' de Pendente
        amizadesModel.setDataSolicitacao(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()));
        validar(amizadesModel);
        amizadeRepository.addAmizades(amizadesModel);
        String mensagem = "Você recebeu um novo pedido de amizade.";
        String destinatario = "usuario_id:" + idDestinatario;
        notificacaoApplication.enviarNotificacao("sistema", mensagem, destinatario);
    }

    public void excluirAmizade(int id) {
        amizadeRepository.removeAmizades(id);
    }

    public void atualizarAmizades(int id, AmizadesModel amizadesModel) {
        validar(amizadesModel);
        amizadeRepository.updateAmizades(id, amizadesModel);
    }

    public List<FriendDTO> listarAmigos(int idUsuarioLogado) {
        List<AmizadesModel> amizades = amizadesJpa.findByIdUsuario1AndStatusOrIdUsuario2AndStatus(idUsuarioLogado, 'A', idUsuarioLogado, 'A');
        return amizades.stream().map(amizade -> {
            int amigoId = (amizade.getIdUsuario1() == idUsuarioLogado) ? amizade.getIdUsuario2() : amizade.getIdUsuario1();
            UsuariosModel amigo = usuariosRepository.searchByCode((long) amigoId);
            // Adicionado um null check para segurança
            if (amigo == null) return null;
            return new FriendDTO(amizade.getId(), amigoId, amigo.getNickname());
        }).filter(java.util.Objects::nonNull).collect(Collectors.toList());
    }

    public List<PendingRequestDTO> listarConvitesPendentes(int idUsuarioLogado) {
        List<AmizadesModel> convites = amizadesJpa.findByIdUsuario2AndStatus(idUsuarioLogado, 'P');
        return convites.stream().map(convite -> {
            UsuariosModel remetente = usuariosRepository.searchByCode((long) convite.getIdUsuario1());
            // Adicionado um null check para segurança
            if (remetente == null) return null;
            return new PendingRequestDTO(convite.getId(), remetente.getId(), remetente.getNickname(), convite.getDataSolicitacao());
        }).filter(java.util.Objects::nonNull).collect(Collectors.toList());
    }

    private Amizades validar(AmizadesModel amizadesModel){
        Amizades amizades = new Amizades(
                amizadesModel.getIdUsuario1(),
                amizadesModel.getIdUsuario2(),
                amizadesModel.getStatus(),
                amizadesModel.getDataSolicitacao()
        );

        if(!amizades.validarAmizades()){
            throw new IllegalArgumentException("Validação da amizade falhou: " + amizades.getErrosValidacao());
        }
        return amizades;
    }
}

