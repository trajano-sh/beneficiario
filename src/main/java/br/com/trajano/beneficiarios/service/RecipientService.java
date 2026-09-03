package br.com.trajano.beneficiarios.service;

import br.com.trajano.beneficiarios.database.model.Recipient;
import br.com.trajano.beneficiarios.database.repository.IRecipientRepository;
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
public class RecipientService {
    private final IRecipientRepository recipientsRepository;
    private final RecipientMapper recipientMapper;

    @Transactional
    public void createRecipient(RecipientRequestDTO dto) {
        if (dto.name().length() < 3) throw new BusinessException("The name must be longer than 2 characters");

        if (dto.phone().length() < 5) throw new BusinessException("The number must have more than 4 characters");

        Recipient recipient = recipientMapper.toEntity(dto);
        recipientsRepository.save(recipient);
    }

    @Transactional(readOnly = true)
    public List<RecipientsResponseDTO> getAllRecipients() {
        List<Recipient> recipients = recipientsRepository.findAll();
        return recipientMapper.getAll(recipients);
    }

    @Transactional(readOnly = true)
    public RecipientResponseDTO getRecipient(Long id) {
        Recipient recipient = recipientsRepository.findById(id).orElseThrow(() -> new NotFoundException("Recipients not found"));

        return recipientMapper.toDto(recipient);
    }

    @Transactional
    public RecipientResponseDTO updatedRecipient(Long id, RecipientUpdateRequestDTO dto) {
        if (dto.name().length() < 3) throw new BusinessException("The name must be longer than 2 characters");

        if (dto.phone().length() < 5) throw new BusinessException("The number must have more than 4 characters");

        Recipient recipient = recipientsRepository.findById(id).orElseThrow(() -> new NotFoundException("Recipients not found"));
        recipientMapper.toUpdate(recipient, dto);
        return recipientMapper.toDto(recipient);
    }

    @Transactional
    public void deleteRecipient(Long id) {
        Recipient recipient = recipientsRepository.findById(id).orElseThrow(() -> new NotFoundException("Recipients not found"));
        recipientsRepository.delete(recipient);
    }
}

