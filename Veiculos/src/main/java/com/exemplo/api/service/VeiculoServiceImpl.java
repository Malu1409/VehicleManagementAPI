package com.exemplo.api.service;

import com.exemplo.api.model.Veiculo;
import com.exemplo.api.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Override
    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }

    @Override
    public Veiculo criarVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    @Override
    public Veiculo atualizarVeiculo(Long id, Veiculo veiculo) {
        Optional<Veiculo> veiculoExistente = veiculoRepository.findById(id);
        if (veiculoExistente.isPresent()) {
            Veiculo veiculoAtualizado = veiculoExistente.get();
            veiculoAtualizado.setMarca(veiculo.getMarca());
            veiculoAtualizado.setModelo(veiculo.getModelo());
            return veiculoRepository.save(veiculoAtualizado);
        } else {
            throw new RuntimeException("Veículo não encontrado com o ID: " + id);
        }
    }

    @Override
    public void deletarVeiculo(Long id) {
        veiculoRepository.deleteById(id);
    }

    @Override
    public Veiculo buscarPorId(Long id) {
        Optional<Veiculo> veiculo = veiculoRepository.findById(id);
        if (veiculo.isPresent()) {
            return veiculo.get();
        } else {
            throw new RuntimeException("Veículo não encontrado com o ID: " + id);
        }
    }
}
