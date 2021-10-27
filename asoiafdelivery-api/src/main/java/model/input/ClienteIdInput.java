package model.input;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter	
public class ClienteIdInput {
	@Valid
	@NotNull
	private Long id;
	
	@Valid
	@NotNull
	private DestinatarioInput input;
	
	@NotNull
	private BigDecimal taxa;
}
