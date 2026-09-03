package br.com.trajano.beneficiarios.service;

import br.com.trajano.beneficiarios.database.model.Beneficiario;
import br.com.trajano.beneficiarios.database.model.Documentos;
import br.com.trajano.beneficiarios.database.repository.IBeneficiarioRepository;
import br.com.trajano.beneficiarios.database.repository.IDocumentosRepository;
import br.com.trajano.beneficiarios.dto.BeneficiarioRequestDTO;
import br.com.trajano.beneficiarios.dto.BeneficiarioResponseDTO;
import br.com.trajano.beneficiarios.dto.BeneficiarioUpdateRequestDTO;
import br.com.trajano.beneficiarios.dto.BeneficiariosResponseDTO;
import br.com.trajano.beneficiarios.exceptions.BusinessException;
import br.com.trajano.beneficiarios.exceptions.NotFoundException;
import br.com.trajano.beneficiarios.mapper.BeneficiarioMapper;
import br.com.trajano.beneficiarios.mapper.DocumentosMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BeneficiarioService {
    private final IBeneficiarioRepository beneficiarioRepository;
    private final BeneficiarioMapper beneficiarioMapper;

    @Transactional
    public void createBeneficiario(BeneficiarioRequestDTO dto) {
        if (dto.name().length() < 3) throw new BusinessException("Nome precisa ter mais que 2 caracteres");

        if (dto.phone().length() < 5) throw new BusinessException("O numero precisa ter mais que 4 caracteres");

        Beneficiario beneficiario = beneficiarioMapper.toEntity(dto);
        beneficiarioRepository.save(beneficiario);
    }

    @Transactional(readOnly = true)
    public List<BeneficiariosResponseDTO> getAllRecipientes() {
        List<Beneficiario> beneficiarios = beneficiarioRepository.findAll();
        return beneficiarioMapper.getAll(beneficiarios);
    }

    @Transactional(readOnly = true)
    public BeneficiarioResponseDTO getRecipient(Long id) {
        Beneficiario beneficiario = beneficiarioRepository.findById(id).orElseThrow(() -> new NotFoundException("Beneficiario nao existe"));

        return beneficiarioMapper.toDto(beneficiario);
    }

    @Transactional
    public BeneficiarioResponseDTO updatedBeneficario(Long id, BeneficiarioUpdateRequestDTO dto) {
        if (dto.name().length() < 3) throw new BusinessException("Nome precisa ter mais que 2 caracteres");

        if (dto.phone().length() < 5) throw new BusinessException("O numero precisa ter mais que 4 caracteres");

        Beneficiario beneficiario = beneficiarioRepository.findById(id).orElseThrow(() -> new NotFoundException("Beneficiario nao existe"));
        beneficiarioMapper.toUpdate(beneficiario, dto);
        return beneficiarioMapper.toDto(beneficiario);
    }

    @Transactional
    public void deleteBeneficiario(Long id) {
        Beneficiario beneficiario = beneficiarioRepository.findById(id).orElseThrow(() -> new NotFoundException("Beneficiario nao encontrado"));
        beneficiarioRepository.delete(beneficiario);
    }
}

