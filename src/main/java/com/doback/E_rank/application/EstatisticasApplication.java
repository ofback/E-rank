package com.doback.E_rank.application;

import com.doback.E_rank.entity.Estatisticas;
import com.doback.E_rank.models.EstatisticasModel;
import com.doback.E_rank.interfaces.EstatisticasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstatisticasApplication {
    private final EstatisticasRepository estatisticaRepository;

    public EstatisticasApplication(EstatisticasRepository estatisticaRepository) {
        this.estatisticaRepository = estatisticaRepository;
    }

    public List<EstatisticasModel> obterTodas() {
        return estatisticaRepository.buscar();
    }

    public EstatisticasModel obterPorId(int id) {
        return estatisticaRepository.searchByCode(id);
    }

    public void criar(EstatisticasModel estatisticaModel) {
        Estatisticas estatisticaEntidade = new Estatisticas(
                estatisticaModel.getKills(),
                estatisticaModel.getAssistencias(),
                estatisticaModel.getQtdPartidas(),
                estatisticaModel.getStsProvacao(),
                estatisticaModel.getVitorias(),
                estatisticaModel.getDerrotas(),
                estatisticaModel.getRecordKills(),
                estatisticaModel.getHeadshots()
        );


        String erros = estatisticaEntidade.getErrosValidacao();
        if (!erros.isEmpty()) {
            throw new IllegalArgumentException(erros);
        }

        estatisticaRepository.addEstatisticas(estatisticaModel);
    }

    public void excluir(int id) {
        estatisticaRepository.removeEstatisticas(id);
    }

    public void atualizar(int id, EstatisticasModel estatisticaModel) {
        Estatisticas estatisticaEntidade = new Estatisticas(
                estatisticaModel.getKills(),
                estatisticaModel.getAssistencias(),
                estatisticaModel.getQtdPartidas(),
                estatisticaModel.getStsProvacao(),
                estatisticaModel.getVitorias(),
                estatisticaModel.getDerrotas(),
                estatisticaModel.getRecordKills(),
                estatisticaModel.getHeadshots()
        );


        String erros = estatisticaEntidade.getErrosValidacao();
        if (!erros.isEmpty()) {
            throw new IllegalArgumentException(erros);
        }

        estatisticaRepository.updateEstatisticas(id, estatisticaModel);
    }
}
