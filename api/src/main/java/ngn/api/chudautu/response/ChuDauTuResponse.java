package ngn.api.chudautu.response;

import lombok.Data;
import ngn.api.chudautu.models.ChuDauTuModel;

@Data
public class ChuDauTuResponse {
	private int status;
	private String message;
	private ChuDauTuModel data;
}
