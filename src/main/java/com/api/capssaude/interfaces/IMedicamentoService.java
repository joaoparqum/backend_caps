import java.util.Optional;
import java.util.List;
import org.hibernate.validator.constraints.UUID;

import com.api.capssaude.model.Medicamento;

public interface IMedicamentoService{
public Medicamento save(Medicamento medicamento);
public List<Medicamento> findAll();
public Optional<Medicamento> findById(UUID id);
public void delete(Medicamento medicamento);
}