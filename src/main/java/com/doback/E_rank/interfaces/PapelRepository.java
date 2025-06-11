package com.doback.E_rank.interfaces;

import com.doback.E_rank.models.PapelModel;

public interface PapelRepository {
    PapelModel findByNome(String nome);
    void save(PapelModel papelModel);
}