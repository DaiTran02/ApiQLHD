package ngn.api.hopdong.reponse;

import java.util.List;

import lombok.Data;
import ngn.api.hopdong.models.HopDongModel;

@Data
public class ListHopDongReponse {
	private int status;
	private String message;
	private Integer soluong;
	private List<HopDongModel> data;

}
