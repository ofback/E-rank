package com.doback.E_rank.application;

import com.doback.E_rank.entity.Estatisticas;
import com.doback.E_rank.entity.Times;
import com.doback.E_rank.models.EstatisticasModel;
import com.doback.E_rank.interfaces.EstatisticasRepository;
import com.doback.E_rank.models.TimesModel;
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
        validar(estatisticaModel);
        estatisticaRepository.addEstatisticas(estatisticaModel);
    }

    public void excluir(int id) {
        estatisticaRepository.removeEstatisticas(id);
    }

    public void atualizar(int id, EstatisticasModel estatisticaModel) {
        validar(estatisticaModel);
        estatisticaRepository.updateEstatisticas(id, estatisticaModel);
    }

    private Estatisticas validar(EstatisticasModel estatisticaModel){
        Estatisticas estatisticas = new Estatisticas(
                estatisticaModel.getKills(),
                estatisticaModel.getAssistencias(),
                estatisticaModel.getQtdPartidas(),
                estatisticaModel.getStsProvacao(),
                estatisticaModel.getVitorias(),
                estatisticaModel.getDerrotas(),
                estatisticaModel.getRecordKills(),
                estatisticaModel.getHeadshots()
        );

        if (!estatisticas.validarEstatisticas()) {
            throw new IllegalArgumentException("Validação de estatistica falhou: " + estatisticas.getErrosValidacao());
        }

        return estatisticas;
    }
}
