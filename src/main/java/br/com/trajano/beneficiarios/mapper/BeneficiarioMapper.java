package br.com.trajano.beneficiarios.mapper;

import br.com.trajano.beneficiarios.database.model.Beneficiario;
import br.com.trajano.beneficiarios.database.model.Documentos;
import br.com.trajano.beneficiarios.dto.BeneficiarioRequestDTO;
import br.com.trajano.beneficiarios.dto.BeneficiarioResponseDTO;
import br.com.trajano.beneficiarios.dto.DocumentosResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BeneficiarioMapper {
    private final DocumentosMapper docsMapper;

    public Beneficiario toEntity(BeneficiarioRequestDTO dto) {
        Beneficiario bf = new Beneficiario();
        bf.setName(dto.name());
        bf.setPhone(dto.phone());
        bf.setDateOfBirth(dto.dateOfBirth());
        return bf;
    }

    public BeneficiarioResponseDTO toDto(Beneficiario bf, List<Documentos> docs) {
        List<DocumentosResponseDTO> docsResponse = docs.stream().map(docsMapper::toDto).toList();

        BeneficiarioResponseDTO beneficiarioResponseDTO = new BeneficiarioResponseDTO(bf.getId(), bf.getName(), bf.getPhone(), bf.getDateOfBirth(), bf.getCreatedAt(), bf.getUpdatedAt(), docsResponse);
        return beneficiarioResponseDTO;
    }
}
