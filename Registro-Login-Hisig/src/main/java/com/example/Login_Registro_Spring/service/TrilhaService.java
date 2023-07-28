package com.example.Login_Registro_Spring.service;

import com.example.Login_Registro_Spring.entity.Trilha;
import com.example.Login_Registro_Spring.repository.TrilhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

@Service
public class TrilhaService {

    private final TrilhaRepository trilhaRepository;

    @Autowired
    public TrilhaService(TrilhaRepository trilhaRepository) {
        this.trilhaRepository = trilhaRepository;
    }

    public Trilha createTrilha(Trilha trilha) {
        return trilhaRepository.save(trilha);
    }

    public void deleteTrilhaById(Integer id) {
        trilhaRepository.deleteById(id);
    }

    public Collection<Trilha> getAllTrilhas() {
        return trilhaRepository.findAll();
    }

    public Trilha updateTrilha(Integer id, Trilha trilha) {
        Trilha existingTrilha = getTrilhaById(id);
        if (existingTrilha != null) {
            existingTrilha.setNome_aula(trilha.getNome_aula());
            existingTrilha.setDescricao(trilha.getDescricao());
            existingTrilha.setLink_aula(trilha.getLink_aula());
            existingTrilha.setModulo(trilha.getModulo());
            return trilhaRepository.save(existingTrilha);
        } else {
            return null;
        }
    }

    public Trilha getTrilhaById(Integer id) {
        Optional<Trilha> optionalTrilha = trilhaRepository.findById(id);
        return optionalTrilha.orElse(null);
    }

    public void saveFile(Integer trilhaId, MultipartFile file) throws IOException {
        Trilha trilha = getTrilhaById(trilhaId);
        if (trilha != null) {
            trilha.setResumo_Envio(file.getBytes());
            trilhaRepository.save(trilha);
        } else {
            throw new IllegalArgumentException("Trilha Não Encontrada ID: " + trilhaId);
        }
    }

    public byte[] getFileBytes(Integer trilhaId) {
        Trilha trilha = getTrilhaById(trilhaId);
        if (trilha != null) {
            return trilha.getResumo_Envio();
        } else {
            throw new IllegalArgumentException("Trilha Não Encontrada ID:: " + trilhaId);
        }
    }
}
