package com.exemplo.api.service;

import com.exemplo.api.model.Veiculo;

import java.util.List;

public interface VeiculoService {

    List<Veiculo> listarTodos();

    Veiculo criarVeiculo(Veiculo veiculo);

    Veiculo atualizarVeiculo(Long id, Veiculo veiculo);

    void deletarVeiculo(Long id);

    Veiculo buscarPorId(Long id);
}
