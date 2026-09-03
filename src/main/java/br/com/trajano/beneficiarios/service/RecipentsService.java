package br.com.trajano.beneficiarios.service;

import br.com.trajano.beneficiarios.database.model.Recipient;
import br.com.trajano.beneficiarios.database.repository.IRecipientsRepository;
import br.com.trajano.beneficiarios.dto.RecipientRequestDTO;
import br.com.trajano.beneficiarios.dto.RecipientResponseDTO;
import br.com.trajano.beneficiarios.dto.RecipientUpdateRequestDTO;
import br.com.trajano.beneficiarios.dto.RecipientsResponseDTO;
import br.com.trajano.beneficiarios.exceptions.BusinessException;
import br.com.trajano.beneficiarios.exceptions.NotFoundException;
import br.com.trajano.beneficiarios.mapper.RecipientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RecipentsService {
    private final IRecipientsRepository beneficiarioRepository;
    private final RecipientMapper recipientMapper;

    @Transactional
    public void createBeneficiario(RecipientRequestDTO dto) {
        if (dto.name().length() < 3) throw new BusinessException("Nome precisa ter mais que 2 caracteres");

        if (dto.phone().length() < 5) throw new BusinessException("O numero precisa ter mais que 4 caracteres");

        Recipient recipient = recipientMapper.toEntity(dto);
        beneficiarioRepository.save(recipient);
    }

    @Transactional(readOnly = true)
    public List<RecipientsResponseDTO> getAllRecipientes() {
        List<Recipient> recipients = beneficiarioRepository.findAll();
        return recipientMapper.getAll(recipients);
    }

    @Transactional(readOnly = true)
    public RecipientResponseDTO getRecipient(Long id) {
        Recipient recipient = beneficiarioRepository.findById(id).orElseThrow(() -> new NotFoundException("Beneficiario nao existe"));

        return recipientMapper.toDto(recipient);
    }

    @Transactional
    public RecipientResponseDTO updatedBeneficario(Long id, RecipientUpdateRequestDTO dto) {
        if (dto.name().length() < 3) throw new BusinessException("Nome precisa ter mais que 2 caracteres");

        if (dto.phone().length() < 5) throw new BusinessException("O numero precisa ter mais que 4 caracteres");

        Recipient recipient = beneficiarioRepository.findById(id).orElseThrow(() -> new NotFoundException("Beneficiario nao existe"));
        recipientMapper.toUpdate(recipient, dto);
        return recipientMapper.toDto(recipient);
    }

    @Transactional
    public void deleteBeneficiario(Long id) {
        Recipient recipient = beneficiarioRepository.findById(id).orElseThrow(() -> new NotFoundException("Beneficiario nao encontrado"));
        beneficiarioRepository.delete(recipient);
    }
}

