package ngn.api.chudautu.response;

import java.util.List;

import lombok.Data;
import ngn.api.chudautu.models.ChuDauTuModel;

@Data
public class ListChuDauTuResponse {
	private int status;
	private int soluong;
	private String message;
	private List<ChuDauTuModel> data;

}
