package br.com.trajano.beneficiarios.mapper;

import br.com.trajano.beneficiarios.database.model.Beneficiario;
import br.com.trajano.beneficiarios.database.model.Documentos;
import br.com.trajano.beneficiarios.dto.BeneficiarioRequestDTO;
import br.com.trajano.beneficiarios.dto.BeneficiarioResponseDTO;
import br.com.trajano.beneficiarios.dto.BeneficiariosResponseDTO;
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

        if (!dto.documents().isEmpty() || dto.documents() != null){
            List<Documentos> docs = dto.documents().stream().map(docsMapper::toEntity).toList();
            bf.setDocuments(docs);
        }

        bf.setName(dto.name());
        bf.setPhone(dto.phone());
        bf.setDateOfBirth(dto.dateOfBirth());
        return bf;
    }

    public Beneficiario toUpdate(Beneficiario beneficiario,BeneficiarioRequestDTO dto){
        if (dto.name()!=null){
            beneficiario.setName(dto.name());
        }
        if (dto.phone()!=null){
            beneficiario.setPhone(dto.phone());
        }
        if (!dto.documents().isEmpty()){
            beneficiario.setDocuments(docsMapper.toEntity(dto.documents()));
        }
        beneficiario.setName(dto.name());
    }

    public List<BeneficiariosResponseDTO> getAll(List<Beneficiario> beneficiarios) {
        if (beneficiarios == null || beneficiarios.isEmpty()) {
            return List.of();
        }
        return beneficiarios.stream()
                .map(b -> new BeneficiariosResponseDTO(
                        b.getId(),
                        b.getName(),
                        b.getPhone(),       // replace with your actual 4 fields
                        b.getDateOfBirth()
                ))
                .toList();
    }

    public BeneficiarioResponseDTO toDto(Beneficiario bf) {
        List<DocumentosResponseDTO> docsResponse = bf.getDocuments().stream().map(docsMapper::toDto).toList();

        BeneficiarioResponseDTO beneficiarioResponseDTO = new BeneficiarioResponseDTO(bf.getId(), bf.getName(), bf.getPhone(), bf.getDateOfBirth(), bf.getCreatedAt(), bf.getUpdatedAt(), docsResponse);
        return beneficiarioResponseDTO;
    }
}
